package com.gmail.yuomelyanchuk;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class FolderViewer implements Runnable {
	private File[] filelist;
	private String path;
	private long time = 0;

	public FolderViewer(String path) {
		super();
		this.path = path;
		filelist = (new File(path)).listFiles();
	}

	private boolean isExist(File[] files, File chekFile) {
		for (File file : files) {
			if (file.getName().compareTo(chekFile.getName()) == 0) {
				return (true);
			}
		}
		return (false);

	}

	private void compareFileList(File[] fOld, File[] fNew) {
		for (File file : fNew) {
			if (!isExist(fOld, file)) {
				System.out.println("File " + file.getName() + " was added");
			}
		}
		for (File file : fOld) {
			if (!isExist(fNew, file)) {
				System.out.println("File " + file.getName() + " was deleted");
			}
		}
	}

	@Override
	public void run() {
		System.out.println((new Date()));
		compareFileList(filelist, (new File(path)).listFiles());
		filelist = (new File(path)).listFiles();

	}

}
