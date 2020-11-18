package co.com.ubits.medical.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "pet")
public class Pet implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "pet_id")
	private String petId;
	
	@Column(name = "pet_name")
	private String petName;
	
	@Column(name = "pet_size")
	private String petSize;
	
	@Column(name = "pet_owner_name")
	private String petOwnerName;
	
	@Column(name = "pet_description")
	private String petDescription;
	
	@Column(name = "vet_id")
	private String vetId;
	
	@Column(name = "tipe_id")
	private String tipeId;
	
	@Column(name = "vape_id")
	private String vapeId;
	
}
