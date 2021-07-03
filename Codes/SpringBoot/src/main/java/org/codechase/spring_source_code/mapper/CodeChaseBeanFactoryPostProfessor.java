package org.codechase.spring_source_code.mapper;

import org.codechase.spring_source_code.services.IndexService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;

/**
 * @author codechase <codecx@163.com>
 * Created on 2021-06-26
 */

// Spring会自动在容器初始化过程中回调BeanFactoryPostProcessor的方法,但必须将BeanFactoryPostProcessor也添加上@Component注解
//@Component
public class CodeChaseBeanFactoryPostProfessor implements BeanFactoryPostProcessor {

    // 方法的参数就是一个beanFactory,就是Spring的工厂,其中存放着beanDefinitionMap
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        // 可以通过BeanDefinition,或者GenericBeanDefinition来获取
        // 一般都是使用GeneticBeanDefinition,是BeanDefinition的子类,拥有更多的方法
        GenericBeanDefinition genericBeanDefinition = (GenericBeanDefinition) configurableListableBeanFactory.getBeanDefinition("userService");

        // 当我们进行这样的设置,并且将CodeChaseBeanFactoryPostProfessor上加入@Component注解之后
        // 我们再去获取annotationConfigApplicationContext.getBean(UserService.class).getService();
        // 或者UserService userService = (UserService) annotationConfigApplicationContext.getBean("userService");
        // 都会报错,提示Caused by: org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'indexService'
        genericBeanDefinition.setBeanClass(IndexService.class);
    }
}
