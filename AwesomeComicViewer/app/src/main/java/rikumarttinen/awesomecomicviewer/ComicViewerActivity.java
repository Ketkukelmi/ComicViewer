package rikumarttinen.awesomecomicviewer;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

/**
 * Created by martt_000 on 3.10.2017.
 */

public class ComicViewerActivity extends AppCompatActivity {
    ImageView comicView;
    String comic;
    String cName;
    int i = 0;
    private float x1, x2;
    static final int MIN_DISTANCE = 150;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comic);


        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            comic = extras.getString("URL");
        }

        String firstURLToLoad;
        switch (comic) {
            default:
            case "fingerpori":
                firstURLToLoad = getResources().getStringArray(R.array.fingerpori)[i];
                break;
            case "xkcd":
                firstURLToLoad = getResources().getStringArray(R.array.xkcd)[i];
                break;
        }
        comicView = (ImageView) findViewById(R.id.comicView);
        Picasso.with(this)
                .load(firstURLToLoad).into(comicView);
    }

    public void onClickNext(View view) {
        i = ++i;
        String nextUrl = null;
        switch (comic){
            case "fingerpori":
                if(i >= getResources().getStringArray(R.array.fingerpori).length){
                    Toast.makeText(this,"No more comics", Toast.LENGTH_SHORT).show();
                    i = 7;
                }else {
                    nextUrl = getResources().getStringArray(R.array.fingerpori)[i];
                }
                break;
            case "xkcd":
                if(i >= getResources().getStringArray(R.array.fingerpori).length){
                    Toast.makeText(this,"No more comics", Toast.LENGTH_SHORT).show();
                    i = 7;
                }else {
                    nextUrl = getResources().getStringArray(R.array.xkcd)[i];
                }
                break;
            default:
        }
        comicView = (ImageView) findViewById(R.id.comicView);
        Picasso.with(getApplication())
                .load(nextUrl).into(comicView);
    }

    public void onClicBack(View view) {
        String nextUrl = null;
        i = --i;
        switch (comic){
            case "fingerpori":
                if(i <= 0 ){
                    Toast.makeText(this,"No more comics", Toast.LENGTH_SHORT).show();
                    i = 0;
                }else {
                    nextUrl = getResources().getStringArray(R.array.fingerpori)[i];
                }
                break;
            case "xkcd":
                if(i <= 0 ){
                    Toast.makeText(this,"No more comics", Toast.LENGTH_SHORT).show();
                    i = 0;
                }else {
                    nextUrl = getResources().getStringArray(R.array.xkcd)[i];
                }
                break;
            default:
        }
        comicView = (ImageView) findViewById(R.id.comicView);
        Picasso.with(getApplication())
                .load(nextUrl).into(comicView);
    }
}
