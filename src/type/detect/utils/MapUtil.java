/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package type.detect.utils;

/**
 *
 * @author Amir
 */
import java.util.*;

public class MapUtil {

    public static <K, V extends Comparable<? super V>> Map<K, V>
            sortByValue(Map<K, V> map) {
        List<Map.Entry<K, V>> list
                = new LinkedList<Map.Entry<K, V>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<K, V>>() {
            public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

        Map<K, V> result = new LinkedHashMap<K, V>();
        for (Map.Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }

    public static void addToFreqMap(String type, int freq, Map<String, Integer> map) {
        Integer val = map.get(type);
        if (val == null) {
            map.put(type, freq);
        } else {
            map.put(type, val + freq);
        }
    }

    public static void addToFreqMap(String type, Map<String, Integer> map) {
        addToFreqMap(type, 1, map);
    }

    public static void mergeToFreqMap(Map<String, Integer> newmap, Map<String, Integer> orgmap) {
        for (String key : newmap.keySet()) {
            addToFreqMap(key, newmap.get(key), orgmap);
        }
    }
}
