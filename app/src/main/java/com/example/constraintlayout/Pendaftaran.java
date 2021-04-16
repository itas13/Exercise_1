package com.example.constraintlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.constraintlayout.R;
import com.google.android.material.snackbar.Snackbar;

public class Pendaftaran extends AppCompatActivity {

    EditText name, email, pass, repass, alamat;
    Button btndaf, btnbatal;
    CheckBox jeniskelamin, agama;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pendaftaran);

        name = findViewById(R.id.rNama);
        email = findViewById(R.id.remail);
        pass = findViewById(R.id.rpass);
        repass = findViewById(R.id.repass);
        alamat = findViewById(R.id.ralamat);
        btndaf = findViewById(R.id.rbtndaftar);
        btnbatal = findViewById(R.id.rbtnbatal);

        btnbatal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });

        btndaf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name.getText().toString().isEmpty() ||
                        email.getText().toString().isEmpty() ||
                        alamat.getText().toString().isEmpty() ||
                        pass.getText().toString().isEmpty() ||
                        repass.getText().toString().isEmpty())
                {
                    name.setError("Masukkan Nama");
                    email.setError("Masukkan Email");
                    alamat.setError("Masukkan Alamat");
                    pass.setError("Masukkan Password");
                    repass.setError("Masukkan Re-Password");

                } else {
                    if (pass.getText().toString().equals(repass.getText().toString())) {
                        Toast.makeText(getApplicationContext(), "registration is successful",
                                Toast.LENGTH_LONG).show();
                        Intent i = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(i);
                    } else {
                        Snackbar.make(v, "password and repassword must be same",
                                Snackbar.LENGTH_LONG).show();
                    }
                }
            }
        });

    }
}