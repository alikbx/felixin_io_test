package com.felixin.test.service;

import com.felixin.test.repository.NumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NumberService {
    @Autowired
    NumberRepository numberRepository;

    public void createRandomNumber() {

    }

}
