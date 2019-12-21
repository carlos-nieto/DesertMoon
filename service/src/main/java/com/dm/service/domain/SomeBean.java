/**
 * SomeBean.java
 * Project: desert-moon
 * Copyright (c) 2019, Desert Moon
 * All rights reserved.
 */

package com.dm.service.domain;

import com.fasterxml.jackson.annotation.JsonFilter;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@JsonFilter("SomeBeanFilter")
public class SomeBean {

    private String field1;

    private String field2;

    private String field3;

}
