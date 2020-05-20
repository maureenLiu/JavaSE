package com.maureen.lambda.why2;

public class ScoreFilter implements StudentFilter {
    @Override
    public boolean compare(Student student) {
        return student.getScore() > 75;
    }
}
