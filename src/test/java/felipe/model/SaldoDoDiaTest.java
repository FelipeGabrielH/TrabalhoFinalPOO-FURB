package felipe.model;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class SaldoDoDiaTest {

	@Test
	void testCriar() {
		SaldoDoDia saldoDoDia = new SaldoDoDia(1050.00, LocalDate.of(2026, 2, 5));
		Assert.assertNotNull(saldoDoDia);
	}
	
	@Test
	void testData() {
		Exception ex = assertThrows(IllegalArgumentException.class, () -> {
			SaldoDoDia saldoDoDia = new SaldoDoDia(1050.00, null);
		});
	}
}
