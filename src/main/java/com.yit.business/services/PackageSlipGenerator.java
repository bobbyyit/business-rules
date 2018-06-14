package com.yit.business.services;

public class PackageSlipGenerator {
    public static String generatePackagingSlipFor(String destination) {
        return "Package slip generate for: " + destination;
    }

    public static String generateCustomPackagingSlipFor(String product, String destination) {
        return "Free " + product + " included for: " + destination;
    }
}
