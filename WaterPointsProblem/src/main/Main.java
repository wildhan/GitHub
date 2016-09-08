/**
 * 
 */
package main;

/**
 * @author Wildhan Ibrahim
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Service service = new Service();
		service.getInfrastructureData("https://raw.githubusercontent.com/onaio/ona-tech/master/data/water_points.json");
		System.out.println("The number of water points functional :" + service.getNumberOfWaterPointFunction());
		System.out.println("The number of water points per community :");
		for (Community commu : service.getlCommunties()) {
			System.out.println(commu.getName()+"\t: "+commu.getWaterPoints().size());
		}
		System.out.println("The number of water points per community :");
		for (Community commu : service.getlCommunties()) {
			System.out.println(commu.getName()+"\t: "+commu.getBrokenWaterPointsPercentage());
		}
	}

}
