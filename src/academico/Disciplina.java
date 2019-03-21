/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package academico;

import java.util.ArrayList;
import java.util.List;
//import java.util.Vector;

/**
 *
 * @author rodrigo
 */
public class Disciplina {
    
    private String nome;
    private int semestre;
    private int ano;
    private Professor prof;
    
    private List<Aluno> lstAluno;
//    private ArrayList<Aluno> lstAluno;
    
    private String horario;
    
    // A classe não possuirá o metodo set para a lista de alunos
    // pois serão feitos métodos para manipular o cadastro de alunos diretamente

    /**
     * A ideia desse construtor é evitar chamadas nos métodos set após a construção.
     * 
     * @param nome
     * @param semestre
     * @param ano
     * @param prof 
     * @param horario 
     */
    public Disciplina(String nome, int semestre, int ano, Professor prof
//            ,List<Aluno> lstAluno
            ,String horario
            ) {
        this.nome = nome;
        this.semestre = semestre;
        this.ano = ano;
        this.prof = prof;
        
//        this.lstAluno = lstAluno;
        // Vamos criar uma lista vazia através da subclasse Vector<>
//        lstAluno = new Vector<>();
        this.lstAluno = new ArrayList<>();
        this.horario = horario;
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
     * @return the semestre
     */
    public int getSemestre() {
        return semestre;
    }

    /**
     * @param semestre the semestre to set
     */
    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    /**
     * @return the ano
     */
    public int getAno() {
        return ano;
    }

    /**
     * @param ano the ano to set
     */
    public void setAno(int ano) {
        this.ano = ano;
    }

    /**
     * @return the prof
     */
    public Professor getProf() {
        return prof;
    }

    /**
     * @param prof the prof to set
     */
    public void setProf(Professor prof) {
        this.prof = prof;
    }

    /**
     * @return the lstAluno
     */
    public List<Aluno> getLstAluno() {
        return lstAluno;
    }
    
    public void cadastrarAluno(Aluno aluno) {
        lstAluno.add(aluno);    // o método List<>.add adiciona itens no final da lista
    }
    
    public int apagarAluno(int matricula) {
        
        // Procurando o objeto Aluno correspondente na lista
//        lstAluno.contains(matricula);
        int i;
        
        for (i = 0; i < lstAluno.size(); i++) {
            
            Aluno aluno = lstAluno.get(i);
            
            if (aluno.getMatricula() == matricula) {    // Verificando a matrícula com o método Aluno.getMatricula()
                
                // no caso, o aluno foi encontrado pela matrícula
                // Nesse caso, ele será removido da list e a rotina retornarám
                lstAluno.remove(i);     // Removendo o item
                
                return 0;               // Fazendo uma interface de sucesso para o desenvolvedor
            }                    
        }
        
        // Nesse ponto, assume-se que não foi encontrado o aluno na lista
        // Logo, vamos retornar "1" por enquanto para avisar ao desenvoldor
        return 1;
    }

    /**
     * @return the horario
     */
    public String getHorario() {
        return horario;
    }

    /**
     * @param horario the horario to set
     */
    public void setHorario(String horario) {
        this.horario = horario;
    }

    /**
     * @param lstAluno the lstAluno to set
     */
    public void setLstAluno(List<Aluno> lstAluno) {
        this.lstAluno = lstAluno;
    }
}
