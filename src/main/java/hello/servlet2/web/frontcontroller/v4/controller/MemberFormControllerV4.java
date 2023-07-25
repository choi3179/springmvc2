package hello.servlet2.web.frontcontroller.v4.controller;

import hello.servlet2.web.frontcontroller.v4.ControllerV4;

import java.util.Map;

public class MemberFormControllerV4 implements ControllerV4{

    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) {
        //  단순하게 뷰 논리 이름만 반환
        return "new-form";
    }
}
