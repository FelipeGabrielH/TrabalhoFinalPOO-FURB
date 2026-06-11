package felipe.repository;

import felipe.database.DatabaseConfig;
import felipe.model.CategoriaReceita;
import felipe.model.Despesa;
import felipe.model.Receita;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CsvRepository extends DatabaseConfig {

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public void insertReceitas(Receita receita) {
        // Instancia o arquivo usando o java.io.File
        File arquivo = new File(PATH_DATABASE_RECEITAS);

        String linha = receita.getDescricao() + ";" +
                receita.getValor() + ";" +
                receita.getReceita() + ";" +
                receita.getData();

        // O 'true' no FileWriter serve para fazer o APPEND (acrescentar ao final do arquivo)
        try (FileWriter fw = new FileWriter(arquivo, true);
             BufferedWriter bw = new BufferedWriter(fw)) {

            bw.write(linha);
            bw.newLine(); // Adiciona a quebra de linha de forma segura operacionalmente

        } catch (Exception e) {
            throw new RuntimeException("Erro ao criar sabomba", e);
        }
    }

    public void insertDespesas(Despesa despesa) {
        // Implementação futura...
    }

    public List<Receita> findAllReceita() {
        File arquivo = new File(PATH_DATABASE_RECEITAS);
        List<Receita> receitas = new ArrayList<>();

        // Usamos BufferedReader para ler o arquivo linha por linha de forma eficiente
        try (FileReader fr = new FileReader(arquivo);
             BufferedReader br = new BufferedReader(fr)) {

            String linha;
            boolean primeiraLinha = true;

            while ((linha = br.readLine()) != null) {
                // Pula o cabeçalho do CSV
                if (primeiraLinha) {
                    primeiraLinha = false;
                    continue;
                }

                String[] dados = linha.split(";");

                Receita receita = new Receita(
                        dados[0],
                        Double.parseDouble(dados[1]),
                        LocalDate.parse(dados[3], formatter),
                        CategoriaReceita.valueOf(dados[2])
                );
                receitas.add(receita);
            }
            return receitas;

        } catch (Exception e) {
            throw new RuntimeException("Nao achou é nothing", e);
        }
    }
}