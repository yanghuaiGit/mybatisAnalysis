package com.example.mybatisexample.service;

import org.springframework.web.bind.annotation.PathVariable;

public interface UserService {
    void update(@PathVariable Long id);
}
