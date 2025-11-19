package ie.atu.cicd1_exam_19.model;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
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
    @NotBlank(message = "Registration Number cannot be blank") @Pattern(regexp = "[0-9]{2,3}-[A-Z]{1,2}-[0-9]{1,6}")
    private String regNumber;

    @NotBlank(message = "Driver name must not be blank")
    private String driverName;

    @Email(message = "Invalid email address")
    private String email;

    @NotBlank(message = "Passengers must not be blank") @Size(min = 1, max = 8)
    private String passengers;
}
