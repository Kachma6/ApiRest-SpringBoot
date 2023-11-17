package com.diplomado.ApiRestSpringBoot.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@Entity
@Table(name = "user_detail")
public class UserDetail {
    @Id
    @SequenceGenerator(name = "user_detail_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator =  "user_detail_sequence")
    private Integer id;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private Integer age;
    @Column(name = "birth_day", columnDefinition = "DATE")
    private LocalDate birthDay;

    public UserDetail() {
    }

    public UserDetail(String firstName, String lastName, Integer age, LocalDate birthDay) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.birthDay = birthDay;
    }
}
