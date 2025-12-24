package com.Compose.AuthService.service.impl;

import com.Compose.AuthService.dto.UserDetailsResponseDto;
import com.Compose.AuthService.dto.UserSearchResponseDto;
import com.Compose.AuthService.exception.NotFoundException;
import com.Compose.AuthService.model.User;
import com.Compose.AuthService.repository.UserRepository;
import com.Compose.AuthService.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDetailsResponseDto userById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("user not found."));

        return modelMapper.map(user, UserDetailsResponseDto.class);
    }

    @Override
    public List<UserSearchResponseDto> searchUserByEmail(String email) {
        List<User> users= userRepository.findByEmailContainingIgnoreCase(email);
        return users.stream().map(user -> modelMapper.map(user, UserSearchResponseDto.class)).toList();
    }
}
