package com.gmail.yuomelyanchuk;

import java.math.BigInteger;

public class FactorialThread implements Runnable {
	public FactorialThread(int number) {
		super();
	}

	private BigInteger calculateFactorial(int number) {
		BigInteger fact = new BigInteger("1");
		for (int i = 2; i <= number; i++) {
			fact = fact.multiply(new BigInteger("" + i));
		}

		return fact;
	}

	@Override
	public void run() {
		Thread th = Thread.currentThread();
		System.out.println(th.getName()+"!="+ calculateFactorial(Integer.parseInt(th.getName())));

	}
}
