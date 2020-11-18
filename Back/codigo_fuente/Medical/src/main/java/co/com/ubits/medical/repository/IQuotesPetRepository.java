package co.com.ubits.medical.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.ubits.medical.model.QuotesPet;

public interface IQuotesPetRepository extends JpaRepository<QuotesPet, String> {
	
	List<QuotesPet> findByPetId(String petId);
}
