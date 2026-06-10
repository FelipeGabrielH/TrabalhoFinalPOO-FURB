package felipe.service;

import felipe.model.Despesa;
import felipe.model.Receita;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ControleFinanceiro {

    private List<Receita> receitas = new ArrayList<>();
    private List<Despesa> despesas = new ArrayList<>();

    public void adicionarReceita(Receita receita) {
        receitas.add(receita);

    }

    public void adicionarDespesa(Despesa despesa) {
        despesas.add(despesa);
    }

    public double saldoAtual() {

        double receitasTotal = receitas.stream()
                .filter(r -> !r.getData().isAfter(LocalDate.now()))
                .mapToDouble(Receita::getValor)
                .sum();

        double despesasTotal = despesas.stream()
                .filter(d -> !d.getData().isAfter(LocalDate.now()))
                .mapToDouble(Despesa::getValor)
                .sum();

        return receitasTotal - despesasTotal;
    }

    public double saldoTotal() {

        double receitasTotal = receitas.stream()
                .mapToDouble(Receita::getValor)
                .sum();

        double despesasTotal = despesas.stream()
                .mapToDouble(Despesa::getValor)
                .sum();

        return receitasTotal - despesasTotal;
    }

    public List<Receita> listarReceitas() {
        return receitas;
    }

    public List<Despesa> listarDespesas() {
        return despesas;
    }
}