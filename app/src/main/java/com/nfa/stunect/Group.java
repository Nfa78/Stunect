package com.nfa.stunect;

public class Group {

    private final String groupID;
    private groupType type;

    public Group(String groupID, groupType type) {

        this.groupID = groupID;
        this.type = type;
    }

    //Getters

    public String getGroupID () {
        return this.groupID;
    }

    public groupType getGroupType () {
        return this.type;
    }

}
