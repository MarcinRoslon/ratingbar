package com.example.ratingbar;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.graphics.Color;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        TextView tekst = findViewById(R.id.tekst);
        RatingBar ratingBar = findViewById(R.id.ratingBar);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                Log.d("Ocena: ", "" + v);
                Log.d("Klikniete: ", "" + b);
                float ocena = (float)ratingBar.getRating();
                int kolor;
                Toast.makeText(MainActivity.this, "Wybrana ocena: " + ocena, Toast.LENGTH_SHORT).show();
                if(ocena < 3) {
                    kolor = Color.RED;
                    tekst.setText("słabo");
                }
                else if(ocena < 5) {
                    kolor = Color.GRAY;
                    tekst.setText("dobrze");
                }
                else {
                    kolor = Color.YELLOW;
                    tekst.setText("doskonale");
                }
                ratingBar.setProgressTintList(ColorStateList.valueOf(kolor));
            }
        });
    }
}