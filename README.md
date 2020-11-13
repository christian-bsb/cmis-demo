# cmis-demo

## Reset Database

drop table flyway_schema_history cascade;
drop table werk cascade;
drop table obj_definition cascade;
drop table property_definition cascade;


## selects

select * from obj_definition

select * from property_definition