package com.example.hiringMaster;

import com.example.hiringMaster.enums.ActivityTypes;
import com.example.hiringMaster.models.Activity;
import com.example.hiringMaster.models.Profile;
import com.example.hiringMaster.repositories.ActivityRepository;
import com.example.hiringMaster.repositories.ProfileRepository;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Component
public class DatabaseLoader implements CommandLineRunner {


    private final ActivityRepository activityRepository;
    private final ProfileRepository profileRepository;
    public DatabaseLoader(ProfileRepository profileRepository, ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
        this.profileRepository = profileRepository;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        // Create your objects here
        var p1 = new Profile().builder()
                .name("Victorine Goethiers")
                .email("victorine@email.com")
                .phone("0701222948")
                .build();
        var p2 = new Profile().builder()
                .name("Autre Activités")
                .email("autre@email.com")
                .phone("0701222948")
                .build();
        var p3 = new Profile().builder()
                .name("Ronald FOX")
                .email("autre@email.com")
                .phone("0701222948")
                .build();
        var p4 = new Profile().builder()
                .name("Eduardo COOPER")
                .email("autre@email.com")
                .phone("0701222948")
                .build();
        this.profileRepository.saveAll(Arrays.asList(p1,p2,p3,p4));
//        System.out.println("Profiles");
//        System.out.println(p1);
//        System.out.println(p2);
//        System.out.println(p3);
//        System.out.println(p4);
        var mockActivity = new Activity().builder()
                .visibility("public")
                .comment("This is a comment")
                .title("Réunion le 04 mai 2021")
                .time(new Date())
                .participants(Arrays.asList(p1,p2))
                .description("This is a description")
                .owner(p1)
                .subActivities("Don't mind me")
                .job("Developeur Fullstack java / react")
                .address("paris")
                .medium("phone")
                .type("HR")
                .finished(false)
                .activityType(ActivityTypes.REUNION);

        var a1= mockActivity.build();
        var a2=mockActivity
                .title("Finir mon rapport pour entretie...")
                .activityType(ActivityTypes.REMINDER)
                .build();
        var a3 = mockActivity
                .title("Preparer questions pour entreti...")
                .activityType(ActivityTypes.REMINDER)
                .build();
        var a4 = mockActivity
                .title("Réunion le 20 avr. 2021...")
                .activityType(ActivityTypes.REUNION)
                .build();
        var a5 = mockActivity
                .title("Réunion RH manegement")
                .activityType(ActivityTypes.REUNION)
                .finished(true)
                .build();
        var a6 = mockActivity
                .title("Preparer questions pour entreti...")
                .activityType(ActivityTypes.REUNION)
                .finished(true)
                .build();
        var a7 = mockActivity
                .title("Finir mon rapport pour entretie...")
                .activityType(ActivityTypes.REUNION)
                .finished(true)
                .build();
        var a8 = mockActivity
                .title("Interview le 5 avr. 2021")
                .activityType(ActivityTypes.INTERVIEW)
                .finished(true)
                .build();
//        System.out.println("Activities");
//        System.out.println(a1);
//        System.out.println(a3);
//        System.out.println(a5);
//        System.out.println(a8);
        activityRepository.saveAll(Arrays.asList(a1,a2,a3,a4,a5,a6,a7,a8));

    }
}