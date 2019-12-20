/*
 * @(#)Input.java		0.2 2019.12.20
 *
 * Copyright (c) 2019 lxxjn0.
 */

package com.lxxjn0.ui;

import java.util.Scanner;

/**
 * 입력과 관련된 모든 기능을 담당하는 Input 클래스.
 *
 * @author JUNYOUNG LEE (lxxjn0)
 * @version 0.2 2019.12.20
 */
public class Input {
	private static Scanner scanner;

	public static String receiveCarNamesInput() {
		scanner = new Scanner(System.in);

		Output.printRequestCarNamesInput();
		return scanner.nextLine();
	}

	public static String receiveAttemptNumberInput() {
		scanner = new Scanner(System.in);

		Output.printRequestAttemptNumberInput();
		return scanner.nextLine();
	}
}
