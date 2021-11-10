package com.example.wheelsup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.util.ObjectsCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ListCar extends AppCompatActivity {

    ListView listview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_car);

        listview=findViewById(R.id.listView);

        ArrayList<Person> arrayList=new ArrayList<>();
        arrayList.add(new Person(R.drawable.c1,"Maruti Suzuki Ertiga","Maximum 8 Sitter"));
        arrayList.add(new Person(R.drawable.c2,"Maruti Suzuki Swift","Maximum 5 Sitter"));
        arrayList.add(new Person(R.drawable.c3,"Mahendra Bolero","Maximum 9 Sitter"));
        arrayList.add(new Person(R.drawable.c4,"Mahendra Scorpio","Maximum 7 Sitter"));
        arrayList.add(new Person(R.drawable.c5,"Maruti Suzuki Wagon R","Maximum 5 Sitter"));
        arrayList.add(new Person(R.drawable.c6,"Toyota Inova","Maximum 8 Sitter"));

        PersonAdapter personAdapter=new PersonAdapter(this,R.layout.list_carrow,arrayList);

        listview.setAdapter(personAdapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position ==0){
                    Intent intent= new Intent(view.getContext(),Description1.class);
                    startActivity(intent);
                }
                if (position ==1){
                    Intent intent= new Intent(view.getContext(),Description2.class);
                    startActivity(intent);
                }
                if (position ==2){
                    Intent intent= new Intent(view.getContext(),Description3.class);
                    startActivity(intent);
                }
                if (position ==3){
                    Intent intent= new Intent(view.getContext(),Description4.class);
                    startActivity(intent);
                }
                if (position ==4){
                    Intent intent= new Intent(view.getContext(),Description5.class);
                    startActivity(intent);
                }
                if (position ==5){
                    Intent intent= new Intent(view.getContext(),Description6.class);
                    startActivity(intent);
                }
            }
        });


    }
}