package com.jenniferlholmes.notarywebsite.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jenniferlholmes.notarywebsite.models.Document;
import com.jenniferlholmes.notarywebsite.repositories.DocumentRepository;


@Service

public class DocumentService {
	@Autowired
	private DocumentRepository repoDoc;
	
	//Get All
	public ArrayList<Document> all() {
		return repoDoc.findAll();	}
	
	//Find One By ID
		public Document findOne(Long id) {
			return repoDoc.findById(id).orElse(null);
		}
		
	//Create
	public Document create(Document document) {
		return repoDoc.save(document);
	}
	
	//Update
	public Document update(Document document) {
		return repoDoc.save(document);
	}
	
	//Delete
	public void destroy(Long id) {
		repoDoc.deleteById(id);
	}


}
