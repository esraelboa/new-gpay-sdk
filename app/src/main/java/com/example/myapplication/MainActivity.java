package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.UUID;
import com.example.gpaypaymentsdk.GpayPayment;
import com.example.gpaypaymentsdk.GpayUrl;
import com.example.gpaypaymentsdk.PaymentResultListener;
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onCloseButtonClick(View view) {
        finish();
    }

    public void onPayWithGpayClicked(View view) {

        GpayPayment payment = new GpayPayment(
                "50.000",
                "0edf0e40-62ab-4b80-83d6-c9fd7ce801f1",
                "esraelhadi1",
                "1746524431038",
                GpayUrl.TESTING_STAGE
        );

        payment.show(MainActivity.this, new PaymentResultListener() {
            @Override
            public void checkPayment(UUID requestId, String requestTimestamp) {
                Log.d("test1", "check payment status ! request_id : " + requestId + " request_timestamp : " + requestTimestamp);
                Toast.makeText(MainActivity.this, "Payment Success: " + requestId, Toast.LENGTH_SHORT).show();
            }
        });
    }

}
