package net.javaguides.productservices.inheritanceexample.tableperclass;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "tpc_student")

public class Student extends User {

    private String batch;
    private double psp;


//    public double getPsp() {
//        return psp;
//    }

//    public void setPsp(double psp) {
//        this.psp = psp;
//    }

//    public String getBatch() {
//        return batch;
//    }

//    public void setBatch(String batch) {
//        this.batch = batch;
//    }
}
