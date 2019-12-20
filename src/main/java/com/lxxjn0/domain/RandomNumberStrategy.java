/*
 * @(#)RandomNumbers.java		0.1 2019.12.20
 *
 * Copyright (c) 2019 lxxjn0
 */

package com.lxxjn0.domain;

import java.util.Random;

public class RandomNumberStrategy {
	private static final int FORWARD_JUDGEMENT_NUMBER = 3;
	private static final int RANDOM_NUMBER_UPPER_BOUND = 10;

	public boolean isMoveforward() {
		return getRandomNumber() > FORWARD_JUDGEMENT_NUMBER;
	}

	private int getRandomNumber() {
		return new Random().nextInt(RANDOM_NUMBER_UPPER_BOUND);
	}
}
