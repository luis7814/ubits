package co.com.ubits.medical.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.ubits.medical.model.TypePet;

public interface ITypePetRepository extends JpaRepository<TypePet, String> {
	
	TypePet findByTipeId(String tipeId);

}
