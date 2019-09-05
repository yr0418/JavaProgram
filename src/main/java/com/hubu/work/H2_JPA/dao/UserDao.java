package com.hubu.work.H2_JPA.dao;

import com.hubu.work.H2_JPA.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserDao extends JpaRepository<User,Integer> {
  @Modifying
  @Query(value = "select * from user",nativeQuery = true)
  List<User> selectAll();
}
