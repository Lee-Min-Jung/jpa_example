package com.example.jpa_example.domain;

import com.example.jpa_example.domain.enu.DeliveryStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "delivery")
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "delivery_id")
    private Long id;

    @OneToOne(mappedBy = "delivery")
    private Orders order;

    private Address address;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;
}
