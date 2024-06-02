package com.capgemini.wsb.fitnesstracker.training.internal;

import com.capgemini.wsb.fitnesstracker.training.api.TrainingDto;
import com.capgemini.wsb.fitnesstracker.training.api.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/trainings")
public class TrainingController {
    private final TrainingService trainingService;

    @Autowired
    public TrainingController(TrainingService trainingService) {
        this.trainingService = trainingService;
    }

    @GetMapping
    public List<TrainingDto> getAllTrainings() {
        return trainingService.getAllTrainings();
    }

    @GetMapping("/user/{userId}")
    public List<TrainingDto> getTrainingsByUserId(@PathVariable Long userId) {
        return trainingService.getTrainingsByUserId(userId);
    }

    @GetMapping("/completed")
    public List<TrainingDto> getCompletedTrainings(@RequestParam Date date) {
        return trainingService.getCompletedTrainings(date);
    }

    @GetMapping("/activity/{activityType}")
    public List<TrainingDto> getTrainingsByActivityType(@PathVariable ActivityType activityType) {
        return trainingService.getTrainingsByActivityType(activityType);
    }

    @PostMapping
    public TrainingDto createTraining(@RequestBody TrainingDto trainingDto) {
        return trainingService.createTraining(trainingDto);
    }

    @PutMapping("/{id}")
    public TrainingDto updateTraining(@PathVariable Long id, @RequestBody TrainingDto trainingDto) {
        return trainingService.updateTraining(id, trainingDto);
    }
}


