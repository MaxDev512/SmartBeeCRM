package com.exam.crm.dao;

import com.exam.crm.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
  @Transactional
  @Modifying
  @Query("update Client c set "
    + "c.company_id = CASE WHEN :#{#client.company_id} IS NULL THEN c.company_id ELSE :#{#client.company_id} END, "
    + "c.name = CASE WHEN :#{#client.name} IS NULL THEN c.name ELSE :#{#client.name} END, "
    + "c.email = CASE WHEN :#{#client.email} IS NULL THEN c.email ELSE :#{#client.email} END, "
    + "c.phone = CASE WHEN :#{#client.phone} IS NULL THEN c.phone ELSE :#{#client.phone} END, "
    + "c.created_by = CASE WHEN :#{#client.created_by} IS NULL THEN c.created_by ELSE :#{#client.created_by} END, "
    + "c.created_at = CASE WHEN :#{#client.created_at} IS NULL THEN c.created_at ELSE :#{#client.created_at} END, "
    + "c.updated_by = CASE WHEN :#{#client.updated_by} IS NULL THEN c.updated_by ELSE :#{#client.updated_by} END, "
    + "c.updated_at = CASE WHEN :#{#client.updated_at} IS NULL THEN c.updated_at ELSE :#{#client.updated_at} END "
    + "where c.id = :#{#client.id}")
  void updateById(Client client);
}
