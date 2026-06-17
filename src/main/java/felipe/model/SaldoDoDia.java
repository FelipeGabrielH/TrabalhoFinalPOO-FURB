package felipe.model;

import java.time.LocalDate;

public class SaldoDoDia extends Lancamento{

        public SaldoDoDia(double valor,LocalDate data) {
            super("SALDO DO DIA", valor, data, "SALDO DO DIA");
        }

}
