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
public class API2 {
	
	//API Key for LOTR hMUAUEAybB3om46dcLRj
	
	private static HttpURLConnection connection;
	
	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the Lord of the Rings Book Number(1-3)");
		int id = scan.nextInt();
		String key="";
		if(id==1) {
			key = "5cf5805fb53e011a64671582";
		}else if (id==2) {
			key = "5cf58077b53e011a64671583";
		}else if( id==3) {
			key = "5cf58080b53e011a64671584";
		}
		
		BufferedReader read;
		String line;
		StringBuffer responseContent = new StringBuffer();
		
		
		try {
	
		URL url = new URL("https://the-one-api.dev/v2/book/"+key); 
		//System.out.println("https://the-one-api.dev/v2/book/"+key);
		
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
		System.out.print("Book "+id+"'s title is ");
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
				    JsonArray array = jsonObject.getAsJsonArray("docs");
				    JsonObject list = (JsonObject) array.get(0);
				    System.out.print(list.get("name"));
				}
				
			}
			
}
