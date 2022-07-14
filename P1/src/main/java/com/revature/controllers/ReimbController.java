package com.revature.controllers;

import com.google.gson.Gson;
import com.revature.daos.ReimbDAO;
import com.revature.models.Reimbursement;

import io.javalin.http.Handler;

public class ReimbController {
    
    ReimbDAO rDAO = new ReimbDAO();
    
    public Handler getAllReimbsHandler = (ctx) -> {

        if (AuthController.session != null) {
            ctx.json(rDAO.getAllReimbursements());
        } else {
            ctx.status(401);
        }

    };

    public Handler insertReimbHandler = (ctx) -> {

        if (AuthController.session != null) {
            String json = ctx.body();
            Gson gson = new Gson();
            Reimbursement reimb = gson.fromJson(json, Reimbursement.class);
            rDAO.insertReimbursement(reimb);
            ctx.status(201);
        } else {
            ctx.status(401);
        }

    };

    public Handler deleteReimbHandler = (ctx) -> {

        if (AuthController.session != null) {
            int id = Integer.parseInt(ctx.pathParam("id"));
            rDAO.deleteReimbursement(id);
            ctx.status(200);
        } else {
            ctx.status(401);
        }

    };
}
