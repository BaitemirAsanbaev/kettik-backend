package com.example.tourism.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "order_table")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String note;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    private User user;

    public Long getUserId() {
        return user != null ? user.getId() : null;
    }
}
