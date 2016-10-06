package com.example.amit.order;



import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int quantity = 2;

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }


    //This is called when the plus button is hit
    public void increment(View view) {

        quantity++;
        display(quantity);
    }

    public void decrement(View view) {
        quantity--;
        display(quantity);
    }


    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);

        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));

    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        if (quantity < 0) {
            TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
            priceTextView.setText("Sorry, please enter a positive amount");
        } else {

            display(quantity);
            displayPrice(quantity * 5);
            displaymessage();


        }
    }

    public void displaymessage() {
        int i = quantity * 5;

        TextView finalprice = (TextView) findViewById(R.id.final_price);
        finalprice.setText("The final cost is " + i + "  Thank you  ");

    }

    public void checkout(View v) {

        Uri uri = Uri.parse("https://www.paypal.com/us/webapps/mpp/payflow-payment-gateway");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }


    public void look(View v) {

        Uri uri = Uri.parse("http://www.cafecoffeeday.com/cafe-menu/beverages/hot-coffee");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
}
