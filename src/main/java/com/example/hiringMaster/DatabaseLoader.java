package com.example.hiringMaster;

import com.example.hiringMaster.models.Activity;
import com.example.hiringMaster.models.Job;
import com.example.hiringMaster.models.Profile;
import com.example.hiringMaster.repositories.ActivityRepository;
import com.example.hiringMaster.repositories.JobRepository;
import com.example.hiringMaster.repositories.ProfileRepository;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;

@Component
public class DatabaseLoader implements CommandLineRunner {


    private final ActivityRepository activityRepository;
    private final ProfileRepository profileRepository;
    private final JobRepository jobRepository;

    public DatabaseLoader(ProfileRepository profileRepository, ActivityRepository activityRepository, JobRepository jobRepository) {
        this.activityRepository = activityRepository;
        this.profileRepository = profileRepository;
        this.jobRepository = jobRepository;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        // Create your objects here
        var p1 = Profile.builder()
                .name("Victorine Goethiers")
                .email("victorine@email.com")
                .phone("0701222948")
                .build();
        var p2 = Profile.builder()
                .name("Autre Activités")
                .email("autre@email.com")
                .phone("0701222948")
                .build();
        var p3 = Profile.builder()
                .name("Ronald FOX")
                .email("autre@email.com")
                .phone("0701222948")
                .build();
        var p4 = Profile.builder()
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
        var fullstackJob = Job.builder()
                .title("Developeur Fullstack")
                .parentJob(null)
                .build();
        var reactjavaJob = Job.builder()
                .title("Developeur Fullstack java / react")
                .parentJob(fullstackJob)
                .build();
        var angularjavaJob = Job.builder()
                .title("Developeur Fullstack angular / java")
                .parentJob(fullstackJob)
                .build();
        jobRepository.saveAll(Arrays.asList(fullstackJob,angularjavaJob,reactjavaJob));
        var mockActivity = Activity.builder()
                .visibility("public")
                .comment("This is a comment")
                .title("Réunion le 04 mai 2021")
                .time(new Date())
                .deadline(new Date())
                .participants(Arrays.asList(p2))
                .description("This is a description")
                .owner(p1)
                .subActivities("Don't mind me")
                .job(reactjavaJob)
                .address("paris")
                .medium("phone")
                .type("HR")
                .finished(false)
                .activityType(Activity.ActivityTypes.REUNION);

        var a1= mockActivity.build();
        var a2=mockActivity
                .title("Finir mon rapport pour entretien d'aumbauche")
                .activityType(Activity.ActivityTypes.REMINDER)
                .participants(Arrays.asList(p1,p2))
                .deadline(formatter.parse("7-Jun-2013"))
                .job(fullstackJob)
                .build();
        var a3 = mockActivity
                .title("Preparer questions pour entretien d'aumbauche")
                .activityType(Activity.ActivityTypes.TASK)
                .deadline(formatter.parse("01-Jan-2025"))
                .build();
        var a4 = mockActivity
                .title("Réunion le 20 avr. 2021...")
                .activityType(Activity.ActivityTypes.REUNION)
                .participants(Arrays.asList(p3))
                .build();
        var a5 = mockActivity
                .title("Réunion RH manegement")
                .activityType(Activity.ActivityTypes.REUNION)
                .participants(Arrays.asList(p1,p3))
                .finished(true)
                .deadline(formatter.parse("09-Feb-2024"))
                .build();
        var a6 = mockActivity
                .title("Entretien du 2 mars")
                .activityType(Activity.ActivityTypes.INTERVIEW)
                .candidate(p4)
                .finished(true)
                .build();
        var a7 = mockActivity
                .title("Finir mon rapport pour entretie...")
                .activityType(Activity.ActivityTypes.REUNION)
                .participants(Arrays.asList(p1,p2))
                .finished(true)
                .build();
        var a8 = mockActivity
                .title("Interview le 5 avr. 2021")
                .activityType(Activity.ActivityTypes.REUNION)
                .finished(true)
                .owner(p2)
                .job(angularjavaJob)
                .build();
        var a9 = mockActivity
                .title("Interview le 5 avr. 2021")
                .activityType(Activity.ActivityTypes.REMINDER)
                .owner(p2)
                .participants(Arrays.asList(p3))
                .build();
        var a10 = mockActivity
                .title("Interview le 5 avr. 2021")
                .activityType(Activity.ActivityTypes.INTERVIEW)
                .owner(p2)
                .candidate(p3)
                .participants(Arrays.asList(p3,p4))
                .build();
        var a11 = mockActivity
                .title("Interview le 5 avr. 2021")
                .activityType(Activity.ActivityTypes.INTERVIEW)
                .owner(p2)
                .finished(true)
                .candidate(p4)
                .build();
//        System.out.println("Activities");
//        System.out.println(a1);
//        System.out.println(a3);
//        System.out.println(a5);
//        System.out.println(a8);
        activityRepository.saveAll(Arrays.asList(a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,a11));

    }
}