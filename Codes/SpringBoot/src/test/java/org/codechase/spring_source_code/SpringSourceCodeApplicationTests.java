package org.codechase.spring_source_code;

import org.codechase.spring_source_code.config.AppConfig;
import org.codechase.spring_source_code.services.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootTest
class SpringSourceCodeApplicationTests {

	@Test
	void contextLoads() {
		// 初始化Spring容器
		AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		annotationConfigApplicationContext.getBean(UserService.class).getService();
	}

}
