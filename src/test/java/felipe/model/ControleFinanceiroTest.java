package felipe.model;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class ControleFinanceiroTest {
	private final ControleFinanceiro controle = new ControleFinanceiro();

	@Test
	void testAdicionarReceita() {
		Receita receita = new Receita("Salário", 1230.00, LocalDate.of(2026, 2, 5), "Salário");
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
		Assert.assertTrue(controle.listarReceitas().size() > 0);;
	}
	
	@Test
	void testListarDespesas() {
		Assert.assertTrue(controle.listarDespesas().size() > 0);
	}
	
	@Test
	void testListarLancamentos() {
		Assert.assertTrue(controle.listarLancamentos().size() > 0);
	}
}
