package logic.pojos;

import java.util.Objects;

public class Client extends Pojo{

    private String nome;
    private String cpf;

    public Client(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public Client() {
        this("", "");
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    @Override
    public String toString() {
        return "Cliente{" + "nome=" + nome + ", cpf=" + cpf + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Client other = (Client) obj;
        if (!this.getNome().equals(other.getNome())) {
            return false;
        }
        if (!this.getCpf().equals(other.getCpf())) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.nome);
        hash = 97 * hash + Objects.hashCode(this.cpf);
        return hash;
    }
}
