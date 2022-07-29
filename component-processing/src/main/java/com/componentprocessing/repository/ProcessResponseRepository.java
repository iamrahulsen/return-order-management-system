package com.componentprocessing.repository;

// Repository for CRUD operation on the ProcessResponse
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.componentprocessing.model.ProcessResponse;
@Repository
public interface ProcessResponseRepository extends JpaRepository<ProcessResponse, UUID> {

}
