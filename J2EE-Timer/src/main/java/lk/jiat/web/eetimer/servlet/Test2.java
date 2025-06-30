package lk.jiat.web.eetimer.servlet;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.jiat.web.eetimer.ejb.TimerSessionBean;

import java.io.IOException;

@WebServlet("/test2")
public class Test2 extends HttpServlet {

    @EJB
    TimerSessionBean timerSessionBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        timerSessionBean.cancelTimer();

    }
}
