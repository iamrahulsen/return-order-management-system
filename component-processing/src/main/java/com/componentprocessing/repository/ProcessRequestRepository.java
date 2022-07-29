package com.componentprocessing.repository;


// Repository for CRUD operation on ProcessRequest
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.componentprocessing.model.ProcessRequest;
@Repository
public interface ProcessRequestRepository extends JpaRepository<ProcessRequest, UUID> {

}
