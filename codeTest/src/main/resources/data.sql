DROP TABLE IF EXISTS User;

CREATE TABLE User
(
    id integer NOT NULL,
    user_id varchar(255) not null,
    user_enc_pwd varchar(255) not null,
    primary key(id)
);

INSERT INTO User Values (1, 'admin', 'admin');