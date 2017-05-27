CREATE DATABASE employees
  WITH OWNER = postgres
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       CONNECTION LIMIT = -1;

CREATE TABLE employee
(
  id integer NOT NULL DEFAULT nextval('employees_id_seq'::regclass),
  name text,
  CONSTRAINT employees_pkey PRIMARY KEY (id)
)
ALTER TABLE employee
  OWNER TO postgres;
