package com.reimbursement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.reimbursement.controllers.ReimbursementController;
import com.reimbursement.controllers.UserController;
import com.reimbursement.dao.UsersDAOImpl;

import io.javalin.Javalin;

public class ReimbursementApp {
	public static final Logger LOG = LogManager.getLogger(ReimbursementApp.class);
	public static void main(String[] args) {
		
		Javalin app = Javalin.create((config) -> config.enableCorsForAllOrigins()).start(2020);

		UserController usersController = new UserController();
		ReimbursementController reimbController = new ReimbursementController();

		app.post("/api/users/logon", usersController.userLogon);

		app.get("/api/users/search", usersController.searchUsers);
		
		app.get("/api/users/getUser", usersController.getUser);

		app.put("/api/users", usersController.updateUser);

		app.post("/api/reimbursements", reimbController.addReimbursement);

		app.get("/api/reimbursements/search", reimbController.searchReimbursements);
		
		app.get("/api/reimbursements", reimbController.getAllReimbursements);

		app.put("/api/reimbursements", reimbController.updateReimbursement);

		System.out.println("Server listening at part 2020.........");
		LOG.info("Server is listening at port 2020 ...");
		
		

	}
}
