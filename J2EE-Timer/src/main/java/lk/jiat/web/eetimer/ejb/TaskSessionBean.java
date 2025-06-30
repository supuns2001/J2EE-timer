package lk.jiat.web.eetimer.ejb;

import jakarta.annotation.Resource;
import jakarta.ejb.Stateless;
import jakarta.enterprise.concurrent.ManagedExecutorService;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;

@Stateless
public class TaskSessionBean {

    @Resource
    ManagedExecutorService executorService;

    public Future<String> doTask(){
        System.out.println("do task...");

       return executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("Sending Message.."+Thread.currentThread().getName());

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                System.out.println("Message Sent "+Thread.currentThread().getName());

                return "Task done";
            }
        });

//        executorService.submit(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Sending Message.."+Thread.currentThread().getName());
//
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//
//                System.out.println("Message Sent "+Thread.currentThread().getName());
//
//
//            }
//        });


    }
}
