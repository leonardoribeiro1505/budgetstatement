package com.springbatch.budgetstatement.reader;

import com.springbatch.budgetstatement.domain.LaunchGroup;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.batch.item.ItemStreamReader;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.file.ResourceAwareItemReaderItemStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

@Component
public class GroupLaunchReader implements ItemStreamReader<LaunchGroup>, ResourceAwareItemReaderItemStream<LaunchGroup> {

	@Autowired
	private JdbcCursorItemReader<LaunchGroup> delegate;
	private LaunchGroup lancamentoAtual;

	@Override
	public void open(ExecutionContext executionContext) throws ItemStreamException {
		delegate.open(executionContext);
	}

	@Override
	public void update(ExecutionContext executionContext) throws ItemStreamException {
		delegate.update(executionContext);
	}

	@Override
	public void close() throws ItemStreamException {
		delegate.close();
	}

	@Override
	public void setResource(Resource resource) {
		// Descomentar para a leitura de arquivo
		//delegate.setResource(resource);
	}
	
	@Override
	public LaunchGroup read() throws Exception {
		if (lancamentoAtual == null) {
			lancamentoAtual = delegate.read();
		}

		LaunchGroup launchGroup = lancamentoAtual;
		lancamentoAtual = null;
		
		if (launchGroup != null) {
			LaunchGroup proxLancamento = peek();
			while (isLancamentoRelacionado(launchGroup, proxLancamento)) {
				launchGroup.getLaunches().add(lancamentoAtual.getLaunchTmp());
				proxLancamento = peek();
			}			
			launchGroup.getLaunches().add(launchGroup.getLaunchTmp());
		}
		return launchGroup;
	}

	private boolean isLancamentoRelacionado(LaunchGroup launchGroup, LaunchGroup proxLancamento) {
		return proxLancamento != null && proxLancamento.getCodeExpense().equals(launchGroup.getCodeExpense());
	}
	
	public LaunchGroup peek() throws Exception {
		lancamentoAtual = delegate.read();
		return lancamentoAtual;
	}
}
