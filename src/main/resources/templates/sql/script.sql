--
-- PostgreSQL database dump
--

-- Dumped from database version 15.3
-- Dumped by pg_dump version 15.1

-- Started on 2023-09-11 11:10:22

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 214 (class 1259 OID 16422)
-- Name: paciente; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.paciente (
    nome character varying(40),
    genero character varying(20),
    idade integer,
    codigo bigint NOT NULL,
    peso double precision,
    altura double precision
);


ALTER TABLE public.paciente OWNER TO postgres;

--
-- TOC entry 215 (class 1259 OID 16425)
-- Name: paciente_codigo_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.paciente ALTER COLUMN codigo ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.paciente_codigo_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


-- Completed on 2023-09-11 11:10:22

--
-- PostgreSQL database dump complete
--

