package fauzi.hilmy.app5revisi;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class AboutDeveloper extends AppCompatActivity {

    ImageButton btnGithub, btnLinkedin, btnLine, btnWordpress, btnInstagram;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_developer);

        btnGithub = (ImageButton)findViewById(R.id.btnGithub);
        btnLinkedin = (ImageButton)findViewById(R.id.btnLinkedin);
        btnLine = (ImageButton)findViewById(R.id.btnLine);
        btnWordpress = (ImageButton)findViewById(R.id.btnWordpress);
        btnInstagram = (ImageButton)findViewById(R.id.btnInstagram);

        btnGithub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //memanggil url
                String urlWeb = "https://github.com/Fauzee26";
                //memanggil urlWeb ketika intent
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(urlWeb));
                startActivity(intent);
            }
        });

        btnLinkedin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //memanggil url
                String urlWeb = "https://www.linkedin.com/in/hilmy-fauzi-batam26/";
                //memanggil urlWeb ketika intent
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(urlWeb));
                startActivity(intent);
            }
        });

        btnLine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //memanggil url
                String urlWeb = "http://line.me/ti/p/bDTpen3_AJ";
                //memanggil urlWeb ketika intent
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(urlWeb));
                startActivity(intent);
            }
        });

        btnWordpress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //memanggil url
                String urlWeb = "https://hilmyfauzi26.wordpress.com/";
                //memanggil urlWeb ketika intent
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(urlWeb));
                startActivity(intent);
            }
        });

        btnInstagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //memanggil url
                String urlWeb = "https://www.instagram.com/hill.fauzi/";
                //memanggil urlWeb ketika intent
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(urlWeb));
                startActivity(intent);
            }
        });
    }
}
