package com.workhop.apimongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.workhop.apimongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {}

