package felipe.model;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class DespesaTest {

	@Test
	void testCriar() {
		Despesa despesa = new Despesa("Compras", 250.00, LocalDate.of(2026, 2, 6), "Alimentação");
		Assert.assertNotNull(despesa);
	}
	
	@Test
	void testDescricao() {
		Exception ex = assertThrows(IllegalArgumentException.class, () -> {
			Despesa despesa = new Despesa("         ", 250.00, LocalDate.of(2026, 2, 6), "Alimentação");
		});
	}
	
	@Test
	void testData() {
		Exception ex = assertThrows(IllegalArgumentException.class, () -> {
			Despesa despesa = new Despesa("Compras", 250.00, null, "Alimentação");
		});
	}
	
	@Test
	void testCategoria() {
		Exception ex = assertThrows(IllegalArgumentException.class, () -> {
			Despesa despesa = new Despesa("Compras", 250.00, LocalDate.of(2026, 2, 6), "");
		});
	}
}
