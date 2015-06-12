package edu.ifsp.ged.commons.product;

public abstract class Product {
	
	private float price;
	private int overalQuality;
	private float densidadeAmbiente;
	private float temperaturaAmostra;
	private int quantidadeRecebidoAmbiente;

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getOveralQuality() {
		return overalQuality;
	}

	public void setOveralQuality(int overalQuality) {
		this.overalQuality = overalQuality;
	}

	public float getDensidadeAmbiente() {
		return densidadeAmbiente;
	}

	public void setDensidadeAmbiente(float densidadeAmbiente) {
		this.densidadeAmbiente = densidadeAmbiente;
	}

	public float getTemperaturaAmostra() {
		return temperaturaAmostra;
	}

	public void setTemperaturaAmostra(float temperaturaAmostra) {
		this.temperaturaAmostra = temperaturaAmostra;
	}

	public int getQuantidadeRecebidoAmbiente() {
		return quantidadeRecebidoAmbiente;
	}

	public void setQuantidadeRecebidoAmbiente(int quantidadeRecebidoAmbiente) {
		this.quantidadeRecebidoAmbiente = quantidadeRecebidoAmbiente;
	}

}
