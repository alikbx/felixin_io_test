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

    /**
     * first delete all records in the database,then
     * generates a thousand random numbers in the start and end intervals
     */
    public void createRandomNumber() {
        numberRepository.deleteAll();
        Random r = new Random();
        int[] randomNumbers = r.ints(COUNT, START, END).toArray();
        Arrays.stream(randomNumbers).forEach(value -> numberRepository.save(new FelixinNumber().setNumber(value)));
    }

    /**
     * Retrieve all records in the database
     *
     * @return List of numbers
     */
    public List<FelixinNumber> getRandomNumbers() {
        return numberRepository.findAll();
    }

    /**
     * This function first checks the input number that is between the start and end intervals,
     * then searches the database and finds 10 numbers smaller than this number and 10 numbers larger than this number.
     *
     * @param felixinNumber middle number
     * @return MiddleResponseDTO contain bigger and smaller list
     * @throws RuntimeException
     */
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
