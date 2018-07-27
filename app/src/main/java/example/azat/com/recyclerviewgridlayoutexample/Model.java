package example.azat.com.recyclerviewgridlayoutexample;

import android.support.annotation.NonNull;

import example.azat.com.recyclerviewgridlayoutexample.application.ApiApplication;
import example.azat.com.recyclerviewgridlayoutexample.network.ApiClient;
import example.azat.com.recyclerviewgridlayoutexample.network.ApiService;

public final class Model {

    @NonNull public final ApiApplication app;
    private ApiClient apiClient;


    public Model(final ApiApplication app){
        this.app = app;
        apiClient = ApiClient.getServiceClient(ApiService.class);
    }

    public ApiClient getApiClient() {
        return apiClient;
    }
}
