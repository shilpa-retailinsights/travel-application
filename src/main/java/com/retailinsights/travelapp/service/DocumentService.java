package com.retailinsights.travelapp.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retailinsights.travelapp.entiry.Documents;
import com.retailinsights.travelapp.repo.DocumentsRepository;

@Service
public class DocumentService {

	@Autowired
	private DocumentsRepository documentsRepository;

	public Documents addDocuments(Documents documentDetails) {
		return documentsRepository.save(documentDetails);
	}
	
	public List<Documents> findAllDocuments(){
		return documentsRepository.findAll();
	}
	
	public Optional<Documents> findByDocId(UUID documentId){
		return documentsRepository.findById(documentId);
	}

	public Documents updateDocument(Documents document) {
		Documents updateDocument = documentsRepository.save(document);
		return updateDocument;
	}
	
	public void deleteDocument(UUID documentId) {
		documentsRepository.deleteById(documentId);
	}
}
