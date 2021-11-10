package com.example.wheelsup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class List_Vehicle extends AppCompatActivity {
    ListView listView;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list__vehicle);
        listView= findViewById(R.id.listview_vehicle);

        ArrayList<Personv> arrayList=new ArrayList<>();
        arrayList.add(new Personv(R.drawable.v1,"Force Traveller","Maximum 13 sitter"));
        arrayList.add(new Personv(R.drawable.v2,"Tata Ace Ex","Payload Capacity:750kg"));
        arrayList.add(new Personv(R.drawable.v3,"Maruti Suzuki Super Carry","Payload Capacity:1Ton"));
        arrayList.add(new Personv(R.drawable.v4,"Tata Truck","Payload Capacity:5Ton"));
        arrayList.add(new Personv(R.drawable.v5,"Tata Truck(6 Wheels)","Payload Capacity: 9Ton"));
        arrayList.add(new Personv(R.drawable.v6,"Eicher Tempo","Payload Capacity:6Ton"));

        PersonAdapterV personAdapterV=new PersonAdapterV(this,R.layout.list_vehiclerow,arrayList);

        listView.setAdapter(personAdapterV);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position ==0){
                    Intent intent= new Intent(view.getContext(),Descriptionv1.class);
                    startActivity(intent);
                }
                if (position ==1){
                    Intent intent= new Intent(view.getContext(),Descriptionv2.class);
                    startActivity(intent);
                }
                if (position ==2){
                    Intent intent= new Intent(view.getContext(),Descriptionv3.class);
                    startActivity(intent);
                }
                if (position ==3){
                    Intent intent= new Intent(view.getContext(),Descriptionv4.class);
                    startActivity(intent);
                }
                if (position ==4){
                    Intent intent= new Intent(view.getContext(),Descriptionv5.class);
                    startActivity(intent);
                }
                if (position ==5){
                    Intent intent= new Intent(view.getContext(),Descriptionv6.class);
                    startActivity(intent);
                }
            }
        });
    }
}