package example.azat.com.recyclerviewgridlayoutexample.model;

import android.content.res.Resources;
import android.net.Uri;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import example.azat.com.recyclerviewgridlayoutexample.R;

public class Entry {
    private String title;
    private Uri dynamicUrl;
    private String url;
    private List<Multimedia> multimedia;

    public Entry() {
    }

    public Entry(
            String title, String dynamicUrl, String url, List<Multimedia> multimedia) {
        this.title = title;
        this.dynamicUrl = Uri.parse(dynamicUrl);
        this.url = url;
        this.multimedia = multimedia;
    }

    public String getTitle() {
        return title;
    }

    public Uri getDynamicUrl() {
        return dynamicUrl;
    }

    public String getUrl() {
        return url;
    }

    public List<Multimedia> getMultimedia() {
        return multimedia;
    }
}
