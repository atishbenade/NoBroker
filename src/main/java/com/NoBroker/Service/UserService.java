package com.NoBroker.Service;

import com.NoBroker.entity.User;
import com.NoBroker.payload.UserDto;

import java.util.List;

public interface UserService {
    UserDto registerUser(UserDto userDto);



    User getUserByEmail(String email);

    void verifyEmail(User user);


    boolean isEmailVerified(String email);

    void deleteByEmail(String email);

    List<User> getAllUsers();
}
