package co.com.ubits.medical.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "type_pet")
public class TypePet implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "tipe_id")
	private String tipeId;
	
	@Column(name = "tipe_name")
	private String tipeName;
	
	@Column(name = "tipe_description")
	private String tipeDescription;
	
	
}
