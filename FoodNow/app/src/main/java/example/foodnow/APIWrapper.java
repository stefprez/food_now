package example.foodnow;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.JSONObject;

/**
 * Created by rwitting on 11/7/15.
 */
public class APIWrapper {
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
    final static String CLIENT_ID = "NDU1MWU1YjM4NzczMjljN2ZlNjFkODFkNDhlMjdkZGZk";
    final static String ORDER_TYPE = "delivery";

    public JSONObject data;

}
