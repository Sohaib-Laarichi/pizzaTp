package com.example.pizaatp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.pizaatp.classes.Produit;

public class PizzaDetailActivity extends AppCompatActivity {
    private Produit selectedPizza;
    private static final String COMPANY_NAME = "Pizza Recipes";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detaill_pizza_activity);

        // Setup Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // Enable back button

        selectedPizza = (Produit) getIntent().getSerializableExtra("produit");

        if (selectedPizza != null) {
            getSupportActionBar().setTitle(selectedPizza.getNom());
            ((ImageView) findViewById(R.id.pizzaImage)).setImageResource(selectedPizza.getPhoto());
            ((TextView) findViewById(R.id.pizzaName)).setText(selectedPizza.getNom());
            ((TextView) findViewById(R.id.pizzaTime)).setText("Time: " + selectedPizza.getDuree());
            ((TextView) findViewById(R.id.pizzaIngredients)).setText("Ingredients:\n" + selectedPizza.getDetaislngred());
            ((TextView) findViewById(R.id.pizzaDescription)).setText("Description:\n" + selectedPizza.getDescription());
            ((TextView) findViewById(R.id.pizzaSteps)).setText("Steps:\n" + selectedPizza.getPreparation());
        } else {
            getSupportActionBar().setTitle("Pizza Details");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.layout.menu_top, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_share) {
            sharePizzaRecipe();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void sharePizzaRecipe() {
        String message;
        if (selectedPizza != null) {
            message = "Check out this delicious pizza: " + selectedPizza.getNom() + " from " + COMPANY_NAME + " !!!!!";
        } else {
            message = "Check out this delicious pizza from " + COMPANY_NAME + "!";
        }
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, message);
        startActivity(Intent.createChooser(intent, "Share via"));
    }
}