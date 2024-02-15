package ma.todoapp.Entities.Dtos;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TaskResponseDto {
    private Long id;
    private String title;
    private String description;
    private Long userId;
    private String userFirstName;
    private String userLastName;
    private String userEmail;
}
