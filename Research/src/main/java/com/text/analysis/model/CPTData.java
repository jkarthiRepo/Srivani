package com.text.analysis.model;

public class CPTData {

	private Long studentId;
	private String testDate;
	private Double speedScore;
	private Double responsesReturned;
	private Double bestScore;
	private Double arithmeticScore;
	private Double noOfCorrectProblems;
	private Double bestArScore;
	private Double flexibilityValue;
	private Double noofCorrectCards;
	private Double fuseCluesScore;
	private Double memoryScore;
	private Double noOfTargetedBlocks;
	private Double noOfIncorrectBlocks;

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public String getTestDate() {
		return testDate;
	}

	public void setTestDate(String testDate) {
		this.testDate = testDate;
	}

	public Double getFlexibilityValue() {
		return flexibilityValue;
	}

	public void setFlexibilityValue(Double flexibilityValue) {
		this.flexibilityValue = flexibilityValue;
	}

	public Double getNoofCorrectCards() {
		return noofCorrectCards;
	}

	public void setNoofCorrectCards(Double noofCorrectCards) {
		this.noofCorrectCards = noofCorrectCards;
	}

	public Double getSpeedScore() {
		return speedScore;
	}

	public void setSpeedScore(Double speedScore) {
		this.speedScore = speedScore;
	}

	public Double getResponsesReturned() {
		return responsesReturned;
	}

	public void setResponsesReturned(Double responsesReturned) {
		this.responsesReturned = responsesReturned;
	}

	public Double getBestScore() {
		return bestScore;
	}

	public void setBestScore(Double bestScore) {
		this.bestScore = bestScore;
	}

	public Double getArithmeticScore() {
		return arithmeticScore;
	}

	public void setArithmeticScore(Double arithmeticScore) {
		this.arithmeticScore = arithmeticScore;
	}

	public Double getNoOfCorrectProblems() {
		return noOfCorrectProblems;
	}

	public void setNoOfCorrectProblems(Double noOfCorrectProblems) {
		this.noOfCorrectProblems = noOfCorrectProblems;
	}

	public Double getBestArScore() {
		return bestArScore;
	}

	public void setBestArScore(Double bestArScore) {
		this.bestArScore = bestArScore;
	}

	public Double getFuseCluesScore() {
		return fuseCluesScore;
	}

	public void setFuseCluesScore(Double fuseCluesScore) {
		this.fuseCluesScore = fuseCluesScore;
	}

	public Double getMemoryScore() {
		return memoryScore;
	}

	public void setMemoryScore(Double memoryScore) {
		this.memoryScore = memoryScore;
	}

	public Double getNoOfTargetedBlocks() {
		return noOfTargetedBlocks;
	}

	public void setNoOfTargetedBlocks(Double noOfTargetedBlocks) {
		this.noOfTargetedBlocks = noOfTargetedBlocks;
	}

	public Double getNoOfIncorrectBlocks() {
		return noOfIncorrectBlocks;
	}

	public void setNoOfIncorrectBlocks(Double noOfIncorrectBlocks) {
		this.noOfIncorrectBlocks = noOfIncorrectBlocks;
	}

	@Override
	public String toString() {
		return "CPTData [studentId=" + studentId + ", testDate=" + testDate + ", speedScore=" + speedScore
				+ ", responsesReturned=" + responsesReturned + ", bestScore=" + bestScore + ", arithmeticScore="
				+ arithmeticScore + ", noOfCorrectProblems=" + noOfCorrectProblems + ", bestArScore=" + bestArScore
				+ ", flexibilityValue=" + flexibilityValue + ", noofCorrectCards=" + noofCorrectCards
				+ ", fuseCluesScore=" + fuseCluesScore + ", memoryScore=" + memoryScore + ", noOfTargetedBlocks="
				+ noOfTargetedBlocks + ", noOfIncorrectBlocks=" + noOfIncorrectBlocks + ", getStudentId()="
				+ getStudentId() + ", getTestDate()=" + getTestDate() + ", getFlexibilityValue()="
				+ getFlexibilityValue() + ", getNoofCorrectCards()=" + getNoofCorrectCards() + ", getSpeedScore()="
				+ getSpeedScore() + ", getResponsesReturned()=" + getResponsesReturned() + ", getBestScore()="
				+ getBestScore() + ", getArithmeticScore()=" + getArithmeticScore() + ", getNoOfCorrectProblems()="
				+ getNoOfCorrectProblems() + ", getBestArScore()=" + getBestArScore() + ", getFuseCluesScore()="
				+ getFuseCluesScore() + ", getMemoryScore()=" + getMemoryScore() + ", getNoOfTargetedBlocks()="
				+ getNoOfTargetedBlocks() + ", getNoOfIncorrectBlocks()=" + getNoOfIncorrectBlocks() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}
