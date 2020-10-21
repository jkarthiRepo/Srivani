package com.text.analysis.model;

public class AcademicData {

	private Long studentId;
	private Long admissionNo;
	private String name;
	private String standard;
	private String gender;
	private String age;
	private String attentionInClass;
	private Double mathsAcademicMarks;
	private Double generalKnowledgeScore;
	private Double attendance;
	private String privateTuitionTaken;
	private String teachersOpinion;
	private String interestOfChildren;

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public Long getAdmissionNo() {
		return admissionNo;
	}

	public void setAdmissionNo(Long admissionNo) {
		this.admissionNo = admissionNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStandard() {
		return standard;
	}

	public void setStandard(String standard) {
		this.standard = standard;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getAttentionInClass() {
		return attentionInClass;
	}

	public void setAttentionInClass(String attentionInClass) {
		this.attentionInClass = attentionInClass;
	}

	public Double getMathsAcademicMarks() {
		return mathsAcademicMarks;
	}

	public void setMathsAcademicMarks(Double mathsAcademicMarks) {
		this.mathsAcademicMarks = mathsAcademicMarks;
	}

	public Double getGeneralKnowledgeScore() {
		return generalKnowledgeScore;
	}

	public void setGeneralKnowledgeScore(Double generalKnowledgeScore) {
		this.generalKnowledgeScore = generalKnowledgeScore;
	}

	public Double getAttendance() {
		return attendance;
	}

	public void setAttendance(Double attendance) {
		this.attendance = attendance;
	}

	public String getPrivateTuitionTaken() {
		return privateTuitionTaken;
	}

	public void setPrivateTuitionTaken(String privateTuitionTaken) {
		this.privateTuitionTaken = privateTuitionTaken;
	}

	public String getInterestOfChildren() {
		return interestOfChildren;
	}

	public void setInterestOfChildren(String interestOfChildren) {
		this.interestOfChildren = interestOfChildren;
	}

	public String getTeachersOpinion() {
		return teachersOpinion;
	}

	public void setTeachersOpinion(String teachersOpinion) {
		this.teachersOpinion = teachersOpinion;
	}

	@Override
	public String toString() {
		return "AcademicData [studentId=" + studentId + ", admissionNo=" + admissionNo + ", name=" + name
				+ ", standard=" + standard + ", gender=" + gender + ", age=" + age + ", attentionInClass="
				+ attentionInClass + ", mathsAcademicMarks=" + mathsAcademicMarks + ", generalKnowledgeScore="
				+ generalKnowledgeScore + ", attendance=" + attendance + ", privateTuitionTaken=" + privateTuitionTaken
				+ ", teachersOpinion=" + teachersOpinion + ", interestOfChildren=" + interestOfChildren + "]";
	}

}