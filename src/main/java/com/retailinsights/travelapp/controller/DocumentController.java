package com.retailinsights.travelapp.controller;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.retailinsights.travelapp.entiry.Documents;
import com.retailinsights.travelapp.entiry.Student;
import com.retailinsights.travelapp.model.DocumentsFormDto;
import com.retailinsights.travelapp.service.DocumentService;
import com.retailinsights.travelapp.service.StudentService;

@RestController
public class DocumentController {
	 @Autowired
	 private DocumentService documentService;
	 
	 @Autowired
	 private StudentService studentService;
	 
	 @PostMapping("/api/v1/documents")
	 public ResponseEntity<Documents> addDocument(@RequestBody DocumentsFormDto documentsDto) {
		  Optional<Student> student = studentService.findStudentById(documentsDto.getStudent_id());
		  Documents documentDetails = new Documents();
		 //documentDetails.setId(documentsDto.getId());
		  documentDetails.setStudent(student.get());
		 documentDetails.setName(documentsDto.getName());
		 documentDetails.setImage(documentsDto.getImage());
		 documentDetails.setSize(documentsDto.getSize());
		 documentDetails.setStatus(documentsDto.getStatus());
		 documentDetails.setType(documentsDto.getType());
		 documentDetails.setUploaded_date(documentsDto.getUploaded_date());
		 Documents addedDocuments = documentService.addDocuments(documentDetails);
		return new ResponseEntity<Documents>(addedDocuments,HttpStatus.CREATED);
	 }
	 
	 @GetMapping("/api/v1/documents/{documentId}")
	 public Documents findByDocId(@PathVariable(name = "documentId") UUID documentId) {
	  Optional<Documents> docData = documentService.findByDocId(documentId);
	   return docData.get();
	 }
	 
	 @GetMapping("/api/v1/documents")
	 public List<Documents> findAllDocuments(){
		List<Documents> documentsList = documentService.findAllDocuments();
		return documentsList;
	 }
	 
	 @DeleteMapping("/api/v1/documents/{documentId}")
	 public ResponseEntity deleteDocumnet(@PathVariable(name = "documentId") UUID documentId) {
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	 }
	 
	 @PutMapping("/api/v1/documents/{documentId}")
	 public Documents updateDocument(@PathVariable(name = "documentId") UUID documentId, @RequestBody DocumentsFormDto documentDto) {
		  Optional<Documents> docData = documentService.findByDocId(documentId);
		  docData.get().setImage(documentDto.getImage());
		  docData.get().setName(documentDto.getName());
		  docData.get().setSize(documentDto.getSize());
          Documents updateDocument = documentService.updateDocument(docData.get());
		  return updateDocument;
	 }
}
