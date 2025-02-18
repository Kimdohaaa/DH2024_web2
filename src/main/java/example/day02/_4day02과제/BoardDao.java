package example.day02._4day02과제;

import example.day02._3day02과제.BoardDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;



@Component
public class BoardDao {

    int count = 0;
    // + 게시물 리스트 선언
    private ArrayList<BoardDto> boards = new ArrayList<>();


    // 1. 게시물 쓰기 처리 함수
    public boolean create( BoardDto boardDto ) {
        // [1] 매개변수로 받은 객체를 add() 이용하여 리스트에 저장
        // 요청값이 존재하면 list 에 add
        if(boardDto != null) {
            boardDto.setBno(++count); // bno 증가

            count = boardDto.getBno(); // 다음 입력 시를 위해 count 값 변경

            System.out.println(count); // 증가 확인
            System.out.println(boardDto.getBno()); // 증가확인

            boards.add(boardDto); // list 에 요청값 add

            return true; // 성공 시 true 반환
        }
// [2] 저장 결과 반환
        return false;
    }

    // 2. 게시물 반환 처리 함수
    public ArrayList<BoardDto> readAll(){
        // [1] 모든 게시물을 갖는 리스트객체 반환
        return boards;
    }

    // 3. 게시물 수정 처리 함수
    public boolean update( BoardDto boardDto ) {

        for(BoardDto j : boards){
            if(j.getBno() == boardDto.getBno()){ // 만약 list 의 j 번째 bno 와 요청값 bno 가 같다면
                j.setTitle(boardDto.getTitle()); // Setter 을 통해 j 번째 title 변경
                j.setContent(boardDto.getContent()); // Setter 을 통해 j 번째 content 변경
                return true; // true 반환
            }
        }

        // [3] 결과 반환
        return false;
    } // f end

    // 4. 게시물 삭제 처리 함수
    public boolean delete( int bno ) {
        // [1] 리스트 에서 특정한 인덱스를 .remove()함수 이용하여 요소 삭제한다.
        for(int i = 0; i < boards.size(); i++){
            if(boards.get(i).getBno() == bno){ // 만약 list 의 i 번째 bno 와 요청값 bno 가 같다면
                boards.remove(i); // i 번째 boardDto 삭제
                return true; // true 반환
            }
        }
        return false;
    } // f end

    public  BoardDto read(@RequestParam int bno){ // 요청값 쿼리스트링
        System.out.println("BoardController.find");
        System.out.println("bno = " + bno);

        // 배열 순회를 통해 list 내에 있는 요청값과 같은 bno 찾기
        for(BoardDto i : boards){
            if(i.getBno() == bno){ // 만약 list 의 i 번째 bno 와 요청값 bno 가 같다면
                return i; // i 번째 boardDto 반환
            }
        }

        return null; // 찾지 못할 시 null 반환
    }

}