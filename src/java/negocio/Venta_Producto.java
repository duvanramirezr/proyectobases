package negocio;

public class Venta_Producto {

    private int id_pedido;
    private int id_producto;
    private int cantidad;
    private double total_producto;
    private int calificacion;

    public int getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getTotal_producto() {
        return total_producto;
    }

    public void setTotal_producto(double total_producto) {
        this.total_producto = total_producto;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

}
