package com.group.trip.utils;

import java.util.HashMap;
import java.util.Map;

public class HttpClientsUtil {
    public HttpClientsUtil() {}
    public static Map<String, String> createHeaders() {
        Map<String, String> headers = new HashMap<>();
        headers.put("Accept", "application/json");
        return headers;
    }
}
