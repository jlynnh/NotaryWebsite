package com.jenniferlholmes.notarywebsite.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jenniferlholmes.notarywebsite.models.Document;

@Repository

public interface DocumentRepository extends CrudRepository <Document, Long>{
	public ArrayList <Document> findAll();

}
