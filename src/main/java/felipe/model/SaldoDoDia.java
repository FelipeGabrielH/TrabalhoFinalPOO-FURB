package felipe.model;

import java.time.LocalDate;

public class SaldoDoDia extends Lancamento{

        public SaldoDoDia(LocalDate data, double valor, String categoria) {
            super("SALDO DO DIA", valor, data, categoria);
        }

}
