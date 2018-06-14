package com.yit.business.order;

import com.yit.business.pojo.Payment;
import com.yit.business.services.EmailService;
import com.yit.business.services.PackageSlipGenerator;

import java.util.ArrayList;
import java.util.List;

import static com.yit.business.services.EmailService.emailToNewMembership;
import static com.yit.business.services.EmailService.emailToUpgradeMembership;
import static com.yit.business.services.MembershipManager.activate;
import static com.yit.business.services.MembershipManager.upgrade;
import static com.yit.business.services.PackageSlipGenerator.generatePackagingSlipFor;
import static com.yit.business.pojo.Product.*;
import static java.lang.String.join;

public class PaymentAction {

    public String apply(Payment payment) {
        List<String> messages = new ArrayList<>();
        if (payment.getProduct() == PHYSICAL) {
            messages.add(generatePackagingSlipFor(payment.getFrom()));
        } else if (payment.getProduct() == BOOK) {
            messages.add(generatePackagingSlipFor(payment.getFrom()));
            messages.add(generatePackagingSlipFor(payment.getFrom()));
        } else if (payment.getProduct() == NEW_MEMBERSHIP) {
            messages.add(activate(payment.getFrom()));
            messages.add(emailToNewMembership(payment.getFrom()));
        } else if (payment.getProduct() == UPGRADE_MEMBERSHIP) {
            messages.add(upgrade(payment.getFrom()));
            messages.add(emailToUpgradeMembership(payment.getFrom()));
        } else if (payment.getProduct() == VIDEO) {
            messages.add(generatePackagingSlipFor(payment.getFrom()));
            messages.add(PackageSlipGenerator.generateCustomPackagingSlipFor("Ski video", payment.getFrom()));
        }

        return join(", ", messages);
    }
}
