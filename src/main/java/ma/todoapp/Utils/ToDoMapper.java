package ma.todoapp.Utils;

import ma.todoapp.Entities.Dtos.TaskRequestDto;
import ma.todoapp.Entities.Dtos.TaskResponseDto;
import ma.todoapp.Entities.Task;
import org.modelmapper.ModelMapper;


public class ToDoMapper {
    public static Task taskRequestDtoToTask(TaskRequestDto taskRequestDto) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(taskRequestDto, Task.class);
    }

    public static TaskResponseDto taskToTaskResponseDto(Task task) {
        ModelMapper mapper = new ModelMapper();
        return new TaskResponseDto(task.getId(), task.getTitle(),task.getDescription(),task.getUser().getId(),task.getUser().getFirstName(),task.getUser().getLastName(),task.getUser().getEmail());
    }

    }

