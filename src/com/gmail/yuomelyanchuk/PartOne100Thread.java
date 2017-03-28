package com.gmail.yuomelyanchuk;

public class PartOne100Thread  implements Runnable{

	@Override
	public void run() {
		Thread[] th = new Thread[100];
		for (int i = 0; i < th.length; i++) {
			
			th[i]=new Thread(new FactorialThread(i));
			th[i].setName(""+(i+1));
		}
		
		for (Thread thread : th) {
			thread.start();
		}
		
	}
	
	

}
