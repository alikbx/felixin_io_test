package com.felixin.test.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "number")
@Data
public class FelixinNumber {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long number_id;
    private Long number;
}
