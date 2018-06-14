package com.yit.business.handler;

import com.yit.business.order.PaymentAction;
import com.yit.business.pojo.Payment;
import com.yit.business.pojo.Product;
import spark.Request;
import spark.Response;
import spark.Route;

public class OrderHandler implements Route {

    private PaymentAction paymentAction;

    public OrderHandler(PaymentAction paymentAction) {
        this.paymentAction = paymentAction;
    }

    @Override
    public Object handle(Request request, Response response) {
        if (hasNameAndProduct(request)) {
            response.status(200);
            Payment payment = new Payment(Product.valueOf(request.params("product")), request.params("name"));

            return paymentAction.apply(payment);
        } else {
            response.status(400);
            return "Bad parameters";
        }
    }

    private boolean hasNameAndProduct(Request request) {
        return request.params("name") != null && request.params("product") != null;
    }
}
