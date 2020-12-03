package com.exam.crm.dao;

import com.exam.crm.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {
  @Transactional
  @Modifying
  @Query("update Company c set "
    + "c.name = CASE WHEN :#{#company.name} IS NULL THEN c.name ELSE :#{#company.name} END, "
    + "c.address = CASE WHEN :#{#company.address} IS NULL THEN c.address ELSE :#{#company.address} END, "
    + "c.created_by = CASE WHEN :#{#company.created_by} IS NULL THEN c.created_by ELSE :#{#company.created_by} END, "
    + "c.created_at = CASE WHEN :#{#company.created_at} IS NULL THEN c.created_at ELSE :#{#company.created_at} END, "
    + "c.updated_by = CASE WHEN :#{#company.updated_by} IS NULL THEN c.updated_by ELSE :#{#company.updated_by} END, "
    + "c.updated_at = CASE WHEN :#{#company.updated_at} IS NULL THEN c.updated_at ELSE :#{#company.updated_at} END "
    + "where c.id = :#{#company.id}")
  void updateById(Company company);
//  @Query(value = "update company set name=?2, address=?3, created_by=?4, created_at=?5, updated_by=?6, updated_at=?7 where id=?1", nativeQuery = true)
//  Company updateById(String id, String name, String address, String createdBy, Date createdAt, String updatedBy, Date updatedAt);

//  @Override
//  void deleteById(Integer integer);

  // 使用 HQL 查詢
  // :name 對應 @Param 裡的 name
  @Query("from Company c where c.name=:name")
  Company findByHQL(@Param("name") String name);

  // 使用 SQL 查詢
  // ?1 表示第一個引數，?2 表示第二個引數
  @Query(value = "select * from company where name = ?1 and age = ?2", nativeQuery = true)
  Company findBySQL(String name1, Integer age);
}
