package com.forum.forum.entity;

public class JwtResponse {
    private String jwtToken;
    private String username;

    public static JwtResponseBuilder builder() {
        return new JwtResponseBuilder();
    }

    public String getJwtToken() {
        return this.jwtToken;
    }

    public String getUsername() {
        return this.username;
    }

    public void setJwtToken(final String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public JwtResponse(final String jwtToken, final String username) {
        this.jwtToken = jwtToken;
        this.username = username;
    }

    public JwtResponse() {
    }

    public String toString() {
        String var10000 = this.getJwtToken();
        return "JwtResponse(jwtToken=" + var10000 + ", username=" + this.getUsername() + ")";
    }

    public static class JwtResponseBuilder {
        private String jwtToken;
        private String username;

        JwtResponseBuilder() {
        }

        public JwtResponseBuilder jwtToken(final String jwtToken) {
            this.jwtToken = jwtToken;
            return this;
        }

        public JwtResponseBuilder username(final String username) {
            this.username = username;
            return this;
        }

        public JwtResponse build() {
            return new JwtResponse(this.jwtToken, this.username);
        }

        public String toString() {
            return "JwtResponse.JwtResponseBuilder(jwtToken=" + this.jwtToken + ", username=" + this.username + ")";
        }
    }
}