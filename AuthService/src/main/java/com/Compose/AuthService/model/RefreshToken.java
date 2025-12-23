package com.Compose.AuthService.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class RefreshToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String token;
    private boolean isExpired;
    private LocalDateTime expireDate;

    @ManyToOne
    private User user;
}
