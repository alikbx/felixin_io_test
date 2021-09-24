package com.felixin.test.service.dtos;

import com.felixin.test.domain.FelixinNumber;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class MiddleResponseDTO {
    private int numbers;
    private List<FelixinNumber> smaller;
    private List<FelixinNumber> bigger;
}
