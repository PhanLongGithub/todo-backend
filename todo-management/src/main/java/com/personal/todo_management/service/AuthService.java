package com.personal.todo_management.service;

import com.personal.todo_management.dto.LoginDto;
import com.personal.todo_management.dto.RegisterDto;

public interface AuthService {
    String register(RegisterDto registerDto);
    String login(LoginDto loginDto);
}
