/**
 * UserNotFoundException.java
 * Project: desert-moon
 * Copyright (c) 2019, Desert Moon
 * All rights reserved.
 */

package com.dm.service.exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(final String message) {
        super(message);
    }

}
