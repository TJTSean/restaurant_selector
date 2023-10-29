package com.selector.restaurant.response;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Map;

public class Response {

    protected LocalDateTime timestamp;
    protected int statusCode;
    protected HttpStatus status;
    protected String reason;
    protected String message;
    protected String logMessage;
    protected Map<?, ?> data;

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getReason() {
        return reason;
    }

    public String getMessage() {
        return message;
    }

    public String getLogMessage() {
        return logMessage;
    }

    public Map<?, ?> getData() {
        return data;
    }

    private Response(ResponseBuilder builder) {
        this.timestamp = builder.timestamp;
        this.statusCode = builder.statusCode;
        this.status = builder.status;
        this.reason = builder.reason;
        this.message = builder.message;
        this.logMessage = builder.logMessage;
        this.data = builder.data;
    }

    public static class ResponseBuilder {
        private LocalDateTime timestamp;
        private int statusCode;
        private HttpStatus status;
        private String reason;
        private String message;
        private String logMessage;
        private Map<?, ?> data;

        public ResponseBuilder setTimestamp(LocalDateTime timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public ResponseBuilder setStatusCode(int statusCode) {
            this.statusCode = statusCode;
            return this;
        }

        public ResponseBuilder setStatus(HttpStatus status) {
            this.status = status;
            return this;
        }

        public ResponseBuilder setReason(String reason) {
            this.reason = reason;
            return this;
        }

        public ResponseBuilder setMessage(String message) {
            this.message = message;
            return this;
        }

        public ResponseBuilder setLogMessage(String logMessage) {
            this.logMessage = logMessage;
            return this;
        }

        public ResponseBuilder setData(Map<?, ?> data) {
            this.data = data;
            return this;
        }

        public Response build() {
            return new Response(this);
        }
    }
}
