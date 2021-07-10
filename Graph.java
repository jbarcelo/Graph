import java.util.LinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;

import java.util.concurrent.TimeUnit;


class Graph {

	private static String readAll(Reader rd) throws IOException {
		StringBuilder sb = new StringBuilder();
		int cp;
		while ((cp = rd.read()) != -1) {
			sb.append((char) cp);
		}
		return sb.toString();
	}

	public static JSONArray readJsonFromUrl(String url) throws Exception {
		InputStream is = new URL(url).openStream();
		try {
			TimeUnit.SECONDS.sleep(1);
			BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
			String jsonText = readAll(rd);
			JSONArray json = new JSONArray(jsonText);
			return json;
		} finally {
			is.close();
		}
	}

	public static void main(String[] args) throws Exception {
		String target = "tcampaner"; //the user we are searching for
		int newNeighbors=1; //the starting point is the only new neighbor
		int neighborsChecked=0; //we haven't checked for neighbors of any node yet
		int distance = 1; // in the first iteration we'll look for nodes at distance 1
		LinkedList<String> neighbors = new LinkedList<String>(); // data structure to store the neighbors
		neighbors.add("jbarcelo"); //this is the root, the starting point

		while (newNeighbors>0){
			System.out.println("------------------------------");
			System.out.println("Looking for neighbors at distance: " + distance);
			//the number of nodes to check in this iteration
			int nodesToCheck = newNeighbors;
			//the number of nodes to check in the next iteration
			newNeighbors = 0;
			for (int i=0; i<nodesToCheck; i++){
				String neighbor = neighbors.get(neighborsChecked+i);
				System.out.println("Looking for neighbors of node " + neighbor);
				JSONArray json = readJsonFromUrl("https://api.github.com/users/"+neighbor+"/following");
				for (int jsonCounter=0; jsonCounter<json.length(); jsonCounter++){
					String login = json.getJSONObject(jsonCounter).getString("login");
					System.out.println("Node " + login + " is adjacent");
					if (!neighbors.contains(login)){
						if (login.equals(target)) {
							System.out.println("We found "+login+"at distance "+distance);
							System.exit(0);
						}
						System.out.println("Node " + login + " is not in our list. We add it.");
						neighbors.add(login);
						newNeighbors++;
					}
				}
			}
			neighborsChecked+=nodesToCheck;
			distance++;
			System.out.println("newNeighbors found: " + newNeighbors);
		}

	}
}
