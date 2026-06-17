package felipe.model;

import java.io.File;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

class DataBaseConfigTest {
	
	@Test
	void testArquivoReceitas() {
		DataBaseConfig.inicializarBanco();
		File arquivoReceitas = new File("src/main/resources/database/receitas.csv");
        Assert.assertTrue(arquivoReceitas.exists());
	}
	
	@Test
	void testArquivoDespesas() {
		DataBaseConfig.inicializarBanco();
        File arquivoDespesas = new File("src/main/resources/database/despesas.csv");
        Assert.assertTrue(arquivoDespesas.exists());
	}

}
