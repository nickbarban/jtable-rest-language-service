package com.barban.bootstrap;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.barban.model.User;
import com.barban.repositories.UserRepository;

import java.math.BigDecimal;

@Component
public class UserLoader implements ApplicationListener<ContextRefreshedEvent> {

	private UserRepository userRepository;

	private Logger log = Logger.getLogger(UserLoader.class);

	@Autowired
	public void setProductRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {

		User nick = new User();
		nick.setName("Nick");
		nick.setLogin("babel");
		nick.setPassword("1111");
		nick.setEmail("nick@babel.com");
		userRepository.save(nick);

		log.info("Saved user - id: " + nick.getId() + " by name: " + nick.getName());

		User cate = new User();
		cate.setName("Cate");
		cate.setLogin("buty");
		cate.setPassword("2222");
		cate.setEmail("cate@buty.com");
		userRepository.save(cate);

		log.info("Saved user - id:" + cate.getId() + " by name: " + cate.getName());
	}
}