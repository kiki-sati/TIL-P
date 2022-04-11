package hello.hellospring;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * 컨트롤러, 서비스, 리파지토리 = 정형화된 패턴
 * 컨트롤러 : 외부요청받기 , 서비스 : 비지니스 로직 만듬, 리파지토리 : 데이터 저장
 */

@Controller
public class MemberController {

    private final MemberService memberService;


    // 의존성 주입 (서비스연결)
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
