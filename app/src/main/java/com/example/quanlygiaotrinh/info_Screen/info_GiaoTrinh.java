package com.example.quanlygiaotrinh.info_Screen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.example.quanlygiaotrinh.Adapter.AdapterReCyInfo;
import com.example.quanlygiaotrinh.Database.Book;
import com.example.quanlygiaotrinh.Database.DBHelper;
import com.example.quanlygiaotrinh.MainActivity;
import com.example.quanlygiaotrinh.R;

import java.util.ArrayList;

public class info_GiaoTrinh extends AppCompatActivity {
    RecyclerView recyclerView;
    ImageView btnBack;
    DBHelper dbHelper;
    ArrayList<Book> listBook=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_giao_trinh);
        getId();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        AdapterReCyInfo adapterReCyInfo=new AdapterReCyInfo(listBook,this);
        recyclerView.setAdapter(adapterReCyInfo);
        btnBack.setOnClickListener(v -> {
            startActivity(new Intent(this, MainActivity.class));
            finish();
        }
        );
    }
    void getId(){
        dbHelper=MainActivity.dbHelper;
        Log.d("null", "getId: ");
        listBook=dbHelper.getBooksByStatus(2);
        recyclerView=findViewById(R.id.info_recyView);
        btnBack=findViewById(R.id.info_book_btn_arrowback);
    }
}