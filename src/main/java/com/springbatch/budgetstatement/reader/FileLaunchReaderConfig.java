package com.springbatch.budgetstatement.reader;

import com.springbatch.budgetstatement.domain.Launch;
import com.springbatch.budgetstatement.domain.LaunchGroup;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FileLaunchReaderConfig {
	
	@Bean
	public FlatFileItemReader<LaunchGroup> arquivoLancamentoReader() {
		return new FlatFileItemReaderBuilder<LaunchGroup>()
				.name("arquivoLancamentoReader")
				.delimited()
				.names("codigoNaturezaDespesa", 
						"descricaoNaturezaDespesa", 
						"descricaoLancamento", 
						"dataLancamento", 
						"valorLancamento")
				.fieldSetMapper(grupoLancamentoFieldSetMapper())
				.build();
	}

	private FieldSetMapper<LaunchGroup> grupoLancamentoFieldSetMapper() {
		return fieldSet -> {
			LaunchGroup grupo = new LaunchGroup();
			grupo.setCodeExpense(fieldSet.readInt("codigoNaturezaDespesa"));
			grupo.setDescriptionExpense(fieldSet.readString("descricaoNaturezaDespesa"));
			grupo.setLaunchTmp(new Launch());
			grupo.getLaunchTmp().setData(fieldSet.readDate("dataLancamento"));
			grupo.getLaunchTmp().setDescricao(fieldSet.readString("descricaoLancamento"));
			grupo.getLaunchTmp().setValor(fieldSet.readDouble("valorLancamento"));
			return grupo;
		};
	}
}
