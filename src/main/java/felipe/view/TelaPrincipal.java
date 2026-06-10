package felipe.view;

import felipe.database.DatabaseConfig;
import felipe.model.CategoriaReceita;
import felipe.model.Receita;
import felipe.service.ControleFinanceiro;

import javax.swing.*;
import java.awt.*;
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

            JTextField descricaoField = new JTextField(15);
            JTextField valorField = new JTextField(15);

            JComboBox<CategoriaReceita> categoriaCombo =
                    new JComboBox<>(CategoriaReceita.values());

            JPanel panel = new JPanel(new GridLayout(0, 2, 5, 5));

            panel.add(new JLabel("Descrição:"));
            panel.add(descricaoField);

            panel.add(new JLabel("Valor:"));
            panel.add(valorField);

            panel.add(new JLabel("Categoria:"));
            panel.add(categoriaCombo);


            int result = JOptionPane.showConfirmDialog(
                    this,
                    panel,
                    "Nova Receita",
                    JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.PLAIN_MESSAGE
            );

            if (result == JOptionPane.OK_OPTION) {

                String descricao = descricaoField.getText();
                String valor = valorField.getText();
                CategoriaReceita categoria =
                        (CategoriaReceita) categoriaCombo.getSelectedItem();

                Receita receita =  new Receita(descricao,Double.parseDouble(valor), LocalDate.now(), categoria);

                controle.adicionarReceita(receita);

                JOptionPane.showMessageDialog(
                        this,
                        "Receita adicionada!"
                );
            }
        });

        btnSaldo.addActionListener(e ->
                JOptionPane.showMessageDialog(
                        this,
                        "Saldo: R$ " + controle.saldoAtual()
                )
        );
    }
}