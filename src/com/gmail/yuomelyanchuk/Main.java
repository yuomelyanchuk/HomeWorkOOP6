package com.gmail.yuomelyanchuk;

import java.math.BigInteger;
import java.util.Date;
import java.util.concurrent.FutureTask;

public class Main {

	public static void main(String[] args) {
		Thread th = new Thread(new PartOne100Thread());
		th.start();
		Thread t = Thread.currentThread();
		try {
			t.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		int[] arr = new int[100_000_000];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 1000);
		}
		Date st = new Date();
		BigInteger r1 = new BigInteger("0");
		for (int j = 0; j < arr.length; j++) {
			r1 = r1.add(new BigInteger("" + arr[j]));
		}

		Date en = new Date();
		System.out.println("sum=" + r1 + " by " + (en.getTime() - st.getTime()) / 1000 + " sec");
		st = new Date();
		CalculateArraySumThread summ = new CalculateArraySumThread(arr);
		summ.calcSum();
		en = new Date();
		System.out.println("sum=" + summ.getTotal() + " by " + (en.getTime() - st.getTime()) / 1000 + " sec");

		CopyAllFileInFolder copy = new CopyAllFileInFolder("D:\\corses\\test1", "D:\\corses\\test2");
		copy.copyFiles();

		th = new Thread(new RunFileChecker("D:\\corses\\test2"));
		th.start();
		System.out.println("end");

	}

}
