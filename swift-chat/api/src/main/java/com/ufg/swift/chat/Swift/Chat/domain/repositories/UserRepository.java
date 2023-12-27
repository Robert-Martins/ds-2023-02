package com.ufg.swift.chat.Swift.Chat.domain.repositories;

import com.ufg.swift.chat.Swift.Chat.domain.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    Optional<User> findByName(String name);

    // Método para atualizar o nome do usuário
    @Modifying
    @Query("UPDATE User u SET u.name = :newName WHERE u.name = :oldName")
    void updateByName(@Param("oldName") String oldName, @Param("newName") String newName);
}
