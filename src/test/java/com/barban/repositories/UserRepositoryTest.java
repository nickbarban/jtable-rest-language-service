package com.barban.repositories;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.barban.configuration.RepositoryConfiguration;
import com.barban.model.User;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { RepositoryConfiguration.class })
public class UserRepositoryTest {

	private UserRepository userRepository;

	@Autowired
	public void setProductRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Test
	public void testSaveUser() {
		// setup user
		User user = new User();
		user.setName("Nick");
		user.setLogin("babel");
		user.setPassword("1111");
		user.setEmail("nick@babel.com");

		// save user, verify has ID value after save
		assertNull(user.getId()); // null before save
		userRepository.save(user);
		assertNotNull(user.getId()); // not null after save

		// fetch from DB
		User fetchedUser = userRepository.findOne(user.getId());

		// should not be null
		assertNotNull(fetchedUser);

		// should equal
		assertEquals(user.getId(), fetchedUser.getId());
		assertEquals(user.getName(), fetchedUser.getName());

		// update description and save
		fetchedUser.setName("Cate");
		userRepository.save(fetchedUser);

		// get from DB, should be updated
		User fetchedUpdatedUser = userRepository.findOne(fetchedUser.getId());
		assertEquals(fetchedUser.getName(), fetchedUpdatedUser.getName());

		// verify count of users in DB
		long userCount = userRepository.count();
		assertEquals(userCount, 1);

		// get all users, list should only have one
		Iterable<User> users = userRepository.findAll();

		int count = 0;

		for (User u : users) {
			count++;
		}

		assertEquals(count, 1);
	}
}