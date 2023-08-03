package com.dev.http.service;

import com.dev.http.dao.UserDao;
import com.dev.http.dto.CreateUserDto;
import com.dev.http.dto.UserDto;
import com.dev.http.entity.User;
import com.dev.http.exception.ValidationException;
import com.dev.http.mapper.CreateUserMapper;
import com.dev.http.validator.CreateUserValidator;
import com.dev.http.validator.ValidationResult;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class UserService {

    private static final UserService INSTANCE = new UserService();

    private final CreateUserValidator createUserValidator = CreateUserValidator.getInstance();
    private final UserDao userDao = UserDao.getInstance();
    private final CreateUserMapper createUserMapper = CreateUserMapper.getInstance();

    public Integer create(CreateUserDto userDto) {
        var validationResult = createUserValidator.isValid(userDto);
        if (!validationResult.isValid()) {
            throw new ValidationException(validationResult.getErrors());
        }
        var userEntity = createUserMapper.mapFrom(userDto);
        userDao.save(userEntity);
        return userEntity.getId();
        // validator
        // map
        // userDao.save
        // return id

    }

    public static UserService getInstance() {
        return INSTANCE;
    }
}
