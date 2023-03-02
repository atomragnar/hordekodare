package org.hordekodning.alltid.hordekodare;
import org.hordekodning.alltid.hordekodare.login.Constants;

import org.hordekodning.alltid.hordekodare.Service.LinkService;
import org.hordekodning.alltid.hordekodare.login.UserService;
import org.hordekodning.alltid.hordekodare.login.UserServiceImpl;
import org.hordekodning.alltid.hordekodare.pojo.Link;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class HordekodareApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void testLinkName() {
		Link link = new Link("https://www.google.com", "Google");
		Assertions.assertEquals("https://www.google.com", link.getName());
	}

	@Test
	public void testChangeLinkName() {
		Link link = new Link("https://www.google.com", "Google");
		Assertions.assertEquals("https://www.google.com", link.getName());
		link.setName("https://www.bing.com");
		Assertions.assertEquals("https://www.bing.com", link.getName());
	}

	/*@Test
	public void testIsLoginValid() {
		UserServiceImpl userService = new UserServiceImpl();
		int result = userService.isLoginValid("username", "password");
		Assertions.assertEquals(0, result);
	}*/
}
