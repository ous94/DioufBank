package com.base.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.base.Entities.Client;
public interface ClientRepository extends JpaRepository<Client, Long> {

}
