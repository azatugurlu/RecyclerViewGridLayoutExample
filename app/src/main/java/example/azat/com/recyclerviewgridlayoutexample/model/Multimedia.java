package example.azat.com.recyclerviewgridlayoutexample.model;

public class Multimedia {
    private String url;
    private String type;
    private int height;
    private int width;

    public Multimedia() {
    }

    public Multimedia(String url, String type, int height, int width) {
        this.url = url;
        this.type = type;
        this.height = height;
        this.width = width;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}
