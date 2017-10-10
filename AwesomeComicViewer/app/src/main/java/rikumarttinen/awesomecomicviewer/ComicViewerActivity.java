package rikumarttinen.awesomecomicviewer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

/**
 * Created by martt_000 on 3.10.2017.
 */

public class ComicViewerActivity extends AppCompatActivity {
    ImageView comicView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comic);
        comicView = (ImageView) findViewById(R.id.comicView);

        Log.d("asdf", "asdf");
        Picasso.with(this)
                .load("https://hs.mediadelivery.fi/img/1920/23c29b6be1c2496a953911b4531bd1ff.jpg").into(comicView, new Callback() {
            @Override
            public void onSuccess() {
                Log.d("picasso", "onsuccess");
            }

            @Override
            public void onError() {
                Log.d("picasso", "onerror");
            }
        });
    }
}
