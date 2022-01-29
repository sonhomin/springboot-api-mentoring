package com.example.springbootapi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder

public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String number;

    private String email;

    public static Member toEntity(MemberCreateRequest request) {
        return Member.builder()
                .name(request.getName())
                .number(request.getNumber())
                .email(request.getEmail())
                .build();
    }

    public void updateName(String name){
        this.name = name;
    }
}