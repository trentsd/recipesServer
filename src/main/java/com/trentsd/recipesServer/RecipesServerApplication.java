package com.trentsd.recipesServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import java.util.stream.Stream;

@SpringBootApplication
public class RecipesServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecipesServerApplication.class, args);
	}

	@Bean
	ApplicationRunner init(CommentRepository repository) {
		return args -> {
			Stream.of("Sean", "Jon", "Pete").forEach(name -> {
				Comment comment = new Comment();
				comment.setName(name);
				comment.setPageid(new Long(1)); //THIS WILL CHANGE WHEN PAGE ENTITIES ARE ADDED
				comment.setContent("THIS IS A TEST COMMENT");
				repository.save(comment);
			});
			Comment diffComment = new Comment();
			diffComment.setName("Different User");
			diffComment.setPageid(new Long(0));
			diffComment.setContent("This comment is on a different page");
			repository.save(diffComment);
			repository.findAll().forEach(System.out::println);
		};
	}

}
