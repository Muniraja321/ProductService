package net.javaguides.productservices.inheritanceexample.mappedsuperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "msc_student")
public class Student extends User {

    private String batch;
    private double psp;
}
