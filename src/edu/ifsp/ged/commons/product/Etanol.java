package edu.ifsp.ged.commons.product;

import edu.ifsp.ged.commons.utils.Utils.enumEtanolTypes;

/**
 * Etanol type.
 * 
 * @author jvidiri
 *
 */
public class Etanol {
	private float Price;
	private int Quality;
	private boolean IncolorLII;
	private enumEtanolTypes type;
	private float density; // depends of type
	private float alcoholicTenor; // depends of type

	public float getPrice() {
		return Price;
	}

	public void setPrice(float price) {
		Price = price;
	}

	public int getQuality() {
		return Quality;
	}

	public void setQuality(int quality) {
		Quality = quality;
	}

	public boolean isIncolorLII() {
		return IncolorLII;
	}

	public void setIncolorLII(boolean incolorLII) {
		IncolorLII = incolorLII;
	}

	public enumEtanolTypes getType() {
		return type;
	}

	public void setType(enumEtanolTypes type) {
		this.type = type;
	}

	public float getDensity() {
		return density;
	}

	public void setDensity(float density) {
		this.density = density;
	}

	public float getAlcoholicTenor() {
		return alcoholicTenor;
	}

	public void setAlcoholicTenor(float alcoholicTenor) {
		this.alcoholicTenor = alcoholicTenor;
	}

}
