package example.day08.product.service;

import example.day08.product.model.dto.ProductDto;
import example.day08.product.model.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductMapper productMapper;

    // [1] 제품등록
    public boolean write(ProductDto productDto){
        System.out.println("ProductService.write");
        System.out.println("productDto = " + productDto);

        return productMapper.write(productDto);
    }

    // [2] 제품 전체 조회
    public List<ProductDto> findAll(){
        System.out.println("ProductService.findAll");
        System.out.println();

        return productMapper.findAll();
    }

    // [3] 제품 수정
    public boolean update(ProductDto productDto){
        System.out.println("ProductService.update");
        System.out.println("productDto = " + productDto);

        return productMapper.update(productDto);
    }

    // [4] 제품 삭제
    public  boolean delete(int pno){
        System.out.println("ProductService.delete");
        System.out.println("pno = " + pno);

        return productMapper.delete(pno);
    }

    // [5] 제품 상세 조회
    public ProductDto view(int pno){
        System.out.println("ProductService.view");
        System.out.println("pno = " + pno);

        return productMapper.view(pno);
    }
}
