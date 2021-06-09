package com.zolotavin.bcstestingtask.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.ArrayList;

@Data
@Accessors(chain = true)
public class ServiceRequestDish {

    private ArrayList<String> listDishes;
}
