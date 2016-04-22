package com.devtechgroup.ems.controller;

import com.devtechgroup.ems.business.logic.model.CustomerDto;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController extends BaseApiController {

    @RequestMapping("/api/test")
    public ResponseEntity test() {
        CustomerDto logedinUser = (CustomerDto) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();

        System.out.println(logedinUser.getEmail());

        return ok(null);
    }

}
