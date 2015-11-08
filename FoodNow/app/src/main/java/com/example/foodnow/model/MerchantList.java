package com.example.foodnow.model;

import java.util.List;

/**
 * Created by csperlic on 11/8/15.
 */
public class MerchantList {
    @SuppressWarnings("merchants")
    List<Merchant> merchants;

    public List<Merchant> getMerchants() {
        return merchants;
    }

    public Merchant getRandomMerchant() {
        if (merchants.size() > 0) {
            return merchants.get((int) (Math.random() * merchants.size()) + 1);
        }
        else return null;
    }
}
