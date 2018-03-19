package com.main.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.main.util.ResponseMessage;

@JsonInclude(Include.NON_EMPTY)
@Entity
public class Representative extends ResponseMessage {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonIgnore
	private Integer id;
	@NotNull
	private String representativeFirstName;
	private String representativeLastName;
	@NotNull
	private int companyId;
	@Column(nullable = false, unique = true)
	private int representativeEmployeeId;
	private String representativeAddress; 
	private String representativeCountry;
	private String representativeState;
	private String representativeCity;
	private int representativePinCode;
	@Transient
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "representative")
	private Set<Drug> drug = new HashSet<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRepresentativeFirstName() {
		return representativeFirstName;
	}

	public void setRepresentativeFirstName(String representativeFirstName) {
		this.representativeFirstName = representativeFirstName;
	}

	public String getRepresentativeLastName() {
		return representativeLastName;
	}

	public void setRepresentativeLastName(String representativeLastName) {
		this.representativeLastName = representativeLastName;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public int getRepresentativeEmployeeId() {
		return representativeEmployeeId;
	}

	public void setRepresentativeEmployeeId(int representativeEmployeeId) {
		this.representativeEmployeeId = representativeEmployeeId;
	}

	public String getRepresentativeAddress() {
		return representativeAddress;
	}

	public void setRepresentativeAddress(String representativeAddress) {
		this.representativeAddress = representativeAddress;
	}

	public String getRepresentativeCountry() {
		return representativeCountry;
	}

	public void setRepresentativeCountry(String representativeCountry) {
		this.representativeCountry = representativeCountry;
	}

	public String getRepresentativeState() {
		return representativeState;
	}

	public void setRepresentativeState(String representativeState) {
		this.representativeState = representativeState;
	}

	public String getRepresentativeCity() {
		return representativeCity;
	}

	public void setRepresentativeCity(String representativeCity) {
		this.representativeCity = representativeCity;
	}

	public int getRepresentativePinCode() {
		return representativePinCode;
	}

	public void setRepresentativePinCode(int representativePinCode) {
		this.representativePinCode = representativePinCode;
	}

	public Set<Drug> getDrug() {
		return drug;
	}

	public void setDrug(Set<Drug> drug) {
		this.drug = drug;
	}

}
