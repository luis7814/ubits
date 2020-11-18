package co.com.ubits.medical.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.ubits.medical.model.Vaccine;

public interface IVaccineRepository extends JpaRepository<Vaccine, String> {
	
	Vaccine findByVecId(String vecId);

}
