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
    private static final String TAG = Entry.class.getSimpleName();

    public final String title;
    public final Uri dynamicUrl;
    public final String url;
    public final List<Multimedia> multimedia;

    public Entry(
            String title, String dynamicUrl, String url, List<Multimedia> multimedia) {
        this.title = title;
        this.dynamicUrl = Uri.parse(dynamicUrl);
        this.url = url;
        this.multimedia = multimedia;
    }


    /**
     * Loads a raw JSON at R.raw.products and converts it into a list of ProductEntry objects

    public static List<Entry> initEntryList(Resources resources) {
        InputStream inputStream = resources.openRawResource(R.raw.products);
        Writer writer = new StringWriter();
        char[] buffer = new char[1024];
        try {
            Reader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            int pointer;
            while ((pointer = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, pointer);
            }
        } catch (IOException exception) {
            Log.e(TAG, "Error writing/reading from the JSON file.", exception);
        } finally {
            try {
                inputStream.close();
            } catch (IOException exception) {
                Log.e(TAG, "Error closing the input stream.", exception);
            }
        }
        String jsonProductsString = writer.toString();
        Gson gson = new Gson();
        Type productListType = new TypeToken<ArrayList<Entry>>() {
        }.getType();
        return gson.fromJson(jsonProductsString, productListType);
    }
    */
}
