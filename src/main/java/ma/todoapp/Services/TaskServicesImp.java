package ma.todoapp.Services;

import lombok.AllArgsConstructor;
import ma.todoapp.Entities.Dtos.TaskResponseDto;
import ma.todoapp.Entities.Enums.Status;
import ma.todoapp.Entities.Task;
import ma.todoapp.Entities.Dtos.TaskRequestDto;
import ma.todoapp.Utils.ToDoMapper;
import ma.todoapp.reposetory.TaskRepository;
import ma.todoapp.reposetory.UserResposetory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class TaskServicesImp implements TasksServices{
    private final TaskRepository taskRepository;
    private final UserResposetory userResposetory;
    @Override
    public List<TaskResponseDto> getAllTasks() {
        return taskRepository
                .findAll()
                .stream()
                .map(ToDoMapper::taskToTaskResponseDto)
                .toList();
    }

    @Override
    public TaskResponseDto addTask(TaskRequestDto taskDto) {
        var user = userResposetory.findById(taskDto.getUserId()).orElseThrow();
        Task task = ToDoMapper.taskRequestDtoToTask(taskDto);
        task.setStatus(Status.NOTDONE);
        task.setUser(user);
        var savedTask = taskRepository.save(task);
        return ToDoMapper.taskToTaskResponseDto(savedTask);
    }

    @Override
    public TaskResponseDto updateTask(TaskRequestDto task) {
        return null;
    }

    @Override
    public void deleteTask(Long taskId) {
        taskRepository.deleteById(taskId);
    }

    @Override
    public TaskResponseDto getTaskById(Long id) {
        return ToDoMapper.taskToTaskResponseDto( taskRepository.getReferenceById(id));
    }
}
