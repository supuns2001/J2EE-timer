package lk.jiat.web.eetimer.ejb;

import jakarta.annotation.Resource;
import jakarta.ejb.*;
import lk.jiat.web.eetimer.timer.Task;

import java.io.Serializable;
import java.util.UUID;

@Stateless
public class TimerSessionBean {

    @Resource
    private TimerService timerService;



    public Task doTask(long time){


        TimerConfig timerConfig = new TimerConfig();

        String taskId = UUID.randomUUID().toString();
        Task task  = new Task(taskId, "Test Task");
        timerConfig.setInfo(task);
        timerConfig.setPersistent(false);

//        timerService.createSingleActionTimer(time, timerConfig);

        ScheduleExpression expression = new ScheduleExpression();
        expression.dayOfWeek("MON-FRI");

        //expression.dayOfMonth("L"); //last day of month

        timerService.createCalendarTimer(expression , timerConfig);

        return task;
    }


    @Timeout
    public void  timeOutTask1(Timer timer){
        Serializable info = timer.getInfo();
        if (info instanceof Task) {
            Task task = (Task) info;
            System.out.println(task.getTaskName()+" : "+ task.getTaskId() +" = Task is Done");
        }
    }

    public void cancelTimer(String taskId){

        for (Timer timer : timerService.getTimers()) {
            if (timer.getInfo() instanceof  Task && ((Task) timer.getInfo()).getTaskId().equals(taskId)) {
                timer.cancel();
                System.out.println("Task id is canceled" + taskId);
                break;
            }
        }


//        timerService.getAllTimers().forEach(timer->{
//
//            Task task = (Task) timer.getInfo();
//            if ( task.getTaskId().equals(taskId)) {
//                timer.cancel();
//
//            }
//        });
//
        //        if (timer != null) {
//            timer.cancel();
//        }
    }
}
