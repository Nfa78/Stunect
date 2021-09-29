package com.nfa.stunect;

import android.util.Log;

public class IDGenerator {

    public String generateID (String preFix, String initial) {

        String result = preFix.concat(initial);

        try {

           switch (preFix) {

               case "user":
                   result.concat(String.valueOf(SQLHelpers.getCountOfDB("User")));
               case "group":
                   result.concat(String.valueOf(SQLHelpers.getCountOfDB("Group")));
               case "uni":
                   result.concat(String.valueOf(SQLHelpers.getCountOfDB("University")));
           }

            return result;


        } catch (Exception e) {

            Log.e("Not A Valid Prefix", e.getMessage());
        }

        return "XX";


    }

}
