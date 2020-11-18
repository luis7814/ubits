package co.com.ubits.medical.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.ubits.medical.model.Pet;

public interface IPetRepository extends JpaRepository<Pet, String> {
	
	public Pet findByPetName(String petName);

}
