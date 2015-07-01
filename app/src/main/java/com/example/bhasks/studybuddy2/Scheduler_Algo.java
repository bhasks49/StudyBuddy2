package com.example.bhasks.studybuddy2;

import java.util.ArrayList;

public class Scheduler_Algo{

    private int number_of_assignments;
    private Map<float,float> map_pts_to_time;
    private float ArrayList<ArrayList<int>> table_2D;

    static float max_point = 100.0;

    public Scheduler_Algo(Map<float,float> input_map){

        number_of_assignments = input_map.size();
        map_pts_to_time = new Map<float,float>(input_map);

        table_2D = new ArrayList<ArrayList<float>>(number_of_assignments);
        for (int i = 0; i < number_of_assignments; i++){
            table_2D[i] = new ArrayList<float>(number_of_assignments*max_point);
        }

    }



}