package com.example.foodnow;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.foodnow.controller.FoodItemFactory;
import com.example.foodnow.model.Item;
import com.example.foodnow.model.OptionGroup;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final Context context = this;
        super.onCreate(savedInstanceState);

        //TODO: Shit's borked. Sorry guys.
//        Item pizza = new Item();
//        pizza.setEverything("1", "Pizza");
//
//        OptionGroup toppings = new OptionGroup();
//        toppings.setEverything("2", "Toppings", 0, 0);
//
//        pizza.addChild(toppings);
//        Item orderedItem = FoodItemFactory.buildFoodItem(pizza);
//        Log.d("ITEM", orderedItem.getName());
//        Log.d("GROUP", orderedItem.getChildren().get(0).getName());

        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        APIWrapper BOOM = new APIWrapper();
        BOOM.doAPICALL();

        final TextView confirmationText = (TextView) findViewById(R.id.confirmText);
        final Button newOrderButton = (Button) findViewById(R.id.newOrderButton);
        newOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmationText.setVisibility(View.INVISIBLE);
                newOrderButton.setVisibility(View.INVISIBLE);
            }
        });

        Button orderButton = (Button) findViewById(R.id.orderButton);
        orderButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                confirmationText.setVisibility(View.VISIBLE);
                newOrderButton.setVisibility(View.VISIBLE);
            }
        });

        FloatingActionButton infoButton = (FloatingActionButton) findViewById(R.id.infoButton);
        infoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String orderedItemDetails = "Item: Pizza\nOptions: Pepperoni, Bacon, Sausage\nCost: $14.38";
                new AlertDialog.Builder(context)
                        .setTitle("Ordered Item")
                        .setMessage(orderedItemDetails)
                        .setNeutralButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        })
                        .setIcon(android.R.drawable.ic_menu_info_details)
                        .show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
