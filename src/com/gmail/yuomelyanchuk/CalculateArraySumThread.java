package com.gmail.yuomelyanchuk;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.math.BigInteger;

public class CalculateArraySumThread {

	private ArrayList<Future<BigInteger>> result = new ArrayList<>();
	private int[] arr;
	private int proc = Runtime.getRuntime().availableProcessors()*2;
	private BigInteger total = new BigInteger("0");

	public CalculateArraySumThread(int[] arr) {
		super();
		this.arr = arr;
	}

	public CalculateArraySumThread() {
		super();
	}

	public void setArr(int[] arr) {
		this.arr = arr;
	}

	public BigInteger getTotal() {
		return total;
	}

	public void calcSum() {
		generateThread();
		totalSum();
	}

	private void generateThread() {
		FutureTask<BigInteger> res;
		for (int i = 0; i < proc; i += 1) {
			int startIndex = (arr.length / proc) * i;
			int endIndex = ((arr.length / proc) * (i + 1)) - 1;
			if (i != (proc - 1)) {
				res = new FutureTask<>(new PartArraySum(startIndex, endIndex, arr));
			} else {
				res = new FutureTask<>(new PartArraySum(startIndex, arr.length - 1, arr));
			}
			result.add(res);
			Thread thread = new Thread(res);
			thread.start();
		}
	}

	private void totalSum() {
		for (Future<BigInteger> future : result) {
			try {
				total = total.add(future.get());

			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}

	}

}
