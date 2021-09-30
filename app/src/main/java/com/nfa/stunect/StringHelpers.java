package com.nfa.stunect;

public class StringHelpers
{
    public static Boolean String_Cmp_filter_spaces_cases (String s1,String s2){
       return s1.trim().replaceAll("\\s+", " ").equalsIgnoreCase(s2.trim().replaceAll("\\s+", " "));
    }
    public static Boolean String_Cmp_filter_spaces (String s1,String s2){
        return s1.trim().replaceAll("\\s+", " ").equals(s2.trim().replaceAll("\\s+", " "));
    }
}
