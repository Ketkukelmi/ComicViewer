package rikumarttinen.awesomecomicviewer;

import android.content.Intent;
import android.graphics.Typeface;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private ImageButton fingerB, xkcdB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        TextView textView = (TextView) findViewById(R.id.textView3);
        textView.setText(R.string.pickComic);
        Typeface custom_font = Typeface.createFromAsset(getAssets(), "fonts/TTF.ttf");
        textView.setTypeface(custom_font);
        fingerB = (ImageButton) findViewById(R.id.imageButton);
        xkcdB = (ImageButton) findViewById(R.id.imageButton2);

        fingerB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fingerpori = "dunno url tai jtn";
                Intent intent = new Intent(getApplication(), ComicViewerClass.class);
                intent.putExtra("Fingerpori", fingerpori);
                startActivity(intent);
            }
        });
        xkcdB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String xkcd = "dunno url tai jtn";
                Intent intent = new Intent(getApplication(), ComicViewerClass.class);
                intent.putExtra("Xkcd", xkcd);
                startActivity(intent);
            }
        });
    }
}
