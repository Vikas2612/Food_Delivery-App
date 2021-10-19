package com.example.takeaway;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.takeaway.databinding.ActivityDetailBinding;

public class DetailActivity extends AppCompatActivity {


    ActivityDetailBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        DBOhelper helps = new DBOhelper(this);

        if(getIntent().getIntExtra("type",0)==1) {


            final int image = getIntent().getIntExtra("image", 0);
            final int price = Integer.parseInt(getIntent().getStringExtra("price"));
            final String name = getIntent().getStringExtra("name");
            final String description = getIntent().getStringExtra("desc");

            binding.detailimage.setImageResource(image);
            binding.pricelbl.setText(String.format("%d", price));
            binding.namebox.setText(name);
            binding.detaildescription.setText(description);



            binding.insertbutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    boolean isInsert = helps.insertOrder(
                            binding.namebox2.getText().toString(),
                            binding.phonebox.getText().toString(),
                            binding.addressdelivery.getText().toString(),
                            price,
                            image,
                            Integer.parseInt(binding.quantity.getText().toString()),
                            description,
                            name

                    );

                    if (isInsert) {
                        Toast.makeText(DetailActivity.this, "Thank you for placing order, You will receive your order within 30 minutw", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(DetailActivity.this, "Error", Toast.LENGTH_SHORT).show();
                    }

                }
            });
        }
        else{
            int id=getIntent().getIntExtra("id",0);
            Cursor cursor =helps.getOrderById(id);
            final int image=cursor.getInt(5);
            binding.detailimage.setImageResource(image);
            binding.pricelbl.setText(String.format("%d", cursor.getInt(4)));
            binding.namebox.setText(cursor.getString(8));
            binding.detaildescription.setText(cursor.getString(7));

            binding.namebox2.setText(cursor.getString(1));
            binding.phonebox.setText(cursor.getString(2));
            binding.addressdelivery.setText(cursor.getString(3));
            binding.insertbutton.setText("Update Now");
            binding.insertbutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                 boolean isUpdated=   helps.updateOrder(
                            binding.namebox2.getText().toString(),
                            binding.phonebox.getText().toString(),
                            binding.addressdelivery.getText().toString(),
                            Integer.parseInt(binding.pricelbl.getText().toString()),
                            image,
                            1,
                            binding.detaildescription.getText().toString(),
                            binding.namebox.getText().toString(),
                            id
                    );
                 if(isUpdated)
                 {
                     Toast.makeText(DetailActivity.this, "Updated", Toast.LENGTH_SHORT).show();
                 }
                 else
                 {
                     Toast.makeText(DetailActivity.this, "Fail to update", Toast.LENGTH_SHORT).show();
                 }
                }
            });

        }


    }
}