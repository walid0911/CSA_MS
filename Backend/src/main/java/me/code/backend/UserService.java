package me.code.backend;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void addUser(UserRequest request) {
        User user = User.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .birthDate(request.birthDate())
                .build();

        userRepository.saveAndFlush(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

    @Transactional
    public void updateUser(Integer id, UserRequest request) {
        Optional<User> user = userRepository.findById(id);

        if (user.isPresent()) {
            String firstName = request.firstName().isEmpty() ? user.get().getFirstName() : request.firstName();
            String lastName = request.lastName().isEmpty() ? user.get().getLastName() : request.lastName();
            Date birthDate = request.birthDate().toString().isEmpty() ? user.get().getBirthDate() : request.birthDate();

            userRepository.updateUser(firstName,lastName,birthDate,id);
        }
    }
}
