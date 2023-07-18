package com.guvenkarabulut.forumwebapi.entity;

import jakarta.persistence.*;
import lombok.*;

import java.net.URL;
import java.util.Date;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "user_id_seq")
    @SequenceGenerator(name = "user_id_seq")
    @Column(name = "user_id")
    private int id;
    @Column(length = 50,unique = true)
    private String email;
    @Column(length = 50)
    private String firstname;
    @Column(length = 50)
    private String lastname;
    @Column(length = 50)
    private String password;
    @Column(nullable = true,length = 500)
    private String profilImageUrl;
    private Date createTime;
    private boolean isActive;
}
