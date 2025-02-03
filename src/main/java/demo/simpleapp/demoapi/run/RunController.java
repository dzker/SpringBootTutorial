package demo.simpleapp.demoapi.run;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/runs")
public class RunController {

    private final RunRepository runRepository;

    public RunController(RunRepository runRepository) {
        this.runRepository = runRepository;
    }


    /*GET METHOD */
    @GetMapping("")
     List<Run> getRuns() {
        return runRepository.findAll();
    }

    @GetMapping("/{id}")
    Run findById(@PathVariable Integer id){
        
        Optional<Run> run = runRepository.findById(id);
        if(run.isEmpty()) {
            throw new RunNotFoundException(id);
        }
        return run.get();
    }

    /*POST METHOD */
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    Run create(@Valid @RequestBody Run run) {
        runRepository.create(run);
        
        return run;
    }

    /*PUT METHOD */
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    Run update(@Valid@PathVariable Integer id, @RequestBody Run run) {
        runRepository.update(id, run);
        return run;
    }

    /*DELETE METHOD */
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id) {
        runRepository.delete(id);
    }

}
