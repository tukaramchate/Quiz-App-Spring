package com.tukaram.quizapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse<T> {
    private boolean success;
    private String message;
    private T data;
    private int statusCode;

    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(true, "Success", data, 200);
    }

    public static <T> ApiResponse<T> success(String message, T data) {
        return new ApiResponse<>(true, message, data, 200);
    }

    public static <T> ApiResponse<T> error(String message) {
        return new ApiResponse<>(false, message, (T) null, 400);
    }

    public static <T> ApiResponse<T> error(String message, int statusCode) {
        return new ApiResponse<>(false, message, (T) null, statusCode);
    }

    public static <T> ApiResponse<T> created(T data) {
        return new ApiResponse<>(true, "Created successfully", data, 201);
    }

    public static <T> ApiResponse<T> notFound(String message) {
        return new ApiResponse<>(false, message, (T) null, 404);
    }

    public static <T> ApiResponse<T> serverError(String message) {
        return new ApiResponse<>(false, message, (T) null, 500);
    }
}