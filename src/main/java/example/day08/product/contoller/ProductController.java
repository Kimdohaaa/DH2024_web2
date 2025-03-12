package example.day08.product.contoller;

import example.day08.product.model.dto.ProductDto;
import example.day08.product.service.ProductService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/day08/product")
@CrossOrigin("http://192.168.40.24:5181")
public class ProductController {

    @Autowired
    private ProductService productService;

    // [1] 제품등록
    @PostMapping
    public boolean write(@RequestBody ProductDto productDto){
        System.out.println("ProductMapper.writeP");
        System.out.println("productDto = " + productDto);

        return productService.write(productDto);
    }

    // [2] 제품 전체 조회
    @GetMapping
    public List<ProductDto> findAll(){
        System.out.println("ProductController.findAll");
        System.out.println();

        return productService.findAll();
    }

    // [3] 제품 수정
    @PutMapping
    public boolean update(@RequestBody ProductDto productDto){
        System.out.println("ProductController.update");
        System.out.println("productDto = " + productDto);

        return productService.update(productDto);
    }

    // [4] 제품 삭제
    @DeleteMapping
    public boolean delet(@RequestParam int pno){
        System.out.println("ProductController.delet");
        System.out.println("pno = " + pno);

        return productService.delete(pno);
    }

    // [5] 제품 상세 조회
    @GetMapping("/view")
    public ProductDto view(@RequestParam int pno){
        System.out.println("ProductController.view");
        System.out.println("pno = " + pno);

        return productService.view(pno);
    }
}
