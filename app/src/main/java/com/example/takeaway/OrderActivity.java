package com.example.takeaway;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.takeaway.Adapterss.OrdersAdapter;
import com.example.takeaway.Modelss.OrdersModel;
import com.example.takeaway.databinding.ActivityOrderBinding;

import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity {

    ActivityOrderBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityOrderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        DBOhelper helps=new DBOhelper(this);

        ArrayList<OrdersModel> list= helps.getOrders();




        OrdersAdapter adapter = new OrdersAdapter(list, this);
        binding.orderRecyclerview.setAdapter(adapter);

        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        binding.orderRecyclerview.setLayoutManager(layoutManager);
    }
}