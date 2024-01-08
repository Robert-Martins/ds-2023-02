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

    // Evite usar @Autowired, o Autowired injeta dependências a nível de execução e foge do princípio Singleton
    // Inicialize dependências como private final e injete pelo Constructor ou utilize a anotação @RequiredArgsConstructor
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

        // O objeto user possui um método que converte uma entidade em seu respectivo DTO
        return mapEntityToDto(newUser);
    }

    @Override
    public UserDto read(UUID id) {
        // O objeto user possui um método que converte uma entidade em seu respectivo DTO
        // No Optional, para este caso, acho que é interessante lançar uma exception e tratá-la no ExceptionHandler
        return userRepository.findById(id)
                .map(this::mapEntityToDto)
                .orElse(null);
    }

    @Override
    public void update(UUID id, String name) {
        // Nesse caso, o requireNonNull é redundante, poderia ser utilizado o map do Optional e o orElse
        UserDto existingUser = Objects.requireNonNull(userRepository.findById(id).orElse(null)).mapEntityToDto();
        if (existingUser != null) {
            existingUser.setName(name);
            userRepository.save(existingUser.mapDtoToEntity());
        }
    }

    // Esse mesmo método já está implementando em User
    private UserDto mapEntityToDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        return userDto;
    }
}
