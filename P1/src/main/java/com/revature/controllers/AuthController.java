package com.revature.controllers;

import javax.servlet.http.HttpSession;
import io.javalin.http.Handler;

import com.google.gson.Gson;
import com.revature.models.LoginDTO;
import com.revature.services.AuthService;

public class AuthController {
    
    AuthService as = new AuthService();

    public static HttpSession session;

    public Handler loginHandler = (ctx) -> {

        String json = ctx.body();
        Gson gson = new Gson();
        LoginDTO ld = gson.fromJson(json, LoginDTO.class);
        String username = ld.getUsername();
        String password = ld.getPassword();
        String token = as.login(username, password);
        if (token != null) {
            session = ctx.req.getSession();
            session.setAttribute("username", username);
            session.setAttribute("token", token);
            ctx.status(200);
        } else {
            ctx.status(401);
        }
    };

}


