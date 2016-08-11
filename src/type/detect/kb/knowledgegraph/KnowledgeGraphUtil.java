/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package type.detect.kb.knowledgegraph;

/**
 *
 * @author Amir
 */
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;

import com.jayway.jsonpath.JsonPath;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;

/**
 * Client calling Knowledge Graph Search API
 */
public class KnowledgeGraphUtil {

    final private static String KG_PROPERTIES_LOC = "resources/freebase/freebase.properties";

    public static Properties properties = new Properties();

    public static void main(String[] args) {
        System.out.println(getType("LogP"));
    }

    public static String getType(String query) {
        final JSONArray elements = getResult(query);
        System.out.println(elements);
        for (Object element : elements) {
            List<String> typeArray = JsonPath.read(element, "$.result.@type");
            for (String type : typeArray) {
                if (!type.equals("Thing")) {
                    return type;
                }
            }
        }
        System.out.println("Empty set");
        return null;
    }

    public static JSONArray getResult(String query) {
        try {
            properties.load(new FileInputStream(KG_PROPERTIES_LOC));

            HttpTransport httpTransport = new NetHttpTransport();
            HttpRequestFactory requestFactory = httpTransport.createRequestFactory();
            JSONParser parser = new JSONParser();
            GenericUrl url = new GenericUrl("https://kgsearch.googleapis.com/v1/entities:search");
            url.put("query", query);
            url.put("limit", "1");
            url.put("indent", "true");
            url.put("key", properties.get("KG_API_KEY"));
            HttpRequest request = requestFactory.buildGetRequest(url);
            HttpResponse httpResponse = request.execute();
            JSONObject response = (JSONObject) parser.parse(httpResponse.parseAsString());
            JSONArray elements = (JSONArray) response.get("itemListElement");
            return elements;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
