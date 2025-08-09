package net.javaguides.productservices.inheritanceexample.joinedtable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("jt_student_repo")
public interface StudentRepository extends JpaRepository<net.javaguides.productservices.inheritanceexample.joinedtable.Student, Long> {
}
