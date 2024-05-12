package com.example.tourism.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_table")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    @NotBlank
    private String firstname;
    @NotNull
    @NotBlank
    private String lastname;
    @NotNull
    @NotBlank
    private String phone;
    @NotNull
    @NotBlank
    private String email;
    @NotNull
    @NotBlank
    private String password;
    private String token;
    private Role role;


    @OneToMany(cascade = CascadeType.REMOVE)
    @JsonIgnore
    @JsonManagedReference
    private List<Booking> bookingList;

    @OneToMany(cascade = CascadeType.REMOVE)
    @JsonIgnore
    @JsonManagedReference
    private List<Order> orderList;
}

