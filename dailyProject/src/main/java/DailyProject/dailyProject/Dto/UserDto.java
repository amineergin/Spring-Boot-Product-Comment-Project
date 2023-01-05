package DailyProject.dailyProject.Dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long userId;
    private String name;
    private String surname;
    private String mail;
    private String phoneNumber;
}
