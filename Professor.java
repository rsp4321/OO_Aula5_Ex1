package classes;

import java.util.Scanner;

/**
 *
 * @author Arma X
 */
public class Professor {

    private String nome;
    private char sexo;
    private int idade;
    private String cpf;

    public Professor() {
        this.nome = "";
        this.sexo = 'f';
        this.idade = 0;
        this.cpf = "";
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void preencherProfessor() {
        Scanner ler = new Scanner(System.in);
        System.out.print("Nome do professor: ");
        this.nome = ler.nextLine();
        setNome(this.nome);
        System.out.print("CPF: ");
        this.cpf = ler.nextLine();
        setCpf(this.cpf);
        System.out.print("Sexo: ");
        this.sexo = ler.next().charAt(0);
        setSexo(this.sexo);
        System.out.print("Idade: ");
        this.idade = ler.nextInt();
        setIdade(this.idade);
    }

    public void imprimirProfessor() {
        System.out.println("Professor: " + getNome());
        System.out.println("Sexo: " + getSexo());
        System.out.println("Idade: " + getIdade());
        System.out.println("CPF: " + getCpf());
    }

    public String imprimirProfessorString() {
        String texto = "";
        texto = "Professor: " + getNome() + "\n"
                + "Sexo: " + getSexo() + "\n"
                + "Idade: " + getIdade() + "\n"
                + "CPF: " + getCpf() + "\n";
        return texto;
    }
}
