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

public class DetailJarakActivity extends AppCompatActivity {
    Spinner spJarak;
    EditText edInputJarak;
    TextView txtHasilJarak;
    Button tbHitung;
    float hasilConversi = 0;
    int posConversi = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_jarak);
        edInputJarak = findViewById(R.id.edInputJarak);
        txtHasilJarak = findViewById(R.id.txtHasilJarak);
        tbHitung = findViewById(R.id.tbHitung);
        spJarak = findViewById(R.id.spJarak);
        String[] dataMasa = new  String[]{"kilometer to meter", "meter to kilometer", "meter to centimeter", "centimeter to meter"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, dataMasa);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spJarak.setAdapter(adapter);

        spJarak.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
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
                    hasilConversi = (float)(Integer.parseInt(edInputJarak.getText().toString())* 1000); // KG TO GR
                    txtHasilJarak.setText("" + hasilConversi);
                }else if (posConversi==1){
                    hasilConversi = (float)(Integer.parseInt(edInputJarak.getText().toString())/ 1000) ; //GR TO KG
                    txtHasilJarak.setText("" + hasilConversi);
                }else if (posConversi==2){
                    hasilConversi = (float)(Integer.parseInt(edInputJarak.getText().toString())* 1000 ) ; // KG TO TON
                    txtHasilJarak.setText("" + hasilConversi);
                }else if (posConversi==3){
                    hasilConversi = (float)(Integer.parseInt(edInputJarak.getText().toString())/ 1000) ; // TON TO KG
                    txtHasilJarak.setText("" + hasilConversi);
                } else {
                    txtHasilJarak.setText("Input Suhu Tidak boleh kosong");
                }
            }
        });
    }
}