package com.maureen.lambda.why2;

public class AgeFilter implements StudentFilter {
    @Override
    public boolean compare(Student student) {
        return student.getAge() > 14;
    }
}
