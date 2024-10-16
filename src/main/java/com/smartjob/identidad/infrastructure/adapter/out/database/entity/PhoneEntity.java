package com.smartjob.identidad.infrastructure.adapter.out.database.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "phone")
@Entity
public class PhoneEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "phone_id_seq")
    @SequenceGenerator(name = "phone_id_seq", sequenceName = "phone_id_seq", allocationSize = 1)
    private Long id;
    private String number;
    
    @Column(name = "city_code")
    private String cityCode;
    
    @Column(name = "country_code")
    private String countryCode;
    
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private UserEntity customer;
    
}