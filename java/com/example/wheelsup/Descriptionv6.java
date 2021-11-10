package com.example.wheelsup;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;

import org.json.JSONException;
import org.json.JSONObject;

public class Descriptionv6 extends AppCompatActivity implements PaymentResultListener {
    Button payment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descriptionv6);

        payment=findViewById(R.id.payment);

        String sAmount="100";
        int amount=Math.round(Float.parseFloat(sAmount)*100);

        payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Checkout checkout= new Checkout();
                checkout.setKeyID("rzp_test_Ek0cSnKoj9aUAB");
                checkout.setImage(R.drawable.rzp_logo);

                JSONObject object= new JSONObject();

                try {
                    object.put("name","Manan Hude");
                    object.put("description","Test Payment");

                    object.put("theme.color","#0093DD");
                    object.put("currency","INR");
                    object.put("amount",amount);
                    object.put("prefill.contact","9370819072");
                    object.put("prefill.email","mananhude10@gmail.com");
                    checkout.open(Descriptionv6.this,object);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });


    }

    @Override
    public void onPaymentSuccess(String s) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Payment ID");
        builder.setMessage(s);
        builder.show();
    }

    @Override
    public void onPaymentError(int i, String s) {
        Toast.makeText(getApplicationContext(),s,Toast.LENGTH_SHORT).show();

    }
}