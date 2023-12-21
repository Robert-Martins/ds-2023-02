package com.ufg.swift.chat.Swift.Chat.presentation.services;

import com.ufg.swift.chat.Swift.Chat.presentation.dtos.EnumDto;

import java.util.List;

public interface IEnumService {

    List<EnumDto> loadEnumByType(String type);

}
