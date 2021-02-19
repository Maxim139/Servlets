package by.koreshkov.filters;

import by.koreshkov.Person;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/insertSubjAndMarksJSP", "/salaryJSP",
                            "/teacherStartPage", "/updateSubjAndMarksJSP"})
public class TeacherFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpSession session = request.getSession();
        ServletContext context = servletRequest.getServletContext();
        Person user = (Person) session.getAttribute("user");

        if (user != null) {
            // if (!user.getRole().equals("")) {
            if (user.getRole().equals("teacher")) {
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                RequestDispatcher dispatcher = context.getRequestDispatcher("/error");
                dispatcher.forward(servletRequest, servletResponse);
            }
        } else {
            RequestDispatcher dispatcher = context.getRequestDispatcher("/error");
            dispatcher.forward(servletRequest, servletResponse);
        }

    }

    @Override
    public void destroy() {

    }
}
