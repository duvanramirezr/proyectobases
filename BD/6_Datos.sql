

INSERT INTO UBICACION VALUES (415, 'COLOMBIA',NULL, NULL);

INSERT INTO UBICACION VALUES (41501, 'CARIBE', 415, NULL);
INSERT INTO UBICACION VALUES (41502, 'PACIFICA', 415, NULL);
INSERT INTO UBICACION VALUES (41503, 'ANDINA', 415, NULL);
INSERT INTO UBICACION VALUES (41504, 'LLANOS ORIENTALES', 415, NULL);
INSERT INTO UBICACION VALUES (41505, 'AMAZONIA', 415, NULL);

INSERT INTO CATEGORIA VALUES (601, 'NUTRICION', NULL);
INSERT INTO CATEGORIA VALUES (602, 'BELLEZA', NULL);
INSERT INTO CATEGORIA VALUES (603, 'HOGAR', NULL);
INSERT INTO CATEGORIA VALUES (604, 'CUIDADOS PERSONALES', NULL);
INSERT INTO CATEGORIA VALUES (605, 'LAVANDERIA', 603);
INSERT INTO CATEGORIA VALUES (606, 'LIMPIEZA DE PISOS', 603);
INSERT INTO CATEGORIA VALUES (607, 'DESINFECTANTES', 603);
INSERT INTO CATEGORIA VALUES (608, 'SUPLEMENTOS', 601);

INSERT INTO PRODUCTO VALUES (SEQ_ID_PRODUC.NEXTVAL, 'SANPIC', 606, 2200, 'Limpiador multiusos perfumado', 8.1);
INSERT INTO PRODUCTO VALUES (SEQ_ID_PRODUC.NEXTVAL, 'SOFLAN', 605, 1500, 'Aromatizante de ropa', 7.1);
INSERT INTO PRODUCTO VALUES (SEQ_ID_PRODUC.NEXTVAL, 'CLOROX', 607, 2500, 'Desinfectante multiusos', 5.2);
INSERT INTO PRODUCTO VALUES (SEQ_ID_PRODUC.NEXTVAL, 'HERBALIFE', 608, 2200, 'Suplemento alimenticio', 10.8);

INSERT INTO REGION_PRODUCTO VALUES (41503, 100, 800, 'DISPONIBLE');
INSERT INTO REGION_PRODUCTO VALUES (41503, 101, 650, 'DISPONIBLE');
INSERT INTO REGION_PRODUCTO VALUES (41503, 102, 120, 'DISPONIBLE');
INSERT INTO REGION_PRODUCTO VALUES (41503, 103, 510, 'DISPONIBLE');

INSERT INTO REPRESENTANTE_VENTA VALUES (102517, 'LaDoris', 'Perozo', '4562014', '123456', 41503, NULL);
INSERT INTO REPRESENTANTE_VENTA VALUES (248612, 'Duvan', 'Venavidez', '5426842', '123456', 41503, 102517);

INSERT INTO CLASIFICACION VALUES (1, 'BG', 100000, 200000, 3, '01/06/2017', '01/11/2017', 1.3);
INSERT INTO CLASIFICACION VALUES (2, 'JN', 210000, 400000, 3.5, '01/06/2017', '01/11/2017', 2.5);
INSERT INTO CLASIFICACION VALUES (3, 'SN', 410000, 800000, 4, '01/06/2017', '01/11/2017', 3.4);
INSERT INTO CLASIFICACION VALUES (4, 'MS', 810000, 1000000, 4.5, '01/06/2017', '01/11/2017', 5);

INSERT INTO HISTORICO_CLASIFICACION VALUES (102517, 2 , 3.8, 300000);
INSERT INTO HISTORICO_CLASIFICACION VALUES (248612, 3 , 4.4, 600000);

INSERT INTO CLIENTE VALUES (7412, 'Luis', 'Ramirez', '5842617', '123456');
INSERT INTO CLIENTE VALUES (7413, 'Mayvi', 'Ocampo', '5842617', '123456');
INSERT INTO CLIENTE VALUES (7414, 'Milton', 'Suescun', '5842617', '123456');
INSERT INTO CLIENTE VALUES (7415, 'Sebastian', 'Moreno', '5842617', '123456');

INSERT INTO REP_VENTA_CLIENTE VALUES (7412, 248612, '12/08/2017', NULL);
INSERT INTO REP_VENTA_CLIENTE VALUES (7413, 102517, '12/08/2017', NULL);

INSERT INTO TARJETA VALUES (SEQ_ID_TARJETA.NEXTVAL, 456123, 7412, 4264, '14/10/2018');

INSERT INTO PSE VALUES (SEQ_ID_PSE.NEXTVAL, 7413, 123456);