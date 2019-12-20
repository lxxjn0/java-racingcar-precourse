package com.lxxjn0.domain;

import java.util.ArrayList;
import java.util.List;

public class RaceResult {
	private List<RaceStatus> raceResult;

	public RaceResult() {
		this.raceResult = new ArrayList<>();
	}

	public void add(RaceStatus newRaceStatus) {
		raceResult.add(newRaceStatus);
	}

	public List<Car> getWinner() {
		final int lastResult = raceResult.size() - 1;
		return raceResult.get(lastResult).getWinner();
	}

	public List<RaceStatus> getRaceResult() {
		return raceResult;
	}
}
