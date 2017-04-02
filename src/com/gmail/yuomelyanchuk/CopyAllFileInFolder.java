package com.gmail.yuomelyanchuk;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

public class CopyAllFileInFolder {
	private String sourceFolder = "";
	private String destFolder = "";
	private File f;

	public CopyAllFileInFolder(String sourceFolder, String destFolder) {
		super();
		this.sourceFolder = sourceFolder;
		this.destFolder = destFolder;
		
	}

	public void copyFiles() {
		f = new File(sourceFolder);
		File[] fileList = f.listFiles();
		File dest = new File(destFolder);
		ExecutorService exSer = Executors.newFixedThreadPool(4);
		if (dest.isDirectory()) {			
			ArrayList<Callable<Boolean>> tasks = new ArrayList<>();
			for (File file : fileList) {			
				File toFile= new File(dest.getAbsolutePath()+"\\"+file.getName());
				tasks.add(new FileCopy(file, toFile));
				try{
					exSer.invokeAll(tasks);
				}catch (InterruptedException e1) {
					e1.printStackTrace();
				}

			}
		}

	}

}
