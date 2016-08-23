/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package type.detect;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import type.detect.kb.wikidata.WikiDataConsumer;

/**
 *
 * @author Amir
 */
public class TypeDetect {

    /**
     * @param args the command line arguments
     */
    public TypeDetect() {
    }

    public static void main(String[] args) {
        // TODO code application logic here
    }

    public String besttype(String text) {
        return WikiDataConsumer.getBestType(text);
    }

    public String besttype(List<String> list) {
        return WikiDataConsumer.getBestType(list);
    }

    public String besttype(Set<String> set) {
        List<String> list = new ArrayList<>(set);
        return WikiDataConsumer.getBestType(list);
    }

}
