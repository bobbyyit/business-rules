package com.yit.business.handler;

import spark.Request;
import spark.Response;
import spark.Route;

public class OrderHandler implements Route {

    @Override
    public Object handle(Request request, Response response) throws Exception {
        response.status(200);

        return "hello";
    }
}
