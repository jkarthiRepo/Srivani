package com.text.analysis.readerwriter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.text.analysis.model.AcademicData;
import com.text.analysis.model.CPTData;
import com.text.analysis.model.Concept;
import com.text.analysis.util.CoreUtil;
import com.text.analysis.util.PropertiesUtil;

public class Reader {

	public static List<Concept> readNounPhrases() {
		List<Concept> list = new ArrayList<Concept>();
		try {
			String line = "";
			BufferedReader br = new BufferedReader(new FileReader("./local/NounPhrases Output/NounPhrases_Topics.txt"));
			while ((line = br.readLine()) != null) {
				if (null != line && !line.trim().isEmpty()) {
					String[] arr = line.trim().split(" ");
					String topic = "";
					for (String string : arr) {
						if (string.startsWith("Topic")) {
							topic = string.trim().split(":")[1];
						} else {
							Concept concept = CoreUtil.getConceptWithProb(string);
							concept.setTopic(topic);
							list.add(concept);
						}
					}
				}
			}
			br.close();
		} catch (Exception e) {
		}
		return list;
	}

	public static Map<String, List<String>> readPreprocessFiles() throws IOException {
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		String preprocessedDataPath = PropertiesUtil.getProperty("preprocessedDataPath");
		File dir1 = new File(preprocessedDataPath);
		File listDir1[] = dir1.listFiles();
		for (File file1 : listDir1) {
			String line = "";
			List<String> list = new ArrayList<String>();
			BufferedReader br = new BufferedReader(new FileReader(preprocessedDataPath+"/"+file1.getName()));
			while ((line = br.readLine()) != null) {
				if (null != line && !line.trim().isEmpty()) {
					list.add(line);
				}
			}
			br.close();
			map.put(file1.getName(), list);
		
		}
		
		return map;
	}

	public static List<AcademicData> readAcademicFile() {
		String csvFile = PropertiesUtil.getProperty("academicDataPath");
        String line = "";
        String cvsSplitBy = ",";
        List<AcademicData> list = new ArrayList<AcademicData>();int count = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {

                String[] row = line.split(cvsSplitBy);
                if(row.length==13 && count!=0) {
                	AcademicData academicData = new AcademicData();
                	academicData.setAdmissionNo(Long.parseLong(row[0]));
                	academicData.setStudentId(Long.parseLong(row[1]));
                	academicData.setName(row[2]);
                	academicData.setStandard(row[3]);
                	academicData.setGender(row[4]);
                	academicData.setAge(row[5]);
                	academicData.setAttentionInClass(row[6]);
                	academicData.setMathsAcademicMarks(Double.parseDouble(row[7]));
                	academicData.setGeneralKnowledgeScore(Double.parseDouble(row[8]));
                	academicData.setAttendance(Double.parseDouble(row[9]));
                	academicData.setPrivateTuitionTaken(row[10]);
                	academicData.setTeachersOpinion(row[11]);
                	academicData.setInterestOfChildren(row[12]);
                	list.add(academicData);
                }
                count++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("\nAcademicDetails : ");
        list.forEach(x->System.out.println(x.toString()));
        System.out.println(
				"============================================================================================================================================");

		return list;
	}
	

	public static List<CPTData> readCPT234DataList() {
		String csvFile = PropertiesUtil.getProperty("cpt234DataPath");
        String line = "";
        String cvsSplitBy = ",";
        List<CPTData> list = new ArrayList<CPTData>();int count = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {

                String[] row = line.split(cvsSplitBy);
                if(row.length==10 && count!=0) {
                	CPTData cptData = new CPTData();
                	cptData.setStudentId(Long.parseLong(row[0]));
                	cptData.setTestDate(row[1]);
                	cptData.setFlexibilityValue(Double.parseDouble(row[2]));
                	cptData.setNoofCorrectCards(Double.parseDouble(row[3]));
                	cptData.setSpeedScore(Double.parseDouble(row[4]));
                	cptData.setResponsesReturned(Double.parseDouble(row[5]));
                	cptData.setBestScore(Double.parseDouble(row[6]));
                	cptData.setArithmeticScore(Double.parseDouble(row[7]));
                	cptData.setNoOfCorrectProblems(Double.parseDouble(row[8]));
                	cptData.setBestArScore(Double.parseDouble(row[9]));
                	list.add(cptData);
                }
                count++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("\nCPTDetails : ");
        System.out.println("\nCPT234 : ");
        list.forEach(x->System.out.println(x.toString()));
       
		return list;
	}

	public static List<CPTData> readCPT567DataList() {
		String csvFile = PropertiesUtil.getProperty("cpt567DataPath");
        String line = "";
        String cvsSplitBy = ",";
        List<CPTData> list = new ArrayList<CPTData>();int count = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {

                String[] row = line.split(cvsSplitBy);
                if(row.length==12 && count!=0) {
                	CPTData cptData = new CPTData();
                	cptData.setStudentId(Long.parseLong(row[0]));
                	cptData.setTestDate(row[1]);
                	cptData.setSpeedScore(Double.parseDouble(row[2]));
                	cptData.setResponsesReturned(Double.parseDouble(row[3]));
                	cptData.setBestScore(Double.parseDouble(row[4]));
                	cptData.setFuseCluesScore(Double.parseDouble(row[5]));
                	cptData.setMemoryScore(Double.parseDouble(row[6]));
                	cptData.setNoOfTargetedBlocks(Double.parseDouble(row[7]));
                	cptData.setNoOfIncorrectBlocks(Double.parseDouble(row[8]));
                	cptData.setArithmeticScore(Double.parseDouble(row[9]));
                	cptData.setNoOfCorrectProblems(Double.parseDouble(row[10]));
                	cptData.setBestArScore(Double.parseDouble(row[11]));
                	list.add(cptData);
                }
                count++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("\nCPT567 : ");
        list.forEach(x->System.out.println(x.toString()));
        System.out.println(
				"============================================================================================================================================");

		return list;
	}

}
