package com.yit.business.services;

public class EmailService {
    public static String emailToNewMembership(String recipient) {
        return "New membership email sent to: " + recipient;
    }

    public static String emailToUpgradeMembership(String recipient) {
        return "Upgrade email sent to: " + recipient;
    }
}
