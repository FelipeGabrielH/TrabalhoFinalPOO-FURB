package felipe.model;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class ControleFinanceiroTest {
	private final ControleFinanceiro controle = new ControleFinanceiro();

	@Test
	void testAdicionarReceita() {
		Receita receita = new Receita("Salário", 1050.00, LocalDate.of(2026, 2, 5), "Salário");
		try {
			controle.adicionarReceita(receita);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File arquivoReceitas = new File("src/main/resources/database/receitas.csv");
		Assert.assertTrue(arquivoReceitas.exists());
	}
	
	@Test
	void testAdicionarDespesa() {
		Despesa despesa = new Despesa("Compras", 250.00, LocalDate.of(2026, 2, 6), "Alimentação");
		try {
			controle.adicionarDespesa(despesa);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File arquivoDespesas = new File("src/main/resources/database/despesas.csv");
		Assert.assertTrue(arquivoDespesas.exists());
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
