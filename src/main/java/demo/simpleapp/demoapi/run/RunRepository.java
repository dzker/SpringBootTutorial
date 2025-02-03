package demo.simpleapp.demoapi.run;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import jakarta.annotation.PostConstruct;
import jakarta.validation.Valid;

import org.springframework.stereotype.Repository;

@Repository
public class RunRepository {

    private List<Run> runs = new ArrayList<>();


    /*GET METHOD */
    List<Run> findAll() {
        return runs;
    }   

    Optional<Run> findById(Integer id) {
        return runs.stream()
            .filter(run -> run.id().equals(id))
            .findFirst();
    }

    /*POST METHOD */
    void create(Run run) {
        runs.add(run);
    }

    /*PUT METHOD */
    void update(Integer id, Run run) {
        Optional<Run> existingRun = findById(id);
        if(existingRun.isPresent()) {
            runs.set(runs.indexOf(existingRun.get()), run);
        }
    }

    /*DELETE METHOD */
    void delete(Integer id) {
        runs.removeIf(run -> run.id().equals(id));
    }

    @PostConstruct
    private void init() {
        runs.add(new Run(1, "Monday Morning Run", LocalDateTime.now(), LocalDateTime.now().plus(30, 
        ChronoUnit.MINUTES), 3, Location.INDOOR));

        runs.add(new Run(3, "Wednesday Morning Run", LocalDateTime.now(), LocalDateTime.now().plus(30, 
        ChronoUnit.MINUTES), 4, Location.INDOOR));
    }

}
