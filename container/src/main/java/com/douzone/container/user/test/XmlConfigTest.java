package com.douzone.container.user.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import com.douzone.container.user.User;

public class XmlConfigTest {

	public static void main(String[] args) {
		// Xml Auto Configuration(Annotation Scanning)
		//testBeanFactory01();

		// Xml Bean Configuration(Explict Scanning)
		//testBeanFactory02();
		
		// Xml Auto Configuration(Annotation Scanning)
		//testApplicationContext01();
		
		// Xml Bean Configuration(Explict Scanning)
		testApplicationContext02();
		
		
		
		
	}

	private static void testApplicationContext02() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/douzone/container/config/user/applicationContext02.xml");
		
		User user = null;
		
		// id로 빈 가져오기
		user = (User)ac.getBean("user1");
		System.out.println("id : " + user.getName());
		
		// name으로 빈 가져오기
		user = (User)ac.getBean("usr1");
		System.out.println("name : " + user.getName());
		
		// Type으로 빈 가져오기
		// 같은 Type의 빈이 2개 이상 있으면 Type으로 가져오기 실패
		//1. id + type
		//2. name + type
		user = (User)ac.getBean("user1", User.class);
		System.out.println("id + type : " + user.getName());

		user = (User)ac.getBean("user2", User.class);
		System.out.println("id + type : " + user.getName());

		// 파라미터 1개인 생성자로 생성된 빈 가져오기
		user = (User)ac.getBean("user2", User.class);
		System.out.println("user2 : " + user);
		
		// 파라미터 2개인 생성자로 생성된 빈1 가져오기
		user = ac.getBean("user3", User.class);
		System.out.println("user3 : " + user);
		
		// 파라미터 2개인 생성자로 생성된 빈2 가져오기
		user = ac.getBean("user4", User.class);
		System.out.println("user4 : " + user);

		// setter를 사용한 빈 가져오기
		user = ac.getBean("user5", User.class);
		System.out.println("user5 : " + user);
		
		// setter를 사용한 빈 가져오기(DI)
		user = ac.getBean("user6", User.class);
		System.out.println("user6 : " + user);
		
		// setter를 사용한 빈 가져오기(Collection Property)
		user = ac.getBean("user7", User.class);
		System.out.println("user7 : " + user);
		
		
		
		
		
		
		
		
	}

	private static void testApplicationContext01() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/douzone/container/config/user/applicationContext01.xml");
		
		User user = null;
		
		// Annotation Scan 설정에서는 Bean id가 자동으로 부여
		user = (User)ac.getBean("user");
		System.out.println(user.getName());
	}

	
	private static void testBeanFactory01() {
		BeanFactory bf = new XmlBeanFactory(new ClassPathResource("com/douzone/container/config/user/applicationContext01.xml"));
		
		User user = bf.getBean(User.class);
		System.out.println(user.getName());
	}

	private static void testBeanFactory02() {
		BeanFactory bf = new XmlBeanFactory(new ClassPathResource("com/douzone/container/config/user/applicationContext02.xml"));
		
		User user = bf.getBean(User.class);
		System.out.println(user.getName());
	}

}
