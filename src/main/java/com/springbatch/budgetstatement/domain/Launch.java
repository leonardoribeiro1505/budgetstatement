package com.springbatch.budgetstatement.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Launch {
	private String descricao;
	private Date data;
	private Double valor;
}
