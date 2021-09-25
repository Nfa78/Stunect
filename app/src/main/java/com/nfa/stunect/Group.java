package com.nfa.stunect;

public class Group {

    private final int groupID;
    private groupType type;

    public Group(int groupID, groupType type) {

        this.groupID = groupID;
        this.type = type;
    }

    //Getters

    public int getGroupID () {
        return this.groupID;
    }

    public groupType getGroupType () {
        return this.type;
    }

}
