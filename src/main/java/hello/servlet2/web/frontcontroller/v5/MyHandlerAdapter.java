package hello.servlet2.web.frontcontroller.v5;

import hello.servlet2.web.frontcontroller.ModelView;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public interface MyHandlerAdapter {

    /*
        어댑터가 해당 컨트롤러를 처리할 수 있는지 판단하는 메소드[23.07.25]
     */
    boolean supports(Object handler);

    /*
        어댑터는 실제 컨트롤러를 호출하여 그 결과로 ModelView를 반환한다.
        이전에는 프론트 컨트롤러가 직접 모델을 반환했다면, 이제는 어댑터를 통해서 실제 컨트롤러가 호출된다.[23.07.25]
     */
    ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException;
}
