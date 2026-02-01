package Builder;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class UserCollapse {
    private Long id;
    private String fullName;
    private LocalDate birthday;
    private String ethnic;
    private Education education;
    private String religion;
    private Double salaryPerYear;
}
