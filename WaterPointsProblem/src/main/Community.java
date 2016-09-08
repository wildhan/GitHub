/**
 * 
 */
package main;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wildhan Ibrahim
 *
 */
public class Community implements Comparable<Community> {
	private String name;
	private List<WaterPoint> lWaterPoints = new ArrayList<WaterPoint>();
	private int brokenWaterPoints = 0;
	
	public Community(WaterPoint waterPoint) {
		super();
		this.name = waterPoint.getCommunitiesVillages();
		lWaterPoints.add(waterPoint);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<WaterPoint> getWaterPoints() {
		return lWaterPoints;
	}

	public void setWaterPoints(List<WaterPoint> waterPoints) {
		this.lWaterPoints = waterPoints;
	}

	public int getBrokenWaterPoints() {
		return brokenWaterPoints;
	}

	public void setBrokenWaterPoints(int brokenWaterPoints) {
		this.brokenWaterPoints = brokenWaterPoints;
	}

	@Override
	public int compareTo(Community community) {
		// TODO Auto-generated method stub
		return Float.valueOf(community.getBrokenWaterPointsPercentage()).compareTo(Float.valueOf(this.getBrokenWaterPointsPercentage()));
	}
	
	public void addWaterPoint(WaterPoint waterPoint){
		lWaterPoints.add(waterPoint);
		if(!waterPoint.getWaterFunction())
			brokenWaterPoints++;
	}
	
	public Float getBrokenWaterPointsPercentage() {
		float value =  ((float)getBrokenWaterPoints() * 100) / getWaterPoints().size();
		return Float.valueOf(String.format("%.2f", value)); // round up to 2 dp
	}
}
