package com.springbatch.budgetstatement.step;

import com.springbatch.budgetstatement.domain.LaunchGroup;
import com.springbatch.budgetstatement.reader.GroupLaunchReader;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BudgetStatementStepConfig {

	public final StepBuilderFactory stepBuilderFactory;

	public BudgetStatementStepConfig(StepBuilderFactory stepBuilderFactory) {
		this.stepBuilderFactory = stepBuilderFactory;
	}

	@Bean
	public Step demonstrativoOrcamentarioStep(
			GroupLaunchReader demonstrativoOrcamentarioReader,
			ItemWriter<LaunchGroup> demonstrativoOrcamentarioWriter) {
		return stepBuilderFactory
				.get("demonstrativoOrcamentarioStep")
				.<LaunchGroup, LaunchGroup>chunk(1)
				.reader(demonstrativoOrcamentarioReader)
				.writer(demonstrativoOrcamentarioWriter)
				.build();
	}
}
