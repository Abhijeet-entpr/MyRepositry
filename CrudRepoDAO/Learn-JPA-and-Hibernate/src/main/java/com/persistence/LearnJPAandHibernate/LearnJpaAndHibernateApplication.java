package com.persistence.LearnJPAandHibernate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.apache.catalina.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Repository;

import com.persistence.LearnJPAandHibernate.CourseRepo.CourseRepository;
import com.persistence.LearnJPAandHibernate.SpringData.Course;

import ch.qos.logback.core.Context;

@SpringBootApplication
public class LearnJpaAndHibernateApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = 
				SpringApplication.run(LearnJpaAndHibernateApplication.class, args);
	
		CourseRepository repository = context.getBean(CourseRepository.class);
	Course course1 = new Course(1L,"Kubernetes","in28min");
	Course course2 = new Course(2L,"Terraform","EazyBytes");
	Course course3 = new Course(3L,"Jenkins","Ashok IT");
	Course course4 = new Course(4L,"Learn AWS","in28min");

	//repository.save(course1);
	repository.saveAll(Arrays.asList(course1,course2,course3,course4));
//	Optional<Course> find = repository.findById(1L);
//	if(find.isPresent()) {
//		System.out.println(find.get());
//	}
//	Iterable<Course> AllById = repository.findAllById(Arrays.asList(1L,2L));
//	AllById.forEach(course -> System.out.println(course));
//	Iterable<Course> All = repository.findAll();
//	All.forEach(course -> System.out.println(course));
//	List<Course> findByAuth = repository.findByAuthor("in28min");
//	findByAuth.forEach(course -> System.out.println(course));
//	List<Course> findByNa = repository.findByName("Learn AWS");
//	findByNa.forEach(course -> System.out.println(course));
//	
	List<Course> filtered = repository.getAllCourseByAuthor("in28min");
	filtered.forEach(course -> System.out.println(course));
	
	repository.deleteById(102l);
	repository.deleteById(152l);
	repository.deleteById(52l);

	List<Course> allCourse = repository.getAllCoursesHql();
	allCourse.forEach(course -> System.out.println(course));
	
	}	
	
	
}
