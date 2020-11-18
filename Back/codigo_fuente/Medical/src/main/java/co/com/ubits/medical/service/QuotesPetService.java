package co.com.ubits.medical.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.ubits.medical.model.Doctor;
import co.com.ubits.medical.model.MedicalService;
import co.com.ubits.medical.model.Pet;
import co.com.ubits.medical.model.QuotesPet;
import co.com.ubits.medical.model.Vaccine;
import co.com.ubits.medical.repository.IDoctorRepository;
import co.com.ubits.medical.repository.IMedicalServiceRepository;
import co.com.ubits.medical.repository.IPetRepository;
import co.com.ubits.medical.repository.IQuotesPetRepository;
import co.com.ubits.medical.repository.IVaccineRepository;
import co.com.ubits.medical.vo.QuotesPetVo;
import lombok.Data;

@Data
@Service
public class QuotesPetService {
	
	@Autowired
	private IQuotesPetRepository iQuotesPetRepository;
	
	@Autowired
	private IPetRepository iPetRepository;
	
	@Autowired
	private IDoctorRepository iDoctorRepository;
	
	@Autowired
	private IVaccineRepository iVaccineRepository;
	
	@Autowired
	private IMedicalServiceRepository iMedicalServiceRepository;
	
	
	
	private List<QuotesPetVo> quotesPetVos;
	
	public void save(QuotesPet quotesPet) throws Exception {
		iQuotesPetRepository.save(quotesPet);
	}
	
	public void update(QuotesPet quotesPet) throws Exception {
		iQuotesPetRepository.save(quotesPet);
	}

	public List<QuotesPet> findAll() throws Exception {
		return iQuotesPetRepository.findAll();
	}
	
	public List<QuotesPetVo> findByPet(String petName) throws Exception {
		
		Pet pet = iPetRepository.findByPetName(petName);
		
		if(pet != null) {
			
			List<QuotesPet> quotesPets = iQuotesPetRepository.findByPetId(pet.getPetId());
			
			quotesPetVos = new ArrayList<QuotesPetVo>();
			
			quotesPets.forEach((value) -> {
				
				QuotesPetVo quotesPetVo = new QuotesPetVo();
				
				quotesPetVo.setDocId(value.getDocId());
				
				Doctor doctor = iDoctorRepository.findByDocId(value.getDocId());
				quotesPetVo.setDocName(doctor != null ? doctor.getDocName() : "");
				
				
				quotesPetVo.setMeseId(value.getMeseId());
				
				MedicalService medicalService = iMedicalServiceRepository.findByMeseId(value.getMeseId());
				quotesPetVo.setMeseName(medicalService != null ? medicalService.getMeseName() : "");
				
				quotesPetVo.setPetId(value.getPetId());
				quotesPetVo.setPetName(pet.getPetName());
				quotesPetVo.setVacId(value.getVacId());
				
				Vaccine vaccine = iVaccineRepository.findByVecId(value.getVacId());
				quotesPetVo.setVacName(vaccine != null ? vaccine.getVecName() : "");
				
				quotesPetVo.setVapeDate(value.getVapeDate());
				quotesPetVo.setVapeId(value.getVapeId());
				
				quotesPetVos.add(quotesPetVo);
				
			});
			
		}
		
		return quotesPetVos;
		
	}


}
