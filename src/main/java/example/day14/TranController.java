package example.day14;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/day14/users")
@RequiredArgsConstructor
public class TranController {

    private final TranService tranService;

    // [1] 이름 등록
    @PostMapping
    public boolean tran(){
        System.out.println("TranController.tran");

        return  tranService.tran();
    }

    // [2] 트랜잭션을 이용한 이체 로직
    @PostMapping("/transfer")
    public boolean transfer(@RequestBody Map<String,String> params){
        System.out.println("TranController.transfer");
        System.out.println("prams = " + params);
        try{
            tranService.transfer(params);
            return true;
        }catch (Exception e){
            return  false;
        }
    }
}
