package com.capgemini.wsb.fitnesstracker.training.api;

public interface TrainingService {
    List<TrainingDto> getAllTrainings();
    List<TrainingDto> getTrainingsByUserId(Long userId);
    List<TrainingDto> getCompletedTrainings(LocalDate date);
    List<TrainingDto> getTrainingsByActivityType(ActivityType activityType);
    TrainingDto createTraining(TrainingDto trainingDto);
    TrainingDto updateTraining(Long id, TrainingDto trainingDto);
}
