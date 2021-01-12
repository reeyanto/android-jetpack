package com.riyanto.androidjetpackviewmodel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private MainViewModel mainViewModel;
    private TextView label;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // init view bernama button dan label
        button = findViewById(R.id.button);
        label  = findViewById(R.id.label);

        // instansiasi kelas MainViewModel
        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);

        // dengarkan setiap perubahan data dari MainViewModel yang dikirim lewat paramater 's'
        mainViewModel.getNama().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                label.setText(s);
            }
        });

        // saat button diklik, ubah data pada MainViewModel (jalankan method setNama())
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainViewModel.setNama();
            }
        });
    }
}