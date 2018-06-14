package com.yit.business.handler;

import org.junit.Before;
import org.junit.Test;
import spark.Request;
import spark.Response;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class OrderHandlerTest {
    OrderHandler handler;
    private Request request;
    private Response reponse;

    @Before
    public void setUp() throws Exception {
        handler = new OrderHandler();
        request = mock(Request.class);
        reponse = mock(Response.class);
    }

    @Test
    public void setsOkStatus() throws Exception {
        handler.handle(request, reponse);

        verify(reponse).status(200);
    }

    @Test
    public void returnResponseMessage() throws Exception {
        String responseMessage = (String) handler.handle(request, reponse);

        assertThat(responseMessage, is("hello"));
    }
}