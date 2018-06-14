package com.yit.business.handler;

import org.junit.Before;
import org.junit.Test;
import spark.Request;
import spark.Response;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.*;

public class OrderHandlerTest {
    OrderHandler handler;
    private Request request;
    private Response response;

    @Before
    public void setUp() {
        handler = new OrderHandler();
        request = mock(Request.class);
        response = mock(Response.class);
    }

    @Test
    public void returnsOkWhenNameAndProductSpecified() throws Exception {
        when(request.params("name")).thenReturn("John");
        when(request.params("product")).thenReturn("BOOK");

        handler.handle(request, response);

        verify(response).status(200);
        verify(response, times(0)).status(400);
    }

    @Test
    public void returnResponseMessage() throws Exception {
        String responseMessage = (String) handler.handle(request, response);

        assertThat(responseMessage, is("hello"));
    }

    @Test
    public void returnsErrorWhenNameNotSpecified() throws Exception {
        when(request.params("product")).thenReturn("BOOK");
        handler.handle(request, response);

        verify(response).status(400);
    }

    @Test
    public void returnsErrorWhenProductNotSpecified() throws Exception {
        when(request.params("name")).thenReturn("john");
        handler.handle(request, response);

        verify(response).status(400);
    }

}