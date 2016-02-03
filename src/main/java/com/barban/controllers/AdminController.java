package com.barban.controllers;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

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
import org.springframework.web.context.request.RequestAttributes;

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

	@RequestMapping(value = { "/", "" })
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
			List<JTableUser> jTableUsers = users.stream().map(new Function<User, JTableUser>() {

				@Override
				public JTableUser apply(User user) {
					JTableUser jTableUser = new JTableUser();
					jTableUser.setId(user.getId());
					jTableUser.setName(user.getName());
					jTableUser.setLogin(user.getLogin());
					jTableUser.setEmail(user.getEmail());
					jTableUser.setPassword(user.getPassword());
					return jTableUser;
				}
			}).collect(Collectors.<JTableUser>toList());
			response.setResult("OK");
			response.setRecords(jTableUsers);
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
			JTableUser jTableUser = new JTableUser();
			jTableUser.setId(savedUser.getId());
			jTableUser.setName(savedUser.getName());
			jTableUser.setLogin(savedUser.getLogin());
			jTableUser.setEmail(savedUser.getEmail());
			jTableUser.setPassword(savedUser.getPassword());
			LOG.info(String.format("Add user: %s", jTableUser));
			response.setResult("OK");
			response.setRecord(jTableUser);
		} else {
			LOG.warn("User is null");
			response.setResult("ERROR");
		}
		return response;
	}

	@RequestMapping("/updateUser")
	@ResponseBody
	JTableJsonResponse updateUser(User user) {
		LOG.info(String.format("Update user: (%s)", user));
		JTableJsonResponse response = new JTableJsonResponse();
		if (user != null) {
			LOG.info(String.format("Update user with id: (%s)", user.getId()));
			//User fetchUser = userService.getUserById(user.getId());
			userService.saveUser(user);
			response.setResult("OK");
			response.setRecord(user);
		} else {
			LOG.warn("User is null");
			response.setResult("ERROR");
		}

		response.setResult("OK");
		response.setRecord(user);
		return response;
	}

	@RequestMapping("/deleteUser")
	@ResponseBody
	JTableJsonResponse deleteUser(Integer id) {
		LOG.info(String.format("Delete user: %s", id));
		JTableJsonResponse response = new JTableJsonResponse();

		if (id != null) {
			LOG.info(String.format("Delete user with id: (%s)", id));
			userService.deleteUser(id);
			response.setResult("OK");
		} else {
			LOG.warn("User is null");
			response.setResult("ERROR");
		}

		response.setResult("OK");
		return response;
	}
}
