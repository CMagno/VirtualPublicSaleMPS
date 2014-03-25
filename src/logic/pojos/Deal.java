package logic.pojos;

public class Deal extends Pojo{
    
    private long idComprador;
    private long idVendedor;
    private long idProduto;

    public Deal(long idComprador, long idVendedor, long idProduto) {
        this.idComprador = idComprador;
        this.idVendedor = idVendedor;
        this.idProduto = idProduto;
    }

    public long getIdComprador() {
        return idComprador;
    }

    public void setIdComprador(long idComprador) {
        this.idComprador = idComprador;
    }

    public long getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(long idVendedor) {
        this.idVendedor = idVendedor;
    }

    public long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(long idProduto) {
        this.idProduto = idProduto;
    }
    
    @Override
    public String toString() {
        return    "===Comprador==\n"
                + idComprador
                + "==============\n"
                + "===Vendedor==\n"
                + idVendedor
                + "==============\n"
                + "===Produto==\n"
                + idProduto
                + "==============\n";
    }
    
    
    
}
