package com.example.gpaypaymentsdk;

import android.app.Activity;
import android.content.Intent;

import java.io.Serializable;

public class GpayPayment implements Serializable {
    private String amount;
    private String requestId;
    private String requesterUsername;
    private String baseUrl;
    private String requestTimestamp;

//    public static PaymentResultListener paymentResultListener;
    public GpayPayment(String amount, String requestId, String requester_username, String requestTimestamp , GpayUrl gpayUrl) {
        this.amount = amount;
        this.requestId = requestId;
        this.requesterUsername = requester_username;
        this.requestTimestamp = requestTimestamp;
        this.baseUrl= gpayUrl.getUrl();
    }

    public void show(Activity activity, PaymentResultListener listener) {
        PaymentWebViewActivity.paymentResultListener = listener;

        String fullUrl = baseUrl +
                "/?amount=" + amount +
                "&requester_username=" + requesterUsername +
                "&request_id=" + requestId +
                "&request_time=" + requestTimestamp;

        Intent intent = new Intent(activity, PaymentWebViewActivity.class);
        intent.putExtra("url", fullUrl);
        activity.startActivity(intent);
    }

    public void closePaymentWebViewActivity() {
        PaymentWebViewActivity.closePaymentActivity();
    }

    public interface OnConfirmClickListener {
        void onConfirm();
    }

    public static OnConfirmClickListener confirmClickListener;

    public static void setOnConfirmClickListener(OnConfirmClickListener listener) {
        confirmClickListener = listener;
    }
    public String getAmount() {
        return amount;
    }
    public String getRequestId() {
        return requestId;
    }
    public String getRequester_username() {
        return requesterUsername;
    }

}
