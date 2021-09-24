package com.felixin.test.service;

import com.felixin.test.domain.FelixinNumber;
import com.felixin.test.repository.NumberRepository;
import com.felixin.test.service.dtos.MiddleResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
public class NumberService {

    private static final int START = 3000000;
    private static final int END = 6000000;
    private static final int COUNT = 1000;


    @Autowired
    NumberRepository numberRepository;

    public void createRandomNumber() {
        numberRepository.deleteAll();
        Random r = new Random();
        int[] randomNumbers = r.ints(COUNT, START, END).toArray();
        Arrays.stream(randomNumbers).forEach(value -> numberRepository.save(new FelixinNumber().setNumber(value)));
    }

    public List<FelixinNumber> getRandomNumbers() {
        return numberRepository.findAll();
    }

    public MiddleResponseDTO checkNumber(FelixinNumber felixinNumber) throws RuntimeException {
        if (felixinNumber.getNumber() <= END && felixinNumber.getNumber() >= START) {
            return new MiddleResponseDTO().setNumbers(felixinNumber.getNumber())
                    .setBigger(numberRepository.findTop10ByNumberGreaterThanOrderByNumberAsc(felixinNumber.getNumber()))
                    .setSmaller(numberRepository.findTop10ByNumberLessThanOrderByNumberDesc(felixinNumber.getNumber()));
        } else {
            throw new RuntimeException();
        }
    }

}
