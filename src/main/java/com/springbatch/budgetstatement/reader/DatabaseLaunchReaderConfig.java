package com.springbatch.budgetstatement.reader;

import com.springbatch.budgetstatement.domain.Launch;
import com.springbatch.budgetstatement.domain.LaunchGroup;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;

@Configuration
public class DatabaseLaunchReaderConfig {

	@Bean
	public JdbcCursorItemReader<LaunchGroup> databaseLaunchReader(@Qualifier("appDataSource") DataSource dataSource) {
		return new JdbcCursorItemReaderBuilder<LaunchGroup>()
				.name("databaseLaunchReader")
				.dataSource(dataSource)
				.sql("select * from launch")
				.rowMapper(rowMapper())
				.build();
	}

	private RowMapper<LaunchGroup> rowMapper() {
		return (rs, rowNum) -> {
			LaunchGroup group = new LaunchGroup();
			group.setCodeExpense(rs.getInt("codeExpense"));
			group.setDescriptionExpense(rs.getString("descriptionExpense"));
			group.setLaunchTmp(new Launch());
			group.getLaunchTmp().setData(rs.getDate("dateLaunch"));
			group.getLaunchTmp().setDescricao(rs.getString("descriptionLaunch"));
			group.getLaunchTmp().setValor(rs.getDouble("amountLaunch"));
			return group;
		};
	}
}
