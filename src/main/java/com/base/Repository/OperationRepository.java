 package com.base.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.base.Entities.Operation;

public interface OperationRepository extends JpaRepository<Operation, Long> {

}
