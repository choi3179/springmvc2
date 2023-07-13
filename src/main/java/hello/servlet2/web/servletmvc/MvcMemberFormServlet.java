package hello.servlet2.web.servletmvc;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * MVC 패턴 적용 - 컨트롤러 = 서블릿
 * 회원 등록 폼 컨트롤러
 * 모델 : HttpServletRequest 객체 -> 내부 데이터 저장소 사용
 */

@WebServlet(name = "mvcMemberFormServlet", urlPatterns = "/servlet-mvc/members/new-form")
public class MvcMemberFormServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String viewPath = "/WEB-INF/views/new-form.jsp";    // /WEB-INF 경로 안에 JSP가 있으면 외부에서 직접 JSP를 호출할 수 없다.
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        dispatcher.forward(request, response);      // 다른 서블릿이나 JSP로 이동

    }
}
