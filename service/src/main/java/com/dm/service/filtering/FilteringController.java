/**
 * FilteringController.java
 * Project: desert-moon
 * Copyright (c) 2019, Desert Moon
 * All rights reserved.
 */

package com.dm.service.filtering;

import com.dm.service.domain.SomeBean;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.PropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilteringController {

    @GetMapping("/filtering")
    public MappingJacksonValue retrieveSomeBeans() {
        SomeBean someBean = new SomeBean("value1", "value2", "value3");
        return createSomeBeanFilterMapping(someBean,"field1", "field2");
    }

    @GetMapping("/filtering-list")
    public MappingJacksonValue retrieveSomeBeansList() {
        List<SomeBean> someBeans = Arrays.asList(
                new SomeBean("value1", "value2", "value3"),
                new SomeBean("value11", "value22", "value33")
        );
        return createSomeBeanFilterMapping(someBeans,"field2", "field3");

    }

    public MappingJacksonValue createSomeBeanFilterMapping(final Object someBean, final String... fields) {
        PropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept(fields);
        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
        MappingJacksonValue mapping = new MappingJacksonValue(someBean);
        mapping.setFilters(filters);
        return mapping;
    }
}
