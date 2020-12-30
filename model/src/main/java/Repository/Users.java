package Repository;

import by.koreshkov.Administrator;
import by.koreshkov.application.Init;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Users {
List<Object> users = new ArrayList<>();

    public void save(Object o){
        users.add(o);
    }

    public void remove(Object o){
        users.remove(o);
    }

    public String authorization(String login, String password){
        for (Object user : users) {
            String userLogin = user.getLogin();
            String userPassword = user.getPassword();
            if (login.equals(userLogin) && password.equals(userPassword)) {

            }



        }

}
