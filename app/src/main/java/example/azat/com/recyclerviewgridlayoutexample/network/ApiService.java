package example.azat.com.recyclerviewgridlayoutexample.network;

import example.azat.com.recyclerviewgridlayoutexample.model.TopStoriesResponse;
import io.reactivex.Single;
import retrofit2.http.GET;

public interface ApiService {
    @GET("svc/topstories/v2/home.json")
    Single<TopStoriesResponse> fetchAllEntries();
}
