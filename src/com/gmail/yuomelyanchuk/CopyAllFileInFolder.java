package com.gmail.yuomelyanchuk;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.FutureTask;

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
		if (dest.isDirectory()) {
			for (File file : fileList) {			
				File toFile= new File(dest.getAbsolutePath()+"\\"+file.getName());
				try{
				toFile.createNewFile();				
				if (file.isFile()) {
					FutureTask<Boolean> res = new FutureTask<>(	new FileCopy(file, toFile));
					Thread thread = new Thread(res);					
					thread.start();
				}
				}catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
