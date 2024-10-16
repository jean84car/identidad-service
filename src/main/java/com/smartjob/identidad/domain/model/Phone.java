package com.smartjob.identidad.domain.model;

import lombok.Data;

@Data
public class Phone {

	private Long id;
    private String number;
    private String citycode;
    private String contrycode;
	
}
