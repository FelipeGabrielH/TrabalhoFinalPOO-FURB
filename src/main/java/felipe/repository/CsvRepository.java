package felipe.repository;

import felipe.database.DatabaseConfig;
import felipe.model.CategoriaReceita;
import felipe.model.Despesa;
import felipe.model.Receita;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CsvRepository extends DatabaseConfig {

    DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public void insertReceitas(Receita receita) {
        Path path = Paths.get(PATH_DATABASE_RECEITAS);
        String descricao = receita.getDescricao();
        String valor = String.format("%s", receita.getValor());
        CategoriaReceita categoriaReceita = receita.getReceita();
        LocalDate localDate = receita.getData();
        CharSequence charSequence = descricao + ";" + valor + ";" + categoriaReceita + ";" + localDate + "\n";
        try {
            Files.writeString(path, charSequence, StandardOpenOption.APPEND);

        } catch (Exception e) {
            throw new RuntimeException("Erro ao criar sabomba", e);
        }

    }

    public void insertDespesas(Despesa despesa) {

    }

    public List<Receita> findAllReceita() {
        Path path = Paths.get(PATH_DATABASE_RECEITAS);
        try {
            List<Receita> receitas = new ArrayList<>();
            List<String> linhas = Files.readAllLines(path);

            for (int i = 1; i < linhas.size(); i++) {
                String linha = linhas.get(i);

                String[] dados = linha.split(";");

                Receita receita = new Receita(
                        dados[0],
                        Double.parseDouble(dados[1]),
                        LocalDate.parse(dados[3],formatter),
                        CategoriaReceita.valueOf(dados[2])
                );
                receitas.add(receita);
            }
            return receitas;
        } catch (Exception e) {
            throw new RuntimeException("Nao achou é nothing",e);
        }
    }
}
