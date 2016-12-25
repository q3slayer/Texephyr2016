package org.texephyr.texephyr2k16;

public class RowItem {
    private String title;
    private String tagline;
    private int image;

    public RowItem(String title, String tagline, int image){
        this.title = title;
        this.tagline = tagline;
        this.image = image;
    }

    public String getTitle() { return title; }

    public String gettagline() { return tagline; }

    public int getImage() { return image; }
}
