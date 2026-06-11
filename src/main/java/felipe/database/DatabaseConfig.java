package felipe.database;

import java.io.File;
import java.io.FileWriter;

public class DatabaseConfig {
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
                    fw.write("Desc;Valoritos;DataCriacao;Categoria\n");
                }
            }

            if (!arquivoDespesas.exists()) {
                arquivoDespesas.createNewFile();
                try (FileWriter fw = new FileWriter(arquivoDespesas)) {
                    fw.write("id;Desc;Valoritos;DataCriacao;Categoria\n");
                }
            }

        } catch (Exception e) {
            throw new RuntimeException("Problema ao criar o banco de dados que nao e um banco de dados", e);
        }
    }
}