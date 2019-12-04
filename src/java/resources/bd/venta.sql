/* 
 * Autor:  hiralda
 * Email: castroc.hiralda@gmail.com
 * Creación: 26/11/2019
 * Modificación: 3/12/2019
 */
CREATE TABLE public.usuario
(
    idusuario bigserial NOT NULL,
    nombre text NOT NULL,
    tipo text NOT NULL,
    contrasena text NOT NULL,
    usuario text NOT NULL,
    CONSTRAINT usuario_pkey PRIMARY KEY (idusuario),
    CONSTRAINT uq_usuario UNIQUE (usuario)
);

CREATE TABLE public.producto
(
    idproducto text NOT NULL,
    nombre text NOT NULL,
    marca text NOT NULL,
    descripcion text NOT NULL,
    precio numeric NOT NULL,
    existencia integer NOT NULL,
    CONSTRAINT producto_pkey PRIMARY KEY (idproducto)
);

CREATE TABLE public.venta
(
    idventa biginit NOT NULL ,
    fecha timestamp without time zone NOT NULL,
    total numeric NOT NULL,
    usuarioid bigint NOT NULL,
    CONSTRAINT venta_pkey PRIMARY KEY (idventa)
);

CREATE TABLE public.detalle
(
    ventaid biginit NOT NULL,
    cantidad integer NOT NULL,
    productoid text NOT NULL,
    CONSTRAINT detalle_pkey PRIMARY KEY (ventaid, productoid),
    CONSTRAINT fk_producto FOREIGN KEY (productoid)
        REFERENCES public.producto (idproducto),
    CONSTRAINT fk_venta FOREIGN KEY (ventaid)
        REFERENCES public.venta (idventa) 
);
