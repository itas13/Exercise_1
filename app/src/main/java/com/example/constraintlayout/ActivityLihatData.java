package com.example.constraintlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ActivityLihatData extends AppCompatActivity {
    //Deklarasi variabel dengan jenis data TextView
    TextView tvnama, tvnomor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_data);

        tvnama = findViewById(R.id.tvNamaKontak);
        tvnomor = findViewById(R.id.tvNomorTelepon);
        Bundle bundle = getIntent().getExtras();

        String nama = bundle.getString("a");
        switch (nama)
        {
            case "Inayah":
                tvnama.setText("Inayah M");
                tvnomor.setText("082187483247");
                break;
            case "Ilham":
                tvnama.setText("Ilham R");
                tvnomor.setText("082131214243");
                break;
            case "Eris":
                tvnama.setText("Eris J");
                tvnomor.setText("081231342355");
                break;
            case "Fikri":
                tvnama.setText("M Fikri");
                tvnomor.setText("083124565767");
                break;
            case "Maul":
                tvnama.setText("Maul M");
                tvnomor.setText("082214325346");
                break;
            case "Intan":
                tvnama.setText("Intan S");
                tvnomor.setText("082143242355");
                break;
            case "Vina":
                tvnama.setText("Vina R");
                tvnomor.setText("0821874322556");
                break;
            case "Gita":
                tvnama.setText("Gita S");
                tvnomor.setText("0835253463654");
                break;
            case "Lutfi":
                tvnama.setText("Lutfi M");
                tvnomor.setText("0822525436757");
                break;
            case "Vian":
                tvnama.setText("Vian M");
                tvnomor.setText("0821252534656");
                break;
        }

    }
}