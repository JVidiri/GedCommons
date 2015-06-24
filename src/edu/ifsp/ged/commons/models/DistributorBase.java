package edu.ifsp.ged.commons.models;

import edu.ifsp.ged.commons.ranking.Ranking;

public class DistributorBase {
	private String cnpj;
	private Sintegra sintegraData;
	private Ranking baseRanking;

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Sintegra getSintegraData() {
		return sintegraData;
	}

	public void setSintegraData(Sintegra sintegraData) {
		this.sintegraData = sintegraData;
	}

	public Ranking getBaseRanking() {
		return baseRanking;
	}

	public void setBaseRanking(Ranking baseRanking) {
		this.baseRanking = baseRanking;
	}

}
