package lk.jiat.web.eetimer.ejb;

import jakarta.annotation.Resource;
import jakarta.ejb.*;

import java.util.Collection;

@Stateless
public class TimerSessionBean {

    @Resource
    private TimerService timerService;



    public void doTask(){

        timerService.createTimer( 5000 , "Clock");

        TimerConfig timerConfig = new TimerConfig();
        timerConfig.getInfo();

        timerService.createSingleActionTimer(5000, timerConfig);

         Collection<Timer> allTimers = timerService.getAllTimers();
         allTimers.forEach(timer->{

         });
    }


    @Timeout
    public void  timeOutTask(Timer timer){
        System.out.println("ok.. " + timer);
    }

    public void cancelTimer(){
//        if (timer != null) {
//            timer.cancel();
//        }
    }
}
