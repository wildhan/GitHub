/**
 * 
 */
package main;

/**
 * @author Wildhan Ibrahim
 *
 */
public class WaterPoint {
	private String communitiesVillages;
	private Boolean waterFunction;
	
	public WaterPoint(String communitiesVillages,Boolean waterFunction) {
		super();
		this.communitiesVillages = communitiesVillages;
		this.waterFunction = waterFunction;
	}
	
	public String getCommunitiesVillages() {
		return communitiesVillages;
	}
	public void setCommunitiesVillages(String communitiesVillages) {
		this.communitiesVillages = communitiesVillages;
	}
	public Boolean getWaterFunction() {
		return waterFunction;
	}
	public void setWaterFunction(Boolean waterFunction) {
		this.waterFunction = waterFunction;
	}
}
