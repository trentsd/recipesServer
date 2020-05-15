package com.trentsd.recipesServer;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
public class Comment {
    @Id @GeneratedValue
    private Long id;
    private Long pageid; //THIS WILL BECOME A ONE TO ONE CONNECTION WITH A PAGE ENTITY
    private @NonNull String name;
    private String content;
}