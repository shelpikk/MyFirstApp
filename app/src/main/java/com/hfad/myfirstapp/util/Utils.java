package com.hfad.myfirstapp.util;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Utils {
    public static List<String> checkFields(List<TextInputEditText> fields){ ArrayList<String> list = new ArrayList<>();
        for (TextInputEditText entry : fields){
            if (entry.getText().toString().equals("")){
                list.add(entry.getHint().toString());
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
