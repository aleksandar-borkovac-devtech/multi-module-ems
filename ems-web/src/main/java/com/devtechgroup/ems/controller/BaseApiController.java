package com.devtechgroup.ems.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * Created by aleksandar.borkovac on 4/19/2016.
 */
public abstract class BaseApiController {

    protected ResponseEntity ok(Object body) {
        return new ResponseEntity<>(body, new HttpHeaders(), HttpStatus.OK);
    }

    protected ResponseEntity notFound(Object body) {
        return new ResponseEntity<>(body, new HttpHeaders(), HttpStatus.NOT_FOUND);
    }

    protected ResponseEntity badRequest(Object body) {
        return new ResponseEntity<>(body, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    protected ResponseEntity created(Object body) {
        return new ResponseEntity<>(body, new HttpHeaders(), HttpStatus.CREATED);
    }

    protected ResponseEntity deleted() {
        return new ResponseEntity<>(new HttpHeaders(), HttpStatus.NO_CONTENT);
    }

    protected ResponseEntity update(Object body) {
        return new ResponseEntity<>(new HttpHeaders(), HttpStatus.ACCEPTED);
    }

    protected ResponseEntity serverError() {
        return new ResponseEntity<>(new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    protected ResponseEntity notAuthorized() {
        return new ResponseEntity<>(new HttpHeaders(), HttpStatus.UNAUTHORIZED);
    }

}

