package felipe.view;

import felipe.database.DatabaseConfig;
import felipe.model.CategoriaReceita;
import felipe.model.Receita;
import felipe.service.ControleFinanceiro;

import javax.swing.*;
import java.time.LocalDate;

public class TelaPrincipal extends JFrame {

    private final ControleFinanceiro controle = new ControleFinanceiro();

    public TelaPrincipal() {
        DatabaseConfig.inicializarBanco();

        setTitle("Controle Financeiro");
        setSize(500, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JButton btnReceita = new JButton("Adicionar Receita");
        JButton btnSaldo = new JButton("Consultar Saldo");

        JPanel painel = new JPanel();

        painel.add(btnReceita);
        painel.add(btnSaldo);

        add(painel);

        btnReceita.addActionListener(e -> {

            Receita receita = new Receita(
                    "Salário",
                    5000.0,
                    LocalDate.now(),
                    CategoriaReceita.SALARIO
            );

            controle.adicionarReceita(receita);

            JOptionPane.showMessageDialog(
                    this,
                    "Receita adicionada!"
            );
        });

        btnSaldo.addActionListener(e ->
                JOptionPane.showMessageDialog(
                        this,
                        "Saldo: R$ " + controle.saldoAtual()
                )
        );
    }
}