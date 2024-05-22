package com.dao;

import java.util.List;

import com.model.MedicalCheckUp;

public interface MedicalDAO {

	public Integer save(MedicalCheckUp med);

	public MedicalCheckUp getById(Integer patient_id);

	public Integer update(MedicalCheckUp med);

	public Boolean deleteById(Integer patient_id);

	public List<MedicalCheckUp> getAll();
}
