package ie.atu.cicd1_exam_19.model;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder


public class vehicle {
    @NotBlank @Size(min = 1, max = 20)
    private String regNumber;

    @NotBlank @Size(min = 1, max = 20)
    private String driverName;

    @NotBlank @Email
    private String email;
}
