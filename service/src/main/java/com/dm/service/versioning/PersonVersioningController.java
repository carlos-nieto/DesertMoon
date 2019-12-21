/**
 * PersonVersioningController.java
 * Project: desert-moon
 * Copyright (c) 2019, Desert Moon
 * All rights reserved.
 */

package com.dm.service.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {

    // URI VERSIONING
    @GetMapping("v1/person")
    public PersonV1 personV1() {
        return new PersonV1("Carlos Nieto");
    }

    @GetMapping("v2/person")
    public PersonV2 personV2() {
        return new PersonV2(new Name("Carlos", "Nieto"));
    }

    // REQUEST PARAMETER VERSIONING
    @GetMapping(value = "/person/param", params = "version=1")
    public PersonV1 paramV1() {
        return new PersonV1("Carlos Nieto");
    }

    @GetMapping(value = "/person/param", params = "version=2")
    public PersonV2 paramV2() {
        return new PersonV2(new Name("Carlos", "Nieto"));
    }

    // HEADER VERSIONING
    @GetMapping(value = "/person/header", headers = "X-API-VERSION=1")
    public PersonV1 headerV1() {
        return new PersonV1("Carlos Nieto");
    }

    @GetMapping(value = "/person/header", headers = "X-API-VERSION=2")
    public PersonV2 headerV2() {
        return new PersonV2(new Name("Carlos", "Nieto"));
    }

    // ACCEPT HEADER VERSIONING / CONTENT NEGOTIATION
    @GetMapping(value = "/person/produces", produces = "application/vnd.company.app-v1+json")
    public PersonV1 producesV1() {
        return new PersonV1("Carlos Nieto");
    }

    @GetMapping(value = "/person/produces", produces = "application/vnd.company.app-v2+json")
    public PersonV2 producesV2() {
        return new PersonV2(new Name("Carlos", "Nieto"));
    }
}
