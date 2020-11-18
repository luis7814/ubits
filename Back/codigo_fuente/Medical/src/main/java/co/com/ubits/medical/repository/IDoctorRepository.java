package co.com.ubits.medical.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.ubits.medical.model.Doctor;

public interface IDoctorRepository extends JpaRepository<Doctor, String> {
	
	Doctor findByDocId(String docId);

}
