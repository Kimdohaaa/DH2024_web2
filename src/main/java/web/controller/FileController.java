package web.controller;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import web.service.FileService;

@RestController
@RequestMapping("/api/file")
@RequiredArgsConstructor
public class FileController {

    private final FileService fileService;

    // 일반적으로 Spring 은 업로드 용량 제한을 10MB 로 지정됨 //
    // 용량 제한 해제 방법 : application.properties ([5]번) --->
    // [1] 파일 업로드
    @PostMapping("/upload")
    // ★ 테스트 시 MultipartFile 타입의 매개변수명이랑 동일하게 지정
    public String fileUpload(MultipartFile multipartFile){
        System.out.println("FileController.fileUpload");
        System.out.println("multipartFile = " + multipartFile);

        String result = fileService.fileUpload(multipartFile);

        return result;
    }
    
    // [2] 업로드된 파일 다운로드
    @GetMapping("/download")
    // 1) 다운로드할 파일명과 응답객체를 매개변수로 받아오기
    public void fileDownload(@RequestParam String filename, HttpServletResponse resp){
        System.out.println("FileController.fileDownload");
        System.out.println("filename = " + filename + ", resp = " + resp);
        
        // 2) FileService 다운로드 메소드로 매개변수 전달
        fileService.fileDownload(filename, resp);
    }
    
    // [3] 업로드된 파일 삭제
    @GetMapping("/delete")
    // 1) 삭제할 파일명을 매개변수로 받기
    public  boolean fileDelete(@RequestParam String filename){ 
        System.out.println("FileController.fileDelete");
        System.out.println("fileName = " + filename);

        return fileService.fileDelete(filename);

    }
}
