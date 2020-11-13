
create table property_definition (
    id                  serial PRIMARY KEY,
    obj_definition      bigint references obj_definition,
    name                varchar(1024),
    cardinality         varchar(8)
);