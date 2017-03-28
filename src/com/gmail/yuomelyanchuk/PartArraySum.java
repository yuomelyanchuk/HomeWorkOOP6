package com.gmail.yuomelyanchuk;

import java.math.BigInteger;
import java.util.concurrent.Callable;

public class PartArraySum implements Callable<BigInteger> {
	private BigInteger sum = new BigInteger("0");
	private int startPosition;
	private int endPosition;
	private int[] array;

	public PartArraySum() {
		super();

	}

	public PartArraySum(int startPosition, int endPosition, int[] array) {
		super();
		this.startPosition = startPosition;
		this.endPosition = endPosition;
		this.array = array;
	}

	private void calculateSum() {
		for (int i = startPosition; i <= endPosition; i += 1) {
			sum = sum.add(new BigInteger("" + array[i]));
		}

	}

	@Override
	public BigInteger call() throws Exception {
		calculateSum();
		return(sum);
	}

}
