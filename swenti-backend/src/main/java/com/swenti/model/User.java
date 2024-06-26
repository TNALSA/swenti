package com.swenti.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private LocalDateTime birth;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String phone;
}

//public boolean duplicationId(String id){
//
//}
