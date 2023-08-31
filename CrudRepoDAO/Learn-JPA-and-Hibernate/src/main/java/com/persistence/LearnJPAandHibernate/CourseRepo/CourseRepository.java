package com.persistence.LearnJPAandHibernate.CourseRepo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.persistence.LearnJPAandHibernate.SpringData.Course;
public interface CourseRepository extends CrudRepository<Course, Long>  {
//		public List<Course> findByAuthor(String author);
//		public List<Course> findByName(String name);
//		public List<Course> findByAuthorAndName(String auth, String name);
//		public List<Course> findByAuthorIn(List<String> asList);
//		public List<Course> findByIdGreaterThanEqual(Integer id);
//	-------------------------------------------------------------------
//	To Write custom query we use @Query Annotaion on the userdefined methods.
//-----------------------------------------------------------------------------	
	@Query(value="From Course")
	public List<Course> getAllCoursesHql();
	@Query(value="select * from course;",nativeQuery = true)
	public List<Course> getAllCoursesSql();
	@Query(value="From Course where author=:positionalParam")
	public List<Course> getAllCourseByAuthor(String positionalParam);
}
