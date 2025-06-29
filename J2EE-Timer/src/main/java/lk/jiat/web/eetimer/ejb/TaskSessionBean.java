package lk.jiat.web.eetimer.ejb;

import jakarta.annotation.Resource;
import jakarta.ejb.Stateless;
import jakarta.enterprise.concurrent.ManagedExecutorService;

@Stateless
public class TaskSessionBean {

    @Resource
    ManagedExecutorService executorService;

    public void doTask(){
        System.out.println("do task...");

        executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("Sending Message.."+Thread.currentThread().getName());

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                System.out.println("Message Sent "+Thread.currentThread().getName());

            }
        });


    }
}
