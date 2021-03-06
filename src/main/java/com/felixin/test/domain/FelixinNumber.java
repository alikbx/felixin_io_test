package com.felixin.test.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity
@Table(name = "felixin_number")
@Data
@Accessors(chain = true)
public class FelixinNumber {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long number_id;
    @Column(name = "f_number")
    private int number;
}
