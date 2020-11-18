/*
Created: 15/11/2020
Modified: 15/11/2020
Model: PostgreSQL 11
Database: PostgreSQL 11
*/

-- Drop foreign keys (relationships) section ---------------------------------------------------

ALTER TABLE PET DROP CONSTRAINT pets_veterinary
;
ALTER TABLE PET DROP CONSTRAINT pets_type
;
ALTER TABLE DOCTOR DROP CONSTRAINT doctors_veterinary
;
ALTER TABLE QUOTES_PET DROP CONSTRAINT quotes_doctor
;
ALTER TABLE QUOTES_PET DROP CONSTRAINT quotes_pet
;
ALTER TABLE QUOTES_PET DROP CONSTRAINT quotes_vaccine
;
ALTER TABLE QUOTES_PET DROP CONSTRAINT quotes_medical
;
ALTER TABLE MEDICAL_SERVICE DROP CONSTRAINT medicals_veterinary
;

-- Drop keys section -------------------------------------------------

ALTER TABLE MEDICAL_SERVICE DROP CONSTRAINT PK_MEDICAL_SERVICE
;
ALTER TABLE QUOTES_PET DROP CONSTRAINT PK_QUOTES_PET
;
ALTER TABLE VACCINE DROP CONSTRAINT PK_VACCINE
;
ALTER TABLE TYPE_PET DROP CONSTRAINT PK_TYPE_PET
;
ALTER TABLE PET DROP CONSTRAINT PK_PET
;
ALTER TABLE VETERINARY DROP CONSTRAINT PK_VETERINARY
;
ALTER TABLE DOCTOR DROP CONSTRAINT PK_DOCTOR
;

-- Drop indexes section -------------------------------------------------

DROP INDEX vet_id_index
;
DROP INDEX doc_id_index
;
DROP INDEX pet_id_index
;
DROP INDEX vac_id_index
;
DROP INDEX mese_id_index
;
DROP INDEX vec_id_index
;

-- Drop tables section ---------------------------------------------------

DROP TABLE MEDICAL_SERVICE
;
DROP TABLE QUOTES_PET
;
DROP TABLE VACCINE
;
DROP TABLE TYPE_PET
;
DROP TABLE PET
;
DROP TABLE VETERINARY
;
DROP TABLE DOCTOR
;

-- Create tables section -------------------------------------------------

-- Table DOCTOR

CREATE TABLE DOCTOR
(
  doc_id Character varying NOT NULL,
  doc_name Character varying,
  doc_email Character varying,
  doc_phone Character varying,
  doc_speciality Character varying,
  doc_last_name Character varying,
  vet_id Character varying
)
WITH (
  autovacuum_enabled=true)
;

CREATE INDEX vet_id_index ON DOCTOR (vet_id)
;

ALTER TABLE DOCTOR ADD CONSTRAINT PK_DOCTOR PRIMARY KEY (doc_id)
;

-- Table VETERINARY

CREATE TABLE VETERINARY
(
  vet_id Character varying NOT NULL,
  vet_name Character varying,
  vet_description Character varying,
  vet_email Character varying,
  vet_address Character varying,
  vet_country Character varying,
  vet_city Character varying
)
WITH (
  autovacuum_enabled=true)
;

ALTER TABLE VETERINARY ADD CONSTRAINT PK_VETERINARY PRIMARY KEY (vet_id)
;

-- Table PET

CREATE TABLE PET
(
  pet_id Character varying NOT NULL,
  pet_name Character varying,
  pet_size Character varying,
  pet_owner_name Character varying,
  pet_description Character varying,
  vet_id Character varying NOT NULL,
  tipe_id Character varying NOT NULL,
  vape_id Character varying
)
WITH (
  autovacuum_enabled=true)
;

ALTER TABLE PET ADD CONSTRAINT PK_PET PRIMARY KEY (pet_id)
;

-- Table TYPE_PET

CREATE TABLE TYPE_PET
(
  tipe_id Character varying NOT NULL,
  tipe_name Character varying,
  tipe_description Character varying
)
WITH (
  autovacuum_enabled=true)
;

ALTER TABLE TYPE_PET ADD CONSTRAINT PK_TYPE_PET PRIMARY KEY (tipe_id)
;

-- Table VACCINE

CREATE TABLE VACCINE
(
  vac_id Character varying NOT NULL,
  vac_name Character varying,
  vac_description Character varying
)
WITH (
  autovacuum_enabled=true)
;

ALTER TABLE VACCINE ADD CONSTRAINT PK_VACCINE PRIMARY KEY (vac_id)
;

-- Table QUOTES_PET

CREATE TABLE QUOTES_PET
(
  vape_id Character varying NOT NULL,
  pet_id Character varying,
  vac_id Character varying,
  doc_id Character varying,
  vape_date Character varying,
  mese_id Character varying
)
WITH (
  autovacuum_enabled=true)
;

CREATE INDEX doc_id_index ON QUOTES_PET (doc_id)
;

CREATE INDEX pet_id_index ON QUOTES_PET (pet_id)
;

CREATE INDEX vac_id_index ON QUOTES_PET (vac_id)
;

CREATE INDEX mese_id_index ON QUOTES_PET (mese_id)
;

ALTER TABLE QUOTES_PET ADD CONSTRAINT PK_QUOTES_PET PRIMARY KEY (vape_id)
;

-- Table MEDICAL_SERVICE

CREATE TABLE MEDICAL_SERVICE
(
  mese_id Character varying NOT NULL,
  mese_name Character varying,
  mese_description Character varying,
  vet_id Character varying
)
WITH (
  autovacuum_enabled=true)
;

CREATE INDEX vec_id_index ON MEDICAL_SERVICE (vet_id)
;

ALTER TABLE MEDICAL_SERVICE ADD CONSTRAINT PK_MEDICAL_SERVICE PRIMARY KEY (mese_id)
;

-- Create foreign keys (relationships) section -------------------------------------------------

ALTER TABLE PET
  ADD CONSTRAINT pets_veterinary
    FOREIGN KEY (vet_id)
    REFERENCES VETERINARY (vet_id)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
;

ALTER TABLE PET
  ADD CONSTRAINT pets_type
    FOREIGN KEY (tipe_id)
    REFERENCES TYPE_PET (tipe_id)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
;

ALTER TABLE DOCTOR
  ADD CONSTRAINT doctors_veterinary
    FOREIGN KEY (vet_id)
    REFERENCES VETERINARY (vet_id)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
;

ALTER TABLE QUOTES_PET
  ADD CONSTRAINT quotes_doctor
    FOREIGN KEY (doc_id)
    REFERENCES DOCTOR (doc_id)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
;

ALTER TABLE QUOTES_PET
  ADD CONSTRAINT quotes_pet
    FOREIGN KEY (pet_id)
    REFERENCES PET (pet_id)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
;

ALTER TABLE QUOTES_PET
  ADD CONSTRAINT quotes_vaccine
    FOREIGN KEY (vac_id)
    REFERENCES VACCINE (vac_id)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
;

ALTER TABLE QUOTES_PET
  ADD CONSTRAINT quotes_medical
    FOREIGN KEY (mese_id)
    REFERENCES MEDICAL_SERVICE (mese_id)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
;

ALTER TABLE MEDICAL_SERVICE
  ADD CONSTRAINT medicals_veterinary
    FOREIGN KEY (vet_id)
    REFERENCES VETERINARY (vet_id)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
;

