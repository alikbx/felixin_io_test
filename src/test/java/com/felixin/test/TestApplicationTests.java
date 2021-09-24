package com.felixin.test;

import com.felixin.test.domain.FelixinNumber;
import com.felixin.test.service.NumberService;
import com.felixin.test.service.dtos.MiddleResponseDTO;
import com.felixin.test.web.rest.exception.OutOfBoundNumberException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;

@SpringBootTest(classes = TestApplication.class)
@Transactional
class TestApplicationTests {

    public static final int NUMBER = 5000001;
    public static final int WRONG_NUMBER = 10000;
    @Autowired
    NumberService numberService;

    @Test
    @DisplayName("Generate 1000 random number")
    void testGenerateNumber() {
        numberService.createRandomNumber();
        List<FelixinNumber> randomNumbers = numberService.getRandomNumbers();
        Assertions.assertEquals(1000, randomNumbers.size());
    }

    @Test
    @DisplayName("Find bigger and smaller Number")
    void testCheckNumber() throws OutOfBoundNumberException {
        MiddleResponseDTO middleResponseDTO = numberService.checkNumber(new FelixinNumber().setNumber(NUMBER));
        Assertions.assertEquals(10, middleResponseDTO.getBigger().size());
        Assertions.assertEquals(10, middleResponseDTO.getSmaller().size());
        Assertions.assertTrue(middleResponseDTO.getSmaller().stream().findFirst().get().getNumber() < NUMBER);
        Assertions.assertTrue(middleResponseDTO.getBigger().stream().findFirst().get().getNumber() > NUMBER);
    }
}
