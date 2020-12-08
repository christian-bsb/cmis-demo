

<p align="center">
  <img src="http://docs.oasis-open.org/cmis/CMIS/v1.1/os/images/cmis.png" alt="CMIS-logo" width="240">
  <div align="center">Content Management Interoperability Services</div>
  <div align="center">Demo Service based on Java Spring Boot</div>
</p>


# cmis-demo

## Reset Database

drop table flyway_schema_history cascade;
drop table werk cascade;
drop table obj_definition cascade;
drop table property_definition cascade;


## selects

select * from obj_definition

select * from property_definition