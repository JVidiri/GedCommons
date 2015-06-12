package edu.ifsp.ged.commons.product;

import edu.ifsp.ged.commons.utils.Utils.enumGasTypes;

/**
 * Gasoline type.
 * @author jvidiri
 *
 */
public abstract class Gasolina extends Product {
	
	private float price;
	private int quality;
	private boolean aspect;
	private float density;
	private enumGasTypes type;
	private boolean color; // depends of type
	private float alcoholTenor; // depends of type

	public boolean isColor() {
		return color;
	}

	public void setColor(boolean color) {
		this.color = color;
	}

	public float getAlcoholTenor() {
		return alcoholTenor;
	}

	public void setAlcoholTenor(float alcoholTenor) {
		this.alcoholTenor = alcoholTenor;
	}

	public enumGasTypes getType() {
		return type;
	}

	public void setType(enumGasTypes type) {
		this.type = type;
	}

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

	public boolean isAspect() {
		return aspect;
	}

	public void setAspect(boolean aspect) {
		this.aspect = aspect;
	}

	public float getDensity() {
		return density;
	}

	public void setDensity(float density) {
		this.density = density;
	}

}
