package felipe.view;

import felipe.database.DatabaseConfig;
import felipe.model.CategoriaReceita;
import felipe.model.Receita;
import felipe.service.ControleFinanceiro;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.util.List;

public class TelaPrincipal extends JFrame {

    private final ControleFinanceiro controle = new ControleFinanceiro();

    public TelaPrincipal() {
        DatabaseConfig.inicializarBanco();

        setTitle("Controle Financeiro");
        setSize(500, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JButton btnReceita = new JButton("Adicionar Receita");
        JButton btnMostrarReceita = new JButton("Consultar Receitas");

        JPanel painel = new JPanel();

        painel.add(btnReceita);
        painel.add(btnMostrarReceita);

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
                System.out.println("LOCAL DATE NOW "+LocalDate.now());
                Receita receita =  new Receita(descricao,Double.parseDouble(valor), LocalDate.now(), categoria);

                controle.adicionarReceita(receita);

                JOptionPane.showMessageDialog(
                        this,
                        "Receita adicionada!"
                );
            }
        });

        btnMostrarReceita.addActionListener(e -> {

            List<Receita> receitas = controle.listarReceitas();

            StringBuilder mensagem = new StringBuilder();

            for (Receita receita : receitas) {
                mensagem.append("Descrição: ")
                        .append(receita.getDescricao())
                        .append("\nValor: R$ ")
                        .append(receita.getValor())
                        .append("\nCategoria: ")
                        .append(receita.getReceita())
                        .append("\nData: ")
                        .append(receita.getData())
                        .append("\n\n");
            }

            JOptionPane.showMessageDialog(
                    this,
                    mensagem.toString()
            );
        });
    }
}