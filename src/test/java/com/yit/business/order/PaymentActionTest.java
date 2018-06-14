package com.yit.business.order;

import com.yit.business.pojo.Payment;
import com.yit.business.pojo.Product;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PaymentActionTest {

    private PaymentAction paymentAction;

    @Before
    public void setUp() throws Exception {
        paymentAction = new PaymentAction();
    }

    @Test
    public void generatesPackagingSlipForPhysicalProductsAndCommission() {
        Payment payment = new Payment(Product.PHYSICAL, "John A. Smith");

        String result = paymentAction.apply(payment);

        assertThat(result, is("Package slip generate for: John A. Smith, Commission payment generated"));
    }

    @Test
    public void generatesPackagingSlipForBookAndCommission() {
        Payment payment = new Payment(Product.BOOK, "John A. Smith");

        String result = paymentAction.apply(payment);

        assertThat(result, is("Package slip generate for: John A. Smith, Package slip generate for: John A. Smith, Commission payment generated"));
    }

    @Test
    public void activateMembershipAndSendEmail() {
        Payment payment = new Payment(Product.NEW_MEMBERSHIP, "John A. Smith");

        String result = paymentAction.apply(payment);

        assertThat(result, is("Membership activated for: John A. Smith, New membership email sent to: John A. Smith"));
    }

    @Test
    public void upgradeMembershipAndSendEmail() {
        Payment payment = new Payment(Product.UPGRADE_MEMBERSHIP, "John A. Smith");

        String result = paymentAction.apply(payment);

        assertThat(result, is("Membership upgraded for: John A. Smith, Upgrade email sent to: John A. Smith"));
    }

    @Test
    public void addFirstAidVideoForSkiVideo() {
        Payment payment = new Payment(Product.VIDEO, "John A. Smith");

        String result = paymentAction.apply(payment);

        assertThat(result, is("Package slip generate for: John A. Smith, Free Ski video included for: John A. Smith"));
    }
}