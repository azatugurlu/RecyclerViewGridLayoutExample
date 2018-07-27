package example.azat.com.recyclerviewgridlayoutexample;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import example.azat.com.recyclerviewgridlayoutexample.model.Entry;
import example.azat.com.recyclerviewgridlayoutexample.network.ImageRequester;

public class CardRecyclerViewAdapter extends RecyclerView.Adapter<CardViewHolder> {
    private List<Entry> cardList;
    private ImageRequester imageRequester;

    CardRecyclerViewAdapter() {
        cardList = new ArrayList<>();
        imageRequester = ImageRequester.getInstance();
    }

    CardRecyclerViewAdapter(List<Entry> entryList) {
        this.cardList = entryList;
        imageRequester = ImageRequester.getInstance();
    }

    public void setCardList(List<Entry> entryList){
        this.cardList = entryList;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card, parent, false);
        return new CardViewHolder(layoutView);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        if (cardList != null && position < cardList.size()) {
            Entry entry = cardList.get(position);
            holder.cardTitle.setText(entry.getTitle());
            imageRequester.setImageFromUrl(holder.cardImage, entry.getMultimedia().get(1).getUrl());
        }
    }

    @Override
    public int getItemCount() {
        return cardList.size();
    }
}
