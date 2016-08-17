/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package type.detect.kb.wikidata;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import type.detect.utils.IOUtils;

/**
 *
 * @author Amir
 */
public class WikiDataConsumer {

    private static String SEARCH_URL_TEMPLATE = "https://www.wikidata.org/w/api.php?action=wbsearchentities&search={{query}}&language=en&type=item&format=json";

    public static void main(String[] args) {
        System.out.println(search("barack obama"));
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
