package co.com.ubits.medical.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.ubits.medical.model.MedicalService;

public interface IMedicalServiceRepository extends JpaRepository<MedicalService, String> {
	
	MedicalService findByMeseId(String meseId);

}
