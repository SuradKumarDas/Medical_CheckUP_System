package com.serice;

import java.util.List;

import com.model.MedicalCheckUp;


public interface MedicalService {
	public Integer saveBooking(MedicalCheckUp med);

	public MedicalCheckUp getPatientById(Integer patient_id);

	public Integer updateBooking(MedicalCheckUp med);

	public boolean deleteBookingById(Integer patient_id);

	public List<MedicalCheckUp> getAllBooking();
}
