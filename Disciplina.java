package classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Arma X
 */
public class Disciplina {

    private String nome;
    private int semestre;
    private String horario;
    private Professor professor;
    private List<Aluno> lstAlunos;

    public Disciplina() {
        this.nome = "";
        this.semestre = -1;
        this.horario = "";
        this.professor = new Professor();
        this.lstAlunos = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public List<Aluno> getLstAlunos() {
        return lstAlunos;
    }

    public void setLstAlunos(List<Aluno> lstAlunos) {
        this.lstAlunos = lstAlunos;
    }

    public void preencherDisciplina() {
        Scanner ler = new Scanner(System.in);
        System.out.println("Cadastrar Disciplina");
        System.out.print("Nome: ");
        this.nome = ler.nextLine();
        setNome(this.nome);
        System.out.print("Horario: ");
        this.horario = ler.nextLine();
        setHorario(this.horario);
        System.out.print("Semestre: ");
        this.semestre = ler.nextInt();
        setSemestre(this.semestre);
        System.out.println("Cadastre o Professor de " + this.nome);
        Professor professorDisciplina = new Professor();
        professorDisciplina.preencherProfessor();
        this.professor = professorDisciplina;
        setProfessor(professorDisciplina);
        System.out.println("Cadastre os Alunos de " + this.nome);
        for (int i = 0; i < 5; i++) {
            Aluno alunoDisciplina = new Aluno();
            lstAlunos.add(alunoDisciplina);
            alunoDisciplina.preencherAluno();
        }
    }

    public void imprimirDisciplina() {
        System.out.println("*******************************");
        System.out.println("Disciplina: " + getNome());
        System.out.println("Semestre: " + getSemestre());
        System.out.println("Horario: " + getHorario());
        System.out.println("*******************************");
        professor.imprimirProfessor();
        System.out.println("*******************************");
        System.out.println("Alunos inseridos em " + getNome());
        for (Aluno alunoD : lstAlunos) {
            alunoD.imprimirAluno();
            System.out.println("*******************************");
        }
        System.out.println("*******************************");
    }
}
