package felipe.database;

import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class DatabaseConfig {
    public static final String PATH_DATABASE_RECEITAS = "src/main/resources/database/receitas.csv";
    public static final String PATH_DATABASE_DESPESAS = "src/main/resources/database/despesas.csv";

    public static void inicializarBanco(){
        try{
            Path pathDespesas = Paths.get(PATH_DATABASE_DESPESAS);
            Path pathReceitas = Paths.get(PATH_DATABASE_RECEITAS);

            Files.createDirectories(pathDespesas.getParent());
            Files.createDirectories(pathReceitas.getParent());


            if(Files.notExists(pathReceitas)){
                Files.createFile(pathReceitas);
                Files.writeString(pathReceitas, "id,Desc,Valoritos,DataCriacao,Categoria");
            }
            if(Files.notExists(pathDespesas)){
                Files.createFile(pathDespesas);
                Files.writeString(pathDespesas, "id,Desc,Valoritos,DataCriacao,Categoria");
            }

        }catch (FileAlreadyExistsException existsException){
            throw new RuntimeException("Banco de dados ja existe graças a Deus");
        }catch (Exception e){
            throw new RuntimeException("Problema ao criar o banco de dados que nao e um banco de dados");
        }
    }
}
