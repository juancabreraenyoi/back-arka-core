package com.arka.steps.client;

public class ClientCountryCodeStep {

    public static final String CO = "+57";

    public static String concatCountryCode(String phone){
        return CO.concat(phone);
    }
}
