package demo.simpleapp.demoapi.run;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.NotNull;

public record Run(
    Integer id,
    @NotEmpty
    String title,
    @NotNull
    LocalDateTime start,
    @NotNull
    LocalDateTime end,
    @Positive
    Integer miles,
    Location location
) {

    public Run {
        if(!end.isAfter(start)) {
            throw new IllegalArgumentException("End jogging must be after start jogging");
        }
    }
}
