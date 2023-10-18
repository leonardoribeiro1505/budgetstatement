package com.springbatch.budgetstatement.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class BudgetStatementJobConfig {

	@Bean
	public Job budgetStatementJob(Step budgetStatementStep, JobBuilderFactory jobBuilderFactory) {
		return jobBuilderFactory
				.get("budgetStatementJob")
				.start(budgetStatementStep)
				.incrementer(new RunIdIncrementer())
				.build();
	}
}
