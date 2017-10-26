package rikumarttinen.awesomecomicviewer;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

/**
 * Created by martt_000 on 3.10.2017.
 */

public class ComicViewerActivity extends AppCompatActivity  {
    ImageView comicView;
    String comic;
    String cName;
    int i = 0;
    private float x1,x2;
    static final int MIN_DISTANCE = 150;

    @SuppressLint("ClickableViewAccessibility")
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
                firstURLToLoad = getResources().getStringArray(R.array.fingerpori)[i];
                break;
            case "xkcd":
                firstURLToLoad = getResources().getStringArray(R.array.xkcd)[i];
                break;
        }
        comicView = (ImageView) findViewById(R.id.comicView);
        comicView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                String nextUrl = null;
                switch(event.getAction())
                {
                    case MotionEvent.ACTION_DOWN:
                        x1 = event.getX();
                        Log.d("TAG", "HELLO");
                        break;
                    case MotionEvent.ACTION_UP:
                        x2 = event.getX();
                        Log.d("TAG", "HELLO up");
                        float deltaX = x2 - x1;

                        if (Math.abs(deltaX) > MIN_DISTANCE)
                        {
                            //"left2right swipe
                            Log.d("TAG", "HELLO ---");
                            switch (comic){
                                case "fingerpori":
                                    if(i == 0){
                                        return  false;
                                    }
                                    else {
                                        nextUrl = getResources().getStringArray(R.array.fingerpori)[--i];
                                    }
                                    break;
                                case "xkcd":
                                    if(i == 0){
                                        return  false;
                                    }
                                    else {
                                        nextUrl = getResources().getStringArray(R.array.xkcd)[--i];
                                    }
                                    break;
                                default:
                            }
                            comicView = (ImageView) findViewById(R.id.comicView);
                            Picasso.with(getApplication())
                                    .load(nextUrl ).into(comicView);
                        }
                        else if (Math.abs(deltaX) < MIN_DISTANCE)
                        {
                            Log.d("TAG", "HELLO +++");
                            switch (comic){
                                case "fingerpori":
                                    nextUrl = getResources().getStringArray(R.array.fingerpori)[++i];
                                    break;
                                case "xkcd":
                                    nextUrl = getResources().getStringArray(R.array.xkcd)[++i];
                                    break;
                                default:
                            }
                            comicView = (ImageView) findViewById(R.id.comicView);
                            Picasso.with(getApplication())
                                    .load(nextUrl).into(comicView);
                        }
                        break;
                }
                return false;
            }
        });
        Picasso.with(this)
                .load(firstURLToLoad).into(comicView);
    }

}
