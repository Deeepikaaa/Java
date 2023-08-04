package com.bdd.bddscenario.integration;
import java.io.IOException;

import java.nio.charset.Charset;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpStatus;

import org.springframework.http.client.ClientHttpResponse;

public class ResponseResults {
    private final ClientHttpResponse theResponse;
    private final String body;
    private final HttpStatus statusCode;

    ResponseResults(final ClientHttpResponse response) throws IOException {
        this.theResponse = response;
        this.body = IOUtils.toString(response.getBody(), Charset.forName("UTF-8"));
        this.statusCode = response.getStatusCode();
    }

    @Override
	public String toString() {
		return "ResponseResults [theResponse=" + theResponse + ", body=" + body + ", statusCode=" + statusCode + "]";
	}

	ClientHttpResponse getTheResponse() {
        return theResponse;
    }

    String getBody() {
        return body;
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }
}
