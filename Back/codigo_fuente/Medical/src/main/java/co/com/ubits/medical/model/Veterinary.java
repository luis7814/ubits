package co.com.ubits.medical.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "veterinary")
public class Veterinary implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "vet_id")
	private String vetId;
	
	@Column(name = "vet_name")
	private String vetName;
	
	@Column(name = "vet_description")
	private String vetDescription;
	
	@Column(name = "vet_email")
	private String vetEmail;
	
	@Column(name = "vet_address")
	private String vetAddress;
	
	@Column(name = "vet_country")
	private String vetCountry;
	
	@Column(name = "vet_city")
	private String vetCity;
	
}
