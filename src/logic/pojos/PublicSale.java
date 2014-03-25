package logic.pojos;

import java.util.Calendar;

public class PublicSale extends Pojo{
    
    private long  idProduto;
    private Calendar data_int;
    private Calendar data_fim;

    public PublicSale(long produto, Calendar data_int, Calendar data_fim) {
        this.idProduto = produto;
        this.data_int = data_int;
        this.data_fim = data_fim;
    }
    
    public PublicSale(){
        this(0,Calendar.getInstance(),Calendar.getInstance());
    }

    public long getProduto() {
        return idProduto;
    }

    public void setProduto(long produto) {
        this.idProduto = produto;
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

    @Override
    public String toString() {
        return "Produto: " + idProduto + 
               "\nData Inicial: " + data_int + 
               "\nData Final: " + data_fim;
    }
    
    
    
}
