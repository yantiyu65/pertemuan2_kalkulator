package com.example.pertemuan2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    CardView cdTemp, cdMasa, cdLuas, cdJarak;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cdTemp = findViewById(R.id.cdTemp);
        cdMasa = findViewById(R.id.cdMasa);
        cdLuas = findViewById(R.id.cdLuas);
        cdJarak = findViewById(R.id.cdJarak);
        cdTemp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, DetailSuhuActivity.class));
            }
        });
        cdMasa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, DetailMasaActivity.class));
            }
        });
        cdLuas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, DetailLuasActivity.class));
            }
        });
        cdJarak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, DetailJarakActivity.class));
            }
        });
    }
}