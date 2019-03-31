/* @author Arma X */
package gui;

//import classes.*;
import academico.*;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class FrCadAluno2 extends javax.swing.JFrame {

    private ArrayList<Aluno> lista;
    private int newEdit; //0: Novo , 1: Editar
    private int indexEdit;

    public FrCadAluno2() {
        initComponents();
        this.resetFields(false);
        lista = new ArrayList<>();
        this.newEdit = 0;
        this.indexEdit = -1;
    }

    public String imprimirListaCompleta() {
        String listaCompleta = "";
        for (int i = 0; i <= lista.size() - 1; i++) {
            Aluno aux = lista.get(i);
            aux.imprimirString();
            listaCompleta = listaCompleta + aux.imprimirString();
        }
        return listaCompleta;
    }

    public void hideShow(boolean flag) {
        edtNome.setEnabled(flag);
        edtMatricula.setEnabled(flag);

//        edtSexo.setEnabled(flag);
        cmbSexo.setEnabled(flag);

        edtIdade.setEnabled(flag);
    }

    public void resetFields(boolean flag) {
        this.hideShow(flag);
        if (!flag) { //significa (flag == false)
            edtNome.setText("");
            edtMatricula.setText("");

//            edtSexo.setText("");
            cmbSexo.setSelectedIndex(0);

            edtIdade.setText("");
        }
    }

//    public int pesquisar(String matricula) {
    private int pesquisar(int matricula) {
        // Trocado por causa de, na modelagem do objeto principal, o atributo "matricula" é int.
        // O encapsulamento foi alterado para private pois não vejo necessidade de ser reutilizado por agora

        for (int i = 0; i <= this.lista.size(); i++) {

//            if (this.lista.get(i).getMatricula().equals(matricula)) {
            if (this.lista.get(i).getMatricula() == matricula) // justificado acima
            {
                return i;
            }
        }

        return -1;
    }

    public void preencherCamposGUI(int index) {
        Aluno a = this.lista.get(index);
        edtNome.setText(a.getNome());

//        edtMatricula.setText(a.getMatricula());
        edtMatricula.setText(Integer.toString(a.getMatricula()));   // a rotina Integer.toString() faz a conversão explícita do valor int para String

//        edtSexo.setText(a.getSexo() + "");
        cmbSexo.setSelectedIndex(0);

        edtIdade.setText(a.getIdade() + "");
    }

    public Aluno copiarCamposGUI() {

        /*
        Aluno a = new Aluno();
        a.setNome(edtNome.getText());
        a.setMatricula(edtMatricula.getText());
        a.setSexo(edtSexo.getText().charAt(0));
        
        String idade = edtIdade.getText();
        if (!idade.isEmpty()) {//o mesmo que if(idade.equals(""))
            int aux = Integer.parseInt(idade);
            a.setIdade(aux);
        } else {
            JOptionPane.showMessageDialog(this, "Campo idade obrigatório");
        }
         */
        // Como o construtor da classe inicial recebe, obrigatoriamente, todos os campos,
        // eu vou reescrever passando direto para o construtor sem usar os métodos set
        // O código de verificação do campo de idade está com um erro de lógica ao meu ver
        // Se deixar em branco, apesar de mostrar a mensagem, ele cria o objeto "Aluno" com o valor da idade padrão
        String strIdade = edtIdade.getText();
        int idade;

        if (strIdade.isEmpty()) {   // Verificando se o campo não está vazio

            // Chamando a rotina JOptionPane.showInputDialog() para exibir uma janela pedindo a idade novamente
            idade = Integer.parseInt(
                    JOptionPane.showInputDialog(
                            this, // Passando o objeto do formulário como o objeto pai (parent) do diálogo
                            "O campo \"idade\" é obrigatório! Entre com a idade por favor:", // Mensagem do corpo
                            "Aviso", // Mensagem de título
                            JOptionPane.WARNING_MESSAGE) // O tipo da mensagem (ícone)
            );
        } else {
            idade = Integer.parseInt(edtIdade.getText());
        }

        Aluno a;
        a = new Aluno(edtNome.getText(),
                // o objeto "JComboBox" armazena objetos completos como índices. 
                //O método Object.toString, por se tratar de uma string registrada, retorna o conteúdo.
                // Como o sexo é armazenado como char, utilizei o método String.charAt() para pegar o primeiro caractere
                cmbSexo.getSelectedItem().toString().charAt(0),
                idade,
                Integer.parseInt(edtMatricula.getText()));

        return a;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        btnNovo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        lblNome = new javax.swing.JLabel();
        edtNome = new javax.swing.JTextField();
        lblSexo = new javax.swing.JLabel();
        lblIdade = new javax.swing.JLabel();
        edtIdade = new javax.swing.JTextField();
        lblMatricula = new javax.swing.JLabel();
        edtMatricula = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        edtResultado = new javax.swing.JTextArea();
        lblAnoIngresso = new javax.swing.JLabel();
        edtAnoIngresso = new javax.swing.JTextField();
        cmbSexo = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitulo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Cadastro de Alunos");

        btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/new.png"))); // NOI18N
        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/x.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/save.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cancel.png"))); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        lblNome.setText("Nome");

        edtNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                edtNomeKeyReleased(evt);
            }
        });

        lblSexo.setText("Sexo");

        lblIdade.setText("Idade");

        edtIdade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                edtIdadeKeyTyped(evt);
            }
        });

        lblMatricula.setText("Matrícula");

        edtMatricula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                edtMatriculaKeyReleased(evt);
            }
        });

        edtResultado.setColumns(20);
        edtResultado.setRows(5);
        jScrollPane1.setViewportView(edtResultado);

        lblAnoIngresso.setText("Ano de ingresso");

        edtAnoIngresso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                edtAnoIngressoKeyTyped(evt);
            }
        });

        cmbSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "M", "F" }));
        cmbSexo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cmbSexoKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnNovo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExcluir))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblMatricula)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(lblNome)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(edtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblSexo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(lblIdade)
                                .addGap(10, 10, 10)
                                .addComponent(edtIdade, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblAnoIngresso)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(edtAnoIngresso, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(edtNome))))
                .addGap(0, 17, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNome)
                            .addComponent(edtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(edtIdade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(edtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSexo)
                            .addComponent(lblIdade)
                            .addComponent(lblMatricula)
                            .addComponent(lblAnoIngresso)
                            .addComponent(edtAnoIngresso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        this.resetFields(true);
        edtNome.requestFocus();
        this.newEdit = 0;
    }//GEN-LAST:event_btnNovoActionPerformed
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.resetFields(false);
    }//GEN-LAST:event_btnCancelarActionPerformed
    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        Aluno a = this.copiarCamposGUI();
        
        if (newEdit == 0) {
            this.lista.add(a);
        
        } else if (newEdit == 1) {
            Aluno b = this.lista.get(this.indexEdit);
            b.setNome(a.getNome());
            b.setMatricula(a.getMatricula());
            b.setSexo(a.getSexo());
            b.setIdade(a.getIdade());
        }
        
        edtResultado.setText(this.imprimirListaCompleta());
        this.imprimirListaCompleta();
        resetFields(false);
    }//GEN-LAST:event_btnSalvarActionPerformed
    private void edtNomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edtNomeKeyReleased
        if (evt.getKeyChar() == java.awt.event.KeyEvent.VK_ENTER) {
            edtMatricula.requestFocus();
        }
    }//GEN-LAST:event_edtNomeKeyReleased
    private void edtMatriculaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edtMatriculaKeyReleased
        if (evt.getKeyChar() == java.awt.event.KeyEvent.VK_ENTER) {
//            edtSexo.requestFocus();
            cmbSexo.requestFocus();
        }
    }//GEN-LAST:event_edtMatriculaKeyReleased
    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        this.newEdit = 1;
        String matriculaInformada = JOptionPane.showInputDialog("Informe o Aluno a ser editado", "<informe a matrícula>");

        //Pega o valor informado(Matrícula) e pesquisa na lista
//        this.indexEdit = this.pesquisar(matriculaInformada);
        this.indexEdit = this.pesquisar(Integer.parseInt(matriculaInformada));

//Preenche os campos para editar o registro
        this.preencherCamposGUI(this.indexEdit);
        this.hideShow(true);
    }//GEN-LAST:event_btnEditarActionPerformed
    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        String matriculaInformada = JOptionPane.showInputDialog("Informe o Aluno a ser excluido", "<informe a matrícula>");

//        this.indexEdit = this.pesquisar(matriculaInformada);
        this.indexEdit = this.pesquisar(Integer.parseInt(matriculaInformada));

        this.lista.remove(indexEdit);
        edtResultado.setText(this.imprimirListaCompleta());
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void edtAnoIngressoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edtAnoIngressoKeyTyped
        if (evt.getKeyChar() == java.awt.event.KeyEvent.VK_ENTER) {
            btnSalvar.requestFocus();
        }
    }//GEN-LAST:event_edtAnoIngressoKeyTyped

    private void cmbSexoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmbSexoKeyTyped
        if (evt.getKeyChar() == java.awt.event.KeyEvent.VK_ENTER) {
            edtIdade.requestFocus();
        }
    }//GEN-LAST:event_cmbSexoKeyTyped

    private void edtIdadeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edtIdadeKeyTyped

        if (evt.getKeyChar() == java.awt.event.KeyEvent.VK_ENTER) {
            edtAnoIngresso.requestFocus();
        }

    }//GEN-LAST:event_edtIdadeKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cmbSexo;
    private javax.swing.JTextField edtAnoIngresso;
    private javax.swing.JTextField edtIdade;
    private javax.swing.JTextField edtMatricula;
    private javax.swing.JTextField edtNome;
    private javax.swing.JTextArea edtResultado;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAnoIngresso;
    private javax.swing.JLabel lblIdade;
    private javax.swing.JLabel lblMatricula;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblSexo;
    private javax.swing.JLabel lblTitulo;
    // End of variables declaration//GEN-END:variables
}
