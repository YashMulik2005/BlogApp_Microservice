package com.Compose.AuthService.service;

import com.Compose.AuthService.dto.LoginRequestDto;
import com.Compose.AuthService.dto.LoginResponseDto;
import com.Compose.AuthService.dto.SignupRequestDto;
import com.Compose.AuthService.dto.SignupResponseDto;
import com.Compose.AuthService.exception.UserAlreadyExist;
import com.Compose.AuthService.model.User;
import com.Compose.AuthService.repository.UserRepository;
import com.Compose.AuthService.security.JwtUtils;
import com.netflix.discovery.converters.Auto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtils jwtUtils;

    public SignupResponseDto Signup(SignupRequestDto signupRequestDto){
        User existinguser = userRepository.findByEmail(signupRequestDto.getEmail())
                .orElse(null);

        if(existinguser != null) throw new UserAlreadyExist("User with this email already exist.");
        User user = modelMapper.map(signupRequestDto, User.class);
        user.setPassword(passwordEncoder.encode(signupRequestDto.getPassword()));
        User savedUser = userRepository.save(user);
        return modelMapper.map(savedUser, SignupResponseDto.class);
    }

    public LoginResponseDto Login(LoginRequestDto loginRequestDto){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequestDto.getEmail(),loginRequestDto.getPassword())
        );

        User user = (User) authentication.getPrincipal();
        String accessToken = jwtUtils.generateAccessToken(user);
        String refreshToken = jwtUtils.generateRefreshToken(user);

        LoginResponseDto res = new LoginResponseDto();
        res.setUserId(user.getId());
        res.setAccessToken(accessToken);
        res.setRefreshToken(refreshToken);

        return res;
    }
}
