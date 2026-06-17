package felipe.model;

import java.io.File;
import java.io.FileWriter;

/**
 * Classe de configuração e inicialização do banco de dados baseado em arquivos.
 * Define os caminhos estruturais dos arquivos CSV e garante a criação da árvore
 * de diretórios e arquivos necessários para o funcionamento do sistema.
 * @version 1.0
 */
public class DataBaseConfig {

    /**
     * Caminho relativo para o arquivo de armazenamento das receitas.
     */
    public static final String PATH_DATABASE_RECEITAS = "src/main/resources/database/receitas.csv";

    /**
     * Caminho relativo para o arquivo de armazenamento das despesas.
     */
    public static final String PATH_DATABASE_DESPESAS = "src/main/resources/database/despesas.csv";

    /**
     * Inicializa o banco de dados do sistema.
     * O método verifica a existência dos diretórios necessários e os cria caso não existam.
     * Em seguida, verifica a existência dos arquivos CSV de receitas e despesas. Se algum
     * arquivo estiver ausente, ele é criado e inicializado com o respectivo cabeçalho
     * * @throws RuntimeException Se ocorrer qualquer falha crítica de E/S (I/O) durante a
     * criação dos diretórios ou arquivos.
     */
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