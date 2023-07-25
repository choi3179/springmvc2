package hello.servlet2.web.frontcontroller.v3;

import hello.servlet2.web.frontcontroller.ModelView;

import java.util.Map;

public interface ControllerV3 {

    /*
        HttpServletRequest가 제공하는 파라미터를 프로트 컨트롤러가 paramMap에 담아서 호출한다.
     */
    ModelView process(Map<String, String> paramMap);

}
