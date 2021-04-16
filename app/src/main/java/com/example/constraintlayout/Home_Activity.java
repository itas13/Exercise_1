package com.example.constraintlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

import java.util.ArrayList;

public class Home_Activity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {
    //Deklarasi variable dengan jenis data listview
    private ListView list;

    //Memanggil class listviewAdapter dan diinisiasi menjadi variable adapter
    private ListViewAdapter adapter;

    //Deklarasi array untuk menyimpan nama
    String[] listNama;

    //Memanggil class cmassNama
    public static ArrayList<ClassNama> classNamaArrayList = new ArrayList<ClassNama>();

    //Membuat objek Bundle
    Bundle bundle = new Bundle();

    //Membuat objek intent
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_);

        //Menyimpan nama didalam array listNama
        listNama = new String[]{"Inayah", "Ilham", "Eris",
                "Fikri", "Maul", "Intan", "Vina", "Gita",
                "Vian", "Lutfi"};
        list = findViewById(R.id.Listkontak);

        //membuat objek dari class ClassNama menjadi arraylist
        classNamaArrayList = new ArrayList<>();

        //Membaca seluruh data pada array listNama
        for (int i = 0; i < listNama.length; i++)
        {
            //Membuat objek class nama
            ClassNama classNama = new ClassNama(listNama[i]);
            //Binds string ke array
            classNamaArrayList.add(classNama);
        }

        //membuat objek dari listviewadapter
        adapter = new ListViewAdapter( this);

        //Binds adapter ke listview
        list.setAdapter(adapter);

        //membuat event dari list onclick
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //Deklarasi variable nama yang berisi item yang di klik
                String nama = classNamaArrayList.get(position).getNama();

                //memasukan value dari variabel nama dengan kunci "a"
                //dan dimasukkan kedalam bundle
                bundle.putString("a", nama.trim());

                //membuat objek popup menu
                PopupMenu pm = new PopupMenu(getApplicationContext(), view);

                //membuat event untuk popup menu ketika dipilih
                pm.setOnMenuItemClickListener(Home_Activity.this);

                //menampilkan popup menu dari layout menu
                pm.inflate(R.menu.popup_menu);

                //menampilkan popup menu
                pm.show();
            }
        });
    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem){
        switch (menuItem.getItemId())
        {
            case R.id.mnview:
                intent = new Intent(getApplicationContext(),ActivityLihatData.class);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.mnedit:
                Toast.makeText(getApplicationContext(), "Ini untuk edit kontak",
                        Toast.LENGTH_LONG).show();
                break;
        }
        return false;
    }
}