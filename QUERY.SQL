/*////////////////////////////////////////////// DATABASE //////////////////////////////////////////////*/

-- Database: nexos

-- DROP DATABASE IF EXISTS nexos;

CREATE DATABASE nexos
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Spanish_Colombia.1252'
    LC_CTYPE = 'Spanish_Colombia.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

COMMENT ON DATABASE nexos
IS 'Base de datos para la prueba tecnica de nexos software';


/*/////////////////////////////////////////////// TABLES ///////////////////////////////////////////////*/

-- Table: public.charges

-- DROP TABLE IF EXISTS public.charges;

CREATE TABLE IF NOT EXISTS public.charges
(
    id bigint NOT NULL,
    charge character varying(255) COLLATE pg_catalog."default" NOT NULL,
    created_by character varying(255) COLLATE pg_catalog."default" NOT NULL,
    creation_on timestamp without time zone NOT NULL,
    modified_by character varying(255) COLLATE pg_catalog."default",
    modified_on timestamp without time zone,
    CONSTRAINT charges_pkey PRIMARY KEY (id),
    CONSTRAINT uk_845sev8xum1s58gjew5i7q5m3 UNIQUE (charge)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.charges
OWNER to postgres;


-- Table: public.users

-- DROP TABLE IF EXISTS public.users;

CREATE TABLE IF NOT EXISTS public.users
(
    id bigint NOT NULL,
    admission_date timestamp without time zone NOT NULL,
    age integer NOT NULL,
    charge character varying(255) COLLATE pg_catalog."default" NOT NULL,
    created_by character varying(255) COLLATE pg_catalog."default" NOT NULL,
    creation_on timestamp without time zone NOT NULL,
    modified_by character varying(255) COLLATE pg_catalog."default",
    modified_on timestamp without time zone,
    name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT users_pkey PRIMARY KEY (id),
    CONSTRAINT uk_3g1j96g94xpk3lpxl2qbl985x UNIQUE (name)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.users
OWNER to postgres;


-- Table: public.commodity

-- DROP TABLE IF EXISTS public.commodity;

CREATE TABLE IF NOT EXISTS public.commodity
(
    id bigint NOT NULL,
    admission_date timestamp without time zone NOT NULL,
    created_by character varying(255) COLLATE pg_catalog."default" NOT NULL,
    creation_on timestamp without time zone NOT NULL,
    modified_by character varying(255) COLLATE pg_catalog."default",
    modified_on timestamp without time zone,
    product character varying(255) COLLATE pg_catalog."default" NOT NULL,
    quantity integer NOT NULL,
    user_insert character varying(255) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT commodity_pkey PRIMARY KEY (id),
    CONSTRAINT uk_milk4oyotcjgmcc085rpdedyj UNIQUE (product)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.commodity
OWNER to postgres;