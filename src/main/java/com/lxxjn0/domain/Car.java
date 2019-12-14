/*
 * @(#)Car.java     1.2 2019.12.14
 *
 * Copyright (c) 2019 lxxjn0.
 */

package com.lxxjn0.domain;

import java.util.Random;

import com.lxxjn0.ui.Output;

/**
 * Car 클래스
 *
 * @author JUNYOUNG LEE (lxxjn0)
 * @version 1.2 2019.12.14
 */
public class Car {
	/**
	 * 가장 멀리 전진한 위치(furthestPosition)가 0(출발선)인 경우를 확인하기 위한 상수.
	 */
	private static final int STARTING_LINE = 0;

	/**
	 * 자동차의 전진 여부를 판단할 때 사용하는 상수.
	 */
	private static final int FORWARD_JUDGEMENT_NUMBER = 3;

	/**
	 * 생성 가능한 random 변수의 최대 범위를 제한하기 위한 상수.
	 */
	private static final int MAX_RANDOM_RANGE = 10;

	/**
	 * 자동차들의 위치 중에서 가장 먼 위치(Position)의 값을 저장하는 클래스 변수.
	 */
	private static int furthestPosition = 0;

	/**
	 * 자동차의 이름을 저장하는 String 변수.
	 */
	private final String name;

	/**
	 * 자동차의 위치를 저장하는 int 변수.
	 */
	private int position = 0;

	/**
	 * 출력과 관련된 일을 담당할 Output 인스턴스.
	 */
	private Output out = new Output();

	/**
	 * 자동차의 이름을 매개변수로 받는 Car 클래스의 매개변수 생성자.
	 *
	 * @param name 생성할 자동차의 이름.
	 */
	public Car(String name) {
		this.name = name;
	}

	/**
	 * 랜덤한 수에 따라 자동차를 이동시키고, 변경된 position을 출력하고, position이 모든 자동차들 중에서 가장 큰 값이면
	 * furthestPosition을 초기화시키는 메소드.
	 */
	public void raceGameOnce() {
		if (isCarMoveForward()) {
			moveForward();
			setIfFurthestPosition();
		}
		out.printCarMoveResult(name, StringUtil.convertPositionToMovingBar(position));
	}

	/**
	 * 자동차가 앞으로 이동하는지 여부를 판단하는 메소드.
	 *
	 * @return 랜덤하게 생성된 수가 3보다 크면 true 반환.
	 */
	private boolean isCarMoveForward() {
		return (generateRandomNumber() > FORWARD_JUDGEMENT_NUMBER);
	}

	/**
	 * 0부터 9까지의 범위 내의 정수를 랜덤하게 생성해서 반환해주는 메소드.
	 *
	 * @return 0부터 9까지의 범위 내의 랜덤하게 생성된 정수를 반환.
	 */
	private int generateRandomNumber() {
		return new Random().nextInt(MAX_RANDOM_RANGE);
	}

	/**
	 * 자동차를 앞으로 이동시키는 메소드.
	 */
	private void moveForward() {
		position++;
	}

	/**
	 * 전진한 위치가 모든 자동차들 중 가장 큰 값이면 해당 위치로 furthestPosition을 초기화시키는 메소드.
	 */
	private void setIfFurthestPosition() {
		if (position > furthestPosition) {
			furthestPosition = position;
		}
	}

	/**
	 * 모든 자동차가 이동하지 않고 출발선에 위치해 있는지 여부를 확인하는 메소드.
	 *
	 * @return 자동차들의 위치 중 position이 가장 큰 값(furthestPosition)이 0이면 true 반환.
	 */
	public static boolean isNoWinnerExist() {
		return (furthestPosition == STARTING_LINE);
	}

	/**
	 * 해당 자동차가 우승자인지 판단하는 메소드.
	 *
	 * @return 자동차의 위치가 가장 먼 position이면 true 반환.
	 */
	public boolean isWinner() {
		return (position == furthestPosition);
	}

	/**
	 * name getter
	 *
	 * @return 자동차의 이름을 반환.
	 */
	public String getName() {
		return name;
	}
}
