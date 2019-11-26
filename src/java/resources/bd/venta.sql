/* 
 * Autor:  hiralda
 * Email: castroc.hiralda@gmail.com
 * Creación: 26/11/2019
 *
 */

CREATE TABLE public.usuario
(
    idusuario bigint NOT NULL DEFAULT nextval('usuario_id_seq'::regclass),
    nombre text COLLATE pg_catalog."default" NOT NULL,
    tipo text COLLATE pg_catalog."default" NOT NULL,
    contrasena text COLLATE pg_catalog."default" NOT NULL,
    usuario text COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT usuario_pkey PRIMARY KEY (idusuario),
    CONSTRAINT uq_usuario UNIQUE (usuario)

)

CREATE TABLE public.producto
(
    idproducto text COLLATE pg_catalog."default" NOT NULL,
    nombre text COLLATE pg_catalog."default" NOT NULL,
    marca text COLLATE pg_catalog."default" NOT NULL,
    descripcion text COLLATE pg_catalog."default" NOT NULL,
    precio numeric NOT NULL,
    existencia integer NOT NULL,
    CONSTRAINT producto_pkey PRIMARY KEY (idproducto)
)

CREATE TABLE public.venta
(
    idventa bigint NOT NULL DEFAULT nextval('venta_idventa_seq'::regclass),
    hora timestamp without time zone NOT NULL,
    total numeric NOT NULL,
    usuarioid bigint NOT NULL,
    CONSTRAINT venta_pkey PRIMARY KEY (idventa)
)

CREATE TABLE public.detalle
(
    ventaid bigint NOT NULL DEFAULT nextval('detalle_ventaid_seq'::regclass),
    cantidad integer NOT NULL,
    productoid text COLLATE pg_catalog."default" NOT NULL,
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