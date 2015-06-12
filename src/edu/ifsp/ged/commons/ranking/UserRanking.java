package edu.ifsp.ged.commons.ranking;

public class UserRanking extends Ranking {

	private long rankingId;
	private int points;
	private int pointsDriven;
	private int pointsSearch;
	private int pointsUseFrequency;
	private int pointsRegistrationDate;
	private int pointsAnalyses;
	private int pointsConfidence;
	
	public long getRankingId() {
		return rankingId;
	}

	public void setRankingId(long rankingId) {
		this.rankingId = rankingId;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public int getPointsDriven() {
		return pointsDriven;
	}

	public void setPointsDriven(int pointsDriven) {
		this.pointsDriven = pointsDriven;
	}

	public int getPointsSearch() {
		return pointsSearch;
	}

	public void setPointsSearch(int pointsSearch) {
		this.pointsSearch = pointsSearch;
	}

	public int getPointsUseFrequency() {
		return pointsUseFrequency;
	}

	public void setPointsUseFrequency(int pointsUseFrequency) {
		this.pointsUseFrequency = pointsUseFrequency;
	}

	public int getPointsRegistrationDate() {
		return pointsRegistrationDate;
	}

	public void setPointsRegistrationDate(int pointsRegistrationDate) {
		this.pointsRegistrationDate = pointsRegistrationDate;
	}

	public int getPointsAnalyses() {
		return pointsAnalyses;
	}

	public void setPointsAnalyses(int pointsAnalyses) {
		this.pointsAnalyses = pointsAnalyses;
	}

	public int getPointsConfidence() {
		return pointsConfidence;
	}

	public void setPointsConfidence(int pointsConfidence) {
		this.pointsConfidence = pointsConfidence;
	}
}
