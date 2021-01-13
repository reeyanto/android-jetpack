package com.riyanto.androidjetpackviewmodel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.riyanto.androidjetpackviewmodel.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding activityMainBinding;
    private MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = activityMainBinding.getRoot();
        setContentView(view);

        // instansiasi kelas MainViewModel
        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);

        // dengarkan setiap perubahan data dari MainViewModel yang dikirim lewat paramater 's'
        mainViewModel.getNama().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                activityMainBinding.label.setText(s);
            }
        });

        // saat button diklik, ubah data pada MainViewModel (jalankan method setNama())
        activityMainBinding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainViewModel.setNama();
            }
        });
    }
}