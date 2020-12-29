

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
    * show a form: http://localhost:8086/repository/1/type/book/form
  * type server: http://localhost:8083
    * list all types: http://localhost:8083/repository/1/types
    * show a type: http://localhost:8083/repository/1/type/{typeId}
    * show the book type: http://localhost:8083/repository/1/type/book
  * document server: http://localhost:8087
    * list Docs: http://localhost:8087/repository/1/documents
  * admin server: http://localhost:8088
    * edit book type: http://localhost:8088/repository/1/type/book/update
    * new type: http://localhost:8088/repository/1/type/insert
  * solr: http://localhost:8983/solr

## Reset Database

drop table flyway_schema_history cascade;
drop table werk cascade;
drop table obj_definition cascade;
drop table property_definition cascade;


## selects

select * from obj_definition

select * from property_definition

## create cms strapi database

create user strapi with password 'strapi';

CREATE DATABASE strapi;

grant all privileges on database strapi to strapi;

## cms starten

sudo docker run -it \
  -e DATABASE_CLIENT=postgres \
  -e DATABASE_NAME=strapi \
  -e DATABASE_HOST=localhost \
  -e DATABASE_PORT=5433 \
  -e DATABASE_USERNAME=strapi \
  -e DATABASE_PASSWORD=strapi \
  -p 1337:1337 \
  -v `pwd`/project-name:/srv/app \
  strapi/strapi

### connection errors
https://stackoverflow.com/questions/33357567/econnrefused-for-postgres-on-nodejs-with-dockers

# Components
## CMS Strapi
  * https://strapi.io/
  * im docker: https://github.com/strapi/strapi-docker