package ca.bcit.explorenewwest;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by maggi on 2018-04-09.
 */

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.PlaceViewHolder>{
    private List<Place> places;
    private Context context;

    RVAdapter(List<Place> places, Context context){
        this.places = places;
        this.context = context;
    }

    public static class PlaceViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        ImageView news_photo;
        TextView news_title;
        TextView news_desc;
        Button share;
        Button readMore;

        public PlaceViewHolder(final View itemView) {
            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.card_view);
            news_photo = (ImageView) itemView.findViewById(R.id.location_photo);
            news_title = (TextView) itemView.findViewById(R.id.location_name);
            news_desc = (TextView) itemView.findViewById(R.id.location_desc);
            share = (Button) itemView.findViewById(R.id.btn_share);
            readMore = (Button) itemView.findViewById(R.id.btn_more);
            //Set the TextView background -->opacity
            news_title.setBackgroundColor(Color.argb(20, 0, 0, 0));

        }
    }
    @Override
    public RVAdapter.PlaceViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(context).inflate(R.layout.cardview,viewGroup,false);
        PlaceViewHolder nvh=new PlaceViewHolder(v);
        return nvh;
    }

    @Override
    public void onBindViewHolder(RVAdapter.PlaceViewHolder placeViewHolder, int i) {
        final int j=i;

        placeViewHolder.news_photo.setImageResource(places.get(i).getImgId());
        placeViewHolder.news_title.setText(places.get(i).getaName());
        placeViewHolder.news_desc.setText(places.get(i).getDesc());

        //set the on clilk listener to the btn_share btn_readMore(cardView)
        placeViewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,PlaceActivity.class);
                intent.putExtra("Place",places.get(j));
                context.startActivity(intent);
            }
        });

        placeViewHolder.share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_SUBJECT, "share");
                intent.putExtra(Intent.EXTRA_TEXT, places.get(j).getDesc());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(Intent.createChooser(intent, places.get(j).getaName()));
            }
        });

        placeViewHolder.readMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,PlaceActivity.class);
                intent.putExtra("Place",places.get(j));
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return places.size();
    }


}
