package com.example.pertemuan2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class DetailSuhuActivity extends AppCompatActivity {
    Spinner spSuhu;
    EditText edInputSuhu;
    TextView txtHasilSuhu;
    Button tbHitung;
    float hasilConversi = 0;
    int posConversi = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_suhu);

        // Deklarasi Komponen
        edInputSuhu = findViewById(R.id.edInputSuhu);
        txtHasilSuhu = findViewById(R.id.txtHasilSuhu);
        spSuhu = findViewById(R.id.spSuhu);
        tbHitung = findViewById(R.id.tbHitung);
        /* Data Array
        0 = Cel to Re, rumus 4/5 * Cel
        1 = Cel to Far, rumus (9/5 x Cel) + 32;
         */

        String[] dataSuhu = new  String[]{"Cel to Re", "Cel to Far", "Re to Cel", "Re to Far"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, dataSuhu);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spSuhu.setAdapter(adapter);

        spSuhu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
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
                    hasilConversi = (float)(Integer.parseInt(edInputSuhu.getText().toString())*4)/5; //ce to re
                    txtHasilSuhu.setText("" + hasilConversi);
                }else if (posConversi==1){
                    hasilConversi = (float)(Integer.parseInt(edInputSuhu.getText().toString())*9/5) + 32; //ce to fa
                    txtHasilSuhu.setText("" + hasilConversi);
                }else if (posConversi==2){
                    hasilConversi = (float)(Integer.parseInt(edInputSuhu.getText().toString())* 5) / 4 ; //re to ce
                    txtHasilSuhu.setText("" + hasilConversi);
                }else if (posConversi==3){
                    hasilConversi = (float)(Integer.parseInt(edInputSuhu.getText().toString())*9/4) + 32; // re to fa
                    txtHasilSuhu.setText("" + hasilConversi);
                } else {
                    txtHasilSuhu.setText("Input Suhu Tidak boleh kosong");
                }
            }
        });
    }
}