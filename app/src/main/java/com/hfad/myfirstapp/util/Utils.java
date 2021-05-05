package com.hfad.myfirstapp.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Utils {
    public static List<String> checkFields(Map<String, String> fields){ ArrayList<String> list = new ArrayList<>();
        for (Map.Entry<String, String> entry : fields.entrySet()){
            if (entry.getValue().equals("")){
                list.add(entry.getKey());
            }
        }
        return list;
    }

    public static String convertList(List<String> list) {
        StringBuilder stringBuilder = new StringBuilder();
        for(String str : list){
            stringBuilder.append(str).append(", ");
        }
        return stringBuilder.substring(0,stringBuilder.length()-2);
    }
}
