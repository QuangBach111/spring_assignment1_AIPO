package com.example.spring_assignment1.repository;

import com.example.spring_assignment1.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    void deleteByUserIdIn(List<Long> userId);

    @Modifying
    @Query("UPDATE User u SET u.disable = :isDisable WHERE u.userId IN :userIdList")
    void updateDisableStatusByUserIdIn(@Param("isDisable") boolean isDisable,
                                       @Param("userIdList") List<Long> userIdList);
    @Modifying
    @Query(value = "SELECT u FROM User u " +
            "WHERE concat(u.lastName, ' ', u.firstName) like %:keyword% " +
            "or u.department.name like %:keyword% " +
            "or u.position.name like %:keyword% " +
            "or u.loginName like %:keyword%")
    List<User> search(@Param("keyword") String keyword);
}