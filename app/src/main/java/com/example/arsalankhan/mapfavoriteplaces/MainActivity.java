package com.example.arsalankhan.mapfavoriteplaces;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<String> placesArraylist = new ArrayList<>();
    public static ArrayList<LatLng> locationArraylist = new ArrayList<>();
    public static ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.listview);
        placesArraylist.add("Add Your Favorite Place");
        locationArraylist.add(new LatLng(0,0));

        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,placesArraylist);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(getApplicationContext(),MapsActivity.class);
                intent.putExtra("index",i);
                startActivity(intent);
            }
        });


    }
}
