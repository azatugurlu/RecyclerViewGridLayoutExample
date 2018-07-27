package example.azat.com.recyclerviewgridlayoutexample.model;

import java.util.List;

public class TopStoriesResponse {
    public String status;
    public int num_results;
    public List<Entry> results;

    public TopStoriesResponse(String status, int num_results, List<Entry> results) {
        this.status = status;
        this.num_results = num_results;
        this.results = results;
    }
}
