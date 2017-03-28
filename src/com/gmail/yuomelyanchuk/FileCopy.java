package com.gmail.yuomelyanchuk;


import java.util.concurrent.Callable;
import java.io.*;

public class FileCopy implements Callable<Boolean> {

	private File source;
	private File dest ;

	public FileCopy(File source, File dest) {
		super();
		this.source = source;
		this.dest = dest;
	}
	
	private boolean fileCopy(File source,File dest){
		try(InputStream is=new FileInputStream(source);
				OutputStream os	=new FileOutputStream(dest)){
			byte[] buffer = new byte[1024];
			int len;
			for(;(len=is.read(buffer))>0;){
				os.write(buffer, 0, len);
			}			
			return(true);
			
			
		}catch (IOException e) {
			e.printStackTrace();
			return(false);
		}	
	}

	@Override
	public Boolean call() throws Exception {
		return(fileCopy(source, dest));			

	}

}
