
create table obj_definition (
    pk              serial PRIMARY KEY,
    type_id         varchar(64) unique,
    name            varchar(1024)
);