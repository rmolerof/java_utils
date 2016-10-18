package org.fedex.sandbox.utils.timertask;

import java.awt.Toolkit;
import java.util.Timer;
import java.util.TimerTask;

public class RepetitiveBeep {
	
	Toolkit toolkit;
	Timer timer;
	
	public RepetitiveBeep(){
		toolkit = Toolkit.getDefaultToolkit();
		timer = new Timer();
		timer.schedule(new RemindTask(), 
				1000, // initial delay 
				2000); // period
	}
	
	class RemindTask extends TimerTask{
		int numberOfBeeps = 5;
		public void run(){
			if(numberOfBeeps > 0){
				toolkit.beep();
				System.out.println("Beep");
				numberOfBeeps--;
			} else {
				toolkit.beep();
				System.out.println("Time's up!");
				System.exit(0);
			}
		}
	}
	
	public static void main(String args[]){
		new RepetitiveBeep();
		System.out.println("Task scheduled");		
	}
}
