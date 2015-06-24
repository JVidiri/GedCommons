package edu.ifsp.ged.commons.models;

/**
 * Model for sintegra data.
 * 
 * @author jvidiri
 *
 */
public class Sintegra {
	
	private String companyName;
	private String companyNameFictitious;
	private String street;
	private String CEP;
	private String adressNumber;
	private String adressComplement;
	private String district;
	private String town;
	private String UF;
	private String phone;
	private String country;
	private long lastSintegraUpdate;
	private long companyOpenDate;
	private boolean authorised;
	private long authorisedDate;
	private String email;

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyNameFictitious() {
		return companyNameFictitious;
	}

	public void setCompanyNameFictitious(String companyNameFictitious) {
		this.companyNameFictitious = companyNameFictitious;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCEP() {
		return CEP;
	}

	public void setCEP(String cEP) {
		CEP = cEP;
	}

	public String getAdressNumber() {
		return adressNumber;
	}

	public void setAdressNumber(String adressNumber) {
		this.adressNumber = adressNumber;
	}

	public String getAdressComplement() {
		return adressComplement;
	}

	public void setAdressComplement(String adressComplement) {
		this.adressComplement = adressComplement;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getUF() {
		return UF;
	}

	public void setUF(String uF) {
		UF = uF;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public long getLastSintegraUpdate() {
		return lastSintegraUpdate;
	}

	public void setLastSintegraUpdate(long lastSintegraUpdate) {
		this.lastSintegraUpdate = lastSintegraUpdate;
	}

	public long getCompanyOpenDate() {
		return companyOpenDate;
	}

	public void setCompanyOpenDate(long companyOpenDate) {
		this.companyOpenDate = companyOpenDate;
	}

	public boolean isAuthorised() {
		return authorised;
	}

	public void setAuthorised(boolean authorised) {
		this.authorised = authorised;
	}

	public long getAuthorisedDate() {
		return authorisedDate;
	}

	public void setAuthorisedDate(long authorisedDate) {
		this.authorisedDate = authorisedDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
