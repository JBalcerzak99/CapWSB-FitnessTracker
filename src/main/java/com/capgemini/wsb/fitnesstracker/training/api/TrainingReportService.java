package com.capgemini.wsb.fitnesstracker.training.api;

import com.capgemini.wsb.fitnesstracker.mail.api.EmailSenderService;
import com.capgemini.wsb.fitnesstracker.training.internal.TrainingRepository;
import com.capgemini.wsb.fitnesstracker.user.api.User;
import com.capgemini.wsb.fitnesstracker.user.internal.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Service
public class TrainingReportService {

    private final UserRepository userRepository;
    private final TrainingRepository trainingRepository;
    private final EmailSenderService emailSenderService;

    @Autowired
    public TrainingReportService(UserRepository userRepository, TrainingRepository trainingRepository, EmailSenderService emailSenderService) {
        this.userRepository = userRepository;
        this.trainingRepository = trainingRepository;
        this.emailSenderService = emailSenderService;
    }

    @Scheduled(cron = "0 0 0 * * MON") // Co tydzień w poniedziałek o północy
    public void generateAndSendWeeklyReports() {
        List<User> users = userRepository.findAll();
        LocalDate now = LocalDate.now();
        LocalDate lastWeek = now.minusWeeks(1);
        Date startDate = Date.from(lastWeek.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date endDate = Date.from(now.atStartOfDay(ZoneId.systemDefault()).toInstant());

        for (User user : users) {
            List<Training> trainings = trainingRepository.findByUserIdAndStartTimeBetween(user.getId(), startDate, endDate);
            int trainingCount = trainings.size();

            String subject = "Weekly Training Report";
            String text = String.format("Hello %s,\n\nYou have %d trainings registered in the last week.\n\nBest regards,\nTraining App Team",
                    user.getFirstName(), trainingCount);

            emailSenderService.sendEmail(user.getEmail(), subject, text);
        }
    }
}

