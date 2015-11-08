package com.example.foodnow;

import android.os.AsyncTask;
import android.util.Log;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONObject;


/**
 * Created by rwitting on 11/7/15.
 */
public class APIWrapper {
    //final static String host = "http://sandbox.delivery.com/";
    final static String host = "http://sandbox.delivery.com/";

    final static String GUEST_TOKEN = "Guest-Token";
    final static String AUTH_TOKEN = "Authorization";
    final static String GUEST_TOKEN_URL = "customer/auth/guest";
    final static String CUSTOMER_CART_URL = "customer/cart";
    final static String CHECKOUT_URL = "customer/cart";
    final static String CC_URL = "customer/cc";
    final static String AUTH_URL = "customer/auth";
    final static String LOCATION_URL = "customer/location";
    final static String ORDER_URL = "customer/orders/recent";
    final static String SEARCH_URL = "merchant/search/delivery";
    final static String SEARCH_ADDRESS = "1330 1st Ave, 10021";
    final static String ADDRESS_APT = "Apt 123";
    final static String CLIENT_ID = "OGM0ODA2Mjk2ZTVjYzA0ZGJjZWQxODg5YjY4ZjVjYzBl";
    final static String ORDER_TYPE = "delivery";

    public JSONObject data;
    OkHttpClient mClient = new OkHttpClient();
    public void doAPICALL(){
        new LongOperation().execute("");

    };

    public void getMerchants(){

    };

    private class LongOperation extends AsyncTask<String, Void, String> {
            @Override
            protected String doInBackground(String... params) {
                try{
                    Request req = new Request.Builder().url(host + "merchant/search/delivery?address=704+Pearl+St,+48197&client_id=" + CLIENT_ID).build();
                    Response response = mClient.newCall(req).execute();
                    Log.d("test",response.body().string());
                    return response.body().string();
                }catch(Exception e){
                    Log.e("test",e.getMessage(),e);
                }
                return "";
            }

            @Override
            protected void onPostExecute(String result) {
                //Log.d("test",result);
            }

            @Override
            protected void onPreExecute() {
            }

            @Override
            protected void onProgressUpdate(Void... values) {
            }
    }
}
