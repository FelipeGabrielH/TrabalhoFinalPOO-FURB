package felipe.model;

import java.time.LocalDate;

public class Receita extends Lancamento {
    CategoriaReceita receita;

    public Receita(String descricao,double valor,LocalDate data,String categoria) {
        super(descricao, valor, data, categoria);
    }

}
