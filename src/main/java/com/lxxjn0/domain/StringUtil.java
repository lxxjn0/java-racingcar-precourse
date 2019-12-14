/*
 * @(#)StringUtil.java		0.3 2019.12.14
 *
 * Copyright (c) 2019 lxxjn0.
 */

package com.lxxjn0.domain;

import java.util.Arrays;
import java.util.List;

/**
 * 문자열을 다루는 여러 메소드들을 구현한 StringUtil 클래스.
 *
 * @author JUNYOUNG LEE (lxxjn0)
 * @version 0.32019.12.14
 */
public class StringUtil {
	/**
	 * 문자열을 쉼표(,)를 기준으로 자를 때 사용하기 위한 상수.
	 */
	private static final String COMMA_DELIMITER = ",";

	/**
	 * 자동차의 이동한 위치를 표현할 때 사용하기 위한 상수.
	 */
	private static final String MOVING_BAR = "-";

	/**
	 * 사용자로부터 입력받은 자동차 이름들을 쉼표(,)를 기준으로 잘라서 반환하는 메소드.
	 *
	 * @param userInput 입력받은 자동차 이름 문자열.
	 * @return 쉼표(, )로 구분된 자동차 이름들의 문자열 List.
	 */
	public static List<String> splitCarNames(String userInput) {
		return Arrays.asList(userInput.split(COMMA_DELIMITER));
	}

	/**
	 * 자동차 이름들의 불필요한 공백들을 제거하여 반환하는 메소드.
	 *
	 * @param carNames 자동차 이름들이 저장된 List.
	 */
	public static void trimCarNames(List<String> carNames) {
		for (int i = 0; i < carNames.size(); i++) {
			carNames.set(i, carNames.get(i).trim());
		}
	}

	/**
	 * 자동차의 위치를 moving bar 문자열로 변환하여 반환하는 메소드.
	 *
	 * @param position 해당 자동차의 현재 위치.
	 * @return 자동차의 위치만큼 moving bar로 변환된 문자열.
	 */
	public static String convertPositionToMovingBar(int position) {
		StringBuilder movingPosition = new StringBuilder();

		for (int i = 0; i < position; i++) {
			movingPosition.append(MOVING_BAR);
		}
		return movingPosition.toString();
	}

	/**
	 * 우승한 자동차들의 이름을 하나의 문자열로 합치는 메소드.
	 *
	 * @return 우승한 자동차들의 이름이 하나로 합쳐진 문자열을 반환.
	 */
	public static String joinWinnerNames(List<String> winners) {
		return String.join(COMMA_DELIMITER, winners);
	}
}
