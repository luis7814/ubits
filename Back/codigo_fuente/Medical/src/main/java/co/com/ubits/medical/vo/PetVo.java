package co.com.ubits.medical.vo;

import java.io.Serializable;

import lombok.Data;

@Data
public class PetVo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String petId;
	private String petName;
	private String petSize;
	private String petOwnerName;
	private String petDescription;
	private String tipeId;
	private String typePet;
	
	
}
