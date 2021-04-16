package com.example.constraintlayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Deklarasi variabel untuk Button
    Button btnLogin;

    //Deklarasi variabel untuk Edittext
    EditText edmail, edpassword;

    //Deklarasi variabel untuk menyimpan email dan password
    String nama, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Menghubungkan variabel btnLogin dengan componen button pada layout
        btnLogin = findViewById(R.id.btSignin);

        //Menghubungkan variabel edemail dengan componen button pada Layout
        edmail = findViewById(R.id.edEmail);

        //Menghubungkan variabel edpassword dengan componen button pada Layout
        edpassword = findViewById(R.id.edPassword);

        //Membuat fungsi onclik pada button btnLogin
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Menyimpan input user di edittext email kedalam varibel nama
                nama = edmail.getText().toString();

                //Menyimpan input user di edittext password kedalam variabel password
                password = edpassword.getText().toString();

                //Membuat variabel toast dan membuat toast dengan menambahkan variabel nama dan password
                Toast t = Toast.makeText(getApplicationContext(),
                        "email anda: " + nama + " dan Password anda: " + password + "", Toast.LENGTH_LONG);

                String email = "admin@mail.com";
                String pass = "123456";

                if (nama.equals(email) && password.equals(pass)) {
                    t = Toast.makeText(getApplicationContext(),
                            "Login sukses", Toast.LENGTH_LONG);
                    t.show();

                    Bundle b = new Bundle();
                    b.putString("a", email.trim());
                    b.putString("b", password.trim());
                    Intent i = new Intent(getApplicationContext(), Home_Activity.class);
                    i.putExtras(b);
                    startActivity(i);

                } else if (!nama.equals(email) && password.equals(pass)) {
                    t = Toast.makeText(getApplicationContext(),
                            "Email salah", Toast.LENGTH_LONG);
                    t.show();
                } else if (nama.equals(email) && !password.equals(pass)) {
                    t = Toast.makeText(getApplicationContext(),
                            "password salah", Toast.LENGTH_LONG);
                    t.show();

                } else {
                    t = Toast.makeText(getApplicationContext(),
                            "Email dan Password salah", Toast.LENGTH_LONG);

                    t.show();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Method untuk menam[ilkan menu.
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //Membuat kondisi jika yang dipilih adalah id mnDaftar
        if (item.getItemId() == R.id.mnDaftar){
            //Method untuk memanggil activity "DaftarActivity"
            Intent i =new Intent(getApplicationContext(), FormPendaftaran.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }
}