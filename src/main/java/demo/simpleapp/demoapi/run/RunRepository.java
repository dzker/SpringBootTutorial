package demo.simpleapp.demoapi.run;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.ArrayList;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

@Repository
public class RunRepository {

    private List<Run> runs = new ArrayList<>();

    List<Run> findAll() {
        return runs;
    }   

   Run findById(Integer id) {
        return runs.stream()
            .filter(run -> run.id().equals(id))
            .findFirst()
            .orElse(null);
   }

    @PostConstruct
    private void init() {
        runs.add(new Run(1, "Monday Morning Run", LocalDateTime.now(), LocalDateTime.now().plus(30, 
        ChronoUnit.MINUTES), 3, Location.INDOOR));

        runs.add(new Run(3, "Wednesday Morning Run", LocalDateTime.now(), LocalDateTime.now().plus(30, 
        ChronoUnit.MINUTES), 4, Location.INDOOR));
    }

}
