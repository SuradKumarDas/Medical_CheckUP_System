package com.model;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class MedicalCheckUp implements Serializable {
	private int patient_id;
	private String patient_name;
	private int age;
	private String gender;
	private String disease;
	private Date date;

	public MedicalCheckUp(int patient_id, String patient_name, int age, String gender, String disease, Date date) {
		super();
		this.patient_id = patient_id;
		this.patient_name = patient_name;
		this.age = age;
		this.gender = gender;
		this.disease = disease;
		this.date = date;
	}

	public MedicalCheckUp() {
		
	}

	public int getPatient_id() {
		return patient_id;
	}

	public void setPatient_id(int patient_id) {
		this.patient_id = patient_id;
	}

	public String getPatient_name() {
		return patient_name;
	}

	public void setPatient_name(String patient_name) {
		this.patient_name = patient_name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDisease() {
		return disease;
	}

	public void setDisease(String disease) {
		this.disease = disease;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "MedicalCheckUp [patient_id=" + patient_id + ", patient_name=" + patient_name + ", age=" + age
				+ ", gender=" + gender + ", disease=" + disease + ", date=" + date + "]";
	}

}
