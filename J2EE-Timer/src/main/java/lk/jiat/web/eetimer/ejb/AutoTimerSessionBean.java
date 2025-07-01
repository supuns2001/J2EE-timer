package lk.jiat.web.eetimer.ejb;

import jakarta.ejb.Schedule;
import jakarta.ejb.Schedules;
import jakarta.ejb.Stateless;

@Stateless
public class AutoTimerSessionBean {

    @Schedules({
            @Schedule(hour = "21",minute = "3",second = "10" , persistent = false)  ,
            @Schedule(hour = "21",minute = "3",second = "10" , persistent = false)  ,
            @Schedule(hour = "21",minute = "3",second = "10" , persistent = false)  ,
            @Schedule(hour = "21",minute = "3",second = "10" , persistent = false)
    })


    public void autoSchedule(){
        System.out.println("autoSchedule...");
    }
}
