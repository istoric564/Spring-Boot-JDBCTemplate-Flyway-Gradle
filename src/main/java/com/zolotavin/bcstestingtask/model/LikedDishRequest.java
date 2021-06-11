package com.zolotavin.bcstestingtask.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class LikedDishRequest {

    private List<String> listDishes;
}
