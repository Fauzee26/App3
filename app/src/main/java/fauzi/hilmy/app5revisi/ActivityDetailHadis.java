package fauzi.hilmy.app5revisi;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

import butterknife.ButterKnife;

public class ActivityDetailHadis extends AppCompatActivity {

    TextView hadisArab, hadisIndo;
    String arab, indo, audio;
    ImageButton img;
    MediaPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_hadis);
        ButterKnife.bind(this);                 // ∆˚¬πøˆ¨œ∑´†åƒß˙Ω≈ç√
        Intent aa = getIntent();
        arab = aa.getStringExtra("hadisarab");
        indo = aa.getStringExtra("hadisindo");
        final Integer audiohadis = aa.getIntExtra("audiohadis", 0);
//        audio = aa.getStringExtra("audiohadis");

        hadisArab = (TextView)findViewById(R.id.hadisArab);
        hadisIndo = (TextView)findViewById(R.id.hadisIndo);
        img = (ImageButton)findViewById(R.id.img);

        hadisArab.setText(arab);
        hadisIndo.setText(indo);
        Bundle mBundle = getIntent().getExtras();

        if (mBundle != null){

            img.setImageResource(mBundle.getInt("gambaraudio"));

//            (mBundle.getInt("audiohadis"));
        }

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "playing audio..... ", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
//mutar musik lah
                player =new MediaPlayer();
                Uri lokasiaudio = Uri.parse("android.resource://"+ getPackageName()
                        + "/" + audiohadis);
                player.setAudioStreamType(AudioManager.STREAM_MUSIC);
                try {
                    player.setDataSource(ActivityDetailHadis.this, lokasiaudio);
                } catch (IOException e) {

                }
                try {
                    player.prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                player.start();
            }
        });
    }
}
