package com.example.bhasks.studybuddy2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

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

    public void createPlan_secondary(){
        //TODO COMPLETE SECONDARY METHOD
        float max_profit = Collections.max(assignment_pad.values());
        float scale      = (EPISLON*max_profit)/number_of_tasks;

        Map<Float,Float> rounded_map = createRoundedMap(scale);
        LinkedList<Float> list_points = getListofPoints(rounded_map);
        LinkedList<Float> list_hours = getListofHours(rounded_map);

        points_earned = perform_DynamicProgramming(list_points,list_hours,max_profit);

    }

    public void createPlan_primary(){
        LinkedList<Float> list_points = getListofPoints(assignment_pad);
        LinkedList<Float> list_hours = getListofHours(assignment_pad);

        points_earned = perform_DynamicProgramming(list_points,list_hours);
    }

    private float perform_DynamicProgramming(LinkedList<Float> list_points, LinkedList<Float> list_hours){
        float[][] opt = new float[number_of_tasks][(int) hours_in_workday];


        for (int w = 0; w < hours_in_workday; ++w){
            opt[0][w] = 0;
        }


        for (int n = 1; n < (int) number_of_tasks; ++n){
            for (int w = 0; w < hours_in_workday; ++w){
                if (list_hours.get(w) > w){
                    opt[n][w] = opt[n-1][w];
                }
                else{
                    ArrayList<Float> tmp = new ArrayList<Float>();
                    tmp.add(opt[n-1][w]);
                    tmp.add(list_points.get(n) + opt[n-1][(int) (w - list_hours.get(n))]);
                    opt[n][w] = Collections.max(tmp);
                }
            }
        }

        return opt[number_of_tasks][(int) hours_in_workday];
    }

    private float perform_DynamicProgramming(LinkedList<Float> list_points, LinkedList<Float> list_hours, float max_profit){
        //TODO COMPLETE SECONDARY METHOD
        float[][] opt = new float[number_of_tasks][(int) max_profit*number_of_tasks];


        for (int p = 0; p < max_profit*number_of_tasks; p++){
            opt[0][p] = 0;
        }

//        for (int n = 1; n < number_of_tasks; n++){
//        	for (int p = 0; p < max_profit*number_of_tasks; p++){
//        		if (list_points.get(n) > max_profit*number_of_tasks){
//        			opt[n][max_profit*number_of_tasks] = opt[n-1][]
//        		}
//        	}
//        }

        return -2;
    }

    private LinkedList<Float> getListofPoints(Map<Float,Float> map){
        LinkedList<Float> res = new LinkedList<Float>();
        Iterator<Entry<Float, Float>> iter = map.entrySet().iterator();
        while (iter.hasNext()){
            Map.Entry<Float, Float> task = (Entry<Float, Float>)iter.next();
            res.add(task.getValue());
        }

        return res;
    }

    private LinkedList<Float> getListofHours(Map<Float,Float> map){
        LinkedList<Float> res = new LinkedList<Float>();
        Iterator<Entry<Float, Float>> iter = map.entrySet().iterator();
        while (iter.hasNext()){
            Map.Entry<Float, Float> task = (Entry<Float, Float>)iter.next();
            res.add(task.getKey());
        }

        return res;
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