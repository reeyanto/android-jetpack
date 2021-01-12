package com.riyanto.androidjetpackviewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    // tempat menyimpan data, diberi nama 'nama'
    private MutableLiveData<String> nama;

    // fungsi getter untuk mendapatkan nama
    public MutableLiveData<String> getNama() {
        if (nama == null) {
            nama = new MutableLiveData<>();
        }
        return nama;
    }

    // fungsi setter untuk men-set nama / data baru ke variabel 'nama'
    public void setNama() {
        nama.postValue("Hello, Riyanto!");
    }
}
