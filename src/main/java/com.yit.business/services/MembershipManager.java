package com.yit.business.services;

public class MembershipManager {
    public static String activate(String name) {
        return "Membership activated for: " + name;
    }

    public static String upgrade(String name) {
        return "Membership upgraded for: " + name;
    }
}
