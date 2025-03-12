package example.day09.controller;

import example.day09.model.dto.BookDto;
import example.day09.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
@CrossOrigin("http://localhost:5181")
public class BookController {

    @Autowired
    private BookService bookService;

    // [1] 추천 등록
    @PostMapping
    public boolean write(@RequestBody BookDto bookDto){
        System.out.println("BookController.write");
        System.out.println("bookDto = " + bookDto);

        return bookService.write(bookDto);
    }

    // [2] 추천 수정
    @PutMapping
    public  boolean update (@RequestBody BookDto bookDto){
        System.out.println("BookController.update");
        System.out.println("bookDto = " + bookDto);

        return bookService.update(bookDto);
    }

    // [3] 추천 삭제
    @PostMapping("/delete")
    public  boolean delete(@RequestBody BookDto bookDto){
        System.out.println("BookController.delete");
        System.out.println("bookDto = " + bookDto);
        System.out.println("bno: " + bookDto.getBno() + ", bpwd: " + bookDto.getBpwd());


        return bookService.delete(bookDto);
    }

    // [4] 추천 전체 조회
    @GetMapping
    public List<BookDto> findAll(){
        System.out.println("BookController.findAll");

        return bookService.findAll();
    }

    // [5] 추천 상세 조회
    @GetMapping("/view")
    public BookDto find(@RequestParam int bno){
        System.out.println("BookController.find");
        System.out.println("bno = " + bno);

        return bookService.find(bno);
    }
}
