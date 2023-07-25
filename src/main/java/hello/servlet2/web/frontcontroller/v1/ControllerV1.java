package hello.servlet2.web.frontcontroller.v1;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public interface ControllerV1 {

    /*
        서블릿과 비슷한 모양의 컨트롤러 인터페이스 도입함으로써 프론트 컨트롤러는 이 인터페이스를 호출해서 구현과 관계없이 로직의 일관성을 확보
        V1에서는 기존에 사용한 로직을 최대한 그대로 유지하는 것을 목적으로 한다.[23.07.25]
     */
    void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

}
