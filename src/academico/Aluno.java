/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package academico;

/**
 *
 * @author rodrigo
 */
public class Aluno {
    
    private String nome;
    private char sexo;
    private int idade;
    private int matricula;
//    private int ano_ingresso;

    /**
     * A ideia desse construtor é evitar chamadas nos métodos set após a construção.
     * 
     * @param nome
     * @param sexo
     * @param idade
     * @param matricula
     */
    public Aluno(String nome, char sexo, int idade, int matricula /*, int ano_ingresso */) {
        this.nome = nome;
        this.sexo = sexo;
        this.idade = idade;
        this.matricula = matricula;
//        this.ano_ingresso = ano_ingresso;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the sexo
     */
    public char getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    /**
     * @return the idade
     */
    public int getIdade() {
        return idade;
    }

    /**
     * @param idade the idade to set
     */
    public void setIdade(int idade) {
        this.idade = idade;
    }

    /**
     * @return the matricula
     */
    public int getMatricula() {
        return matricula;
    }

    /**
     * @param matricula the matricula to set
     */
    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    /*
    public int getAno_ingresso() {
        return ano_ingresso;
    }
    */

    /*
    public void setAno_ingresso(int ano_ingresso) {
        this.ano_ingresso = ano_ingresso;
    }
    */
    
    public void imprimirNoTerminal(){
        
        System.out.println("***** Relatório do aluno *****");
        System.out.println("Nome completo: "+ this.getNome());
        System.out.println("Sexo: "+ this.getSexo());
        System.out.println("Idade: "+ this.getIdade());
        System.out.println("Matrícula: "+ this.getMatricula());
//        System.out.println("Ano de ingresso: "+ this.getAno_ingresso());
        System.out.println("***** Fim do relatório *****");
    }
    
    public String imprimirString() {
        
        String s;
        
        s = "Nome: " + this.getNome() + "\n"
                + "Sexo: " + this.getSexo() + "\n"
                + "Idade: " + this.getIdade() + "\n"
                + "Matrícula: " + this.getMatricula() + "\n";
//                + "Ano de ingresso: " + this.getAno_ingresso();
        
        return s;
    }
}
