package ma.todoapp.Services;

import lombok.AllArgsConstructor;
import ma.todoapp.Entities.User;
import ma.todoapp.reposetory.UserResposetory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Component
public class UserServiceImp implements UserServices{

    private final UserResposetory userResposetory;

    @Override
    public User getUser(Long id) {
        return userResposetory.findById(id).orElseThrow();
    }

    @Override
    public User addUser(User user) {
        return userResposetory.save(user);
    }

    @Override
    public User updateUser(User user) {
        return userResposetory.save(user);
    }

    @Override
    public void deleteById(Long id) {
       userResposetory.deleteById(id);
    }

    @Override
    public List<User> getAllUsers() {

        return userResposetory.findAll();
    }
}
