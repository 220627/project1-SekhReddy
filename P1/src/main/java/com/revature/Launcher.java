package com.revature;

import java.sql.Connection;
import java.sql.SQLException;

import com.rev.utils.ConnectionUtil;

import io.Javalin.Javalin;

public class Launcher {

	public static void main(String[] args) {

		System.out.println("=========={ DEMO Expense Reimbursement System }==========");
		System.out.println("===========================================================");
		System.out.println("Initializing...");

		// Try-catch block to initalize connection

		try (Connect conn ConnectionUtil.getConnection()) {
			System.out.println("Connection Successful");
		} catch (SQLException e) {
			System.out.println("Connection failed...");
			e.printStackTrace();
		}

		// Initialize Javalin server

		System.out.println("Initalizing Javalin server...");
		Javalin app = Javalin.create(

			config -> {
				config.defaultContentType = "application/json";
				config.showJavalinBanner = false;
				config.enableCorsForAllOrigins();
			}

		).start(3000); // Start server on port 3000



	}
	
}
