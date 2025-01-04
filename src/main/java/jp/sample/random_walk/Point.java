package jp.sample.random_walk;

import lombok.Data;

@Data
public class Point {
	public double lat;
	public double lng;
	
	public Point(double lat, double lng) {
		this.lat = lat;
		this.lng = lng;
	}
}
