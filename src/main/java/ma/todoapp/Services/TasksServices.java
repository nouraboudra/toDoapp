package ma.todoapp.Services;

import ma.todoapp.Entities.Dtos.TaskRequestDto;
import ma.todoapp.Entities.Dtos.TaskResponseDto;
import org.springframework.stereotype.Service;
import ma.todoapp.Entities.Task;

import java.util.List;

@Service
public interface TasksServices {
    List<TaskResponseDto> getAllTasks();
    TaskResponseDto addTask(TaskRequestDto task);
    TaskResponseDto updateTask(TaskRequestDto task);
    void deleteTask(Long taskId);
    TaskResponseDto getTaskById(Long id);

}
