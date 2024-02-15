package ma.todoapp.Controllers;

import lombok.AllArgsConstructor;
import ma.todoapp.Entities.Dtos.UserRequestDto;
import ma.todoapp.Entities.User;
import ma.todoapp.Services.UserServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {
    public final UserServices userServices;
    //Get
    @GetMapping ("/get/{id}")
    public ResponseEntity<?> getUser(@PathVariable Long id){
        try {
            return ResponseEntity.ok(userServices.getUser(id));
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
    //Post
    @PostMapping("/add")
    public ResponseEntity<?> addUser(@PathVariable User user){
        try {
            return ResponseEntity.ok(userServices.addUser(user));
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
    //Delete
    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteUser(@PathVariable Long id){
        try {
            userServices.deleteById(id);
            return ResponseEntity.ok().build();
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
    //Update
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody User user){
        try {

            return ResponseEntity.ok(userServices.updateUser(user));
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

}
