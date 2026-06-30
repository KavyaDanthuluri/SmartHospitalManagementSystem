--
-- PostgreSQL database dump
--

\restrict D2lJi7z9JzsrkIsIIpykAZvw8nRlIvZ0e1HJG3ubA95Y6rbmsdUgmd2Q9Xogcym

-- Dumped from database version 18.1
-- Dumped by pg_dump version 18.1

-- Started on 2026-06-30 09:57:50

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
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
-- TOC entry 219 (class 1259 OID 34902)
-- Name: appointment; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.appointment (
    id integer NOT NULL,
    appointment_date date,
    appointment_time time(0) without time zone,
    status character varying(255),
    doctor_id integer,
    patient_id integer
);


ALTER TABLE public.appointment OWNER TO postgres;

--
-- TOC entry 220 (class 1259 OID 34908)
-- Name: billing; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.billing (
    id integer NOT NULL,
    amount double precision NOT NULL,
    payment_method character varying(255),
    payment_status character varying(255),
    patient_id integer
);


ALTER TABLE public.billing OWNER TO postgres;

--
-- TOC entry 221 (class 1259 OID 34917)
-- Name: department; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.department (
    id integer NOT NULL,
    department_name character varying(255),
    description character varying(255)
);


ALTER TABLE public.department OWNER TO postgres;

--
-- TOC entry 222 (class 1259 OID 34925)
-- Name: doctor; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.doctor (
    id integer NOT NULL,
    consultation_fee double precision,
    email character varying(255),
    experience integer,
    name character varying(255),
    specialization character varying(255),
    department_id integer
);


ALTER TABLE public.doctor OWNER TO postgres;

--
-- TOC entry 223 (class 1259 OID 34933)
-- Name: patient; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.patient (
    id integer NOT NULL,
    address character varying(255),
    age integer NOT NULL,
    email character varying(255),
    gender character varying(255),
    name character varying(255),
    phone character varying(255)
);


ALTER TABLE public.patient OWNER TO postgres;

--
-- TOC entry 224 (class 1259 OID 34942)
-- Name: prescription; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.prescription (
    id integer NOT NULL,
    diagnosis character varying(255),
    instructions character varying(255),
    medicines character varying(255),
    appointment_id integer
);


ALTER TABLE public.prescription OWNER TO postgres;

--
-- TOC entry 4876 (class 2606 OID 34907)
-- Name: appointment appointment_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.appointment
    ADD CONSTRAINT appointment_pkey PRIMARY KEY (id);


--
-- TOC entry 4878 (class 2606 OID 34916)
-- Name: billing billing_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.billing
    ADD CONSTRAINT billing_pkey PRIMARY KEY (id);


--
-- TOC entry 4880 (class 2606 OID 34924)
-- Name: department department_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.department
    ADD CONSTRAINT department_pkey PRIMARY KEY (id);


--
-- TOC entry 4882 (class 2606 OID 34932)
-- Name: doctor doctor_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.doctor
    ADD CONSTRAINT doctor_pkey PRIMARY KEY (id);


--
-- TOC entry 4884 (class 2606 OID 34941)
-- Name: patient patient_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.patient
    ADD CONSTRAINT patient_pkey PRIMARY KEY (id);


--
-- TOC entry 4886 (class 2606 OID 34949)
-- Name: prescription prescription_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.prescription
    ADD CONSTRAINT prescription_pkey PRIMARY KEY (id);


--
-- TOC entry 4888 (class 2606 OID 34951)
-- Name: prescription ukqiwnn1r91ywfuflspffy0rsse; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.prescription
    ADD CONSTRAINT ukqiwnn1r91ywfuflspffy0rsse UNIQUE (appointment_id);


--
-- TOC entry 4889 (class 2606 OID 34957)
-- Name: appointment fk4apif2ewfyf14077ichee8g06; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.appointment
    ADD CONSTRAINT fk4apif2ewfyf14077ichee8g06 FOREIGN KEY (patient_id) REFERENCES public.patient(id);


--
-- TOC entry 4892 (class 2606 OID 34967)
-- Name: doctor fk75x47tyyeco3xj4cmlhj8v6ta; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.doctor
    ADD CONSTRAINT fk75x47tyyeco3xj4cmlhj8v6ta FOREIGN KEY (department_id) REFERENCES public.department(id);


--
-- TOC entry 4893 (class 2606 OID 34972)
-- Name: prescription fkba3shvghb1nrydjy9khc9c6a7; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.prescription
    ADD CONSTRAINT fkba3shvghb1nrydjy9khc9c6a7 FOREIGN KEY (appointment_id) REFERENCES public.appointment(id);


--
-- TOC entry 4890 (class 2606 OID 34952)
-- Name: appointment fkoeb98n82eph1dx43v3y2bcmsl; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.appointment
    ADD CONSTRAINT fkoeb98n82eph1dx43v3y2bcmsl FOREIGN KEY (doctor_id) REFERENCES public.doctor(id);


--
-- TOC entry 4891 (class 2606 OID 34962)
-- Name: billing fku08erpk3um4b9vratnsipspk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.billing
    ADD CONSTRAINT fku08erpk3um4b9vratnsipspk FOREIGN KEY (patient_id) REFERENCES public.patient(id);


-- Completed on 2026-06-30 09:57:51

--
-- PostgreSQL database dump complete
--

\unrestrict D2lJi7z9JzsrkIsIIpykAZvw8nRlIvZ0e1HJG3ubA95Y6rbmsdUgmd2Q9Xogcym

