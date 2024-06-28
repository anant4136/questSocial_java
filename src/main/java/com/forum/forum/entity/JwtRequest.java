package com.forum.forum.entity;

public class JwtRequest {
    private String username;
    private String password;

    public static JwtRequestBuilder builder() {
        return new JwtRequestBuilder();
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public JwtRequest(final String username, final String password) {
        this.username = username;
        this.password = password;
    }

    public JwtRequest() {
    }

    public String toString() {
        String var10000 = this.getUsername();
        return "JwtRequest(username=" + var10000 + ", password=" + this.getPassword() + ")";
    }

    public static class JwtRequestBuilder {
        private String username;
        private String password;

        JwtRequestBuilder() {
        }

        public JwtRequestBuilder username(final String username) {
            this.username = username;
            return this;
        }

        public JwtRequestBuilder password(final String password) {
            this.password = password;
            return this;
        }

        public JwtRequest build() {
            return new JwtRequest(this.username, this.password);
        }

        public String toString() {
            return "JwtRequest.JwtRequestBuilder(username=" + this.username + ", password=" + this.password + ")";
        }
    }
}
