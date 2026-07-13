package com.cognizant.ormlearn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cognizant.ormlearn.model.Attempt;
import com.cognizant.ormlearn.model.AttemptOption;
import com.cognizant.ormlearn.model.AttemptQuestion;
import com.cognizant.ormlearn.model.Option;
import com.cognizant.ormlearn.service.AttemptService;

@SpringBootApplication
public class OrmLearnApplication implements CommandLineRunner {

    @Autowired
    private AttemptService attemptService;

    public static void main(String[] args) {
        SpringApplication.run(OrmLearnApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        testGetAttemptDetails();
    }

    private void testGetAttemptDetails() {

        Attempt attempt = attemptService.getAttempt(1, 1);

        System.out.println("----------------------------------------");
        System.out.println("Username      : " + attempt.getUser().getUsername());
        System.out.println("Attempt Date  : " + attempt.getAttemptedDate());
        System.out.println("----------------------------------------");

        for (AttemptQuestion aq : attempt.getAttemptQuestions()) {

            System.out.println();
            System.out.println(aq.getQuestion().getQuestionText());

            for (Option option : aq.getQuestion().getOptions()) {

                boolean selected = false;

                for (AttemptOption ao : aq.getAttemptOptions()) {

                    if (ao.getOption().getOptionId() == option.getOptionId()) {
                        selected = true;
                        break;
                    }
                }

                System.out.printf("%-35s %-5d %-8b %-8b%n",
                        option.getOptionText(),
                        option.getScore(),
                        option.isCorrect(),
                        selected);
            }
        }
    }
}