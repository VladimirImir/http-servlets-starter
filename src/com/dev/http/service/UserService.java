package com.dev.http.service;

import com.dev.http.dao.UserDao;
import com.dev.http.dto.CreateUserDto;
import com.dev.http.dto.UserDto;
import com.dev.http.entity.User;
import com.dev.http.exception.ValidationException;
import com.dev.http.mapper.CreateUserMapper;
import com.dev.http.mapper.UserMapper;
import com.dev.http.validator.CreateUserValidator;
import com.dev.http.validator.ValidationResult;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

import java.util.Optional;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class UserService {

    private static final UserService INSTANCE = new UserService();

    private final CreateUserValidator createUserValidator = CreateUserValidator.getInstance();
    private final UserDao userDao = UserDao.getInstance();
    private final CreateUserMapper createUserMapper = CreateUserMapper.getInstance();
    private final UserMapper userMapper = UserMapper.getInstance();
    private final ImageService imageService = ImageService.getInstance();

    public Optional<UserDto> login(String email, String password) {
        return userDao.findByEmailAndPassword(email, password)
                .map(userMapper::mapFrom);
    }

    @SneakyThrows
    public Integer create(CreateUserDto userDto) {
        var validationResult = createUserValidator.isValid(userDto);
        if (!validationResult.isValid()) {
            throw new ValidationException(validationResult.getErrors());
        }
        var userEntity = createUserMapper.mapFrom(userDto);
        imageService.upload(userEntity.getImage(), userDto.getImage().getInputStream());
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
