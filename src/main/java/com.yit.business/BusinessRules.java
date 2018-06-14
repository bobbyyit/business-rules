package com.yit.business;

import com.yit.business.handler.OrderHandler;
import spark.Request;
import spark.Response;

import static spark.Spark.*;

public class BusinessRules {
    public static void main(String[] args) {
        port(9999);
        get("/", (Request request, Response response) -> {
            response.type();
            return "You're up and running!";
        });

        get("order/create", new OrderHandler());
    }
}
