package ma.todoapp.reposetory;

import ma.todoapp.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserResposetory extends JpaRepository<User,Long> {
}
