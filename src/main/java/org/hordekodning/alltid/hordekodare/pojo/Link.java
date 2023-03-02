package org.hordekodning.alltid.hordekodare.pojo;


public class Link {

    private String name;
    private String url;

    public Link(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }
    @Override
    public String toString(){
        return name;
    }
}


