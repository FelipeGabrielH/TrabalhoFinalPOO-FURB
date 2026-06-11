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
        File arquivo = new File(PATH_DATABASE_RECEITAS);

        String linha = receita.getDescricao() + ";" +
                receita.getValor() + ";" +
                receita.getReceita() + ";" +
                receita.getData();

        try (FileWriter fw = new FileWriter(arquivo, true);
             BufferedWriter bw = new BufferedWriter(fw)) {

            bw.write(linha);
            bw.newLine();

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

        try (FileReader fr = new FileReader(arquivo);
             BufferedReader br = new BufferedReader(fr)) {

            String linha;
            boolean primeiraLinha = true;

            while ((linha = br.readLine()) != null) {
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