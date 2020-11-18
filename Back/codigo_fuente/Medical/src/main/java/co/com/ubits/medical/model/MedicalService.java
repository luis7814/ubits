package co.com.ubits.medical.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "medical_service")
public class MedicalService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "mese_id")
	private String meseId;
	
	@Column(name = "mese_name")
	private String meseName;
	
	@Column(name = "mese_description")
	private String meseDescription;
	
	@Column(name = "vet_id")
	private String vetId;
	
}
