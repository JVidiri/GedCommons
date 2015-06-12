package edu.ifsp.ged.commons.ranking;

public class DistributorRanking extends Ranking {
	private int pointProduct;
	private int pointSeller;
	private int pointDriverAttendence;
	private int pointBillOfSalle;

	public int getPointProduct() {
		return pointProduct;
	}

	public void setPointProduct(int pointProduct) {
		this.pointProduct = pointProduct;
	}

	public int getPointSeller() {
		return pointSeller;
	}

	public void setPointSeller(int pointSeller) {
		this.pointSeller = pointSeller;
	}

	public int getPointDriverAttendence() {
		return pointDriverAttendence;
	}

	public void setPointDriverAttendence(int pointDriverAttendence) {
		this.pointDriverAttendence = pointDriverAttendence;
	}

	public int getPointBillOfSalle() {
		return pointBillOfSalle;
	}

	public void setPointBillOfSalle(int pointBillOfSalle) {
		this.pointBillOfSalle = pointBillOfSalle;
	}

}
