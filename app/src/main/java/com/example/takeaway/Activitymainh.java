package com.example.takeaway;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;


import com.example.takeaway.Adapterss.Activitymainadapter;
import com.example.takeaway.Modelss.Activitymainmodel;
import com.example.takeaway.databinding.ActivityActivitymainhBinding;


import java.util.ArrayList;

public class Activitymainh extends AppCompatActivity {

   ActivityActivitymainhBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        binding = ActivityActivitymainhBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<Activitymainmodel> list = new ArrayList<>();

        list.add(new Activitymainmodel(R.drawable.aloodum, "Aloo Dum", "85", "Masaledaar"));
        list.add(new Activitymainmodel(R.drawable.littichokha, "Litti Chokha", "90", "The Ultimate Swaad"));
        list.add(new Activitymainmodel(R.drawable.paneer, "Paneer Butter Masala", "130", "Tasty and Delicious"));
        list.add(new Activitymainmodel(R.drawable.vadapav, "Vadapav", "45", "The best street food"));
        list.add(new Activitymainmodel(R.drawable.lassi, "Lassi", "30", "Sweet and Healthy"));
        list.add(new Activitymainmodel(R.drawable.butterchicken, "Butter Chicken", "140", "Royal Chicken"));
        list.add(new Activitymainmodel(R.drawable.dalmakhni, "Dal Makhni", "75", "Tasty and Healthy"));
        list.add(new Activitymainmodel(R.drawable.friedrice, "Fried rice", "40", "Delicious"));
        list.add(new Activitymainmodel(R.drawable.friedfish, "Fried fish", "95", "Spicy"));
        list.add(new Activitymainmodel(R.drawable.chole, "Chole Bhature", "85", "Spicy"));

       Activitymainadapter adapter = new Activitymainadapter(list,this);
       binding.recyclerview.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.recyclerview.setLayoutManager(layoutManager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.orderss:
                startActivity(new Intent(Activitymainh.this,OrderActivity.class));
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(Activitymainh.this)
                .setTitle("Exit")
                .setIcon(R.drawable.warning)
                .setMessage("Are You sure you want to exit")
                .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        }).show();
    }
}