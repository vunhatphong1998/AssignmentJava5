package edu.poly.spt.models;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "staffs")
public class Staff implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 50)
	@NotNull
	private String name;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date birthday;
	
	@Column(length = 20)	
	private String email;
	
	@Column(length = 100)
	private double luong;
	
	@Column(length = 15)
	private int phone;
	
	@Column(length = 100)
	private String notes;
	
	@Column(length = 100)
	private String photo;
	
	@ManyToOne
	@JoinColumn(name = "departId")
	private Depart depart;
	
	@OneToMany(mappedBy = "staff", cascade = CascadeType.ALL)
	private Set<Record> records;

	
	
	
	public Staff() {
		super();
	}
	
	

	public Staff(Integer id, String name, Date birthday, String email, double luong, int phone, String notes, String photo,
			Depart depart) {
		super();
		this.id = id;
		this.name = name;
		this.birthday = birthday;
		this.email = email;
		this.luong = luong;
		this.phone = phone;
		this.notes = notes;
		this.photo = photo;
		this.depart = depart;
	}



	public Integer getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getLuong() {
		return luong;
	}

	public void setLuong(double luong) {
		this.luong = luong;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Depart getDepart() {
		return depart;
	}

	public void setDepart(Depart depart) {
		this.depart = depart;
	}
	
	
	
}
