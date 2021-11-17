package com.skni.warsztatysghv2.registration;

import org.springframework.stereotype.Component;

@Component
public class StudentService {
    private final UUIDStudentIdGenerator studentIdGenerator;
    private final StatusService statusService;
    private final ApplicationFormService applicationFormService;

    public StudentService(UUIDStudentIdGenerator uuidStudentIdGenerator, StatusService statusService, ApplicationFormService applicationFormService) {
        this.studentIdGenerator = uuidStudentIdGenerator;
        this.statusService = statusService;
        this.applicationFormService = applicationFormService;
    }


    public void printStudent() {
        Student student = create(applicationFormService.createMock());
        System.out.println(student);
    }

    public Student create(ApplicationForm applicationForm) {
        String id = studentIdGenerator.getNext();
        String firstName = applicationForm.getFirstName();
        String lastName = applicationForm.getLastName();
        String email = applicationForm.getEmail();
        Status status = statusService.randomStatus();
        return new Student(id, firstName, lastName, email, status); // new allowed here
    }

}
