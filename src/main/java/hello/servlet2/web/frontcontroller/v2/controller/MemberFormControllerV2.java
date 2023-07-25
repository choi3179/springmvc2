package hello.servlet2.web.frontcontroller.v2.controller;

import hello.servlet2.web.frontcontroller.MyView;
import hello.servlet2.web.frontcontroller.v2.ControllerV2;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class MemberFormControllerV2 implements ControllerV2 {

    @Override
    public MyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
            컨트롤러마다 dispatcher.forward()를 호출할 필요가 없어진다.
         */
        return new MyView("/WEB-INF/views/new-form.jsp");
    }

}
