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
    String comic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comic);
        Bundle extras  = getIntent().getExtras();
        if (extras != null) {
            comic = extras.getString("URL");
        }
        String firstURLToLoad;
        switch (comic) {
            default:
            case "fingerpori":
                firstURLToLoad = getResources().getStringArray(R.array.fingerpori)[0];
                break;
            case "xkcd":
                firstURLToLoad = getResources().getStringArray(R.array.xkcd)[0];
                break;
        }
        comicView = (ImageView) findViewById(R.id.comicView);
        Picasso.with(this)
                .load(firstURLToLoad).into(comicView);
    }
}
