package hello.servlet2.web.frontcontroller.v3.controller;

import hello.servlet2.domain.member.Member;
import hello.servlet2.domain.member.MemberRepository;
import hello.servlet2.web.frontcontroller.ModelView;
import hello.servlet2.web.frontcontroller.v3.ControllerV3;

import java.util.Map;

public class MemberSaveControllerV3 implements ControllerV3 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public ModelView process(Map<String, String> paramMap) {
        String username = paramMap.get("username");         // paramMap에서 파라미터 정보 확인 가능
        int age = Integer.parseInt(paramMap.get("age"));

        Member member = new Member(username, age);
        memberRepository.save(member);

        ModelView mv = new ModelView("save-result");
        mv.getModel().put("member", member);    // 모델에 뷰에서 필요한 member 객체를 담아 반환한다.
        return mv;
    }
}
