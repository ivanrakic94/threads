/*
 * Created on May 28, 2015
 *
 */
package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;

import javax.swing.JTextArea;

import music.Performance;
import music.Singer;
import music.Solo;
import music.Song;
import music.Synchronizer;
import music.Voice;

public class Test {
    
    public static final Scanner IN = new Scanner(System.in);

    private Song song;
    private Performance performance;
    private Singer bbk;
    private Singer bono;
    private Solo solo;
    
    public Test() {
        // TODO Auto-generated constructor stub
    }
    
    public void initialize() {
        List<String> lyrics = new ArrayList<String>();
        lyrics.add("When love comes to town I'm gonna jump that train");
        lyrics.add("When love comes to town I'm gonna catch that flame.");
        lyrics.add("Maybe I was wrong to ever let you down");
        lyrics.add("But I did what I did before love came to town.");
        
        song = new Song("When Love Comes to Town", lyrics);
        performance = new Performance(song, 1000);
        Synchronizer synch = new Synchronizer(true, false);
        boolean stopIt = false;
        
//        bbk = new Singer("B.B. King", Voice.LEAD, performance);
//        bono = new Singer("Bono", Voice.BACKING, performance);
        
        bbk = new Singer("B.B. King", Voice.LEAD, performance, stopIt, synch);
        bono = new Singer("Bono", Voice.BACKING, performance, stopIt, synch);
        solo = new Solo("B. B. King", performance, synch, stopIt);
    }
    
    public synchronized void simpleWait() {
        System.out.println("Wait 2sec...");
        try {
            wait(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("Done.");
    }
    
    public void loopWait() {
        for (int i = 0; i < 5; i++) {
            simpleWait();
        }
    }
    
    public void timerWait() {
        Timer timer = new Timer();
        ShoutTimerTask mtt = new ShoutTimerTask(timer);
        timer.schedule(mtt, 4500);
        loopWait();
    }
    
    public void testPickLine() {
        initialize();
        System.out.println(song.allLyrics());
        System.out.println(song.pickLine(Voice.LEAD, 0));
    }
    
    public void testSing() {
        initialize();
        bbk.sing(song, 8);
        System.out.println();
        bono.sing(song, 8);
    }

    public void testSingWithDelay() {
        initialize();
        bbk.singWithDelay(song, 8);
        System.out.println();
        bono.singWithDelay(song, 8);
    }

    public void testSingWithTimer() {
        initialize();
        
        Timer timer = new Timer();
        ShoutTimerTask shout = new ShoutTimerTask(timer);
        timer.schedule(shout, 2500);
        
        bbk.singWithDelay(song, 8);
    }
    
    public void testSingWithThreads() {
        initialize();
        bbk.start();
        bono.start();
        solo.start();        
    }
    
    public void stop() {
    	bbk.setStopIt(true);
    	bono.setStopIt(true);
    	solo.setStop(true);
    }

	public Song getSong() {
		return song;
	}

	public void setSong(Song song) {
		this.song = song;
	}

	public Performance getPerformance() {
		return performance;
	}

	public void setPerformance(Performance performance) {
		this.performance = performance;
	}

	public Singer getBbk() {
		return bbk;
	}

	public void setBbk(Singer bbk) {
		this.bbk = bbk;
	}

	public Singer getBono() {
		return bono;
	}

	public void setBono(Singer bono) {
		this.bono = bono;
	}

	public Solo getSolo() {
		return solo;
	}

	public void setSolo(Solo solo) {
		this.solo = solo;
	}

}
