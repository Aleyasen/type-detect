/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package type.detect.kb.wikidata;

import com.jayway.jsonpath.JsonPath;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import type.detect.utils.IOUtils;
import type.detect.utils.MapUtil;

/**
 *
 * @author Amir
 */
public class WikiDataConsumer {

    private static final String SEARCH_URL_TEMPLATE = "https://www.wikidata.org/w/api.php?action=wbsearchentities&search={{query}}&language=en&type=item&format=json";
    private static final String SPAPRQL_TYPE_QUERY = IOUtils.readFileToString("resources/wikidata/search_by_id.sparql");
    private static final String SPARQL_URL_TEMPLATE = "https://query.wikidata.org/sparql?format=json&query={{sparql}}";
    private static final Integer DEFUALT_SEARCH_LIMIT = 3;

    public static void main(String[] args) {
//        final Map<String, Integer> types = getTypes("barack obama");
//        System.out.println(types);
//        getBestType("water solubility");
        final Map<String, Integer> types = getTypes(Arrays.asList("barack obama", "Bill clinton"));
        System.out.println(types);
        System.out.println(getBestType(Arrays.asList("barack obama", "Bill clinton")));

    }

    public static Map<String, Integer> getTypes(List<String> terms) {
        Map<String, Integer> freq = new HashMap<>();
        for (String term : terms) {
            final Map<String, Integer> types = getTypes(term);
            MapUtil.mergeToFreqMap(types, freq);
        }
        return freq;
    }

    public static Map<String, Integer> getTypes(String term) {

        Map<String, Integer> freq = new HashMap<>();
        List<WikiDataSearchEntity> results = search(term, DEFUALT_SEARCH_LIMIT);
        System.out.println(results);
        for (WikiDataSearchEntity ent : results) {
            final List<String> types = recognizeTypesForID(ent.getId());
            for (String type : types) {
                MapUtil.addToFreqMap(type, freq);
            }
        }
        return freq;
    }

    public static String getBestType(String term) {
        final Map<String, Integer> types = getTypes(term);
        Map<String, Integer> sortedmap = MapUtil.sortByValue(types);
        System.out.println(sortedmap);
        for (String key : sortedmap.keySet()) {
            return key;
        }
        return null;
    }

    public static String getBestType(List<String> terms) {
        final Map<String, Integer> types = getTypes(terms);
        Map<String, Integer> sortedmap = MapUtil.sortByValue(types);
        System.out.println(sortedmap);
        for (String key : sortedmap.keySet()) {
            return key;
        }
        return null;
    }

    public static List<String> recognizeTypesForID(String id) {
        try {
            String sparql = SPAPRQL_TYPE_QUERY.replace("{{id}}", id);
            sparql = URLEncoder.encode(sparql, "UTF-8");
            final String url = SPARQL_URL_TEMPLATE.replace("{{sparql}}", sparql);
            final JSONObject json = IOUtils.getJsonfromURL(url);
//            System.out.println(json);
            List<String> types = JsonPath.read(json.toString(), "$.results.bindings[*].typelabel.value");
            System.out.println(types);
            return types;
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(WikiDataConsumer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static List<WikiDataSearchEntity> search(String query, int limit) {
        final List<WikiDataSearchEntity> results = search(query);
        if (results.size() <= limit) {
            return results;
        } else {
            return results.subList(0, limit);
        }
    }

    public static List<WikiDataSearchEntity> search(String query) {
        List<WikiDataSearchEntity> results = new ArrayList<>();
        try {
            query = URLEncoder.encode(query, "UTF-8");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(WikiDataConsumer.class.getName()).log(Level.SEVERE, null, ex);
        }
        String url = createURL(query);
        final JSONObject json = IOUtils.getJsonfromURL(url);
        final JSONArray elements = (JSONArray) json.get("search");
        for (Object elem : elements) {
            JSONObject jsonObj = (JSONObject) elem;
            WikiDataSearchEntity wdentity = new WikiDataSearchEntity();
            wdentity.setId(jsonObj.getString("id"));
            wdentity.setUrl(jsonObj.getString("url"));
            wdentity.setLabel(jsonObj.getString("label"));
            results.add(wdentity);
        }
        return results;
    }

    private static String createURL(String query) {
        String url = SEARCH_URL_TEMPLATE.replace("{{query}}", query);
        return url;
    }

}
