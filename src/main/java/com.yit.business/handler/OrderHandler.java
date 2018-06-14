package com.yit.business.handler;

import spark.Request;
import spark.Response;
import spark.Route;

public class OrderHandler implements Route {

    @Override
    public Object handle(Request request, Response response) throws Exception {
        if (hasNameAndProduct(request)) {
            response.status(200);
            return "hello";

        } else {
            response.status(400);
            return "Bad parameters";
        }
    }

    private boolean hasNameAndProduct(Request request) {
        return request.params("name") != null && request.params("product") != null;
    }
}
