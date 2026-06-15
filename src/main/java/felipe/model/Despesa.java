package felipe.model;

import java.time.LocalDate;

public class Despesa extends Lancamento{
    private CategoriaDespesa despesa;

    public Despesa(String descricao, double valor, LocalDate data, String categoria){
        super(descricao,valor,data, categoria);
    }

}
