package com.tukaram.quizapp.service.interfaces;

import com.tukaram.quizapp.dto.request.LoginRequest;
import com.tukaram.quizapp.dto.request.RegisterRequest;
import com.tukaram.quizapp.dto.response.AuthResponse;

public interface AuthService {
    String register(RegisterRequest request);
    AuthResponse login(LoginRequest request);
}