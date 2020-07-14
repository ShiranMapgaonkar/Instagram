package com.example.instagram;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtlusername, edtlpw;
    private Button btnflogin, btngotosignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setTitle("Log in");

        edtlusername = findViewById(R.id.edtlusername);
        edtlpw = findViewById(R.id.edtlpw);
        btnflogin = findViewById(R.id.btnflogin);
        btngotosignup = findViewById(R.id.btngotosignup);

        btnflogin.setOnClickListener(this);
        btngotosignup.setOnClickListener(this);

        if (ParseUser.getCurrentUser() != null) {
            ParseUser.getCurrentUser().logOut();

        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnflogin:
                ParseUser.logInInBackground(edtlusername.getText().toString(),edtlpw.getText().toString(),
                new LogInCallback() {

                    @Override
                    public void done(ParseUser user, ParseException e) {

                        if (user != null && e == null) {
                            Toast.makeText(LoginActivity.this,"Logged in succesfully!",Toast.LENGTH_LONG).show();
                        }
                    }
                });




                break;
            case R.id.btngotosignup:
                break;

        }
    }
}