package felipe.model;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class ReceitaTest {

	@Test
	void testCriar() {
		Receita receita = new Receita("Salário", 1050.00, LocalDate.of(2026, 2, 5), "Salário");
		Assert.assertNotNull(receita);
	}
	
	@Test
	void testDescricao() {
		Exception ex = assertThrows(IllegalArgumentException.class, () -> {
			Receita receita = new Receita("         ", 1050.00, LocalDate.of(2026, 2, 5), "Salário");
		});
	}
	
	@Test
	void testData() {
		Exception ex = assertThrows(IllegalArgumentException.class, () -> {
			Receita receita = new Receita("Salário", 1050.00, null, "Salário");
		});
	}
	
	@Test
	void testCategoria() {
		Exception ex = assertThrows(IllegalArgumentException.class, () -> {
			Receita receita = new Receita("Salário", 1050.00, LocalDate.of(2026, 2, 5), "");
		});
	}
}
