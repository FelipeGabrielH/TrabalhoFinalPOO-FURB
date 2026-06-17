package felipe.model;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class ControleFinanceiroTest {
	private final ControleFinanceiro controle = new ControleFinanceiro();

	@Test
	void testAdicionarReceita() {
		DataBaseConfig.inicializarBanco();
		Receita receita = new Receita("Salário", 1050.00, LocalDate.of(2026, 2, 5), "Salário");
		boolean armazenou = false;
		try {
			controle.adicionarReceita(receita);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Receita> receitas = controle.listarReceitas();

		for(Receita r : receitas) {
			if(receita.equals(r)) {
				armazenou = true;
			}
		}
		
		Assert.assertTrue(armazenou);
	}
	
	@Test
	void testAdicionarDespesa() {
		Despesa despesa = new Despesa("Compras", 250.00, LocalDate.of(2026, 2, 6), "Alimentação");
		boolean armazenou = false;
		try {
			controle.adicionarDespesa(despesa);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<Despesa> despesas = controle.listarDespesas();

		for(Despesa d : despesas) {
			if(despesa.equals(d)) {
				armazenou = true;
			}
		}
		
		Assert.assertTrue(armazenou);
	}
	
	@Test
	void testListarReceitas() {
		assertInstanceOf(List.class, controle.listarReceitas());
	}
	
	@Test
	void testListarDespesas() {
		assertInstanceOf(List.class, controle.listarDespesas());
	}
	
	@Test
	void testListarLancamentos() {
		assertInstanceOf(List.class, controle.listarLancamentos());
	}

}
