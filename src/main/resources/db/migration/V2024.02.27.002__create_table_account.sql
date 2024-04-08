CREATE TABLE group_
(
    id_group character varying(36) NOT NULL,
    tx_name character varying(256) NOT NULL,
    tx_description character varying(256) NOT NULL,
    tx_qtd_members INTEGER NOT NULL,
    CONSTRAINT pk_group PRIMARY KEY (id_group)
);