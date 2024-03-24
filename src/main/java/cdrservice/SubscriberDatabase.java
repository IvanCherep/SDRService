package cdrservice;

import java.util.HashMap;
import java.util.Map;

public class SubscriberDatabase {
    private static final Map<String, String> subscriberData = new HashMap<>();

    public static void addSubscriber(String msisdn, String data) {
        subscriberData.put(msisdn, data);
    }

    public static String getSubscriberData(String msisdn) {
        return subscriberData.get(msisdn);
    }
}
