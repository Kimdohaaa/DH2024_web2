package web.service;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.UUID;

@Service
public class FileService {

    // [0] 업로드된 파일을 저장할 폴더 경로 지정 => 주로 resources 폴더로 지정
    // 1) 현재 프로젝트 최상위 디렉토리(폴더) 경로 찾기
    //  => System.getProperty("user.dir") 현재 작업의 최상위 폴더 반환
    String baseDir = System.getProperty("user.dir");

    // 2) 업로드 경로 지정
    // 2-1 src : 실행 전 코드 (개발자가 사용)
    // String uploadPath1 = "/src/resource/static/upload/"; // 개발자가 사용하는 코드에는 업로드하지 않음
    // 2-2 build : 실행 후 코드 (사용자가 사용)
    String uploadPath2 = baseDir + "/build/resources/main/static/upload/"; // 실제 업로드할 위치
    // ★ 개발자는 src 에서 작업하고 항상 서버를 실행 => 작업한 코드를 build 로 반영(= 컴파일 = 빌드) ★ //

    // [1] 파일 업로드 => Spring 에서는 업로드를 지원(MultipartFile 인터페이스)하기 때문에 별도의 라이브러리를 다운받을 필요 X
    // 1) 매개변수로 MultipartFile 인터페이스 타입 받기
    public String fileUpload(MultipartFile multipartFile){
        // --- MultipartFile 인터페이스가 제공하는 메소드 --- //
        // 1_ .getContentType() : 첨부파일의 확장자 반환
        System.out.println("확장자 : " + multipartFile.getContentType());
        // 2_ .getSize() : 첨부파일의 용량(바이트) 반환
        System.out.println("용량 : " + multipartFile.getSize());
        // 3_ .getOriginalFilename() : 첨부파일의 파일명 반환
        System.out.println("파일명 : " + multipartFile.getOriginalFilename());;
        // 4_ .isEmpty() : 첨부파일 존재 여부를 boolean 타입으로 반환
        System.out.println("존재여부 : " + multipartFile.isEmpty());

        // 2) 업로드할 경로 생성 (업로드할 기본 경로 + 업로드할 파일명)
        // * 사용자가 동일한 파일명으로 업로드 시 식별이 불가능하기 때문에 UUID 를 통해 식별 * //
        // 2-1) UUID
        String uuid = UUID.randomUUID().toString();
        System.out.println("uuid = " + uuid);
        // 2-2) 언더바는 UUID 파일명을 구분하는 용도로 하이픈으로 변경
        String fileName = uuid + "_" + multipartFile.getOriginalFilename().replaceAll("_", "-");
        // 2-3) UUID 가 포함된 파일 경로 지정
        String filePath = uploadPath2 + fileName;
        // 2-4) 만약 업로드 경로가 존재하지 않을 시 경로 생성
        File file2 = new File(uploadPath2);
        if(file2.exists()){
            file2.mkdir();
        }

        // 3) File 클래스 : 파일 관련 다양한 메소드를 제공하는 클래스
        File file = new File(filePath); // 파일 클래스인스턴스에 파일이 존재하는 경로 대입

        // 4) 파일 업로드 ★ !!! 입출력 관련은 예외처리 필수 !!! ★
        try {
            // MultipartFile 객체명.transferTo(파일객체 or Path 객체) : 파일 업로드
            multipartFile.transferTo(file);
        }catch (IOException e){
            System.out.println(e);

            // 5-1) 업로드 실패 시 null 반환
            return  null;
        }

        // 5-2) 업로드 성공 시 업로드한 파일명 반환
        return  fileName;

        // build -> resources -> main -> static -> upload 폴더에 파일이 업로드 됨 //
    }


    // [2] 업로드 된 파일 다운로드
    // 요청 흐름 : [사용자] ---HTTP로 파일요청---> [서버] ---FileInputStream을 통해 파일 탐색---> C:/~
    // 응답 흐름 : [사용자] <---HTTP 응답--- [서버] <---FileOutputStream 을 통해 자바로 바이트배열로 가져오기--- C:/~
    // HTTP 는 기본적으로 문자전송을 지원하고 대용량파일(첨부파일)을 전송 시 바이트(바이너리)로 전송
    // 1) 사용자에게 다운로드할 파일명과 HTTP 응답객체를 매개변수로 받기
    public void fileDownload(String filename, HttpServletResponse resp){
        // 2) 다운로드 받을 파일의 경로 조합 (기본경로 + 다운로드할 파일명)
        String downloadPath = uploadPath2 + filename;
        System.out.println("downloadPath = " + downloadPath);

        // 3) 만약 파일이 존재하지 않을 시 리턴
        File file = new File(downloadPath);
        if(!file.exists()){
            return; // 다운로드 취소
        }

        // 4) 파일 존재 시 업로드된 파일을 자바(바이트)로 가져오기
        try {
            // 4-1) 파일 입력스트림 객체 생성 : FIleInputStream 객체명 = new FileInputStream(파일객체);
            FileInputStream fin = new FileInputStream(downloadPath);

            // 4-2) 해당 파일의 용량만큼 배열 선언
            long fileSize = file.length(); // 파일객체.length() : 파일의 용량 구하기(long 타입으로 반환함)
            byte[] bytes = new byte[(int)fileSize]; // 파일 사이즈 크기의 배열 선언 ★ 배열의 크기는 int 타입으로 지정

            // 4-3) 파일 입력스트림 개체로 파일 읽어오기
            // 파일입력스트림객체.read(바이트배열) => 읽어온 바이트들을 바이트배열에 대입
            fin.read(bytes);
            System.out.println(Arrays.toString(bytes));

            // 4-4) 파일 입력스트림 닫기 : 스트림(바이트이동통로) 에서 이동한 바이트들이 사용한 메모리를 수동으로 초기화(누수방지)
            //                        => 생략 시 일정시간 이후 GC 가 삭제함 (대용량일 시 직접 닫기 권장)
            // 파일입력스트림객체.close()
            fin.close();


            // 5) 가져온 파일을 HTTP response 로 내보내기
            // * HTTP 응답 객체의 헤더 속성 추가 => 브라우저에게 다운로드 형식임을 알리기 위해 (다운로드 받는 프론트는 대다수의 브라우저가 제공)
            // 주의점 : 파일명에 한글 존재 시 깨짐 -> HTTP 는 한글을 지원하지 않기 때문 => 인코딩 필요

            // *-1) 인코딩 후 언더바를 기준으로 나눠 UUID 를 제거하고 본래 파일명만 사용 (사용자에게 알릴 필요 X)
                // URLEncoder.encode(한글파일명, "UTF-8") : 한글 파일명 인코딩
            String oldFilename = URLEncoder.encode( filename.split("_")[1] , "UTF-8");
            // *-2) 브라우저에게 다운로드 형식임을 명시
                // resp.setHeader("Content-Disposition", "attachment;filename=" + 다운로드에 표시할 파일명);
            resp.setHeader("Content-Disposition", "attachment;filename=" + oldFilename);

            // 5-1) 서블릿 출력스트림 객체 생성
            // 응답객체명.getOutputStream() : 응답객체에서 출력 스트림 반환
            ServletOutputStream fout = resp.getOutputStream();

            // 5-2) 서블릿 출력 스트림 객체를 이용한 읽어온 바이트 내보내기
            // .write(출력할 배열) : 내보내기
            fout.write(bytes);

            // 5-3) 서블릿 출력 스트림 객체 닫기
            // 4-4) 파일 출력스트림 닫기 : 스트림(바이트이동통로) 에서 이동한 바이트들이 사용한 메모리를 수동으로 초기화(누수방지)
            //                        => 생략 시 일정시간 이후 GC 가 삭제함 (대용량일 시 직접 닫기 권장)
            fout.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // [3] 업로드 된 파일 삭제
    // 1) 삭제할 파일명을 매개변수로 받기
    public boolean fileDelete(String fileName){
        // 2) 업로드 경로와 삭제할 파일명을 연결
        String filePath = uploadPath2 + fileName;
        
        // 3) File 클래스 
        File file = new File(filePath);
        
        // 3) 업로드된 파일 삭제
        // exists() : 경로 상 파일 존재 시 true 존재하지 않을 시 false 반환
        if(file.exists()){ // 만약 경로 상 파일이 존재하면
            // .delete() : 경로 상의 파일 삭제
            file.delete(); // 해당 파일 삭제
            return true;
        }

        return false;
    }
    
}
