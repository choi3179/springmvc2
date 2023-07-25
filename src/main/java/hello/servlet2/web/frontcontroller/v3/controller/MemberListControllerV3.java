package hello.servlet2.web.frontcontroller.v3.controller;

import hello.servlet2.domain.member.Member;
import hello.servlet2.domain.member.MemberRepository;
import hello.servlet2.web.frontcontroller.ModelView;
import hello.servlet2.web.frontcontroller.v3.ControllerV3;

import java.util.List;
import java.util.Map;

public class MemberListControllerV3 implements ControllerV3 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public ModelView process(Map<String, String> paramMap) {

        List<Member> members = memberRepository.findAll();

        ModelView mv = new ModelView("members");
        mv.getModel().put("members", members);      // MemberRepository에 저장된 데이터를 가져와 뷰에서 필요한 데이터로써 모델에 넣어준다.
        return mv;
    }

}
