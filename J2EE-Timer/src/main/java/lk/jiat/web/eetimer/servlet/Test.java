package lk.jiat.web.eetimer.servlet;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.jiat.web.eetimer.ejb.TaskSessionBean;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@WebServlet("/test")
public class Test extends HttpServlet {

    @EJB
    private TaskSessionBean taskSessionBean;


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       Future<String> doTask = taskSessionBean.doTask();

        try {
             String s = doTask.get();
             response.getWriter().println(s);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
