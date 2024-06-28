package com.forum.forum.config;


import com.forum.forum.service.UserDetailsService;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;


@Component
public class JWTAuthenticationFilter extends OncePerRequestFilter {
    @Autowired
    private JwtHelper jwtHelper;
    @Autowired
    private UserDetailsService userDetailsService;

    public JWTAuthenticationFilter() {
    }

    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String requestHeader = request.getHeader("Authorization");
        System.out.println("Inside auth filter");
        System.out.println(requestHeader);
        String username = null;
        String token = null;
        if (requestHeader != null && requestHeader.startsWith("Bearer")) {
            token = requestHeader.substring(7);

            try {
                System.out.println("Inside jwt auth");
                username = this.jwtHelper.getUsernameFromToken(token);
                System.out.println(username);
            } catch (IllegalArgumentException var10) {
                this.logger.info("Illegal Argument while fetching the username !!");
                var10.printStackTrace();
            } catch (ExpiredJwtException var11) {
                this.logger.info("Given jwt token is expired !!");
                var11.printStackTrace();
            } catch (MalformedJwtException var12) {
                this.logger.info("Some changed has done in token !! Invalid Token");
                var12.printStackTrace();
            } catch (Exception var13) {
                var13.printStackTrace();
            }
        } else {
            this.logger.info("Invalid Header Value !! ");
        }

        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            System.out.println("Fetching details");
            UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
            Boolean validateToken = this.jwtHelper.validateToken(token, userDetails);
            PrintStream var10000 = System.out;
            String var10001 = userDetails.getUsername();
            var10000.println(var10001 + validateToken);
            if (validateToken) {
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, (Object)null, userDetails.getAuthorities());
                authentication.setDetails((new WebAuthenticationDetailsSource()).buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authentication);
            } else {
                this.logger.info("Validation fails !!");
            }
        }

        filterChain.doFilter(request, response);
    }
}
