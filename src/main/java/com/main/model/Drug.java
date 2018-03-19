package com.main.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.main.util.ResponseMessage;
@JsonInclude(Include.NON_EMPTY)
@Entity
public class Drug extends ResponseMessage{
	@Id
	@JsonIgnore
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@NotNull
	private String name;
	private String description;
	private String about;
	private String symptoms;
	private String moleculeName;
	private String productCode;
	@NotNull
	private int representativeEmployeeId;

	public int getId() {
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public String getSymptoms() {
		return symptoms;
	}

	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}

	public String getMoleculeName() {
		return moleculeName;
	}

	public void setMoleculeName(String moleculeName) {
		this.moleculeName = moleculeName;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public int getRepresentativeEmployeeId() {
		return representativeEmployeeId;
	}

	public void setRepresentativeEmployeeId(int representativeEmployeeId) {
		this.representativeEmployeeId = representativeEmployeeId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Drug drug = (Drug) o;

		if (representativeEmployeeId != (drug.representativeEmployeeId))
			return false;
		return name.equals(drug.name);
	}

	@Override
	public int hashCode() {
		int result = 31 * (representativeEmployeeId) + name.hashCode();
		return result;
	}

	@Override
	public String toString() {
		return "Drug [id=" + id + ", name=" + name + ", description=" + description + ", about=" + about + ", symptoms="
				+ symptoms + ", moleculeName=" + moleculeName + ", productCode=" + productCode
				+ ", representativeEmployeeId=" + representativeEmployeeId + "]";
	}

}
