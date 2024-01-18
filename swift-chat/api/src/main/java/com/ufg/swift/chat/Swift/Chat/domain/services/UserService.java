package com.ufg.swift.chat.Swift.Chat.domain.services;

import com.ufg.swift.chat.Swift.Chat.domain.models.User;
import com.ufg.swift.chat.Swift.Chat.domain.repositories.UserRepository;
import com.ufg.swift.chat.Swift.Chat.presentation.dtos.UserDto;
import com.ufg.swift.chat.Swift.Chat.presentation.services.IUserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {

    private final UserRepository userRepository;

    @Override
    public UserDto create(String name) {
        UUID userId = UUID.randomUUID();

        // Criar um novo usuário
        User newUser = new User();
        newUser.setId(userId);
        newUser.setName(name);

        // Salvar o usuário no repositório
        userRepository.save(newUser);

        // Retornar o DTO correspondente ao usuário criado
        return newUser.mapEntityToDto();
    }

    @Override
    public UserDto read(UUID id) {
        return userRepository.findById(id)
                .map(User::mapEntityToDto)
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado com o ID: " + id));
    }

    @Override
    public void update(UUID id, String name) {
        userRepository.findById(id)
                .ifPresent(existingUser -> {
                    existingUser.setName(name);
                    userRepository.save(existingUser);
                });
    }
}
