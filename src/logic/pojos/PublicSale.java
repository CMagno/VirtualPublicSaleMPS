package logic.pojos;

import java.util.Calendar;

public class PublicSale {
    
    private long id;
    private Product  produto;
    private Calendar data_int;
    private Calendar data_fim;

    public PublicSale(Product produto, Calendar data_int, Calendar data_fim) {
        this.produto = produto;
        this.data_int = data_int;
        this.data_fim = data_fim;
    }
    
    public PublicSale(){
        this(new Product(),Calendar.getInstance(),Calendar.getInstance());
    }

    public Product getProduto() {
        return produto;
    }

    public void setProduto(Product produto) {
        this.produto = produto;
    }

    public Calendar getData_int() {
        return data_int;
    }

    public void setData_int(Calendar data_int) {
        this.data_int = data_int;
    }
    
    public Calendar getData_fim() {
        return data_fim;
    }

    public void setData_fim(Calendar data_fim) {
        this.data_fim = data_fim;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Leilao{" + "produto=" + produto.toString() + ", data_int=" + data_int + ", data_fim=" + data_fim + '}';
    }
    
    
    
}
