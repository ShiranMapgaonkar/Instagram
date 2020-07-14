package com.example.instagram;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;



public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtsemail, edtsusername, edtspw;
    private Button btnsignup, btnlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Instagram");

        edtsemail = findViewById(R.id.edtsemail);
        edtspw = findViewById(R.id.edtspw);
        edtsusername = findViewById(R.id.edtsusername);
        btnsignup = findViewById(R.id.btnsignup);
        btnlogin = findViewById(R.id.btnflogin);

        btnsignup.setOnClickListener(MainActivity.this);
        btnlogin.setOnClickListener(MainActivity.this);

        if(ParseUser.getCurrentUser() != null) {
            ParseUser.getCurrentUser().logOut();
        }

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnsignup:

                if (edtsemail.getText().toString().equals("") ||
                        edtsusername.getText().toString().equals("") ||
                        edtspw.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this,"Email,Username,Password is required",Toast.LENGTH_LONG).show();
                } else {

                final ParseUser appUser = new ParseUser();
                appUser.setEmail(edtsemail.getText().toString());
                appUser.setUsername(edtsusername.getText().toString());
                appUser.setPassword(edtspw.getText().toString());

                final ProgressDialog progressDialog = new ProgressDialog(this);
                progressDialog.setMessage("Signing up" + edtsusername.getText().toString());
                progressDialog.show();
                appUser.signUpInBackground(new SignUpCallback() {
                    @Override
                    public void done(ParseException e) {
                        if (e == null) {
                            Toast.makeText(MainActivity.this,"Signed up succesfully",Toast.LENGTH_LONG).show();

                        } else {
                            Toast.makeText(MainActivity.this,e.getMessage(),Toast.LENGTH_LONG).show();
                        }
                        progressDialog.dismiss();
                    }
                });
                }
                break;

            case R.id.btnflogin:

                Intent intent = new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent);
                break;
        }

    }
}