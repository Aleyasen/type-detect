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
import java.util.Properties;

/**
 * Client calling Knowledge Graph Search API
 */
public class KnowledgeGraphUtil {

    final private static String KG_PROPERTIES_LOC = "resources/freebase/freebase.properties";

    public static Properties properties = new Properties();

    public static void main(String[] args) {
        try {
            properties.load(new FileInputStream(KG_PROPERTIES_LOC));

            HttpTransport httpTransport = new NetHttpTransport();
            HttpRequestFactory requestFactory = httpTransport.createRequestFactory();
            JSONParser parser = new JSONParser();
            GenericUrl url = new GenericUrl("https://kgsearch.googleapis.com/v1/entities:search");
            url.put("query", "Taylor Swift");
            url.put("limit", "10");
            url.put("indent", "true");
            url.put("key", properties.get("KG_API_KEY"));
            HttpRequest request = requestFactory.buildGetRequest(url);
            HttpResponse httpResponse = request.execute();
            JSONObject response = (JSONObject) parser.parse(httpResponse.parseAsString());
            JSONArray elements = (JSONArray) response.get("itemListElement");
            System.out.println(elements);
            for (Object element : elements) {
                System.out.println(JsonPath.read(element, "$.result.name").toString());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
