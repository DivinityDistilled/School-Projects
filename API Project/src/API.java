import java.io.BufferedReader;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
public class API {
	
	//API Key for LOTR hMUAUEAybB3om46dcLRj
	
	private static HttpURLConnection connection;
	
	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the city or zipcode");
		String city = scan.nextLine();
		
		BufferedReader read;
		String line;
		StringBuffer responseContent = new StringBuffer();
		
		
		try {
	
		URL url = new URL("http://api.openweathermap.org/data/2.5/weather?q="+city+"&APPID=26aa1d90a24c98fad4beaac70ddbf274"); 
		//System.out.println("http://api.openweathermap.org/data/2.5/weather?q="+city+"&APPID=26aa1d90a24c98fad4beaac70ddbf274");
		
		connection = (HttpURLConnection) url.openConnection();
		
		connection.setRequestMethod("GET");
		connection.setConnectTimeout(5000);
		connection.setReadTimeout(5000);
		
		int status = connection.getResponseCode();
		//System.out.println(status);									//Test
		
		if (status>299) {
			
			read = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
			while((line=read.readLine())!= null) {
				responseContent.append(line);
			}
			read.close();
				
		}else {
			
			read = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			while((line = read.readLine())!= null) {
				responseContent.append(line);
			}
		}
		read.close();
				
		//System.out.println(responseContent.toString());				//Test
		String result = responseContent.toString();
		parser(result);
		
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			
			connection.disconnect();
		}
		
		
	}
			
			
			public static void parser(String jsonLine) {
				JsonParser jsonParser = new JsonParser();
				JsonElement jsonTree = jsonParser.parse(jsonLine);
				if(jsonTree.isJsonObject()) {
				    JsonObject jsonObject = jsonTree.getAsJsonObject();
				    JsonArray array = jsonObject.getAsJsonArray("weather");
				    JsonObject weatherJson = (JsonObject) array.get(0);
				    System.out.print("The weather looks ");
				    System.out.print(weatherJson.get("main")+" in ");
				    System.out.print(jsonObject.get("name"));
				    System.out.print(" which is decribed as ");
				    System.out.print(weatherJson.get("description"));
				}
				
			}
			
}	

	
		
		

