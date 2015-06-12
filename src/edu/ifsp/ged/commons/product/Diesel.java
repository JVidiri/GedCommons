package edu.ifsp.ged.commons.product;

import edu.ifsp.ged.commons.utils.Utils.enumDieselType;

public class Diesel extends Product{
	private float price;
	private int quality;
	private enumDieselType type; // (S10, S500)

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getQuality() {
		return quality;
	}

	public void setQuality(int quality) {
		this.quality = quality;
	}

	public enumDieselType getType() {
		return type;
	}

	public void setType(enumDieselType type) {
		this.type = type;
	}

	public float getDensity() {
		return Density;
	}

	public void setDensity(float density) {
		Density = density;
	}

	private float Density;
}
