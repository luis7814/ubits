package co.com.ubits.medical.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.com.ubits.medical.model.QuotesPet;
import co.com.ubits.medical.service.QuotesPetService;
import co.com.ubits.medical.vo.QuotesPetVo;

@RestController
public class QuotesPetController {
	
	@Autowired
	private QuotesPetService quotesPetService;
	
	@PostMapping("/quotes")
	public ResponseEntity<QuotesPet> save(@RequestBody QuotesPet quotesPet) {
		
		try {
			quotesPetService.save(quotesPet);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<QuotesPet>(quotesPet, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/quotes")
	public ResponseEntity<List<QuotesPet>> findAll() {
		
		List<QuotesPet> quotesPets = null;
		
		try {
			quotesPets = quotesPetService.findAll();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<List<QuotesPet>>(quotesPets, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/quotes/{petName}")
	public ResponseEntity<List<QuotesPetVo>> findByPetName(@PathVariable String petName) {
		
		List<QuotesPetVo> quotesPetVo = null;
		
		try {
			quotesPetVo = quotesPetService.findByPet(petName);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<List<QuotesPetVo>>(quotesPetVo, HttpStatus.ACCEPTED);
	}
	
	

}
