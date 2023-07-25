package hello.servlet2.web.frontcontroller.v5;

import hello.servlet2.web.frontcontroller.ModelView;
import hello.servlet2.web.frontcontroller.MyView;
import hello.servlet2.web.frontcontroller.v3.controller.MemberFormControllerV3;
import hello.servlet2.web.frontcontroller.v3.controller.MemberListControllerV3;
import hello.servlet2.web.frontcontroller.v3.controller.MemberSaveControllerV3;
import hello.servlet2.web.frontcontroller.v4.controller.MemberFormControllerV4;
import hello.servlet2.web.frontcontroller.v4.controller.MemberListControllerV4;
import hello.servlet2.web.frontcontroller.v4.controller.MemberSaveControllerV4;
import hello.servlet2.web.frontcontroller.v5.adapter.ControllerV3HandlerAdapter;
import hello.servlet2.web.frontcontroller.v5.adapter.ControllerV4HandlerAdapter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "frontControllerServletV5", urlPatterns = "/front-controller/v5/*")
public class FrontControllerServletV5 extends HttpServlet {

    private final Map<String, Object> handlerMappingMap = new HashMap<>();
    private final List<MyHandlerAdapter> handlerAdapters = new ArrayList<>();

    public FrontControllerServletV5() {
        initHandlerMappingMap();    // 핸들러 매핑 초기화
        initHandlerAdapters();      // 어댑터 초기화
    }

    private void initHandlerMappingMap() {
        handlerMappingMap.put("/front-controller/v5/v3/members/new-form", new MemberFormControllerV3());
        handlerMappingMap.put("/front-controller/v5/v3/members/save", new MemberSaveControllerV3());
        handlerMappingMap.put("/front-controller/v5/v3/members", new MemberListControllerV3());

        handlerMappingMap.put("/front-controller/v5/v4/members/new-form", new MemberFormControllerV4());
        handlerMappingMap.put("/front-controller/v5/v4/members/save", new MemberSaveControllerV4());
        handlerMappingMap.put("/front-controller/v5/v4/members", new MemberListControllerV4());
    }

    private void initHandlerAdapters() {
        handlerAdapters.add(new ControllerV3HandlerAdapter());
        handlerAdapters.add(new ControllerV4HandlerAdapter());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Object handler = getHandler(request);
        if (handler == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        MyHandlerAdapter adapter = getHandlerAdapter(handler);
        ModelView mv = adapter.handle(request, response, handler);      // 어댑터 호출 -> 핸들러 호출 -> 그 결과를 어댑터에 맞추어 반환
        MyView view = viewResolver(mv.getViewName());

        view.render(mv.getModel(), request, response);
    }

    //  핸들러 어댑터를 찾는 메소드
    private MyHandlerAdapter getHandlerAdapter(Object handler) {
        for (MyHandlerAdapter adapter : handlerAdapters) {
            if (adapter.supports(handler)) {
                return adapter;
            }
        }
        throw new IllegalArgumentException("handler adapter를 찾을 수 없습니다. handler=" + handler);
    }

    //  요청정보를 가지고 핸들러를 찾는 메소드
    private Object getHandler(HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        return handlerMappingMap.get(requestURI);
    }

    private MyView viewResolver(String viewName) {
        return new MyView("/WEB-INF/views/" + viewName + ".jsp");
    }
}
