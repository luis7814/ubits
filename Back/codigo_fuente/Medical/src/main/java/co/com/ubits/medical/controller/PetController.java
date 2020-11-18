package co.com.ubits.medical.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import co.com.ubits.medical.service.PetService;
import co.com.ubits.medical.vo.PetVo;

@RestController
public class PetController {
	
	@Autowired
	private PetService petService;
	
	@GetMapping("/pet/{petName}")
	public ResponseEntity<PetVo> findByPetName(@PathVariable String petName) {
		
		PetVo petVo = null;
		
		try {
			petVo = petService.findByPet(petName);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<PetVo>(petVo, HttpStatus.ACCEPTED);
	}
	
	

}
