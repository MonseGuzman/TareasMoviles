package com.monse.andrea.practica7;

import android.database.Cursor;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    private ListView listaListView;

    ArrayList<tablita> list = new ArrayList<>();
    tablita tab;
    listviewAdapter adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializar();

        content();
    }

    private void inicializar()
    {
        listaListView = (ListView)findViewById(R.id.listaListView);
    }

    private void content()
    {
        Cursor cursor = getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, null, null, null, MediaStore.Images.Media.DEFAULT_SORT_ORDER);

        cursor.moveToFirst();
        while(cursor.moveToNext())
        {
            Log.d("lo intento", " - _ID : " + cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media._ID)));
            Log.d("lo intento", " - File Name : " + cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DISPLAY_NAME)));
            Log.d("lo intento", " - File Path : " + cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA)));

            tab = new tablita(cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media._ID)),
                    cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DISPLAY_NAME)),
                    cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA))
            );

            list.add(tab);
        }

        cursor.close();

        adaptador = new listviewAdapter(this, list);
        listaListView.setAdapter(adaptador);
    }
}
