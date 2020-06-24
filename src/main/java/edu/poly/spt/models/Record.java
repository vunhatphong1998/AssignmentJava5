package edu.poly.spt.models;


import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name ="records")
public class Record	 {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Integer id;
	
	@Column(length = 50)
	private String type;

	
	@Column(length = 50)
	private String reason;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date ngaylap;
	
	
	
	@ManyToOne
	@JoinColumn(name = "staffId")
	private Staff staff;
	
	
	
	



	public Record() {
		super();
	}



	public Record(Integer id, String type, String reason, Date ngaylap, Staff staff) {
		super();
		this.id = id;
		this.type = type;
		this.reason = reason;
		this.ngaylap = ngaylap;
		this.staff = staff;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public String getReason() {
		return reason;
	}



	public void setReason(String reason) {
		this.reason = reason;
	}



	public Date getNgaylap() {
		return ngaylap;
	}



	public void setNgaylap(Date ngaylap) {
		this.ngaylap = ngaylap;
	}



	public Staff getStaff() {
		return staff;
	}



	public void setStaff(Staff staff) {
		this.staff = staff;
	}
	
	
	
	
}
