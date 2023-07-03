package cdac.acts.thread;
import cdac.acts.com.*;

public class TimerEffect {
	
	public static void  loadEffect(String Msg) {
		System.out.println(Msg);
		
		for(int i=0; i<10;i++) {
			try {
				Thread.sleep(300);
				System.out.print("- ");
			}catch (InterruptedException e) {
				System.out.println("OOPS ! Something went Wrong");
			}
		}System.out.println();
	}

	public static void  loadEffect(String Msg, String Token) {
		System.out.println(Msg);
		
		for(int i=0; i<10;i++) {
			try {
				Thread.sleep(300);
				System.out.print( " "+ Token);
			}catch (InterruptedException e) {
				System.out.println("OOPS ! Something went Wrong");
			}
		}System.out.println();
	}
}
