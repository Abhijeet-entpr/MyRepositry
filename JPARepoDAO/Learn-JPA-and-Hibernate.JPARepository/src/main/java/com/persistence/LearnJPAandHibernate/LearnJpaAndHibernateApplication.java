package com.persistence.LearnJPAandHibernate;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import com.persistence.LearnJPAandHibernate.CourseRepo.UserRepository;
import com.persistence.LearnJPAandHibernate.SpringData.User;
@SpringBootApplication
public class LearnJpaAndHibernateApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = 
				SpringApplication.run(LearnJpaAndHibernateApplication.class, args);
	
		UserRepository repository = context.getBean(UserRepository.class);
	User course1 = new User(1L,"Ganesh","India","Male",33);
	User course2 = new User(2L,"Mangal","India","Male",33);
	User course3 = new User(3L,"Vimlesh","India","Male",33);
	User course4 = new User(4L,"Lunatic","France","Male",24);
	User course5 = new User(5L,"Loyd","UK","Male",25);
	User course6 = new User(6L,"Mahesh","India","Male",26);
	User course7 = new User(7L,"Clark","USA","Male",27);
	User course8 = new User(8L,"Morris","Canada","Male",28);
	User course9 = new User(9L,"Kent","USA","Male",29);

	//repository.save(course1);
	repository.saveAll(Arrays.asList(course1,course2,course3,course4,
			course5,course6,course7,course8,course9));

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
//  -------------	SORTING ---------------
	
//	List<User> findAll = repository.findAll(Sort.by("age").ascending());
//	findAll.forEach(User -> System.out.println(User));
//	List<User> findAll = repository.findAll(Sort.by("country").ascending());
//	findAll.forEach(User -> System.out.println(User));
	// --------------------- PAGINATION ----------------------
//	PageRequest pageRequest = PageRequest.of(2, 3);
//	Page<User>page = repository.findAll(pageRequest);
//	List<User> users = page.getContent();
//	users.forEach(user -> System.out.println(user));
	// -------------------- QUERY BY EXAMPLE (QBE)  -----------------------
	User entity = new User();
	entity.setAge(33);
	
	Example<User> example = Example.of(entity);
	List<User> findAll = repository.findAll(example);
	findAll.forEach(User -> System.out.println(User));

	
	
	
	
	}	
	
	
}
