package com.hasnain.UpskillForFree.models;

public class GoLangResponse {
    public String label;
    public String courseDesc;

    public String getCourseDesc() {
        return courseDesc;
    }

    public void setCourseDesc(String courseDesc) {
        this.courseDesc = courseDesc;
    }

    public GoLangResponse() {}

    public String link;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    String image;

    public String getImage() {
        return image;
    }

    public void setImage(String imageUrl) {
        this.image = imageUrl;
    }
}
