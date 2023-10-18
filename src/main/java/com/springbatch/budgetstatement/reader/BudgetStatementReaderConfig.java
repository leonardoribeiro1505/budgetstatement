package com.springbatch.budgetstatement.reader;

import com.springbatch.budgetstatement.domain.LaunchGroup;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.MultiResourceItemReader;
import org.springframework.batch.item.file.builder.MultiResourceItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
public class BudgetStatementReaderConfig {

	@StepScope
	@Bean
	public MultiResourceItemReader<LaunchGroup> budgetStatementReader(
			@Value("#{jobParameters['launchFiles']}") Resource[] launchFiles,
			GroupLaunchReader groupLaunchReader) {
		return new MultiResourceItemReaderBuilder<LaunchGroup>()
				.name("budgetStatementReader")
				.resources(launchFiles)
				.delegate(groupLaunchReader)
				.build();
	}
}
