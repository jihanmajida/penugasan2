package com.example.penugasan.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.util.Log;

import com.example.penugasan.R;
import com.example.penugasan.room.AppDatabase;
import com.example.penugasan.room.Mahasiswa;

import java.util.ArrayList;
import java.util.List;

public class UserActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerViewUserAdapter recyclerAdapter;
    List<Mahasiswa> listMahasiswa = new ArrayList<>();
    private AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        recyclerView = findViewById(R.id.recycleView);
        fetchDataFromRoom();
        initRecyclerView();
        setAdapter();
    }

    private void fetchDataFromRoom() {
        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "mahasiswa").allowMainThreadQueries().build();
        listMahasiswa = db.userDao().getAll();

        //just checking data from db
        for (int i = 0; i <listMahasiswa.size(); i++) {
            Log.e("Aplikasi", listMahasiswa.get(i).getAlamat()+i);
            Log.e("Aplikasi", listMahasiswa.get(i).getKejuruan()+i);
            Log.e("Aplikasi", listMahasiswa.get(i).getNama()+i);
            Log.e("Aplikasi", listMahasiswa.get(i).getNim()+i);
        }
        Log.e("cek list", ""+listMahasiswa.size());
    }

    private void initRecyclerView() {
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);
        recyclerAdapter = new RecyclerViewUserAdapter(this,listMahasiswa);
    }

    private void setAdapter() {
        recyclerView.setAdapter(recyclerAdapter);
    }

}