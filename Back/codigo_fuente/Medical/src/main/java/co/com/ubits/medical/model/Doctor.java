package co.com.ubits.medical.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table (name = "doctor")
public class Doctor implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "doc_id")
	private String docId;
	
	@Column(name = "doc_name")
	private String docName;
	
	@Column(name = "doc_email")
	private String docEmail;
	
	@Column(name = "doc_phone")
	private String docPhone;
	
	@Column(name = "doc_speciality")
	private String docSpeciality;
	
	@Column(name = "doc_last_name")
	private String docLastName;
	
	@Column(name = "vet_id")
	private String vetId;
	
}
