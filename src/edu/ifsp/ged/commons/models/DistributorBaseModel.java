package edu.ifsp.ged.commons.models;

import edu.ifsp.ged.commons.ranking.Ranking;

public class DistributorBaseModel {
	private String cnpj;
	private SintegraModel sintegraData;
	private Ranking baseRanking;

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public SintegraModel getSintegraData() {
		return sintegraData;
	}

	public void setSintegraData(SintegraModel sintegraData) {
		this.sintegraData = sintegraData;
	}

	public Ranking getBaseRanking() {
		return baseRanking;
	}

	public void setBaseRanking(Ranking baseRanking) {
		this.baseRanking = baseRanking;
	}

}
