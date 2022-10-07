package com.example.mydropdown;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    String[] penyulangs = {"Amandari","Blahbatuh","Buahan","Campuan","Candra Asri","Cangi","Exp Istana",
                            "Hanoman","Kalantaka","Kedisan","Kelabang Muding","Kesatrian","Manikan","Mas",
                            "Monkey Forest","Nandini","Nyuh Kuning","Payogan","Petanu","Petulu","Saba",
                            "Sidan","Tampak Siring","Taro","Tiga Nusa","Ubud","Wanayu","Wibrata"};

    AutoCompleteTextView textViewPenyulang;
    ArrayAdapter<String> adapterPenyulang;

    TextInputLayout layoutSection, layoutPenyulang;
    EditText editTextSection;
    Button buttonTest;
    String section, penyulang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layoutSection       = findViewById(R.id.layoutSection);
        layoutPenyulang     = findViewById(R.id.layoutPenyulang);
        editTextSection     = findViewById(R.id.etSection);
        buttonTest          = findViewById(R.id.btnTest);
        textViewPenyulang   = findViewById(R.id.dropdownPenyulang);
        adapterPenyulang    = new ArrayAdapter<String>(this,R.layout.list_item_penyulang,penyulangs);
        textViewPenyulang.setAdapter(adapterPenyulang);

        textViewPenyulang.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                penyulang    = adapterView.getItemAtPosition(i).toString();
            }
        });

        buttonTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isValid = true;

                if (editTextSection.getText().toString().isEmpty()){
                    layoutSection.setError("Section Tidak Boleh Kosong");
                    isValid = false;
                }else {
                    layoutSection.setErrorEnabled(false);
                    section = editTextSection.getText().toString();

                }

                if (textViewPenyulang.getText().toString().isEmpty()){
                    layoutPenyulang.setError("Silahkan Pilih Penyulang");
                }else {
                    layoutPenyulang.setErrorEnabled(false);
                }

//                section = editTextSection.getText().toString();
//                Toast.makeText(MainActivity.this, "Penyulang : " + penyulang + section, Toast.LENGTH_SHORT).show();


                if (isValid){
                    Toast.makeText(MainActivity.this, "Penyulang : " + penyulang + ", Section : " + section, Toast.LENGTH_SHORT).show();
                }

            }
        });



    }
}