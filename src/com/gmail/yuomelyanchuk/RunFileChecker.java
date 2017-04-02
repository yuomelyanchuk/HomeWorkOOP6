package com.gmail.yuomelyanchuk;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;


public class RunFileChecker implements Runnable {

	private String path;
	
	@Override
	public void run() {
		FolderViewer fv = new FolderViewer(path);
		// TODO Auto-generated method stub
		ScheduledExecutorService exs = Executors.newSingleThreadScheduledExecutor();
		ScheduledFuture<?> res = exs.scheduleAtFixedRate(fv, 0, 1,	TimeUnit.SECONDS);
	}

	public RunFileChecker(String path) {
		super();		
		this.path=path;
	}
	
	

}
