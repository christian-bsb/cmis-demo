

<p align="center">
  <img src="http://docs.oasis-open.org/cmis/CMIS/v1.1/os/images/cmis.png" alt="CMIS-logo" width="240">
  <div align="center">Content Management Interoperability Services</div>
  <div align="center">Demo Service based on Java Spring Boot</div>
</p>


# cmis-demo

## URLs
  * cmis server: http://localhost:8085
    * list all types: http://localhost:8085/repository/1/types
  * forms server: http://localhost:8086
    * show a form: http://localhost:8086/repository/1/type/1/form
  * type server: http://localhost:8083
    * list all types: http://localhost:8083/repository/1/types
    * show a type: http://localhost:8083/repository/1/type/{typeId}
  * document server: http://localhost:8087
    * list Docs: http://localhost:8087/repository/1/documents
  * admin server: http://localhost:8088
    * edit type: http://localhost:8088/repository/1/type/1/edit
  * solr: http://localhost:8983/solr

## Reset Database

drop table flyway_schema_history cascade;
drop table werk cascade;
drop table obj_definition cascade;
drop table property_definition cascade;


## selects

select * from obj_definition

select * from property_definition