package com.workhop.apimongo.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.workhop.apimongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
	
	List<Post> findByTitleContainingIgnoreCase (String text);
	
	// title = field | ?0 = first param = title | i =  ignore Case Sensitive
	@Query("{ 'title': { $regex: ?0, $options: 'i' } }")
	List<Post> searchTitleByREGEX (String text);
	
	// Query to fetch string data be in a date range (title, body, and comments.text)
	// Date must to be greater or equal to what is present in the minDate
	// Date must be less than or equal to what is present in the maxDate
	// Text data must be present in post title, post body text and comments text
	@Query("{ $and: [ { date: {$gte: ?1} }, { date: { $lte: ?2} } , { $or: [ { 'title': { $regex: ?0, $options: 'i' } }, { 'body': { $regex: ?0, $options: 'i' } }, { 'comments.text': { $regex: ?0, $options: 'i' } } ] } ] }")
	List<Post> fullSearch (String text, Date minDate, Date maxDate);
}

