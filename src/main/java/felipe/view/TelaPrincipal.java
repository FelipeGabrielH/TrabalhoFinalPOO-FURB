package felipe.view;

import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.swing.JOptionPane;

import felipe.model.ControleFinanceiro;
import felipe.model.Despesa;
import felipe.model.Lancamento;
import felipe.model.Receita;

/**
 *
 * @author vinicius.amorim
 */
public class TelaPrincipal extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;
    private final ControleFinanceiro controle = new ControleFinanceiro();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public TelaPrincipal() {
        initComponents();
        setLocationRelativeTo(null);
    }
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        labelAtual = new javax.swing.JLabel();
        labelTotal = new javax.swing.JLabel();
        jAtualizar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Seja bem vindo, usuário!");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        jPanel2.setPreferredSize(new java.awt.Dimension(300, 70));

        labelAtual.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelAtual.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        controle.setSaldoAtual();
        labelAtual.setText("Saldo atual: R$" + controle.getSaldoAtual());
        labelAtual.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        labelTotal.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        controle.setSaldoTotal();
        labelTotal.setText("Saldo total: R$" + controle.getSaldoTotal());
        labelTotal.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jAtualizar.setFont(new java.awt.Font("Segoe UI Symbol", 0, 12)); // NOI18N
        jAtualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Screenshot_20.png"))); // NOI18N
        jAtualizar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        jAtualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jAtualizar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jAtualizar.setMaximumSize(new java.awt.Dimension(45, 70));
        jAtualizar.setMinimumSize(new java.awt.Dimension(45, 70));
        jAtualizar.setPreferredSize(new java.awt.Dimension(45, 70));
        jAtualizar.addActionListener(this::jAtualizarActionPerformed);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(labelTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(labelAtual, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(labelAtual, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );

        jButton2.setText("Incluir Despesa");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.setMaximumSize(new java.awt.Dimension(106, 23));
        jButton2.setMinimumSize(new java.awt.Dimension(106, 23));
        jButton2.setPreferredSize(new java.awt.Dimension(140, 30));
        jButton2.addActionListener(this::jButton2ActionPerformed);

        jButton4.setText("Listar Despesas");
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.setMaximumSize(new java.awt.Dimension(106, 23));
        jButton4.setMinimumSize(new java.awt.Dimension(106, 23));
        jButton4.setOpaque(true);
        jButton4.setPreferredSize(new java.awt.Dimension(140, 30));
        jButton4.addActionListener(this::jButton4ActionPerformed);

        jButton1.setText("Incluir Receita");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setMaximumSize(new java.awt.Dimension(106, 23));
        jButton1.setMinimumSize(new java.awt.Dimension(106, 23));
        jButton1.setPreferredSize(new java.awt.Dimension(140, 30));
        jButton1.addActionListener(this::jButton1ActionPerformed);

        jButton5.setText("Listar Lançamentos");
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.setPreferredSize(new java.awt.Dimension(300, 30));
        jButton5.addActionListener(this::jButton5ActionPerformed);

        jButton3.setText("Listar Receitas");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.setPreferredSize(new java.awt.Dimension(140, 30));
        jButton3.addActionListener(this::jButton3ActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
                        .addGroup(layout.createSequentialGroup()
                                .addGap(164, 164, 164)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(20, 20, 20)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addGap(164, 164, 164))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45)
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(55, 55, 55))
        );

        pack();
    }// </editor-fold>

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ReceitaForm receita = new ReceitaForm();
        receita.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        DespesaForm receita = new DespesaForm();
        receita.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {

        List<Receita> receitas = controle.listarReceitas();

        StringBuilder mensagem = new StringBuilder();

        if(receitas.size() == 0) {
            JOptionPane.showMessageDialog(this,"Não há receitas cadastradas");
        } else {
            for (Receita receita : receitas) {
                mensagem.append("Descrição: ")
                        .append(receita.getDescricao())
                        .append("\nValor: R$ ")
                        .append(receita.getValor())
                        .append("\nCategoria: ")
                        .append(receita.getReceita())
                        .append("\nData: ")
                        .append(receita.getData().format(formatter))
                        .append("\n\n");
            }
            JOptionPane.showMessageDialog(this,mensagem.toString());
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        List<Despesa> despesas = controle.listarDespesas();

        StringBuilder mensagem = new StringBuilder();

        if(despesas.size() == 0) {
            JOptionPane.showMessageDialog(this,"Não há despesas cadastradas");
        } else {
            for (Despesa despesa : despesas) {
                mensagem.append("Descrição: ")
                        .append(despesa.getDescricao())
                        .append("\nValor: R$ ")
                        .append(despesa.getValor())
                        .append("\nCategoria: ")
                        .append(despesa.getDespesa())
                        .append("\nData: ")
                        .append(despesa.getData().format(formatter))
                        .append("\n\n");
            }
            JOptionPane.showMessageDialog(this,mensagem.toString());
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        List<Lancamento> lancamentos = controle.listarLancamentos();

        StringBuilder mensagem = new StringBuilder();

        if(lancamentos.size() == 0) {
            JOptionPane.showMessageDialog(this,"Não há despesas cadastradas");
        } else {
            for (Lancamento lancamento : lancamentos) {
                if (lancamento instanceof Receita receita) {
                    mensagem.append("Descrição: ")
                            .append(receita.getDescricao())
                            .append("\nValor: R$ ")
                            .append(receita.getValor())
                            .append("\nCategoria: ")
                            .append (receita.getReceita())
                            .append("\nData: ")
                            .append(receita.getData().format(formatter))
                            .append("\n\n");
                } else if (lancamento instanceof Despesa despesa) {
                    mensagem.append("Descrição: ")
                            .append(despesa.getDescricao())
                            .append("\nValor: R$ ")
                            .append(despesa.getValor())
                            .append("\nCategoria: ")
                            .append (despesa.getDespesa())
                            .append("\nData: ")
                            .append(despesa.getData().format(formatter))
                            .append("\n\n");
                }
            }
            JOptionPane.showMessageDialog(this,mensagem.toString());
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jAtualizarActionPerformed(java.awt.event.ActionEvent evt) {
        controle.setSaldoAtual();
        labelAtual.setText("Saldo atual: R$" + controle.getSaldoAtual());
        controle.setSaldoTotal();
        labelTotal.setText("Saldo total: R$" + controle.getSaldoTotal());
    }

    private javax.swing.JButton jAtualizar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel labelAtual;
    private javax.swing.JLabel labelTotal;
}
