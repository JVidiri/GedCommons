package edu.ifsp.ged.commons.models;

public class OpHours {
	private int id_integer;
	private int open_time;
	private int close_time;

	public int getId_integer() {
		return id_integer;
	}

	public void setId_integer(int id_integer) {
		this.id_integer = id_integer;
	}

	public int getOpen_time() {
		return open_time;
	}

	public void setOpen_time(int open_time) {
		this.open_time = open_time;
	}

	public int getClose_time() {
		return close_time;
	}

	public void setClose_time(int close_time) {
		this.close_time = close_time;
	}

	public OpHours() {

	}

	public OpHours(int open_time, int close_time) {
		super();
		this.open_time = open_time;
		this.close_time = close_time;
	}

}
