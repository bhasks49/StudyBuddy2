package com.example.bhasks.studybuddy2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Planner {

    //WEIGHTS ----> HOURS
    //VALUES -----> POINTS
    private Map<Float,Float>    assignment_pad;
    private Map<Float,Float>    plan_for_day;
    private float               hours_in_workday;
    private int                 number_of_tasks;
    private float               points_earned;

    static float EPISLON = 1/3;

    public Planner(Map<Float,Float> in_assignment_pad, float in_workhours, int in_num_task){
        assignment_pad = new HashMap<Float,Float> (in_assignment_pad);
        hours_in_workday = in_workhours;
        plan_for_day = new LinkedHashMap<Float,Float>();
        number_of_tasks = in_num_task;
        points_earned = -1;

    }

    public void createPlan(){
        float max_profit = Collections.max(assignment_pad.values());
        float scale      = (EPISLON*max_profit)/number_of_tasks;

        Map<Float,Float> rounded_map = createRoundedMap(scale);

        points_earned = perform_DynamicProgramming(rounded_map,max_profit);

    }

    private float perform_DynamicProgramming(Map<Float,Float> rounded_map, float max_profit){
        float[][] opt = new float[number_of_tasks][(int) max_profit*number_of_tasks];

        for (int i =  0; i < number_of_tasks; i++){

        }


        return -2;
    }

    private Map<Float,Float> createRoundedMap(float scale){
        Map<Float,Float> rounded_map = new HashMap<Float,Float>(assignment_pad);

        Iterator<Entry<Float, Float>> iter = rounded_map.entrySet().iterator();
        while (iter.hasNext()){
            Map.Entry<Float,Float> task = (Entry<Float, Float>)iter.next();
            float current_points = (float) task.getValue();
            task.setValue(current_points/scale);
        }

        return rounded_map;
    }

    public String printPlan(){
        return null;
    }



    public static void main(String [ ] args){
//		Map<Float,Float> 
//		Planner plan = new Planner();
    }

}