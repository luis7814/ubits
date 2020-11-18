package co.com.ubits.medical.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "quotes_pet")
public class QuotesPet implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "vape_id")
	private String vapeId;
	
	@Column(name = "pet_id")
	private String petId;
	
	@Column(name = "vac_id")
	private String vacId;
	
	@Column(name = "doc_id")
	private String docId;
	
	@Column(name = "vape_date")
	private String vapeDate;
	
	@Column(name = "mese_id")
	private String meseId;

}
