package com.springbatch.budgetstatement.writer;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;

import com.springbatch.budgetstatement.domain.Launch;
import com.springbatch.budgetstatement.domain.LaunchGroup;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class BudgetStatementWriterConfig {

	@Bean
	public ItemWriter<LaunchGroup> budgetStatementWriter() {
		return itens -> {
			log.info("---- Demonstrativo orçamentário ----");
			for (LaunchGroup group : itens) {
				log.info("[{}] {} - {}", group.getCodeExpense(), group.getDescriptionExpense(), NumberFormat.getCurrencyInstance().format(group.getTotal()));
				for (Launch launch : group.getLaunches()) {
					log.info("[{}] {} - {}", new SimpleDateFormat("dd/MM/yyyy").format(launch.getData()), launch.getDescricao(), NumberFormat.getCurrencyInstance().format(launch.getValor()));
				}
			}
		};
	}
}
