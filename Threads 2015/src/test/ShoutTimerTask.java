/*
 * Created on May 28, 2015
 *
 */
package test;

import java.util.Timer;
import java.util.TimerTask;

public class ShoutTimerTask extends TimerTask {

    private Timer timer;
    
    public ShoutTimerTask() {
        // TODO Auto-generated constructor stub
    }

    public ShoutTimerTask(Timer timer) {
        super();
        this.timer = timer;
    }

    @Override
    public void run() {
        System.out.println();
        System.out.println("Yeah!");
        System.out.println();
        timer.cancel();
        timer.purge();
    }
    
}
