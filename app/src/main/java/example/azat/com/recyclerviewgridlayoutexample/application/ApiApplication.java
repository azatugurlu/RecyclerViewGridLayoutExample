package example.azat.com.recyclerviewgridlayoutexample.application;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatDelegate;

import example.azat.com.recyclerviewgridlayoutexample.Model;

public class ApiApplication extends Application {
    private static ApiApplication instance;
    private static Context appContext;
    public Model model;

    public Model getModel() {
        return model;
    }

    public static ApiApplication getInstance() {
        return instance;
    }

    public static Context getAppContext() {
        return appContext;
    }

    public void setAppContext(Context mAppContext) {
        this.appContext = mAppContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        model = new Model(this);

        this.setAppContext(getApplicationContext());
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }
}
