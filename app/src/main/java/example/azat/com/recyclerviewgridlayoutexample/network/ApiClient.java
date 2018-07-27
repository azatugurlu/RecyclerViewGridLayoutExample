package example.azat.com.recyclerviewgridlayoutexample.network;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static ApiClient serviceClient;
    private ApiService apiService;
    private static int REQUEST_TIMEOUT = 10;
    private static String BASE_URL = "https://api.nytimes.com";
    private static String API_KEY = "c3621e1dffa847628e955e278ee370a3";


    public static synchronized ApiClient getServiceClient(Class s){
        if (serviceClient == null) {
            serviceClient = new ApiClient(s);
        }
        return serviceClient;
    }

    private ApiService createService(Class<ApiService> serviceClass){
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.connectTimeout(REQUEST_TIMEOUT, TimeUnit.SECONDS);
        httpClient.readTimeout(REQUEST_TIMEOUT, TimeUnit.SECONDS);
        httpClient.interceptors().add(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY));
        httpClient.interceptors().add(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request original = chain.request();

                HttpUrl originalHttpUrl = original.url();
                HttpUrl url = originalHttpUrl.newBuilder()
                        .addQueryParameter("api-key", API_KEY)
                        .build();

                Request request = original.newBuilder()
                        .header("Accept", "application/json; charset=utf-8")
                        .method(original.method(), original.body())
                        .url(url)
                        .build();
                return chain.proceed(request);
            }
        });
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(httpClient.build())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();
        return retrofit.create(serviceClass);
    }

    private ApiClient(Class<ApiService> serviceClass) {
        apiService = createService(serviceClass);
    }

    public ApiService getApiService() {
        return apiService;
    }
}
