package com.exam.crm.dao;

import com.exam.crm.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
  @Query("from User u where u.id=:id and u.password=:password")
  User findById(@Param("id") String id, @Param("password") String password);
}
