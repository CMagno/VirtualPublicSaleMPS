package logic.pojos;

public class Deal {
    
    private long id;
    private Client comprador;
    private Client vendedor;
    private Product produto;

    public Deal(Client comprador, Client vendedor, Product produto) {
        this.comprador = comprador;
        this.vendedor = vendedor;
        this.produto = produto;
    }

    
    public Client getComprador() {
        return comprador;
    }

    public void setComprador(Client comprador) {
        this.comprador = comprador;
    }

    public Client getVendedor() {
        return vendedor;
    }

    public void setVendedor(Client vendedor) {
        this.vendedor = vendedor;
    }

    public Product getProduto() {
        return produto;
    }

    public void setProduto(Product produto) {
        this.produto = produto;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Negocio{" + "comprador=" + comprador + ", vendedor=" + vendedor + ", produto=" + produto + '}';
    }
    
    
    
}
