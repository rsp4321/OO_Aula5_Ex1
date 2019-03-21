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
public class Professor {
    
    private int siape;
    private String nome;
    private char sexo;
    private int idade;
    private String cpf;

    /**
     * A ideia desse construtor é evitar chamadas nos métodos set após a construção.
     * 
     * @param nome
     * @param sexo
     * @param idade
     * @param cpf
     * @param siape 
     */
    public Professor(String nome, char sexo, int idade, String cpf, int siape) {
        this.nome = nome;
        this.sexo = sexo;
        this.idade = idade;
        this.cpf = cpf;
        this.siape = siape;
    }

    /**
     * @return the siape
     */
    public int getSiape() {
        return siape;
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
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}    
