package com.example.takeaway;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Forgotpass extends AppCompatActivity {

    EditText username;
    Button reset;
    DBhelper DB;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotpass);

        username=findViewById(R.id.userreset);
        reset=findViewById(R.id.btnreset);

        DB=new DBhelper(this);

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user=username.getText().toString();
                Boolean checkuser= DB.checkusername(user);

                if (checkuser==true)
                {
                    Intent intent=new Intent(getApplicationContext(),Resetacivity.class);
                    intent.putExtra("username",user);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(Forgotpass.this, "The User does not Exist", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}