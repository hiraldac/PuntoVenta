/* 
 * Autor:  hiralda
 * Email: castroc.hiralda@gmail.com
 * Creación: 26/11/2019
 * Modificación: 26/11/2019
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

)

CREATE TABLE public.producto
(
    idproducto text NOT NULL,
    nombre text NOT NULL,
    marca text NOT NULL,
    descripcion text NOT NULL,
    precio numeric NOT NULL,
    existencia integer NOT NULL,
    CONSTRAINT producto_pkey PRIMARY KEY (idproducto)
)

CREATE TABLE public.venta
(
    idventa bigserial NOT NULL ,
    hora timestamp without time zone NOT NULL,
    total numeric NOT NULL,
    usuarioid bigint NOT NULL,
    CONSTRAINT venta_pkey PRIMARY KEY (idventa)
)

CREATE TABLE public.detalle
(
    ventaid bigserial NOT NULL,
    cantidad integer NOT NULL,
    productoid text NOT NULL,
    CONSTRAINT detalle_pkey PRIMARY KEY (ventaid, cantidad),
    CONSTRAINT fk_producto FOREIGN KEY (productoid)
        REFERENCES public.producto (idproducto) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk_venta FOREIGN KEY (ventaid)
        REFERENCES public.venta (idventa) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)