package negocio;

public class Pedido {

    private int id_pedido;
    private int id_cliente;
    private int total_pedido;
    private int id_pago;
    private String estado;
    private String fecha;

    public int getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getTotal_pedido() {
        return total_pedido;
    }

    public void setTotal_pedido(int total_pedido) {
        this.total_pedido = total_pedido;
    }

    public int getId_pago() {
        return id_pago;
    }

    public void setId_pago(int id_pago) {
        this.id_pago = id_pago;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

}
