CREATE TABLE MARCAS (
    codigo INTEGER PRIMARY KEY,
    nombre_marca VARCHAR2(100)
);

CREATE SEQUENCE marcas_seq
START WITH 1
INCREMENT BY 1
NOCACHE
NOCYCLE;

CREATE OR REPLACE TRIGGER marcas_trigger
BEFORE INSERT ON MARCAS
FOR EACH ROW
BEGIN
    IF :NEW.codigo IS NULL THEN
        SELECT marcas_seq.NEXTVAL
        INTO :NEW.codigo
        FROM dual;
    END IF;
END;

CREATE TABLE CLIENTES (
    tipo_documento VARCHAR2(2),
    documento INTEGER,
    primer_nombre VARCHAR2(30),
    segundo_nombre VARCHAR2(30),
    primer_apellido VARCHAR2(30),
    segundo_apellido VARCHAR2(30),
    celular VARCHAR2(10),
    direccion VARCHAR2(200),
    email VARCHAR2(100),
    estado CHAR(1),
    presupuesto NUMBER,
    PRIMARY KEY (documento, tipo_documento)
);

CREATE TABLE MECANICOS (
    tipo_documento VARCHAR2(2),
    documento INTEGER,
    primer_nombre VARCHAR2(30),
    segundo_nombre VARCHAR2(30),
    primer_apellido VARCHAR2(30),
    segundo_apellido VARCHAR2(30),
    celular VARCHAR2(10),
    direccion VARCHAR2(200),
    email VARCHAR2(100),
    estado VARCHAR(10),
    PRIMARY KEY (documento, tipo_documento)
);

CREATE TABLE VEHICULOS (
    placa VARCHAR2(6) PRIMARY KEY,
    color VARCHAR2(20),
    cod_marca INTEGER,
    cli_documento INTEGER,
    cli_tipo_documento VARCHAR2(2),
    FOREIGN KEY (cod_marca) REFERENCES MARCAS(codigo),
    FOREIGN KEY (cli_documento, cli_tipo_documento) REFERENCES CLIENTES(documento, tipo_documento)
);

CREATE TABLE SERVICIOS (
    codigo INTEGER PRIMARY KEY,
    nombre_servicio VARCHAR2(100),
    precio NUMBER
);

CREATE SEQUENCE servicios_seq
START WITH 1
INCREMENT BY 1
NOCACHE
NOCYCLE;

CREATE OR REPLACE TRIGGER servicios_trigger
BEFORE INSERT ON SERVICIOS
FOR EACH ROW
BEGIN
    IF :NEW.codigo IS NULL THEN
        SELECT servicios_seq.NEXTVAL
        INTO :NEW.codigo
        FROM dual;
    END IF;
END;

CREATE TABLE REPUESTOS (
    codigo INTEGER PRIMARY KEY,
    nombre_repuesto VARCHAR2(100),
    precio_unitario NUMBER,
    unidades_inventario INTEGER,
    proveedor VARCHAR2(300)
);

CREATE SEQUENCE repuestos_seq
START WITH 1
INCREMENT BY 1
NOCACHE
NOCYCLE;

CREATE OR REPLACE TRIGGER repuestos_trigger
BEFORE INSERT ON REPUESTOS
FOR EACH ROW
BEGIN
    IF :NEW.codigo IS NULL THEN
        SELECT repuestos_seq.NEXTVAL
        INTO :NEW.codigo
        FROM dual;
    END IF;
END;


CREATE TABLE MANTENIMIENTOS (
    codigo INTEGER PRIMARY KEY,
    estado VARCHAR2(20),
    cod_placa VARCHAR2(6),
    fecha DATE,
    mec_documento INTEGER,
    mec_tipo_documento VARCHAR2(2),
    FOREIGN KEY (cod_placa) REFERENCES VEHICULOS(placa),
    FOREIGN KEY (mec_documento, mec_tipo_documento) REFERENCES MECANICOS(documento, tipo_documento)
);

CREATE OR REPLACE TRIGGER mantenimientos_trigger
BEFORE INSERT ON MANTENIMIENTOS
FOR EACH ROW
BEGIN
    IF :NEW.codigo IS NULL THEN
        SELECT mantenimientos_seq.NEXTVAL
        INTO :NEW.codigo
        FROM dual;
    END IF;
END;


CREATE TABLE FOTOS (
    codigo INTEGER PRIMARY KEY,
    ruta VARCHAR2(200),
    cod_mantenimiento INTEGER,
    FOREIGN KEY (cod_mantenimiento) REFERENCES MANTENIMIENTOS(codigo)
);

CREATE TABLE REPUESTOS_X_MANTENIMIENTOS (
    codigo INTEGER PRIMARY KEY,
    unidades INTEGER,
    tiempo_estimado INTEGER,
    cod_mantenimiento INTEGER,
    cod_repuesto INTEGER,
    FOREIGN KEY (cod_mantenimiento) REFERENCES MANTENIMIENTOS(codigo),
    FOREIGN KEY (cod_repuesto) REFERENCES REPUESTOS(codigo)
);

CREATE SEQUENCE repuestos_x_mantenimientos_seq
START WITH 1
INCREMENT BY 1
NOCACHE
NOCYCLE;

CREATE OR REPLACE TRIGGER repuestos_x_mantenimientos_trigger
BEFORE INSERT ON REPUESTOS_X_MANTENIMIENTOS
FOR EACH ROW
BEGIN
    IF :NEW.codigo IS NULL THEN
        SELECT repuestos_x_mantenimientos_seq.NEXTVAL
        INTO :NEW.codigo
        FROM dual;
    END IF;
END;
/



CREATE TABLE SERVICIOS_X_MANTENIMIENTOS (
    codigo INTEGER PRIMARY KEY,
    tiempo_estimado INTEGER,
    cod_servicio INTEGER,
    cod_mantenimiento INTEGER,
    FOREIGN KEY (cod_servicio) REFERENCES SERVICIOS(codigo),
    FOREIGN KEY (cod_mantenimiento) REFERENCES MANTENIMIENTOS(codigo)
);

CREATE SEQUENCE servicios_x_mantenimientos_seq
START WITH 1
INCREMENT BY 1
NOCACHE
NOCYCLE;

CREATE OR REPLACE TRIGGER servicios_x_mantenimientos_trigger
BEFORE INSERT ON SERVICIOS_X_MANTENIMIENTOS
FOR EACH ROW
BEGIN
    IF :NEW.codigo IS NULL THEN
        SELECT servicios_x_mantenimientos_seq.NEXTVAL
        INTO :NEW.codigo
        FROM dual;
    END IF;
END;



-- Crear un procedimiento almacenado para insertar datos
CREATE OR REPLACE PROCEDURE insertarMecanico (
    primerNombre IN VARCHAR2,
    segundoNombre IN VARCHAR2,
    primerApellido IN VARCHAR2,
    segundoApellido IN VARCHAR2,
    tipoDocumento IN VARCHAR2,
    documento IN NUMBER,
    celular IN VARCHAR2,
    direccion IN VARCHAR2,
    email IN VARCHAR2,
    estado IN VARCHAR2
)
IS
BEGIN
    INSERT INTO MECANICOS (
        primer_nombre, segundo_nombre, primer_apellido, segundo_apellido,
        tipo_documento, documento, celular, direccion, email, estado
    )
    VALUES (
        primerNombre, segundoNombre, primerApellido, segundoApellido,
        tipoDocumento, documento, celular, direccion, email, estado
    );
END;
/







