package felipe.model;

import java.time.LocalDate;

public class Despesa extends Lancamento{

    public Despesa(String descricao, double valor, LocalDate data, String categoria){
        super(descricao, valor > 0 ? -valor : valor, data, categoria);
    }
}
