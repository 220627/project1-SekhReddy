package com.revature;

import java.sql.Connection;
import java.sql.SQLException;

import com.revature.controllers.AuthController;
import com.revature.controllers.ReimbController;
import com.revature.utils.ConnectionUtil;

import io.javalin.Javalin;

public class Launcher {

	public static void main(String[] args) {

		System.out.println("=========={ DEMO Expense Reimbursement System }==========");
		System.out.println("===========================================================");
		System.out.println("Initializing...");

		// Try-catch block to initalize connection

		try (Connection conn = ConnectionUtil.getConnection()) {
			System.out.println("Connection Successful");
		} catch (SQLException e) {
			System.out.println("Connection failed...");
			e.printStackTrace();
		}

		// Initialize Javalin server

		System.out.println("Initalizing Javalin server...");
		final Javalin app = Javalin.create(

			config -> {
				config.defaultContentType = "application/json";
				config.showJavalinBanner = false;
				config.enableCorsForAllOrigins();
			}

		).start(3000); // Start server on port 3000

		
		// Instantiate controllers

		System.out.println("Instantiating controllers...");

		AuthController ac = new AuthController();
		ReimbController rc = new ReimbController();
		
		// Endpoint handlers

		// Login Endpoint

		app.post("/login", ac.loginHandler);

		// Reimbursement Endpoints

		app.get("/employees/reimbursements", rc.getAllReimbsHandler);
		
		app.post("/employees/reimbursements", rc.insertReimbHandler);

		app.delete("/employees/reimbursements/delete/:id", rc.deleteReimbHandler);

		app.put("/employees/reimbursements/update/:id", rc.updateReimbHandler);


	}
	
}
