package by.koreshkov.filters;


import by.koreshkov.Person;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.http.HttpRequest;

@WebFilter(urlPatterns = {"/adminStartPage", "/insertPerson", "/insertSalaryJSP",
                            "/updatePersonJSP", "/updateSalaryJSP"})
public class AdminFilter implements Filter {

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
                if (user.getRole().equals("admin")) {
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
