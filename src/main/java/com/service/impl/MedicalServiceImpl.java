package com.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dao.MedicalDAO;
import com.dao.impl.MedicalDAOImpl;
import com.model.MedicalCheckUp;
import com.serice.MedicalService;

@Service
public class MedicalServiceImpl implements MedicalService {
	private MedicalDAO dao = new MedicalDAOImpl();

	public Integer saveBooking(MedicalCheckUp med) {

		Integer patient_id = dao.save(med);
		return patient_id;
	}

	public MedicalCheckUp getPatientById(Integer patient_id) {

		MedicalCheckUp med = dao.getById(patient_id);
		return med;
	}

	public Integer updateBooking(MedicalCheckUp med) {
		Integer count = dao.update(med);
		return count;

	}

	@Override
	public List<MedicalCheckUp> getAllBooking() {
		List<MedicalCheckUp> medList = dao.getAll();
		return medList;

	}

	@Override
	public boolean deleteBookingById(Integer patient_id) {
		Boolean result = dao.deleteById(patient_id);
		return result;

	}

}
