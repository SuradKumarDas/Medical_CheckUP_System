package com.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.MedicalDAO;
import com.model.MedicalCheckUp;

import DBUtill.DBCon;

public class MedicalDAOImpl implements MedicalDAO {

	public Integer save(MedicalCheckUp med) {
		final String query = "INSERT INTO MedicalCheckUp (pat_id,pat_name,age,gender,disease,checkUp_date) values (?,?,?,?,?,?)";
		int out = 0;
		try (Connection con = DBCon.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
			ps.setInt(1, med.getPatient_id());
			ps.setString(2, med.getPatient_name());
			ps.setInt(3, med.getAge());
			ps.setString(4, med.getGender());
			ps.setString(5, med.getDisease());
			java.util.Date date = med.getDate();
			java.sql.Date sqlDate = new java.sql.Date(date.getTime());
			ps.setDate(6, sqlDate);

			out = ps.executeUpdate();
			if (out != 0) {
				try (ResultSet rs = ps.getGeneratedKeys()) {
					if (rs.next()) {
						Integer id = rs.getInt(1);
						System.out.println("Slot Booked successfully...");
						return id;
					}
				}
			} else {
				System.out.println("Slot Booking Failed");
				return out;
			}
		} catch (SQLException e) {
			e.getMessage();
		} catch (Exception e) {
			e.getMessage();
		}
		return out;
	}

	public MedicalCheckUp getById(Integer patient_id) {

		return null;
	}

	@Override
	public Integer update(MedicalCheckUp med) {
		final String query = "UPDATE MedicalCheckUp SET pat_name = ?, age = ?, gender = ?, disease = ?, date = ? WHERE patientId = ?";
		int count = 0;
		try (Connection con = DBCon.getConnection(); PreparedStatement stmt = con.prepareStatement(query)) {
			stmt.setString(1, med.getPatient_name());
			stmt.setInt(2, med.getAge());
			stmt.setString(3, med.getGender());
			stmt.setString(4, med.getDisease());
			stmt.setDate(5, (Date) med.getDate());

			count = stmt.executeUpdate();
			if (count != 0) {
				System.out.println("Patient with ID: " + med.getPatient_id() + " is updated");
			} else {
				System.out.println("Update failed.");
			}
		} catch (SQLException e) {
			e.getMessage();
		} catch (Exception e) {
			e.getMessage();
		}
		return count;

	}

	public Boolean deleteById(Integer patient_id) {
		try {
			Connection con = DBCon.getConnection();
			String query = "DELETE FROM MedicalCheckUp WHERE  pat_Id = ?";
			PreparedStatement stm = con.prepareStatement(query);
			stm.setInt(1, patient_id);
			return stm.executeUpdate() > 0;
		} catch (Exception e) {
			e.getMessage();
		}
		return false;

	}

	public List<MedicalCheckUp> getAll() {
		List<MedicalCheckUp> patients = new ArrayList<>();
		String query = "SELECT * FROM MedicalCheckUp";
		try (Connection con = DBCon.getConnection(); PreparedStatement stm = con.prepareStatement(query)) {

			ResultSet result = stm.executeQuery();
			while (result.next()) {
				MedicalCheckUp patient = new MedicalCheckUp();
				patient.setPatient_id(result.getInt("pat_id"));
				patient.setPatient_name(result.getString("pat_name"));
				patient.setAge(result.getInt("age"));
				patient.setGender(result.getString("gender"));
				patient.setDisease(result.getString("disease"));
				patient.setDate(result.getDate("checkUp_date"));

				patients.add(patient);
			}
		} catch (SQLException e) {
			e.getMessage();
		}
		return patients;
	}

}
