package edu.ifsp.ged.commons.models;

import edu.ifsp.ged.commons.product.Product;
import edu.ifsp.ged.commons.ranking.Ranking;

public class Station {
	private String CNPJ;
	private String stationPassword;
	private OpHours operationHhours;
	private Sintegra sintegraData;
	private Ranking stationRanking;
	private Product[] stationProducts;
	private DistributorBase[] stationDases;

	public String getCNPJ() {
		return CNPJ;
	}

	public void setCNPJ(String cNPJ) {
		CNPJ = cNPJ;
	}

	public String getStationPassword() {
		return stationPassword;
	}

	public void setStationPassword(String stationPassword) {
		this.stationPassword = stationPassword;
	}

	public OpHours getOperatingHhours() {
		return operationHhours;
	}

	public void setOperatingHhours(OpHours operatingHhours) {
		this.operationHhours = operatingHhours;
	}

	public Sintegra getSintegraData() {
		return sintegraData;
	}

	public void setSintegraData(Sintegra sintegraData) {
		this.sintegraData = sintegraData;
	}

	public Ranking getStationRanking() {
		return stationRanking;
	}

	public void setStationRanking(Ranking stationRanking) {
		this.stationRanking = stationRanking;
	}

	public Product[] getStationProducts() {
		return stationProducts;
	}

	public void setStationProducts(Product[] stationProducts) {
		this.stationProducts = stationProducts;
	}

	public DistributorBase[] getStationDases() {
		return stationDases;
	}

	public void setStationDases(DistributorBase[] stationDases) {
		this.stationDases = stationDases;
	}

}
