package logic.pojos;

public class Product extends Pojo{
    
    private String nome;
    private String descricao;
    private double preco_init;
    private int ano;

    public Product(String nome, String descricao, double preco_init, int ano) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco_init = preco_init;
        this.ano = ano;
    }
    
    public Product(){
        this("","",0D,0);
    }

    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco_init() {
        return preco_init;
    }

    public void setPreco_init(double preco_init) {
        this.preco_init = preco_init;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    @Override
    public String toString() {
        return "Nome: " + nome
             + "\nDescricao: " + descricao
             + "\nPreço Inicial: " + preco_init
             + "\nAno: " + ano;
    }
    
    
    
}
