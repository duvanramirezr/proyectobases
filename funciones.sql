Funcion para generar factura parametro
pedido.id_pedido
pedido.fecha
producto.nombre
producto.valor * detalle_producto.cantidad
detalle_producto.total_producto
pedido.total_pedido


/*============*/

Funcion para promedio de calificaciones
fecha inicial
fecha final

select avg(pedido.calificacion), avg(pedido.total_pedido)


/*============*/
procedimiento para clasificar 

tomar resultado de promedio calificaciones
clasificaion.calificacion_minima
clasificacion.valor_inicial


/*============*/
funcion calcular comision
clasificacion.comision * avg(pedido.total_pedido)

/*============*/



