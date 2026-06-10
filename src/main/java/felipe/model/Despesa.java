package felipe.model;

import java.time.LocalDate;

public class Despesa extends Lancamento{
    private CategoriaDespesa despesa;

    public Despesa(String descricao, double valor, LocalDate data, CategoriaDespesa categoria){
        super(descricao,valor,data);
        this.despesa = categoria;
    }


    public CategoriaDespesa getReceita() {
        return despesa;
    }
}
