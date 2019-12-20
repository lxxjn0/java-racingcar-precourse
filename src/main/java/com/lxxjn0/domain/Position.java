/*
 * @(#)Position.java		0.1 2019.12.20
 *
 * Copyright (c) 2019 lxxjn0
 */

package com.lxxjn0.domain;

import java.util.Objects;

import com.lxxjn0.ui.Output;

public class Position {
	private static final int POSITION_MIN = 0;
	private static final int MOVE_ONCE = 1;

	public static Position ZERO = new Position(POSITION_MIN);

	private final int position;

	public Position(int position) {
		isValid(position);

		this.position = position;
	}

	private void isValid(int position) {
		if (position < POSITION_MIN) {
			throw new IllegalArgumentException(Output.VALID_POSITION_EXCEPTION_MESSAGE);
		}
	}

	public Position moveForward() {
		return new Position(position + MOVE_ONCE);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Position comparePosition = (Position)o;
		return position == comparePosition.position;
	}

	@Override
	public int hashCode() {
		return Objects.hash(position);
	}

	public int getPosition() {
		return position;
	}
}
