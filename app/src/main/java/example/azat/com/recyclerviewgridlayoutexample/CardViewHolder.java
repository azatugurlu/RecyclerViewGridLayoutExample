package example.azat.com.recyclerviewgridlayoutexample;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.android.volley.toolbox.NetworkImageView;

public class CardViewHolder extends RecyclerView.ViewHolder {

    public NetworkImageView cardImage;
    public TextView cardTitle;

    public CardViewHolder(@NonNull View itemView) {
        super(itemView);
        cardImage = itemView.findViewById(R.id.card_image);
        cardTitle = itemView.findViewById(R.id.card_title);
    }
}
