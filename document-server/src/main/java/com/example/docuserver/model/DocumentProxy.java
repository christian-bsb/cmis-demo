package com.example.docuserver.model;

public interface DocumentProxy {

  EagerPart getEagerPart();

  LazyPart getLazyPart();
}
