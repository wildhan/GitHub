/**
 * 
 */
package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author Wildhan Ibrahim
 *
 */
public class Service {
	private List<Community> lCommunties = new ArrayList<>();
	private int numberOfWaterPointFunction = 0;
		
	public List<Community> getlCommunties() {
		return lCommunties;
	}

	public void setlCommunties(List<Community> lCommunties) {
		this.lCommunties = lCommunties;
	}

	public int getNumberOfWaterPointFunction() {
		return numberOfWaterPointFunction;
	}

	public void setNumberOfWaterPointFunction(int numberOfWaterPointFunction) {
		this.numberOfWaterPointFunction = numberOfWaterPointFunction;
	}

	public String readJSONText(Reader reader){
		StringBuilder strBuild = new StringBuilder();
		int cp;
		try{
			while ((cp=reader.read())!=-1) 
				strBuild.append((char)cp);				
		} catch (IOException ex) {
			System.out.println("ReadJSONText IO : "+ex.getMessage());
		}
		return strBuild.toString();
	}
	
	public int getIndexCommunities(WaterPoint waterPoint){
		int index = -1;
		for (Community comm : lCommunties) {
			if(comm.getName().equals(waterPoint.getCommunitiesVillages())){
				index = lCommunties.indexOf(comm);
				break;
			}
		}
		return index;
	}
	
	public Boolean setWaterPointsFunctioning(JSONObject jsonObj){
		Boolean value = false;
		try {
			if(jsonObj.getString("water_functioning").equals("yes")){
				numberOfWaterPointFunction++;
				value = true;
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;
	}
	
	public void getInfrastructureData(String url) {
		try {
			InputStream inpStream = new URL(url).openStream();
			BufferedReader buffReader = new BufferedReader(new InputStreamReader(inpStream, Charset.forName("UTF-8")));
			JSONArray jsonArr = new JSONArray(readJSONText(buffReader));
			for(int i=0; i<jsonArr.length() ; i++){
				JSONObject jsonObj = jsonArr.getJSONObject(i);
				WaterPoint waterPoint = new WaterPoint(jsonObj.getString("communities_villages"), setWaterPointsFunctioning(jsonObj));
				int index;
				if((index = getIndexCommunities(waterPoint))!=-1)
					lCommunties.get(index).addWaterPoint(waterPoint);
				else 
					lCommunties.add(new Community(waterPoint));
			}
			Collections.sort(lCommunties);
		} catch (IOException ex) {
			// TODO Auto-generated catch block
			System.out.println("GetInfrastructureData IO : "+ex.getMessage());
		} catch (JSONException ex) {
			// TODO Auto-generated catch block
			System.out.println("GetInfrastructureData JSON : "+ex.getMessage());
		}
	}
}
