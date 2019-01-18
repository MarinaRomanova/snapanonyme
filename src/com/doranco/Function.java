package com.doranco;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Function {
    public Function() {
    }

    public static int generateId(List<Integer> idList){
        Integer id = Math.abs(new Random().nextInt());

        if (idList.contains(id))  generateId(idList);
        else   idList.add(id);
        return id;
    }
}
