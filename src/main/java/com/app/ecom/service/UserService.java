package com.app.ecom.service;

import com.app.ecom.dto.UserResponse;
import com.app.ecom.model.User;
import com.app.ecom.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    //private List<User> userList = new ArrayList<>();
    //private Long nextId = 1L;

    public List<UserResponse> fetchAllUsers() {
        return userRepository.findAll();
    }

    public void addUser(User user) {
        userRepository.save(user);

    }

    public Optional<User> fetchUser(Long id) {
        return userRepository.findById(id);

    }
    public boolean updateUser(Long id, User updateUser){
        return userRepository.findById(id)
                .map(ExistingUser -> {
                    ExistingUser.setFirstName(updateUser.getFirstName());
                    ExistingUser.setLastName(updateUser.getLastName());
                    userRepository.save(ExistingUser);
                    return true;
                })
                .orElse(false);
    }

    private UserResponse mapToUserResponse(){

    }
}
