package ca.bcit.explorenewwest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by maggi on 2018-04-09.
 */

public class PlaceActivity extends AppCompatActivity {
    private ImageView locationPhoto;
    private TextView locationTitle;
    private TextView locationDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place);

        locationPhoto= (ImageView) findViewById(R.id.news_info_photo);
        locationTitle= (TextView) findViewById(R.id.news_info_title);
        locationDesc= (TextView) findViewById(R.id.news_info_desc);

        Intent intent=getIntent();

        Place item= (Place) intent.getSerializableExtra("Place");
        locationPhoto.setImageResource(item.getImgId());
        locationTitle.setText(item.getaName());
        locationDesc.setText(item.getDesc());

    }
}
