package com.nfa.stunect;

import android.util.Log;

public class IDGenerator {

    public String generateID (String preFix, String initial) {

        String tableName = "";

        try {

           switch (preFix) {
               case "user":
                   tableName = "User";
               case "group":
                   tableName = "Group";
               case "uni" :
                   tableName = "University";

           }
            return preFix + initial + SQLHelpers.getCountOfDB(tableName);


        } catch (Exception e) {

            Log.e("Not A Valid Prefix", e.getMessage());
        }

        return "XX";


    }

}
