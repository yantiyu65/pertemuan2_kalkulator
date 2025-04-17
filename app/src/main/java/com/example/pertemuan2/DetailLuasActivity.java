package com.example.pertemuan2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class DetailLuasActivity extends AppCompatActivity {
    Spinner spLuas;
    EditText edInputLuas;
    TextView txtHasilLuas;
    Button tbHitung;
    float hasilConversi = 0;
    int posConversi = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_luas);
        edInputLuas = findViewById(R.id.edInputLuas);
        txtHasilLuas = findViewById(R.id.txtHasilLuas);
        tbHitung = findViewById(R.id.tbHitung);
        spLuas = findViewById(R.id.spLuas);
        String[] dataMasa = new  String[]{"meter to centimeter", "centimeter to meter", "hectar to meter", "meter to hectar"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, dataMasa);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spLuas.setAdapter(adapter);

        spLuas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id){
                posConversi = position;
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent){

            }
        });
        tbHitung.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                if (posConversi==0){
                    hasilConversi = (float)(Integer.parseInt(edInputLuas.getText().toString())* 1000); // KG TO GR
                    txtHasilLuas.setText("" + hasilConversi);
                }else if (posConversi==1){
                    hasilConversi = (float)(Integer.parseInt(edInputLuas.getText().toString())/ 1000) ; //GR TO KG
                    txtHasilLuas.setText("" + hasilConversi);
                }else if (posConversi==2){
                    hasilConversi = (float)(Integer.parseInt(edInputLuas.getText().toString())* 1000 ) ; // KG TO TON
                    txtHasilLuas.setText("" + hasilConversi);
                }else if (posConversi==3){
                    hasilConversi = (float)(Integer.parseInt(edInputLuas.getText().toString())/ 1000) ; // TON TO KG
                    txtHasilLuas.setText("" + hasilConversi);
                } else {
                    txtHasilLuas.setText("Input Suhu Tidak boleh kosong");
                }
            }
        });
    }
}