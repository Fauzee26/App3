package fauzi.hilmy.app5revisi;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.io.IOException;

public class DetailHadisScrolling extends AppCompatActivity {

    TextView hadisArab, hadisIndo;
    String arab, indo, judul;
    ImageButton img;
    MediaPlayer player;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_hadis_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        hadisArab = (TextView)findViewById(R.id.hadisArab);
        hadisIndo = (TextView)findViewById(R.id.hadisIndo);
        img = (ImageButton)findViewById(R.id.img);

        tampilData();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void tampilData() {
        Intent aa = getIntent();
        arab = aa.getStringExtra("hadisarab");
        indo = aa.getStringExtra("hadisindo");
        judul = aa.getStringExtra("judulhadis");
        final Integer audiohadis = aa.getIntExtra("audiohadis", 0);

        setTitle(judul);
        hadisArab.setText(arab);
        hadisIndo.setText(indo);
        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Check audio is playing or not
                if (player != null){
                    //if the sound is playing
                    player.stop();
                    player.release();
                    player = null;
                    fab.setImageResource(R.drawable.playy);
                } else {
                    //if audio is null
                    Snackbar.make(view, "Playing Hadis " + judul, Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    //playing audio
                    player = new MediaPlayer();
                    Uri hadisAudio = Uri.parse("android.resource://" + getPackageName() + "/" + audiohadis);
                    player.setAudioStreamType(AudioManager.STREAM_MUSIC);
                    try {
                        player.setDataSource(DetailHadisScrolling.this, hadisAudio);
                    } catch (IOException e){

                    }
                    try {
                        player.prepare();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    player.start();
                    fab.setImageResource(R.drawable.stopp);
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
    stopAudio();
    finish();
    }

    private void stopAudio(){
        if (player != null){
            player.stop();
            player.release();
            player = null;
        }
    }
}
