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
import java.util.List;

public class CsvRepository extends DatabaseConfig {
    public void insertReceitas(Receita receita){
        Path path = Paths.get(PATH_DATABASE_RECEITAS);
        String descricao = receita.getDescricao();
        String valor = String.format("%s",receita.getValor());
        CategoriaReceita categoriaReceita = receita.getReceita();
        LocalDate localDate = receita.getData();
        CharSequence charSequence = descricao+";"+valor+";"+categoriaReceita+ ";"+localDate+"\n";
        try {
            Files.writeString(path, charSequence,StandardOpenOption.APPEND);

        }catch (Exception e){
            throw new RuntimeException("Erro ao criar sabomba",e);
        }

    }
    public void insertDespesas(Despesa despesa){

    }
 //   public List<Receita> findAllReceita(){
//        Path path = Paths.get(PATH_DATABASE_RECEITAS);
//        try{

//        }catch (Exception e){

    //    }
    //}
    //public List<Despesa> findAllDepesa(){
    //}
}
