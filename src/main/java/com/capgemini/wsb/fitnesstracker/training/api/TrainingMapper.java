package com.capgemini.wsb.fitnesstracker.training.api;

import com.capgemini.wsb.fitnesstracker.user.api.User;
import org.springframework.stereotype.Component;

@Component
public class TrainingMapper {

    public TrainingDto toDto(Training training) {
        if (training == null) {
            return null;
        }

        TrainingDto trainingDto = new TrainingDto();
        trainingDto.setId(training.getId());
        trainingDto.setUserId(training.getUser().getId());
        trainingDto.setStartTime(training.getStartTime());
        trainingDto.setEndTime(training.getEndTime());
        trainingDto.setActivityType(training.getActivityType());
        trainingDto.setDistance(training.getDistance());
        trainingDto.setAverageSpeed(training.getAverageSpeed());

        return trainingDto;
    }

    public Training toEntity(TrainingDto trainingDto, User user) {
        if (trainingDto == null) {
            return null;
        }

        Training training = new Training();
        training.setId(trainingDto.getId());
        training.setUser(user);
        training.setStartTime(trainingDto.getStartTime());
        training.setEndTime(trainingDto.getEndTime());
        training.setActivityType(trainingDto.getActivityType());
        training.setDistance(trainingDto.getDistance());
        training.setAverageSpeed(trainingDto.getAverageSpeed());

        return training;
    }

    public void updateEntityFromDto(TrainingDto trainingDto, Training training) {
        if (trainingDto == null || training == null) {
            return;
        }

        training.setStartTime(trainingDto.getStartTime());
        training.setEndTime(trainingDto.getEndTime());
        training.setActivityType(trainingDto.getActivityType());
        training.setDistance(trainingDto.getDistance());
        training.setAverageSpeed(trainingDto.getAverageSpeed());
    }
}


