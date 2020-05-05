package it.polito.tdp.extflightdelays.model;

public class Volo {

	private int ORIGIN_AIRPORT;
	private int DESTINATION_AIRPORT;
	private int distance;
	
	public Volo(int oRIGIN_AIRPORT, int dESTINATION_AIRPORT, int distance) {
		ORIGIN_AIRPORT = oRIGIN_AIRPORT;
		DESTINATION_AIRPORT = dESTINATION_AIRPORT;
		this.distance = distance;
	}

	public int getORIGIN_AIRPORT() {
		return ORIGIN_AIRPORT;
	}

	public void setORIGIN_AIRPORT(int oRIGIN_AIRPORT) {
		ORIGIN_AIRPORT = oRIGIN_AIRPORT;
	}

	public int getDESTINATION_AIRPORT() {
		return DESTINATION_AIRPORT;
	}

	public void setDESTINATION_AIRPORT(int dESTINATION_AIRPORT) {
		DESTINATION_AIRPORT = dESTINATION_AIRPORT;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}
	
	
	
}
