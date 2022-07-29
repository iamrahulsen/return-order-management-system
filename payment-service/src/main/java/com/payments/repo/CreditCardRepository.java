package com.payments.repo;

// importing files
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.payments.entity.CreditCardDetailsdb;

//Repository to do CRUD operation of the CreditCardDetailsdb
@Repository
public interface CreditCardRepository extends JpaRepository<CreditCardDetailsdb, Long> {

}
