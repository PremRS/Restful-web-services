package com.prajasekaran.tutorials.restfulwebservices.filter;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.prajasekaran.tutorials.restfulwebservices.domain.FilteredBean;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilteringController {

    @GetMapping("/filter")
    public MappingJacksonValue retrieveFilteredBean(){
        FilteredBean filteredBean = new FilteredBean("1", "2", "3");

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1","field3");

        FilterProvider filters = new SimpleFilterProvider().addFilter("Darcarys",filter);

        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(filteredBean);

        mappingJacksonValue.setFilters(filters);

        return mappingJacksonValue;
    }
}
