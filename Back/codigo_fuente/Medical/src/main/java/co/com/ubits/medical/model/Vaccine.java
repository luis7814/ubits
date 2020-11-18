package co.com.ubits.medical.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "vaccine")
public class Vaccine implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "vac_id")
	private String vecId;
	
	@Column(name = "vac_name")
	private String vecName;
	
	@Column(name = "vac_description")
	private String vecDescription;
	
	
}
