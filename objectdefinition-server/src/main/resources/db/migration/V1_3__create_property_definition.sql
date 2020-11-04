
create table property_definition (
    id                  serial PRIMARY KEY,
    object_definition   bigint references object_definiton,
    name                varchar(1024),
    cardinality         varchar(8)
);