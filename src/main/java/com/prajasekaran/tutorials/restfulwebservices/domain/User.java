package com.prajasekaran.tutorials.restfulwebservices.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ApiModel(description = "It is User Model class")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 2)
    @ApiModelProperty(notes = "Name should at least has two characters")
    private String name;

    @NotNull
    @ApiModelProperty(notes = "Age should not be zero")
    private Integer age;

    @NotNull
    private String job;
//    private Set<Post> posts = new HashSet<>();
}
