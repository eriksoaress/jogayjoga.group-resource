CREATE TABLE group
(
    id_group character varying(36) NOT NULL,
    tx_name character varying(256) NOT NULL,
    tx_description character varying(256) NOT NULL,
    tx_qtd_members character INTEGER NOT NULL,
    CONSTRAINT pk_group PRIMARY KEY (id_group)
);