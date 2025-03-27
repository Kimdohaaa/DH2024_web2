package example.day14;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/day14/users")
@RequiredArgsConstructor
public class TranController {

    private final TranService tranService;

    // 이름 등록
    @PostMapping
    public boolean tran(){
        System.out.println("TranController.tran");

        return  tranService.tran();
    }
}
