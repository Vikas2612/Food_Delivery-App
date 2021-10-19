package com.example.takeaway;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Resetacivity extends AppCompatActivity {

    EditText pass,repass;
    TextView  username;
    Button confirm;
    DBhelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resetacivity);
        pass=findViewById(R.id.passwordrsettext);
        repass=findViewById(R.id.enterpasswordresettext);
        username=findViewById(R.id.username_reset_text);
        confirm=findViewById(R.id.btnconfirm);
        DB=new DBhelper(this);

        Intent intent=getIntent();
        username.setText(intent.getStringExtra("username"));

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user= username.getText().toString();
                String password=pass.getText().toString();
                String repassword=repass.getText().toString();
                if(password.equals(repassword))
                {

                Boolean checkpasswordupdate=DB.updatepassword(user,password);
                if(checkpasswordupdate==true)
                {
                    Intent intent=new Intent(getApplicationContext(),Login.class);
                    startActivity(intent);
                    Toast.makeText(Resetacivity.this, "Password Updated Successfully", Toast.LENGTH_SHORT).show();
                }

                else
                {
                    Toast.makeText(Resetacivity.this, "Password Not updated", Toast.LENGTH_SHORT).show();
                }
                }

                else
                {
                    Toast.makeText(Resetacivity.this, "Password Does not Match", Toast.LENGTH_SHORT).show();
                }
            }
        });



    }
}