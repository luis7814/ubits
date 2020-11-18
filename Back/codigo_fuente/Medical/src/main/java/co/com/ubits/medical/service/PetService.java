package co.com.ubits.medical.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.ubits.medical.model.Pet;
import co.com.ubits.medical.model.TypePet;
import co.com.ubits.medical.repository.IPetRepository;
import co.com.ubits.medical.repository.ITypePetRepository;
import co.com.ubits.medical.vo.PetVo;
import lombok.Data;

@Data
@Service
public class PetService {
	
	@Autowired
	private IPetRepository iPetRepository;
	
	@Autowired
	private ITypePetRepository iTypePetRepository;
	
	
	public PetVo findByPet(String petName) throws Exception {
		
		Pet pet = iPetRepository.findByPetName(petName);
		
		
		PetVo petVo = new PetVo();
		
		petVo.setPetDescription(pet.getPetDescription());
		petVo.setPetId(pet.getPetId());
		petVo.setPetName(pet.getPetName());
		petVo.setPetOwnerName(pet.getPetOwnerName());
		petVo.setPetSize(pet.getPetSize());
		petVo.setTipeId(pet.getTipeId());
		
		TypePet typePet = iTypePetRepository.findByTipeId(pet.getTipeId());
		
		if(typePet != null) {
			petVo.setTypePet(typePet.getTipeName());
		}
		
		return petVo;
		
	}

}
