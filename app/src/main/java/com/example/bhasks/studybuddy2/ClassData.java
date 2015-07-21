package com.example.bhasks.studybuddy2;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.List;

/**
 * Created by cordom2 on 7/13/2015.
 */
public class ClassData implements Serializable{

    private String className="";
    private int credits;
    private double percentIn, GPA, grade, minPossible, maxPossible;
    private List<String> assignmentList;

    public ClassData(String className, int credits){
        this.className= className;
        this.credits= credits;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public double getPercentIn() {
        return percentIn;
    }

    public String getPercentInSTR() {
        DecimalFormat df = new DecimalFormat("00.00");
        return df.format(percentIn) + "%";
    }

    public void setPercentIn(double percentIn) {
        this.percentIn = percentIn;
    }

    public double getGrade() {
        return grade;
    }

    public String getGradeSTR() {
        DecimalFormat df = new DecimalFormat("00.00");
        return df.format(grade);
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public double getGPA() {
        return GPA;
    }

    public String getLetterGPA() {
        if(grade>=93) return "A";
        else if(grade>=90) return "A-";
        else if(grade>=87) return "B+";
        else if(grade>=83) return "B";
        else if(grade>=80) return "B-";
        else if(grade>=77) return "C+";
        else if(grade>=73) return "C";
        else if(grade>=70) return "C-";
        else if(grade>=67) return "D+";
        else if(grade>=65) return "D";
        else return "F";
    }

    public String getLetterGPA(double currentGrade) {
        if(currentGrade>=93) return "A";
        else if(currentGrade>=90) return "A-";
        else if(currentGrade>=87) return "B+";
        else if(currentGrade>=83) return "B";
        else if(currentGrade>=80) return "B-";
        else if(currentGrade>=77) return "C+";
        else if(currentGrade>=73) return "C";
        else if(currentGrade>=70) return "C-";
        else if(currentGrade>=67) return "D+";
        else if(currentGrade>=65) return "D";
        else return "F";
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    public double getMaxPossible() {
        maxPossible= (grade*percentIn/100)+(100-percentIn);
        return maxPossible;
    }

    public String getMaxPossibleSTR() {
        maxPossible= (grade*percentIn/100)+(100-percentIn);
        DecimalFormat df = new DecimalFormat("00.00");
        return df.format(maxPossible);
    }

    public void setMaxPossible(double maxPossible) {
        this.maxPossible = maxPossible;
    }

    public double getMinPossible() {
        minPossible= (grade*percentIn/100)+((100-percentIn)/100);
        return minPossible;
    }

    public String getMinPossibleSTR() {
        DecimalFormat df = new DecimalFormat("00.00");
        minPossible= (grade*percentIn/100)+((100-percentIn)/100);
        return df.format(minPossible)+", "+getLetterGPA(minPossible);
    }

    public void setMinPossible(double minPossible) {
        this.minPossible = minPossible;
    }

    public void addAnAssignment(String assignmentName, double percentOfGrade, double score){
        String percentOfGradeSTR= String.valueOf(percentOfGrade);
        String scoreSTR= String.valueOf(score);

        String newAssignment= assignmentName + ", " + percentOfGrade + "% of grade, Grade: " + score;
        //assignmentList.add(newAssignment);   THIS LINE CAUSES AN ERROR!!!!!!!!!!

        double newGrade= (grade*(percentIn/100) + score*(percentOfGrade/100))*(100/(percentIn+percentOfGrade));
        percentIn += percentOfGrade;
        grade= newGrade;

    }
}
