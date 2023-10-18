package com.springbatch.budgetstatement.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class LaunchGroup {
	private Integer codeExpense;
	private String descriptionExpense;
	private List<Launch> launches = new ArrayList<>();
	
	private Launch launchTmp;

	public Double getTotal() {
		return launches
				.stream()
				.mapToDouble(Launch::getValor)
				.reduce(0.0, Double::sum);
	}
}
