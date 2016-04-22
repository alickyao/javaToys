package toysThred;

import java.util.Date;

public class TestThred {

	/*
	 * 
	 * 线程
	 * 
	 */
	public static void main(String[] args) {
		Run run= new Run();
		Thread thread = new Thread(run);
		thread.start();
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		thread.interrupt();
	}
}

//线程类
class Run implements Runnable {
	public void run() {
		while (true) {
			try {
				Thread.sleep(1000);
				System.out.println("==="+ (new Date()) +"===");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				return;
			}
		}
	}
}
