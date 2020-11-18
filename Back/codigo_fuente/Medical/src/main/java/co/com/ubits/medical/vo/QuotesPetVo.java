package co.com.ubits.medical.vo;

import java.io.Serializable;

import lombok.Data;

@Data
public class QuotesPetVo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String vapeId;
	private String petId;
	private String petName;
	private String vacId;
	private String vacName;
	private String docId;
	private String docName;
	private String vapeDate;
	private String meseId;
	private String meseName;

}
