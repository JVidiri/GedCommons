package edu.ifsp.ged.commons.models;

import edu.ifsp.ged.commons.product.Product;
import edu.ifsp.ged.commons.ranking.Ranking;
import edu.ifsp.ged.commons.utils.Utils.enumOpHours;

public class StationModel {
	private String CNPJ;
	private String stationPassword;
	private enumOpHours operatingHhours;
	private SintegraModel sintegraData;
	private Ranking stationRanking;
	private Product[] stationProducts;
	private DistributorBaseModel[] stationDases;

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

	public enumOpHours getOperatingHhours() {
		return operatingHhours;
	}

	public void setOperatingHhours(enumOpHours operatingHhours) {
		this.operatingHhours = operatingHhours;
	}

	public SintegraModel getSintegraData() {
		return sintegraData;
	}

	public void setSintegraData(SintegraModel sintegraData) {
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

	public DistributorBaseModel[] getStationDases() {
		return stationDases;
	}

	public void setStationDases(DistributorBaseModel[] stationDases) {
		this.stationDases = stationDases;
	}

}
