package com.ufg.swift.chat.Swift.Chat.domain.services;

import com.ufg.swift.chat.Swift.Chat.domain.models.User;
import com.ufg.swift.chat.Swift.Chat.domain.repositories.UserRepository;
import com.ufg.swift.chat.Swift.Chat.presentation.dtos.UserDto;
import com.ufg.swift.chat.Swift.Chat.presentation.services.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {

    @Autowired
    UserRepository userRepository;

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
        return mapEntityToDto(newUser);
    }

    @Override
    public UserDto read(UUID id) {
        return userRepository.findById(id)
                .map(this::mapEntityToDto)
                .orElse(null);
    }

    @Override
    public void update(UUID id, String name) {
        UserDto existingUser = Objects.requireNonNull(userRepository.findById(id).orElse(null)).mapEntityToDto();
        if (existingUser != null) {
            existingUser.setName(name);
            userRepository.save(existingUser.mapDtoToEntity());
        }
    }

    private UserDto mapEntityToDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        return userDto;
    }
}
