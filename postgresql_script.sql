CREATE TABLE ARCHIVO
(
  ID      SERIAL                            NOT NULL,
  NUMERO  INTEGER                            NOT NULL
);


CREATE TABLE CAJON
(
  ID          SERIAL                        NOT NULL,
  POSICION    VARCHAR(25 )                 NOT NULL,
  ARCHIVO_ID  INTEGER                        NOT NULL
);



CREATE TABLE DOCUMENTO
(
  ID               SERIAL                   NOT NULL,
  TIPO_DOCUMENTO   VARCHAR(25 )            NOT NULL,
  TITULO           VARCHAR(50 )            NOT NULL,
  FECHA_ARCHIVADO  DATE                         NOT NULL,
  CAJON_ID         INTEGER                   NOT NULL
);


CREATE UNIQUE INDEX DOCUMENTO_PK ON DOCUMENTO(ID);

CREATE UNIQUE INDEX CAJON_PK ON CAJON (ID);


CREATE UNIQUE INDEX ARCHIVO_PK ON ARCHIVO(ID);

CREATE TABLE ANEXO
(
  ID               SERIAL                  NOT NULL,
  TIPO_ANEXO       VARCHAR(25 )            NOT NULL,
  TITULO           VARCHAR(50 )            NOT NULL,
  FECHA_ARCHIVADO  DATE                         NOT NULL,
  DOCUMENTO_ID     INTEGER                   NOT NULL
);


CREATE UNIQUE INDEX ANEXO_PK ON ANEXO(ID);

ALTER TABLE ARCHIVO ADD CONSTRAINT ARCHIVO_PK
  PRIMARY KEY  
  USING INDEX ARCHIVO_PK
  ;

ALTER TABLE CAJON ADD 
  CONSTRAINT CAJON_PK
  PRIMARY KEY  
  USING INDEX CAJON_PK
  ;

ALTER TABLE DOCUMENTO ADD 
  CONSTRAINT DOCUMENTO_PK
  PRIMARY KEY
  USING INDEX DOCUMENTO_PK
  ;

ALTER TABLE ANEXO ADD 
  CONSTRAINT ANEXO_PK
  PRIMARY KEY
  USING INDEX ANEXO_PK
  ;

ALTER TABLE CAJON ADD 
  CONSTRAINT ARCHIVO_FK 
  FOREIGN KEY (ARCHIVO_ID) 
  REFERENCES ARCHIVO (ID)
  ;

ALTER TABLE DOCUMENTO ADD 
  CONSTRAINT CAJON_FK 
  FOREIGN KEY (CAJON_ID) 
  REFERENCES CAJON (ID)
  ;

ALTER TABLE ANEXO ADD 
  CONSTRAINT DOCUMENTO_FK 
  FOREIGN KEY (DOCUMENTO_ID) 
  REFERENCES DOCUMENTO (ID)
  ;
  
  
  
  
  --- data inserts:
  

Insert into ARCHIVO
   (ID, NUMERO)
 Values
   (1, 1);
Insert into ARCHIVO
   (ID, NUMERO)
 Values
   (2, 2);
Insert into ARCHIVO
   (ID, NUMERO)
 Values
   (3, 3);
   
   

Insert into CAJON
   (ID, POSICION, ARCHIVO_ID)
 Values
   (1, 'superior', 1);
Insert into CAJON
   (ID, POSICION, ARCHIVO_ID)
 Values
   (2, 'medio', 1);
Insert into CAJON
   (ID, POSICION, ARCHIVO_ID)
 Values
   (3, 'inferior', 1);
Insert into CAJON
   (ID, POSICION, ARCHIVO_ID)
 Values
   (4, 'superior', 2);
Insert into CAJON
   (ID, POSICION, ARCHIVO_ID)
 Values
   (5, 'medio', 2);
Insert into CAJON
   (ID, POSICION, ARCHIVO_ID)
 Values
   (6, 'inferior', 2);
Insert into CAJON
   (ID, POSICION, ARCHIVO_ID)
 Values
   (7, 'superior', 3);
Insert into CAJON
   (ID, POSICION, ARCHIVO_ID)
 Values
   (8, 'medio', 3);
Insert into CAJON
   (ID, POSICION, ARCHIVO_ID)
 Values
   (9, 'inferior', 3);

   
   Insert into DOCUMENTO
   (ID, TIPO_DOCUMENTO, TITULO, FECHA_ARCHIVADO, CAJON_ID)
 Values
   (8, 'cv', 'Curriculums', TO_DATE('03/03/2014 00:00:00', 'MM/DD/YYYY HH24:MI:SS'), 6);
Insert into DOCUMENTO
   (ID, TIPO_DOCUMENTO, TITULO, FECHA_ARCHIVADO, CAJON_ID)
 Values
   (1, 'contrato', 'Contrato Telefonia', TO_DATE('03/01/2014 00:00:00', 'MM/DD/YYYY HH24:MI:SS'), 4);
Insert into DOCUMENTO
   (ID, TIPO_DOCUMENTO, TITULO, FECHA_ARCHIVADO, CAJON_ID)
 Values
   (2, 'contrato', 'Contrato Otros Servicios', TO_DATE('07/12/2014 00:00:00', 'MM/DD/YYYY HH24:MI:SS'), 7);
Insert into DOCUMENTO
   (ID, TIPO_DOCUMENTO, TITULO, FECHA_ARCHIVADO, CAJON_ID)
 Values
   (3, 'albaran', 'Nuevos ordenadores', TO_DATE('03/01/2014 00:00:00', 'MM/DD/YYYY HH24:MI:SS'), 4);
Insert into DOCUMENTO
   (ID, TIPO_DOCUMENTO, TITULO, FECHA_ARCHIVADO, CAJON_ID)
 Values
   (4, 'contrato', 'Contrato Limpieza', TO_DATE('11/23/2014 00:00:00', 'MM/DD/YYYY HH24:MI:SS'), 3);
Insert into DOCUMENTO
   (ID, TIPO_DOCUMENTO, TITULO, FECHA_ARCHIVADO, CAJON_ID)
 Values
   (5, 'albaran', 'Material oficinal', TO_DATE('03/01/2014 00:00:00', 'MM/DD/YYYY HH24:MI:SS'), 1);
Insert into DOCUMENTO
   (ID, TIPO_DOCUMENTO, TITULO, FECHA_ARCHIVADO, CAJON_ID)
 Values
   (6, 'publicidad', 'Catalogo muebles', TO_DATE('03/01/2014 00:00:00', 'MM/DD/YYYY HH24:MI:SS'), 7);
Insert into DOCUMENTO
   (ID, TIPO_DOCUMENTO, TITULO, FECHA_ARCHIVADO, CAJON_ID)
 Values
   (7, 'contrato', 'Contrato Moviles', TO_DATE('04/01/2015 00:00:00', 'MM/DD/YYYY HH24:MI:SS'), 3);


   
   
   Insert into ANEXO
   (ID, TIPO_ANEXO, TITULO, FECHA_ARCHIVADO, DOCUMENTO_ID)
 Values
   (1, 'factura', 'Factura Mayo Telefonia', TO_DATE('06/03/2015 00:00:00', 'MM/DD/YYYY HH24:MI:SS'), 1);
Insert into ANEXO
   (ID, TIPO_ANEXO, TITULO, FECHA_ARCHIVADO, DOCUMENTO_ID)
 Values
   (2, 'factura', 'Factura Junio Telefonia', TO_DATE('07/03/2015 00:00:00', 'MM/DD/YYYY HH24:MI:SS'), 1);
Insert into ANEXO
   (ID, TIPO_ANEXO, TITULO, FECHA_ARCHIVADO, DOCUMENTO_ID)
 Values
   (3, 'factura', 'Factura Julio Telefonia', TO_DATE('08/03/2015 00:00:00', 'MM/DD/YYYY HH24:MI:SS'), 1);
Insert into ANEXO
   (ID, TIPO_ANEXO, TITULO, FECHA_ARCHIVADO, DOCUMENTO_ID)
 Values
   (4, 'promocion', 'Promocion Junio Telefonia', TO_DATE('06/07/2015 00:00:00', 'MM/DD/YYYY HH24:MI:SS'), 1);
Insert into ANEXO
   (ID, TIPO_ANEXO, TITULO, FECHA_ARCHIVADO, DOCUMENTO_ID)
 Values
   (5, 'factura', 'Factura albaran ordenadores', TO_DATE('06/03/2015 00:00:00', 'MM/DD/YYYY HH24:MI:SS'), 3);
Insert into ANEXO
   (ID, TIPO_ANEXO, TITULO, FECHA_ARCHIVADO, DOCUMENTO_ID)
 Values
   (6, 'factura', 'Factura servicio limpieza Mayo', TO_DATE('06/03/2015 00:00:00', 'MM/DD/YYYY HH24:MI:SS'), 4);
Insert into ANEXO
   (ID, TIPO_ANEXO, TITULO, FECHA_ARCHIVADO, DOCUMENTO_ID)
 Values
   (7, 'factura', 'Factura Electricista', TO_DATE('01/03/2015 00:00:00', 'MM/DD/YYYY HH24:MI:SS'), 2);
Insert into ANEXO
   (ID, TIPO_ANEXO, TITULO, FECHA_ARCHIVADO, DOCUMENTO_ID)
 Values
   (8, 'factura', 'Factura Transportista', TO_DATE('06/03/2015 00:00:00', 'MM/DD/YYYY HH24:MI:SS'), 2);
Insert into ANEXO
   (ID, TIPO_ANEXO, TITULO, FECHA_ARCHIVADO, DOCUMENTO_ID)
 Values
   (9, 'catalogo', 'Catalogo Ikea', TO_DATE('02/14/2015 00:00:00', 'MM/DD/YYYY HH24:MI:SS'), 6);
Insert into ANEXO
   (ID, TIPO_ANEXO, TITULO, FECHA_ARCHIVADO, DOCUMENTO_ID)
 Values
   (10, 'folleto', 'Nuevos terminales', TO_DATE('01/01/2015 00:00:00', 'MM/DD/YYYY HH24:MI:SS'), 7);
   
   
COMMIT;




