package com.prajasekaran.tutorials.restfulwebservices.domain;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
// Used For Static Filtering
//@JsonIgnoreProperties(value = {"field3"})
// Used For Dynamic Filtering
@JsonFilter("Darcarys")
public class FilteredBean {

    private String field1;
    private String field2;
    private String field3;
}
