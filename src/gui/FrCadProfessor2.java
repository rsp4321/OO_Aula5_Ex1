/* @author Arma X */
package gui;

//import classes.*;
import academico.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class FrCadProfessor2 extends javax.swing.JFrame {

    private ArrayList<Professor> lista;
    private int newEdit; //0: Novo , 1: Editar
    private int indexEdit;
    private final String NOME_ARQUIVO = "registroProfessor.txt";

    final Path caminho_arquivo = Paths.get(System.getProperty("user.home"), "OO_Aula5",/*"registro.txt",*/ NOME_ARQUIVO);

    public FrCadProfessor2() {
        initComponents();
        this.resetFields(false);
        lista = new ArrayList<>();
        this.newEdit = 0;
        this.indexEdit = -1;
    }

    public String imprimirListaCompleta() {
        String listaCompleta = "";
        for (int i = 0; i <= lista.size() - 1; i++) {
            Professor aux = lista.get(i);
            aux.imprimirString();
            listaCompleta = listaCompleta + aux.imprimirString() + "\n\n";
        }
        return listaCompleta;
    }

    public void hideShow(boolean flag) {
        edtNome.setEnabled(flag);
        edtSiape.setEnabled(flag);
        /*edtSexo.setEnabled(flag);*/
        cmbSexo.setEnabled(flag);
        edtIdade.setEnabled(flag);
        edtCpf.setEnabled(flag);
    }

    public void resetFields(boolean flag) {
        this.hideShow(flag);
        if (!flag) { //significa (flag == false)
            edtNome.setText("");
            edtCpf.setText("");
            edtSiape.setText("");
            /*edtSexo.setText("");*/
            cmbSexo.setSelectedIndex(0);
            edtIdade.setText("");
        }
    }

    /*public int pesquisar(String Siape) {*/
    private int pesquisar(int Siape) {
        // Trocado por causa de, na modelagem do objeto principal, o atributo "siape" é int.
        // O encapsulamento foi alterado para private pois não vejo necessidade de ser reutilizado por agora
        for (int i = 0; i <= this.lista.size(); i++) {
            /*if (this.lista.get(i).getSiape().equals(siape)) {*/
            if (this.lista.get(i).getSiape() == Siape) {
                return i;
            }
        }
        return -1;
    }

    public void preencherCamposGUI(int index) {
        Professor prof = this.lista.get(index);
        edtNome.setText(prof.getNome());
        edtCpf.setText(prof.getCpf());
        /*edtSiape.setText(a.getSiape());*/
        edtSiape.setText(Integer.toString(prof.getSiape()));//a rotina Integer.toString() faz a conversão explícita do valor int para String
        /*edtSexo.setText(a.getSexo() + "");*/
        cmbSexo.setSelectedIndex(0);
        edtIdade.setText(prof.getIdade() + "");
    }

    public Professor copiarCamposGUI() {
        /*Professor p = new Professor();
         a.setNome(edtNome.getText());
         a.setSiape(edtSiape.getText());
         a.setSexo(edtSexo.getText().charAt(0));        
         String idade = edtIdade.getText();
         if (!idade.isEmpty()) {//o mesmo que if(idade.equals(""))
         int aux = Integer.parseInt(idade);
         a.setIdade(aux);
         } else {
        JOptionPane.showMessageDialog(this, "Campo idade obrigatório");
         }*/
        // Como o construtor da classe inicial recebe, obrigatoriamente, todos os campos,
        // eu vou reescrever passando direto para o construtor sem usar os métodos set
        // O código de verificação do campo de idade está com um erro de lógica ao meu ver
        // Se deixar em branco, apesar de mostrar a mensagem, ele cria o objeto "Professor" com o valor da idade padrão
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
        Professor prof;
        prof = new Professor(edtNome.getText(), cmbSexo.getSelectedItem().toString().charAt(0), idade, edtCpf.getText(), Integer.parseInt(edtSiape.getText()));
        return prof;
    }

    private String imprimirListaCSV() {
        int i;
        String csv = "";
        for (i = 0; i < lista.size(); i++) {    // loop para percorrer os registros

            csv += lista.get(i).getSiape() + ";";       // campo "siape"
            csv += lista.get(i).getNome() + ";";        // campo "nome"
            csv += lista.get(i).getIdade() + ";";       // campo "idade"
            csv += lista.get(i).getCpf() + ";";         // campo "cpf"
            /*csv += lista.get(i).getSexo() + ";\n";*/  // campo "sexo"
            csv += lista.get(i).getSexo() + ";";        // Para corrigir um incidente envolvendo o método de leitura, onde se lê o caracter "\n"
        }
        return csv;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        btnNovo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        lblNome = new javax.swing.JLabel();
        lblIdade = new javax.swing.JLabel();
        edtNome = new javax.swing.JTextField();
        edtIdade = new javax.swing.JTextField();
        lblSexo = new javax.swing.JLabel();
        cmbSexo = new javax.swing.JComboBox<>();
        lblCpf = new javax.swing.JLabel();
        edtCpf = new javax.swing.JTextField();
        lblSiape = new javax.swing.JLabel();
        edtSiape = new javax.swing.JTextField();
        jScrollPaneRelatorio = new javax.swing.JScrollPane();
        txtRelatorio = new javax.swing.JTextArea();
        btnCancelar = new javax.swing.JButton();
        btnAbrirArquivo = new javax.swing.JButton();
        btnSalvarArquivo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitulo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Cadastro de professores");
        lblTitulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

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

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/save.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/erase.png"))); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        lblNome.setText("Nome");

        lblIdade.setText("Idade");

        edtNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                edtNomeKeyTyped(evt);
            }
        });

        edtIdade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                edtIdadeKeyTyped(evt);
            }
        });

        lblSexo.setText("Sexo");

        cmbSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "M", "F" }));
        cmbSexo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cmbSexoKeyTyped(evt);
            }
        });

        lblCpf.setText("CPF");

        edtCpf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                edtCpfKeyTyped(evt);
            }
        });

        lblSiape.setText("SIAPE");

        edtSiape.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                edtSiapeKeyTyped(evt);
            }
        });

        txtRelatorio.setColumns(20);
        txtRelatorio.setRows(5);
        jScrollPaneRelatorio.setViewportView(txtRelatorio);

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cancel.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnAbrirArquivo.setText("Abrir do Arquivo");
        btnAbrirArquivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirArquivoActionPerformed(evt);
            }
        });

        btnSalvarArquivo.setText("Salvar no Arquivo");
        btnSalvarArquivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarArquivoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCancelar)
                .addGap(14, 14, 14)
                .addComponent(btnExcluir)
                .addGap(0, 11, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(lblIdade)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(edtIdade, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(24, 24, 24)
                            .addComponent(lblSexo)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cmbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(lblCpf)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(edtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblSiape)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(edtSiape))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(lblNome)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(edtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAbrirArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(136, 136, 136)
                        .addComponent(btnSalvarArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPaneRelatorio)
            .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovo)
                    .addComponent(btnEditar)
                    .addComponent(btnSalvar)
                    .addComponent(btnExcluir)
                    .addComponent(btnCancelar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAbrirArquivo)
                    .addComponent(btnSalvarArquivo))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(edtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIdade)
                    .addComponent(edtIdade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSexo)
                    .addComponent(cmbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCpf)
                    .addComponent(edtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSiape)
                    .addComponent(edtSiape, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(jScrollPaneRelatorio, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        this.resetFields(true);
        edtNome.requestFocus();
        this.newEdit = 0;
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        Professor prof = this.copiarCamposGUI();
        if (newEdit == 0) {
            this.lista.add(prof);
        } else if (newEdit == 1) {
            Professor a = this.lista.get(this.indexEdit);
            a.setNome(prof.getNome());
            a.setCpf(prof.getCpf());
//            a.setSiape(prof.getSiape());
            a.setSexo(prof.getSexo());
            a.setIdade(prof.getIdade());
        }
        txtRelatorio.setText(this.imprimirListaCompleta());
//        this.imprimirListaCompleta();
        resetFields(false);
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void edtNomeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edtNomeKeyTyped
        if (evt.getKeyChar() == java.awt.event.KeyEvent.VK_ENTER) {
            edtIdade.requestFocus();
        }
    }//GEN-LAST:event_edtNomeKeyTyped

    private void edtIdadeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edtIdadeKeyTyped
        if (evt.getKeyChar() == java.awt.event.KeyEvent.VK_ENTER) {
            cmbSexo.requestFocus();
        }
    }//GEN-LAST:event_edtIdadeKeyTyped

    private void cmbSexoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmbSexoKeyTyped
        if (evt.getKeyChar() == java.awt.event.KeyEvent.VK_ENTER) {
            edtCpf.requestFocus();
        }
    }//GEN-LAST:event_cmbSexoKeyTyped

    private void edtCpfKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edtCpfKeyTyped
        if (evt.getKeyChar() == java.awt.event.KeyEvent.VK_ENTER) {
            edtSiape.requestFocus();
        }
    }//GEN-LAST:event_edtCpfKeyTyped

    private void edtSiapeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edtSiapeKeyTyped
        if (evt.getKeyChar() == java.awt.event.KeyEvent.VK_ENTER) {
            btnSalvar.requestFocus();
        }
    }//GEN-LAST:event_edtSiapeKeyTyped

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.resetFields(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAbrirArquivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirArquivoActionPerformed
        FileReader file_reader_arquivo = null;
        Scanner sc_arquivo = null;
        ArrayList<Professor> lstProfessor = new ArrayList<>();

        try {


            // Usando o método Path.toString() para retornar o diretório no formato de string
            /*FileReader */ file_reader_arquivo = new FileReader(caminho_arquivo.toString());
            /*Scanner */ sc_arquivo = new Scanner(file_reader_arquivo);  // Criando um objeto "Scanner" para ler do objeto "FileReader"
            // Como o formato de arquivo escolhido é o CSV, vamos alterar o delimitador para o caractere ";"
            sc_arquivo.useDelimiter(";");
            // Por questão de ambiguidade do verificador de sintaxe da IDE e do compilador, fiz a inicialização manual das variáveis
            int siape = 0, idade = -1;
            String nome = "";
            String cpf = "";
            char sexo = 'M';
            // Ordem de colunas: Matricula -> Nome -> Idade -> Sexo
            // A estratégia é percorrer os campos até não haver mais nenhum para ler (informado pelo método sc_Arquivo.hasNext() )
            // Para tal, utilizaremos um while com uma variável de controle "campo" e um contador "i"
            // ela indicará qual o tipo de campo que é
            // Para fazer isso, faremos uma matemática básica
            // Como são 4 campos, se implementarmos um contador de campos, observaremos um certo padrão:
            // 1) O campo de matrícula aparecerá quando aparecer resto 0 numa divisão de i por 4;
            // 2) O campo de nome aparecerá quando aparecer resto 1 numa divisão de i por 4;
            // 3) O campo de idade aparecerá quando aparecer resto 2 numa divisão de i por 4;
            // 4) O campo de sexo aparecerá quando aparecer resto 3 numa divisão de i por 4.
            // A partir desses padrões, faremos a identificação do campo lido e colocaremos no vetor lstAluno
            int campo = 0, i = 0;
            final int CAMPO_SIAPE = 0;  // a cláusula "final" indica que se trata de uma constante
            final int CAMPO_NOME = 1;
            final int CAMPO_IDADE = 2;
            final int CAMPO_CPF = 3;
            final int CAMPO_SEXO = 4;

            while (sc_arquivo.hasNext()) {
                campo = i % 5; // Obtendo o resto da divisão de i por 5
                switch (campo) {
                    case CAMPO_SIAPE:
                        siape = sc_arquivo.nextInt();
                        break;

                    case CAMPO_NOME:
                        nome = sc_arquivo.next();
                        break;

                    case CAMPO_IDADE:
                        idade = sc_arquivo.nextInt();
                        break;

                    case CAMPO_CPF:
                        cpf = sc_arquivo.next();
                        break;

                    case CAMPO_SEXO:
                        // Como o sexo é o último campo, vamos instanciar o objeto e armazenar na lista
                        sexo = sc_arquivo.next().charAt(0); // Por se tratar de um char, tem que retirar apenas o primeiro caracter
                        Professor prof = new Professor(nome, sexo, idade, cpf, siape);  // Instanciando o aluno
                        lstProfessor.add(prof);
                        break;
                }
                i++;    // Incrementando o contador para poder fazer a divisão
            }
            file_reader_arquivo.close();
            // Código gerado automaticamente pelo NetBeans
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FrCadProfessor2.class
                    .getName()).log(Level.SEVERE, null, ex);  // Esse método só faz o log do erro
            // Como o método FileReader.close() dispara uma exceção diferente ("IOException"), 
            // coloquei o método genérico para a classe "IOException"
        } catch (IOException e) {
            Logger.getLogger(FrCadProfessor2.class.getName()).log(Level.SEVERE, null, e);
        } finally { // A cláusula "finally" é recomendada pelo Java para finalizar os objetos ligados a recursos utilizados
            if (sc_arquivo != null) {
                sc_arquivo.close();
            }
            /*try {
             file_reader_arquivo.close();
             } catch (IOException ex) {
             Logger.getLogger(FrCadAluno2.class.getName()).log(Level.SEVERE, null, ex);
             }*/
        }
        this.lista = lstProfessor;
        txtRelatorio.setText(this.imprimirListaCompleta());
        JOptionPane.showMessageDialog(this, "Arquivo '" + caminho_arquivo.toString() + "' carregado com sucesso!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnAbrirArquivoActionPerformed

    private void btnSalvarArquivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarArquivoActionPerformed
        // Vamos utilizar a classe java.file.FileWriter para salvar no arquivo
        FileWriter file_writer_arquivo = null;
        // A classe java.file.PrintWriter fará a escrita no arquivo de fato
        PrintWriter print_writer_arquivo = null;

        try {
            file_writer_arquivo = new FileWriter(caminho_arquivo.toString());   // Instanciando com o caminho definido no início da classe
            print_writer_arquivo = new PrintWriter(file_writer_arquivo);
            // Gerando a lista em formato CSV e colocando para imprimir no arquivo usando o método PrintWriter.print() 
            print_writer_arquivo.print(this.imprimirListaCSV());
            file_writer_arquivo.close();
            JOptionPane.showMessageDialog(this,
                    "Lista de professores salva no arquivo '" + caminho_arquivo.toString() + "' com sucesso!",
                    "Aviso",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            Logger.getLogger(FrCadProfessor2.class
                    .getName()).log(Level.SEVERE, null, ex);
            // Còdigo para finalizar o recurso "print_writer_arquivo"
        } finally {
            if (print_writer_arquivo != null) {
                print_writer_arquivo.close();
            }
        }
    }//GEN-LAST:event_btnSalvarArquivoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        this.newEdit = 1;
        String siapeInformado = JOptionPane.showInputDialog("Informe o Professor a ser editado", "<informe o SIAPE>");
        //Pega o valor informado(Matrícula) e pesquisa na lista
        //this.indexEdit = this.pesquisar(matriculaInformada);
        this.indexEdit = this.pesquisar(Integer.parseInt(siapeInformado));
        //Preenche os campos para editar o registro
        this.preencherCamposGUI(this.indexEdit);
        this.hideShow(true);
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        String siapeInformado = JOptionPane.showInputDialog("Informe o Professor a ser excluido", "<informe o SIAPE>");
        //this.indexEdit = this.pesquisar(matriculaInformada);
        this.indexEdit = this.pesquisar(Integer.parseInt(siapeInformado));
        this.lista.remove(indexEdit);
        txtRelatorio.setText(this.imprimirListaCompleta());
    }//GEN-LAST:event_btnExcluirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrirArquivo;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnSalvarArquivo;
    private javax.swing.JComboBox<String> cmbSexo;
    private javax.swing.JTextField edtCpf;
    private javax.swing.JTextField edtIdade;
    private javax.swing.JTextField edtNome;
    private javax.swing.JTextField edtSiape;
    private javax.swing.JScrollPane jScrollPaneRelatorio;
    private javax.swing.JLabel lblCpf;
    private javax.swing.JLabel lblIdade;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblSexo;
    private javax.swing.JLabel lblSiape;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextArea txtRelatorio;
    // End of variables declaration//GEN-END:variables
}
