package com.example.wheelsup;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class PersonAdapterV extends ArrayAdapter<Personv> {
    private Context mContextv;
    private int mResourcev;

    public PersonAdapterV(@NonNull  Context context, int resource, @NonNull ArrayList<Personv> objects) {
        super(context, resource, objects);
        this.mContextv=context;
        this.mResourcev=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater=LayoutInflater.from(mContextv);

        convertView=layoutInflater.inflate(mResourcev,parent,false);

        ImageView imageViewv=convertView.findViewById(R.id.imagev);

        TextView txtNamev=convertView.findViewById(R.id.txtnamev);

        TextView txtDesv=convertView.findViewById(R.id.txtDesv);

        imageViewv.setImageResource(getItem(position).getImagev());

        txtNamev.setText(getItem(position).getNamev());

        txtDesv.setText(getItem(position).getDesv());

        return convertView;
    }
}
