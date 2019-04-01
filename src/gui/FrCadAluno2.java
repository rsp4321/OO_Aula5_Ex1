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

public class FrCadAluno2 extends javax.swing.JFrame {

    private ArrayList<Aluno> lista;
    private int newEdit; //0: Novo , 1: Editar
    private int indexEdit;
    private final String NOME_ARQUIVO = "registro.txt";

    // Como a equipe está desenvolvendo tanto no Windows quanto no linux,
    // vou utilizar a classe java.nio.file.Path para abstrair os diretórios
    // sem precisar utlizar métodos de detecção do sistema operacional por enquanto
    final Path caminho_arquivo = Paths.get( // O objeto "Paths" constrói o objeto "Path" conforme as "partes" do diretório dadas
            System.getProperty("user.home"), // a rotina System.getProperty() retorna algumas variáveis de ambiente definidas pela JVM no momento da execução. A veriável "user.home" retorna o diretório do usuário no sistema operacional
            "OO_Aula5", // Essa "parte" indica que se trata da pasta "OO_Aula5"
            //                "registro.txt");                    // Essa "parte" indica o arquivo
            NOME_ARQUIVO);

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
            listaCompleta = listaCompleta + aux.imprimirString() + "\n\n";
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

    private String imprimirListaCSV() {

        int i;
        String csv = "";

        for (i = 0; i < lista.size(); i++) {    // loop para percorrer os registros

            csv += lista.get(i).getMatricula() + ";";   // campo "matrícula"
            csv += lista.get(i).getNome() + ";";        // campo "nome"
            csv += lista.get(i).getIdade() + ";";       // campo "idade"
//            csv += lista.get(i).getSexo() + ";\n";      // campo "sexo"
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
        cmbSexo = new javax.swing.JComboBox<>();
        btnAbrirArquivo = new javax.swing.JButton();
        btnSalvarArquivo = new javax.swing.JButton();

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

        cmbSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "M", "F" }));
        cmbSexo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cmbSexoKeyTyped(evt);
            }
        });

        btnAbrirArquivo.setText("Abrir do arquivo");
        btnAbrirArquivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirArquivoActionPerformed(evt);
            }
        });

        btnSalvarArquivo.setText("Salvar no arquivo");
        btnSalvarArquivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarArquivoActionPerformed(evt);
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
                        .addComponent(lblMatricula)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblSexo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(lblIdade)
                        .addGap(10, 10, 10)
                        .addComponent(edtIdade, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnNovo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEditar))
                            .addComponent(btnAbrirArquivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnCancelar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnExcluir))
                            .addComponent(btnSalvarArquivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAbrirArquivo)
                    .addComponent(btnSalvarArquivo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
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
                            .addComponent(cmbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
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

    private void cmbSexoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmbSexoKeyTyped
        if (evt.getKeyChar() == java.awt.event.KeyEvent.VK_ENTER) {
            edtIdade.requestFocus();
        }
    }//GEN-LAST:event_cmbSexoKeyTyped

    private void edtIdadeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edtIdadeKeyTyped

        if (evt.getKeyChar() == java.awt.event.KeyEvent.VK_ENTER) {
            btnSalvar.requestFocus();
        }

    }//GEN-LAST:event_edtIdadeKeyTyped

    private void btnAbrirArquivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirArquivoActionPerformed

        FileReader file_reader_arquivo = null;
        Scanner sc_arquivo = null;

        ArrayList<Aluno> lstAluno = new ArrayList<>();

        try {


            // Usando o método Path.toString() para retornar o diretório no formato de string
            /*FileReader */ file_reader_arquivo = new FileReader(caminho_arquivo.toString());

            /*Scanner */ sc_arquivo = new Scanner(file_reader_arquivo);  // Criando um objeto "Scanner" para ler do objeto "FileReader"

            // Como o formato de arquivo escolhido é o CSV, vamos alterar o delimitador para o caractere ";"
            sc_arquivo.useDelimiter(";");

            // Por questão de ambiguidade do verificador de sintaxe da IDE e do compilador, fiz a inicialização manual das variáveis
            int matricula = 0, idade = -1;
            String nome = "";
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
            final int CAMPO_MATRICULA = 0;  // a cláusula "final" indica que se trata de uma constante
            final int CAMPO_NOME = 1;
            final int CAMPO_IDADE = 2;
            final int CAMPO_SEXO = 3;

            while (sc_arquivo.hasNext()) {

                campo = i % 4; // Obtendo o resto da divisão de i por 4

                switch (campo) {

                    case CAMPO_MATRICULA:
                        matricula = sc_arquivo.nextInt();
                        break;

                    case CAMPO_NOME:
                        nome = sc_arquivo.next();
                        break;

                    case CAMPO_IDADE:
                        idade = sc_arquivo.nextInt();
                        break;

                    case CAMPO_SEXO:

                        // Como o sexo é o último campo, vamos instanciar o objeto e armazenar na lista
                        sexo = sc_arquivo.next().charAt(0); // Por se tratar de um char, tem que retirar apenas o primeiro caracter

                        Aluno a = new Aluno(nome, sexo, idade, matricula);  // Instanciando o aluno
                        lstAluno.add(a);
                        break;
                }

                i++;    // Incrementando o contador para poder fazer a divisão
            }

            file_reader_arquivo.close();

            // Código gerado automaticamente pelo NetBeans
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FrCadAluno2.class.getName()).log(Level.SEVERE, null, ex);  // Esse método só faz o log do erro

            // Como o método FileReader.close() dispara uma exceção diferente ("IOException"), 
            // coloquei o método genérico para a classe "IOException"
        } catch (IOException e) {
            Logger.getLogger(FrCadAluno2.class.getName()).log(Level.SEVERE, null, e);

        } finally { // A cláusula "finally" é recomendada pelo Java para finalizar os objetos ligados a recursos utilizados

            if (sc_arquivo != null) {
                sc_arquivo.close();
            }

            /*
            try {
                file_reader_arquivo.close();
            } catch (IOException ex) {
                Logger.getLogger(FrCadAluno2.class.getName()).log(Level.SEVERE, null, ex);
            }
             */
        }

        this.lista = lstAluno;
        edtResultado.setText(this.imprimirListaCompleta());

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
                    "Lista de alunos salva no arquivo '" + caminho_arquivo.toString() + "' com sucesso!",
                    "Aviso",
                    JOptionPane.INFORMATION_MESSAGE);

        } catch (IOException ex) {
            Logger.getLogger(FrCadAluno2.class.getName()).log(Level.SEVERE, null, ex);

            // Còdigo para finalizar o recurso "print_writer_arquivo"
        } finally {

            if (print_writer_arquivo != null) {
                print_writer_arquivo.close();
            }
        }

    }//GEN-LAST:event_btnSalvarArquivoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrirArquivo;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnSalvarArquivo;
    private javax.swing.JComboBox<String> cmbSexo;
    private javax.swing.JTextField edtIdade;
    private javax.swing.JTextField edtMatricula;
    private javax.swing.JTextField edtNome;
    private javax.swing.JTextArea edtResultado;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblIdade;
    private javax.swing.JLabel lblMatricula;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblSexo;
    private javax.swing.JLabel lblTitulo;
    // End of variables declaration//GEN-END:variables
}
