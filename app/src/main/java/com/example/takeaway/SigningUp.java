package com.example.takeaway;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



public class SigningUp extends AppCompatActivity {

    EditText reguser,password,repassword;
    Button regbtn,backlogin;
    DBhelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signing_up);


        reguser=findViewById(R.id.usernamesignup);
        password=findViewById(R.id.signuppassword);
        repassword=findViewById(R.id.resignuppassword);
        regbtn=findViewById(R.id.register);
        backlogin=findViewById(R.id.loginback);
        DB=new DBhelper(this);


        backlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Login.class);
                startActivity(intent);
                finish();
            }
        });

        regbtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String user=reguser.getText().toString();
                String pass=password.getText().toString();
                String repass=repassword.getText().toString();

                //here gettext should be there but we hqave used TextLAyout instead of TextView , thats why we are using getTransitiomn
                if(user.equals("") || pass.equals("") || repass.equals(""))
                {
                    Toast.makeText(SigningUp.this, "Please Enter All the fields", Toast.LENGTH_SHORT).show();
                }

                else
                {
                    if(pass.equals(repass))
                    {
                        Boolean checkuser=DB.checkusername(user);
                        if(checkuser==false)
                        {
                            Boolean insert = DB.insertData(user,pass);
                            if(insert==true)
                            {
                                Toast.makeText(SigningUp.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                                Intent intent=new Intent(getApplicationContext(),Login.class);
                                startActivity(intent);
                                finish();
                            }
                        }
                        else
                        {
                            Toast.makeText(SigningUp.this, "User Already Exists", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else
                    {
                        Toast.makeText(SigningUp.this, "Passwords are not Matching", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });



    }
}