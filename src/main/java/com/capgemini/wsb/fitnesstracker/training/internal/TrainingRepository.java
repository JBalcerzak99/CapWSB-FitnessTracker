package com.capgemini.wsb.fitnesstracker.training.internal;

import com.capgemini.wsb.fitnesstracker.training.api.Training;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface TrainingRepository extends JpaRepository<Training, Long> {
    List<Training> findByUserId(Long userId);
    List<Training> findByEndDateBefore(Date date);
    List<Training> findByActivityType(ActivityType activityType);
    List<Training> findByUserIdAndStartTimeBetween(Long userId, Date startTime, Date endTime);
}

