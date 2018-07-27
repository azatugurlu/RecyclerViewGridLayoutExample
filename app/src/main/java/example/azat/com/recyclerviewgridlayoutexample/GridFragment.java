package example.azat.com.recyclerviewgridlayoutexample;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import example.azat.com.recyclerviewgridlayoutexample.application.ApiApplication;
import example.azat.com.recyclerviewgridlayoutexample.model.Entry;
import example.azat.com.recyclerviewgridlayoutexample.model.TopStoriesResponse;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class GridFragment extends Fragment {

    private CompositeDisposable disposable = new CompositeDisposable();
    private ApiApplication app;
    private RecyclerView recyclerView;
    public CardRecyclerViewAdapter adapter = null;
    private int spanCount = 3;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        app = ((ApiApplication) getActivity().getApplication());
        fetchAllEntries();
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // Inflate the layout for this fragment with the ProductGrid theme
        View view = inflater.inflate(R.layout.grid_fragment, container, false);

        // Set up the toolbar
        setUpToolbar(view);

        // Set up the RecyclerView
        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), spanCount, GridLayoutManager.VERTICAL, false));
        CardRecyclerViewAdapter adapter = new CardRecyclerViewAdapter();
        recyclerView.setAdapter(adapter);
        int largePadding = getResources().getDimensionPixelSize(R.dimen.grid_spacing);
        int smallPadding = getResources().getDimensionPixelSize(R.dimen.grid_spacing_small);
        recyclerView.addItemDecoration(new GridItemDecoration(largePadding, smallPadding));


        return view;
    }

    private void refreshUI(List<Entry> items) {
        adapter = new CardRecyclerViewAdapter(items);
        recyclerView.setAdapter(adapter);
    }

    private void fetchAllEntries() {
        disposable.add(
                app.getModel().getApiClient().getApiService().fetchAllEntries()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(new DisposableSingleObserver<TopStoriesResponse>() {
                            @Override
                            public void onSuccess(TopStoriesResponse response) {
                                refreshUI(response.results);
                            }

                            @Override
                            public void onError(Throwable e) {
                                Log.e("GRIDEX", "onError: " + e.getMessage());
                            }
                        })
        );
    }



    private void setUpToolbar(View view) {
        Toolbar toolbar = view.findViewById(R.id.app_bar);
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        if (activity != null) {
            activity.setSupportActionBar(toolbar);
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.toolbar_menu, menu);
        super.onCreateOptionsMenu(menu, menuInflater);
    }
}
