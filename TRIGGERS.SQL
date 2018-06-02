/*Trigger para auditar cambios en la calificacion de los representantes*/
CREATE OR REPLACE TRIGGER TG_AUDITAR_CALIFICACION
FOR EACH
BEGIN
END TG_AUDITAR_CALIFICACION;

/*Trigger para auditar cambios en el acumulado de ventas de los representantes*/
CREATE OR REPLACE TRIGGER TG_AUDITAR_ACUM_VENTA
FOR EACH
BEGIN
END TG_AUDITAR_ACUM_VENTA;

/*Trigger para auditar cambios en el valor de las comisiones de los representantes*/
CREATE OR REPLACE TRIGGER TG_AUDITAR_COMISION
FOR EACH
BEGIN
END TG_AUDITAR_COMISION;