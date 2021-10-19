package com.example.takeaway;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.TextView;

public class Login extends AppCompatActivity {
    Button callsignup,login,forgot;
    EditText userlogin,passwordlogin;
    DBhelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        callsignup=findViewById(R.id.regbtn);
        login=findViewById(R.id.loginaccount);
        userlogin=findViewById(R.id.loginuser);
        passwordlogin=findViewById(R.id.loginpassword);
        forgot=findViewById(R.id.passwordforgot);

        DB=new DBhelper(this);


        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Login.this,Forgotpass.class);
                startActivity(intent);
                finish();
            }
        });

        callsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Login.this,SigningUp.class);
                startActivity(intent);
                finish();
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user=userlogin.getText().toString();
                String pass=passwordlogin.getText().toString();

                if(user.equals("") || pass.equals(""))
                {
                    Toast.makeText(Login.this, "Please Enter All the fields", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Boolean checkuserpass =DB.checkusernamepassword(user,pass);
                    if(checkuserpass==true)
                    {
                        Toast.makeText(Login.this, "Sign In Successfully", Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(getApplicationContext(),Activitymainh.class);
                        startActivity(intent);
                        finish();
                    }
                    else
                    {
                        Toast.makeText(Login.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
}