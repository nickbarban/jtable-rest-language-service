package com.barban.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.barban.model.User;
import com.barban.services.UserService;
import com.barban.utilities.JTableJsonResponse;
import com.google.common.collect.Lists;

@Controller
@RequestMapping("/admin")
public class AdminController {

	private final static Logger LOG = LoggerFactory.getLogger(AdminController.class);

	private UserService userService;

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping("")
	String admin() {
		return "admin";
	}

	@RequestMapping("/users")
	@ResponseBody
	JTableJsonResponse getAllUsers() {
		List<User> users = Lists.newArrayList(userService.listAllUsers());
		JTableJsonResponse response = new JTableJsonResponse();
		if (users != null && users.size() > 0) {
			LOG.info(String.format("Get all users (%s)", users.size()));
			response.setResult("OK");
			response.setRecords(users); // return Json(new { Result = "OK",
										// Records = bstat },
										// JsonRequestBehavior.AllowGet);
		} else {
			LOG.warn("Error getting users");
			response.setResult("ERROR");
		}
		return response;
	}

	@RequestMapping("/addUser")
	@ResponseBody
	JTableJsonResponse addUser(User user) {
		JTableJsonResponse response = new JTableJsonResponse();
		if (user != null) {
			User savedUser = userService.saveUser(user);
			LOG.info(String.format("Add user: %s", savedUser));
			response.setResult("OK");
			response.setRecord(savedUser);
		} else {
			LOG.warn("User is null");
			response.setResult("ERROR");
		}
		return response;
	}

	@RequestMapping("/updateUser")
	@ResponseBody
	JTableJsonResponse updateUser(User user) {
		LOG.info(String.format("Update user: (%s)", user.toString()));
		JTableJsonResponse response = new JTableJsonResponse();
		/*
		 * if (user != null) {
		 * LOG.info(String.format("Update user with id: (%s)", user.getId()));
		 * User fetchUser = userService.getUserById(user.getId());
		 * 
		 * response.setResult("OK"); response.setRecord(fetchUser); } else {
		 * LOG.warn("User is null"); response.setResult("ERROR"); }
		 */
		response.setResult("OK");
		response.setRecord(user);
		return response;
	}

	@RequestMapping("/deleteUser")
	@ResponseBody
	JTableJsonResponse deleteUser(@RequestParam User user) {
		LOG.info(String.format("Delete user: (%s)", user.toString()));
		JTableJsonResponse response = new JTableJsonResponse();
		/*
		 * if (id != null) { LOG.info(String.format("Delete user with id: (%s)",
		 * id)); userService.deleteUser(id); response.setResult("OK"); } else {
		 * LOG.warn("User is null"); response.setResult("ERROR"); }
		 */
		response.setResult("OK");
		return response;
	}
}
