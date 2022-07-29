package com.componentprocessing.pojo;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


// capturing the details of repair
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class RepairProcessService implements Service {
	private int processingDays= 5;
	private double processingAmount=500;

}
