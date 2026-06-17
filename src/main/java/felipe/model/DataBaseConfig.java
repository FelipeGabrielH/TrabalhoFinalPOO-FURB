package felipe.model;

import java.io.File;
import java.io.FileWriter;

public class DataBaseConfig {
    public static final String PATH_DATABASE_RECEITAS = "src/main/resources/database/receitas.csv";
    public static final String PATH_DATABASE_DESPESAS = "src/main/resources/database/despesas.csv";

    public static void inicializarBanco() {
        try {
            File arquivoReceitas = new File(PATH_DATABASE_RECEITAS);
            File arquivoDespesas = new File(PATH_DATABASE_DESPESAS);

            if (arquivoReceitas.getParentFile() != null) {
                arquivoReceitas.getParentFile().mkdirs();
            }
            if (arquivoDespesas.getParentFile() != null) {
                arquivoDespesas.getParentFile().mkdirs();
            }

            if (!arquivoReceitas.exists()) {
                arquivoReceitas.createNewFile();
                try (FileWriter fw = new FileWriter(arquivoReceitas)) {
                    fw.write("Desc;Valor;DataCriacao;Categoria\n");
                }
            }

            if (!arquivoDespesas.exists()) {
                arquivoDespesas.createNewFile();
                try (FileWriter fw = new FileWriter(arquivoDespesas)) {
                    fw.write("Desc;Valor;DataCriacao;Categoria\n");
                }
            }

        } catch (Exception e) {
            throw new RuntimeException("Houve um problema ao criar o banco de dados :(", e);
        }
    }
}