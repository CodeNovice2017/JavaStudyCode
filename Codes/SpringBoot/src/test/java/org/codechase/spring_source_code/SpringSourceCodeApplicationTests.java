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

		// 输出Spring容器构建好之后的beanDefinitionName
		for(String beanDefinitionName : annotationConfigApplicationContext.getBeanDefinitionNames()){
			System.out.println(beanDefinitionName);
		}

		// 如果我们没有给Spring配置的Component设置名字的话,Spring默认是将其设置为驼峰式命名
		UserService userService = (UserService) annotationConfigApplicationContext.getBean("userService");
		userService.getService();
	}

}
