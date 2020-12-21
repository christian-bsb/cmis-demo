
create table property_definition (
    pk                      serial PRIMARY KEY,
    property_id             varchar(64) unique,
    obj_definition          bigint references obj_definition,
    name                    varchar(1024),
    property_definition     varchar(32),
    cardinality             varchar(8)
);