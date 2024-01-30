package com.NoBroker.Service.ServiceImpl;

import com.NoBroker.Service.UserService;
import com.NoBroker.entity.User;
import com.NoBroker.exception.ResourceNotFoundException;
import com.NoBroker.payload.UserDto;
import com.NoBroker.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private ModelMapper modelMapper;
@Autowired
   private UserRepository userRepository;
    @Override
    public UserDto registerUser(UserDto userDto) {
        User user = mapToEntity(userDto);
        User save = userRepository.save(user);
        return mapToDto(save);
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(
                () -> new ResourceNotFoundException("data not found with this username" + email));
    }

    @Override
    public void verifyEmail(User user) {
        user.setEmailVerified(true);
        userRepository.save(user);
    }

    @Override
    public boolean isEmailVerified(String email) {
        User user =userRepository.findByEmail(email).orElseThrow(() ->
                new ResourceNotFoundException("data not found with given email    " + email));
        return user.isEmailVerified();
    }

    @Override
    public void deleteByEmail(String email) {
             userRepository.deleteByEmail(email);
    }

    @Override
    public List<User> getAllUsers() {
            return userRepository.findAll();
        }



    UserDto mapToDto(User user) {
        UserDto dto = modelMapper.map(user, UserDto.class);
        return dto;
    }

    User mapToEntity(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        return user;
    }

}
