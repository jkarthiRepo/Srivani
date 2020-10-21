package com.text.analysis.core;

import java.util.List;
import java.util.stream.Collectors;

import com.text.analysis.model.AcademicData;
import com.text.analysis.model.CPTData;
import com.text.analysis.readerwriter.Reader;
import com.text.analysis.util.CoreUtil;

public class CPT_Calculation {

	public static void main(String[] args) {

		List<AcademicData> academicDataList = Reader.readAcademicFile();
		List<CPTData> cpt234DataList = Reader.readCPT234DataList();
		List<CPTData> cpt567DataList = Reader.readCPT567DataList();

		academicDataList.stream().forEach(studentData -> {
			if ("234".contains(studentData.getStandard())) {
				Double totalAcademicMarksPercentage = findPercentageValue(studentData, 95.0, 85.0, 75.0);
				Double totalAcademicMarksValue = findPercentageValue(studentData, 1, 0.5, 0);

				System.out.println("Student ID : " + studentData.getStudentId() + "\nStandard : "
						+ studentData.getStandard() + "\nPercentage : "
						+ totalAcademicMarksPercentage + "\nValue : " + totalAcademicMarksValue);
				CPTData cptData = cpt234DataList.stream()
						.filter(x -> x.getStudentId().equals(studentData.getStudentId())).collect(Collectors.toList())
						.get(0);

				Double highestBestScore = cpt234DataList.stream()
						.sorted((c1, c2) -> (c2.getBestScore().intValue() - c1.getBestScore().intValue()))
						.collect(Collectors.toList()).get(0).getBestScore();
				Double highestBestArScore = cpt234DataList.stream()
						.sorted((c1, c2) -> (c2.getBestArScore().intValue() - c1.getBestArScore().intValue()))
						.collect(Collectors.toList()).get(0).getBestArScore();

				Double totalNoOfQuestions = ((highestBestScore * 250) - cptData.getSpeedScore()) / 100;
				Double totalNoOfProblems = ((highestBestArScore * 250) - cptData.getArithmeticScore()) / 100;
				Double taskLearningValue = cptData.getFlexibilityValue() / cptData.getNoofCorrectCards();
				Double responseRate = (cptData.getResponsesReturned() / totalNoOfQuestions) * 100;
				Double processingSpeedIndex = cptData.getSpeedScore() / totalNoOfQuestions;
				Double recallLevelValue = cptData.getResponsesReturned() / 60;
				Double totalNoOfmixedProblems = totalNoOfProblems / cptData.getNoofCorrectCards();
				Double accuracy = 1
						- ((totalNoOfmixedProblems) / (totalNoOfmixedProblems + cptData.getNoofCorrectCards()));
				Double numericalRelashioshipIndex = cptData.getArithmeticScore() / totalNoOfQuestions;
				Double relativePerformanceIndex = (cptData.getArithmeticScore() / cptData.getNoOfCorrectProblems())
						/ 10;
				float cptScore = CoreUtil
						.normalise((float) (taskLearningValue + processingSpeedIndex + numericalRelashioshipIndex));
				System.out.println("");
				String pattern = (cptScore < totalAcademicMarksValue) ? "Pattern of Cognitive Processing as Weakness"
						: (cptScore >= totalAcademicMarksValue) ? "Pattern of Cognitive Processing as Strength" : "";
				System.out.println(pattern + "\n");
				String flexibilityValueLevel = (cptData.getFlexibilityValue() > 8000
						&& cptData.getFlexibilityValue() <= 15000)
								? "HIGH"
								: (cptData.getFlexibilityValue() > 3000 && cptData.getFlexibilityValue() <= 8000)
										? "MEDIUM"
										: (cptData.getFlexibilityValue() >= 600
												&& cptData.getFlexibilityValue() <= 3000) ? "LOW" : "NEUTRAL";

				String responseRateLevel = (responseRate > 50 && responseRate <= 100) ? "HIGH"
						: (responseRate > 30 && responseRate <= 50) ? "MEDIUM"
								: (responseRate >= 5 && responseRate <= 30) ? "LOW" : "NEUTRAL";
				System.out.println("ResponseRateLevel & Level " + responseRate + " ==>" + responseRateLevel);

				String relativePerformanceIndexLevel = (relativePerformanceIndex > 50
						&& relativePerformanceIndex <= 100)
								? "HIGH"
								: (relativePerformanceIndex > 20 && relativePerformanceIndex <= 50) ? "MEDIUM"
										: (relativePerformanceIndex >= 5 && relativePerformanceIndex <= 20) ? "LOW"
												: "NEUTRAL";
				System.out.println("RelativePerformanceIndex & Level " + relativePerformanceIndex + " ==>"
						+ relativePerformanceIndexLevel);

				String accuracyLevel = (accuracy > 70 && accuracy <= 100) ? "HIGH"
						: (accuracy > 40 && accuracy <= 70) ? "MEDIUM"
								: (accuracy >= 5 && accuracy <= 40) ? "LOW" : "NEUTRAL";
				System.out.println("Accuracy & Level " + accuracy + " ==>" + accuracyLevel);

				String recallLevel = (recallLevelValue > 0.6 && recallLevelValue <= 1) ? "HIGH"
						: (recallLevelValue > 0.2 && recallLevelValue <= 0.6) ? "MEDIUM"
								: (recallLevelValue >= 0 && recallLevelValue <= 0.2) ? "LOW" : "NEUTRAL";
				System.out.println("RecallLevelValue & Level " + recallLevelValue + " ==>" + recallLevel);

				String speedScoreLevel = (cptData.getSpeedScore() > 8000 && cptData.getSpeedScore() <= 12000) ? "HIGH"
						: (cptData.getSpeedScore() > 4000 && cptData.getSpeedScore() <= 8000) ? "MEDIUM"
								: (cptData.getSpeedScore() >= 200 && cptData.getSpeedScore() <= 4000) ? "LOW"
										: "NEUTRAL";
				System.out.println("SpeedScore & Level " + cptData.getSpeedScore() + " ==>" + speedScoreLevel);

				String arithmeticScoreLevel = (cptData.getArithmeticScore() > 4000
						&& cptData.getArithmeticScore() <= 6000)
								? "HIGH"
								: (cptData.getArithmeticScore() > 2000 && cptData.getArithmeticScore() <= 4000)
										? "MEDIUM"
										: (cptData.getArithmeticScore() >= 500 && cptData.getArithmeticScore() <= 2000)
												? "LOW"
												: "NEUTRAL";
				System.out.println(
						"ArithmeticScore & Level " + cptData.getArithmeticScore() + " ==>" + arithmeticScoreLevel);

				String cptScoreLevel = (cptScore > 0.6 && cptScore <= 1) ? "HIGH"
						: (cptScore > 0.2 && cptScore <= 0.6) ? "MEDIUM"
								: (cptScore >= 0 && cptScore <= 0.2) ? "LOW" : "NEUTRAL";
				System.out.println("CPTScore & Level " + cptScore + " ==>" + cptScoreLevel);

				Double reasoningCoefficient = ((flexibilityValueLevel.equals("HIGH") && responseRateLevel.equals("HIGH")
						&& recallLevel.equals("HIGH") && speedScoreLevel.equals("HIGH")
						&& arithmeticScoreLevel.equals("HIGH") && cptScoreLevel.equals("HIGH")
						&& relativePerformanceIndexLevel.equals("HIGH") && accuracyLevel.equals("HIGH"))
						&& (totalAcademicMarksValue == 0.1)) ? 1.0 :

								((flexibilityValueLevel.equals("MEDIUM") && responseRateLevel.equals("MEDIUM")
										&& recallLevel.equals("MEDIUM") && speedScoreLevel.equals("MEDIUM")
										&& arithmeticScoreLevel.equals("MEDIUM") && cptScoreLevel.equals("MEDIUM")
										&& relativePerformanceIndexLevel.equals("MEDIUM")
										&& accuracyLevel.equals("MEDIUM")) && (totalAcademicMarksValue == 0.5)) ? 0.5 :

												((flexibilityValueLevel.equals("LOW") && responseRateLevel.equals("LOW")
														&& recallLevel.equals("LOW") && speedScoreLevel.equals("LOW")
														&& arithmeticScoreLevel.equals("LOW")
														&& cptScoreLevel.equals("LOW")
														&& relativePerformanceIndexLevel.equals("LOW")
														&& accuracyLevel.equals("LOW"))
														&& (totalAcademicMarksValue == 1.0)) ? 0.0 : 0.0;

				System.out.println("Reasoning Coefficient : " + reasoningCoefficient);
				System.out.println(
						"============================================================================================================================================");

			} else if ("567".contains(studentData.getStandard())) {

				Double totalAcademicMarksPercentage = findPercentageValue(studentData, 95.0, 85.0, 75.0);
				Double totalAcademicMarksValue = findPercentageValue(studentData, 1, 0.5, 0);

				System.out.println("Student ID : " + studentData.getStudentId() + "\nStandard : "
						+ studentData.getStandard() + "\nPercentage : "
						+ totalAcademicMarksPercentage + "\nValue : " + totalAcademicMarksValue);

				CPTData cptData = cpt567DataList.stream()
						.filter(x -> x.getStudentId().equals(studentData.getStudentId())).collect(Collectors.toList())
						.get(0);

				Double highestBestScore = cpt567DataList.stream()
						.sorted((c1, c2) -> (c2.getBestScore().intValue() - c1.getBestScore().intValue()))
						.collect(Collectors.toList()).get(0).getBestScore();
				Double highestBestArScore = cpt567DataList.stream()
						.sorted((c1, c2) -> (c2.getBestArScore().intValue() - c1.getBestArScore().intValue()))
						.collect(Collectors.toList()).get(0).getBestArScore();

				Double totalNoOfQuestions = ((highestBestScore * 250) - cptData.getSpeedScore()) / 100;
				Double totalNoOfProblems = ((highestBestArScore * 250) - cptData.getArithmeticScore()) / 100;
				Double responseRate = (cptData.getResponsesReturned() / totalNoOfQuestions) * 100;
				Double processingSpeedIndex = cptData.getSpeedScore() / totalNoOfQuestions;
				Double recallLevelValue = cptData.getResponsesReturned() / 60;
				Double longTermStorageAndRetrevalIndex = cptData.getFuseCluesScore() / 4;
				Double logicalReasoningIndex = cptData.getFuseCluesScore() / 60;
				Double workingMemoryIndex = (cptData.getNoOfTargetedBlocks() - cptData.getNoOfIncorrectBlocks()) / (12);
				Double associativeMemoryIndex = cptData.getMemoryScore() / 12;
				Double numericalRelashioshipIndex = cptData.getArithmeticScore() / totalNoOfProblems;
				Double noOfMissedProblems = totalNoOfProblems / cptData.getNoOfCorrectProblems();
				Double accuracy = 1 - ((noOfMissedProblems) / (noOfMissedProblems + cptData.getNoOfCorrectProblems()));
				Double relativePerformanceIndex = (cptData.getArithmeticScore() / cptData.getNoOfCorrectProblems())
						/ 10;
				float cptScore = CoreUtil.normalise(
						(float) (processingSpeedIndex + logicalReasoningIndex + longTermStorageAndRetrevalIndex
								+ associativeMemoryIndex + numericalRelashioshipIndex));

				System.out.println("");
				String pattern = (cptScore < totalAcademicMarksValue) ? "Pattern of Cognitive Processing as Weakness"
						: (cptScore >= totalAcademicMarksValue) ? "Pattern of Cognitive Processing as Strength" : "";
				System.out.println(pattern + "\n");

				String responseRateLevel = (responseRate > 50 && responseRate <= 100) ? "HIGH"
						: (responseRate > 30 && responseRate <= 50) ? "MEDIUM"
								: (responseRate >= 5 && responseRate <= 30) ? "LOW" : "NEUTRAL";
				System.out.println("ResponseRateLevel & Level " + responseRate + " ==>" + responseRateLevel);

				String recallLevel = (recallLevelValue > 0.6 && recallLevelValue <= 1) ? "HIGH"
						: (recallLevelValue > 0.2 && recallLevelValue <= 0.6) ? "MEDIUM"
								: (recallLevelValue >= 0 && recallLevelValue <= 0.2) ? "LOW" : "NEUTRAL";
				System.out.println("RecallLevelValue & Level " + recallLevelValue + " ==>" + recallLevel);

				String relativePerformanceIndexLevel = (relativePerformanceIndex > 50
						&& relativePerformanceIndex <= 100)
								? "HIGH"
								: (relativePerformanceIndex > 20 && relativePerformanceIndex <= 50) ? "MEDIUM"
										: (relativePerformanceIndex >= 5 && relativePerformanceIndex <= 20) ? "LOW"
												: "NEUTRAL";
				System.out.println("RelativePerformanceIndex & Level " + relativePerformanceIndex + " ==>"
						+ relativePerformanceIndexLevel);

				String accuracyLevel = (accuracy > 70 && accuracy <= 100) ? "HIGH"
						: (accuracy > 40 && accuracy <= 70) ? "MEDIUM"
								: (accuracy >= 5 && accuracy <= 40) ? "LOW" : "NEUTRAL";
				System.out.println("Accuracy & Level " + accuracy + " ==>" + accuracyLevel);

				String speedScoreLevel = (cptData.getSpeedScore() > 8000 && cptData.getSpeedScore() <= 12000) ? "HIGH"
						: (cptData.getSpeedScore() > 4000 && cptData.getSpeedScore() <= 8000) ? "MEDIUM"
								: (cptData.getSpeedScore() >= 200 && cptData.getSpeedScore() <= 4000) ? "LOW"
										: "NEUTRAL";
				System.out.println("SpeedScore & Level " + cptData.getSpeedScore() + " ==>" + speedScoreLevel);

				String fuseCluesScoreLevel = (cptData.getFuseCluesScore() > 20000
						&& cptData.getFuseCluesScore() <= 25000)
								? "HIGH"
								: (cptData.getFuseCluesScore() > 15000 && cptData.getFuseCluesScore() <= 20000)
										? "MEDIUM"
										: (cptData.getFuseCluesScore() >= 5000 && cptData.getFuseCluesScore() <= 15000)
												? "LOW"
												: "NEUTRAL";
				System.out.println(
						"FuseCluesScore & Level " + cptData.getFuseCluesScore() + " ==>" + fuseCluesScoreLevel);

				String memoryScoreLevel = (cptData.getMemoryScore() > 20000 && cptData.getMemoryScore() <= 30000)
						? "HIGH"
						: (cptData.getMemoryScore() > 15000 && cptData.getMemoryScore() <= 20000) ? "MEDIUM"
								: (cptData.getMemoryScore() >= 5000 && cptData.getMemoryScore() <= 15000) ? "LOW"
										: "NEUTRAL";
				System.out.println("MemoryScore & Level " + cptData.getMemoryScore() + " ==>" + memoryScoreLevel);

				String arithmeticScoreLevel = (cptData.getArithmeticScore() > 20000
						&& cptData.getArithmeticScore() <= 30000)
								? "HIGH"
								: (cptData.getArithmeticScore() > 10000 && cptData.getArithmeticScore() <= 20000)
										? "MEDIUM"
										: (cptData.getArithmeticScore() >= 1000
												&& cptData.getArithmeticScore() <= 10000) ? "LOW" : "NEUTRAL";
				System.out.println(
						"ArithmeticScore & Level " + cptData.getArithmeticScore() + " ==>" + arithmeticScoreLevel);

				String cptScoreLevel = (cptScore > 0.6 && cptScore <= 1) ? "HIGH"
						: (cptScore > 0.2 && cptScore <= 0.6) ? "MEDIUM"
								: (cptScore >= 0 && cptScore <= 0.2) ? "LOW" : "NEUTRAL";
				System.out.println("CPTScore & Level " + cptScore + " ==>" + cptScoreLevel);

				String workingMemoryIndexLevel = (workingMemoryIndex > 0.5 && workingMemoryIndex <= 1) ? "HIGH"
						: (workingMemoryIndex > 0.2 && workingMemoryIndex <= 0.5) ? "MEDIUM"
								: (workingMemoryIndex >= 0 && workingMemoryIndex <= 0.2) ? "LOW" : "NEUTRAL";
				System.out
						.println("WorkingMemoryIndex & Level " + workingMemoryIndex + " ==>" + workingMemoryIndexLevel);

				Double reasoningCoefficient = ((responseRateLevel.equals("HIGH") && recallLevel.equals("HIGH")
						&& speedScoreLevel.equals("HIGH") && fuseCluesScoreLevel.equals("HIGH")
						&& memoryScoreLevel.equals("HIGH") && arithmeticScoreLevel.equals("HIGH")
						&& cptScoreLevel.equals("HIGH") && workingMemoryIndexLevel.equals("HIGH")
						&& relativePerformanceIndexLevel.equals("HIGH") && accuracyLevel.equals("HIGH"))
						&& (totalAcademicMarksValue == 0.1)) ? 1.0 :

								((responseRateLevel.equals("MEDIUM") && recallLevel.equals("MEDIUM")
										&& speedScoreLevel.equals("MEDIUM") && fuseCluesScoreLevel.equals("MEDIUM")
										&& memoryScoreLevel.equals("MEDIUM") && arithmeticScoreLevel.equals("MEDIUM")
										&& cptScoreLevel.equals("MEDIUM") && workingMemoryIndexLevel.equals("MEDIUM")
										&& relativePerformanceIndexLevel.equals("MEDIUM")
										&& accuracyLevel.equals("MEDIUM")) && (totalAcademicMarksValue == 0.5)) ? 0.5 :

												((responseRateLevel.equals("LOW") && recallLevel.equals("LOW")
														&& speedScoreLevel.equals("LOW")
														&& fuseCluesScoreLevel.equals("LOW")
														&& memoryScoreLevel.equals("LOW")
														&& arithmeticScoreLevel.equals("LOW")
														&& cptScoreLevel.equals("LOW")
														&& workingMemoryIndexLevel.equals("LOW")
														&& relativePerformanceIndexLevel.equals("LOW")
														&& accuracyLevel.equals("LOW"))
														&& (totalAcademicMarksValue == 1.0)) ? 0.0 : 0.0;

				System.out.println("Reasoning Coefficient : " + reasoningCoefficient);
				System.out.println(
						"============================================================================================================================================");

			}

		});

		System.out.println();

	}

	private static Double findPercentageValue(AcademicData studentData, double v1, double v2, double v3) {
		Double PercentageValue = ((studentData.getMathsAcademicMarks() > 80
				&& studentData.getMathsAcademicMarks() <= 100)
				&& (studentData.getGeneralKnowledgeScore() > 40 && studentData.getGeneralKnowledgeScore() <= 50))
						? v1
						: ((studentData.getMathsAcademicMarks() > 60 && studentData.getMathsAcademicMarks() <= 80)
								&& (studentData.getGeneralKnowledgeScore() > 30
										&& studentData.getGeneralKnowledgeScore() <= 40))
												? v2
												: ((studentData.getMathsAcademicMarks() > 40
														&& studentData.getMathsAcademicMarks() <= 60)
														&& (studentData.getGeneralKnowledgeScore() > 20
																&& studentData.getGeneralKnowledgeScore() <= 30)) ? v3
																		: 50;
		return PercentageValue;
	}
}
