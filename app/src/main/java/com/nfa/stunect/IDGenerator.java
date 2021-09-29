package com.nfa.stunect;

import android.util.Log;

public class IDGenerator {



    public static String generateID (String preFix, User user) {

        StringBuilder result = new StringBuilder();
        result.append(preFix).append(user.getInitials());

        try {

           switch (preFix) {

               case "user":
                   result.append(SQLHelpers.getCountOfDB("User"));
                   break;
               case "group":
                   result.append(SQLHelpers.getCountOfDB("Group"));
                   break;
               case "uni":
                   result.append(SQLHelpers.getCountOfDB("University"));
                   break;
           }

            return result.toString();


        } catch (Exception e) {

            Log.e("Not A Valid Prefix", e.getMessage());
        }

        return "XX";


    }


}
