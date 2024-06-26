CREATE TABLE PEDIDO_CABECERA(
    PEDIDO_ID NUMERIC(6) NOT NULL PRIMARY KEY,
    CLIENTE_ID NUMERIC(6) NOT NULL,
    GLOSA VARCHAR2(240) NULL,
    FECHA_REGISTRO DATE DEFAULT SYSDATE,
    
    TOTAL NUMERIC(9,2) NOT NULL,

    ESTADO CHAR(1) DEFAULT '1' NOT NULL
);

CREATE TABLE PEDIDO_DETALLE(
    PEDIDO_DETALLE_ID NUMERIC(6) NOT NULL PRIMARY KEY,
    PEDIDO_ID NUMERIC(6) REFERENCES PEDIDO_CABECERA(PEDIDO_ID),
    PRODUCTO_ID NUMERIC(6)NOT NULL,
    CANTIDAD NUMERIC(6) NOT NULL,
    PRECIO NUMERIC(6,2) NOT NULL,
    SUB_TOTAL NUMERIC(9,2) NOT NULL,
    
    ESTADO CHAR(1) DEFAULT '1' NOT NULL
);


CREATE SEQUENCE SEQ_PEDIDO_CABECERA;

INSERT INTO PEDIDO_CABECERA(PEDIDO_ID,CLIENTE_ID,GLOSA,TOTAL) VALUES(SEQ_PEDIDO_CABECERA.NEXTVAL, 1,'Pedido demo',7500);
COMMIT;

INSERT INTO PEDIDO_CABECERA(PEDIDO_ID,CLIENTE_ID,GLOSA,TOTAL) VALUES(SEQ_PEDIDO_CABECERA.NEXTVAL, 2,'Pedido demo 2',5000);
COMMIT;

SELECT * FROM PEDIDO_CABECERA;

CREATE SEQUENCE SEQ_PEDIDO_DETALLE;

INSERT INTO PEDIDO_DETALLE(PEDIDO_DETALLE_ID,PEDIDO_ID,PRODUCTO_ID,CANTIDAD,PRECIO,SUB_TOTAL) VALUES(SEQ_PEDIDO_DETALLE.NEXTVAL, 1,1,2,3000,6000);
INSERT INTO PEDIDO_DETALLE(PEDIDO_DETALLE_ID,PEDIDO_ID,PRODUCTO_ID,CANTIDAD,PRECIO,SUB_TOTAL) VALUES(SEQ_PEDIDO_DETALLE.NEXTVAL, 1,3,1,1500,1500);
INSERT INTO PEDIDO_DETALLE(PEDIDO_DETALLE_ID,PEDIDO_ID,PRODUCTO_ID,CANTIDAD,PRECIO,SUB_TOTAL) VALUES(SEQ_PEDIDO_DETALLE.NEXTVAL, 2,4,1,5000,5000);

COMMIT;

SELECT * FROM PEDIDO_DETALLE;
