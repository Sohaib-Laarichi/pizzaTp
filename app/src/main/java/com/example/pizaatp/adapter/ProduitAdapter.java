package com.example.pizaatp.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pizaatp.R;
import com.example.pizaatp.classes.Produit;

import java.util.List;

public class ProduitAdapter extends ArrayAdapter<Produit> {


    public ProduitAdapter(Context context, List<Produit> produits) {
        super(context, 0, produits);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item, parent, false);
        }

        Produit produit = getItem(position);


        ImageView pizzaImage = convertView.findViewById(R.id.pizzaImage);
        TextView pizzaName = convertView.findViewById(R.id.pizzaName);
        TextView pizzaRating = convertView.findViewById(R.id.pizzaRating);
        TextView pizzaTime = convertView.findViewById(R.id.pizzaTime);


        pizzaImage.setImageResource(produit.getPhoto());
        pizzaName.setText(produit.getNom());
        pizzaRating.setText(String.valueOf(produit.getNbrlngredient()));
        pizzaTime.setText(produit.getDuree());

        return convertView;
    }
}

