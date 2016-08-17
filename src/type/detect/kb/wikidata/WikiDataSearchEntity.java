/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package type.detect.kb.wikidata;

/**
 *
 * @author Amir
 */
public class WikiDataSearchEntity {

    String id;
    String url;
    String label;
    String type;

    public WikiDataSearchEntity() {
    }

    public WikiDataSearchEntity(String id, String url, String label, String type) {
        this.id = id;
        this.url = url;
        this.label = label;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "WikiDataSearchEntity{" + "id=" + id + ", url=" + url + ", label=" + label + ", type=" + type + "}\n";
    }

}
