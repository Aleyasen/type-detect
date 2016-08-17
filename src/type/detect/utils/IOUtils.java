/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package type.detect.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author Amir
 */
public class IOUtils {

    public static List<String> readFileLineByLine(String file) {
        String content = null;
        try {
            content = FileUtils.readFileToString(new File(file));
        } catch (IOException ex) {
            Logger.getLogger(IOUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        List<String> lines = Arrays.asList(content.split("\\r\\n|\\n|\\r"));
        return lines;
    }

    public static String readUrl(String urlString) {
        BufferedReader reader = null;
        try {
            URL url = new URL(urlString);
            reader = new BufferedReader(new InputStreamReader(url.openStream()));
            StringBuilder buffer = new StringBuilder();
            int read;
            char[] chars = new char[1024];
            while ((read = reader.read(chars)) != -1) {
                buffer.append(chars, 0, read);
            }
            reader.close();
            System.out.println(buffer.toString());
            return buffer.toString();
        } catch (MalformedURLException ex) {
            Logger.getLogger(IOUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(IOUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static JSONObject getJsonfromURL(String urlString) {
        final String jsonStr = readUrl(urlString);
        JSON obj = JSONSerializer.toJSON(jsonStr);
        if (obj.isEmpty()) {
            return null;
        }
        JSONObject jsonObject = (JSONObject) obj;
        return jsonObject;

    }
}
