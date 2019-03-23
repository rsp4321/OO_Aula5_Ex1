package classes;

import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Arma X
 */
public class Aluno {

    private String nome;
    private char sexo;
    private int idade;
    private String matricula;
    private Date ano;

    public Aluno() {
        this.nome = "";
        this.sexo = 'f';
        this.idade = 0;
        this.matricula = "";
        this.ano = new Date();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Date getAno() {
        return ano;
    }

    public void preencherAluno() {
        Scanner ler = new Scanner(System.in);
        System.out.print("Nome do aluno: ");
        this.nome = ler.nextLine();
        setNome(this.nome);
        System.out.print("Matrícula: ");
        this.matricula = ler.nextLine();
        setMatricula(this.matricula);
        System.out.print("Sexo: ");
        this.sexo = ler.next().charAt(0);
        setSexo(this.sexo);
        System.out.print("Idade: ");
        this.idade = ler.nextInt();
        setIdade(this.idade);
    }

    public void imprimirAluno() {
        System.out.println("Aluno: " + getNome());
        System.out.println("Sexo: " + getSexo());
        System.out.println("Idade: " + getIdade());
        System.out.println("Matricula: " + getMatricula());
        System.out.println("Ano: " + getAno());
    }

    public String imprimirAlunoString() {
        String texto = "";
        texto = "Aluno: " + getNome() + "\n"
                + "Sexo: " + getSexo() + "\n"
                + "Idade: " + getIdade() + "\n"
                + "Matricula: " + getMatricula() + "\n"
                + "Ano: " + getAno() + "\n";
        return texto;
    }
}
