package example.day09.service;

import example.day09.model.dto.BookDto;
import example.day09.model.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookMapper bookMapper;

    // [1] 추천 등록
    public  boolean write(BookDto bookDto){
        System.out.println("BookService.write");
        System.out.println("bookDto = " + bookDto);

        return bookMapper.write(bookDto);
    }

    // [2] 추천 수정
    public boolean update(BookDto bookDto){
        System.out.println("BookService.update");
        System.out.println("bookDto = " + bookDto);

        return bookMapper.update(bookDto);
    }

    // [3] 추천 삭제
    public  boolean delete(BookDto bookDto){
        System.out.println("BookService.delete");
        System.out.println("bookDto = " + bookDto);


        return bookMapper.delete(bookDto);
    }

    // [4] 추천 전체 조회
    public List<BookDto> findAll(){
        System.out.println("BookService.findAll");

        return bookMapper.findAll();
    }

    // [5] 추천 상세 조회
    public  BookDto find(int bno){
        System.out.println("BookService.find");
        System.out.println("bno = " + bno);

        return bookMapper.find(bno);
    }
}
