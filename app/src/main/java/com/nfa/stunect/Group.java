package com.nfa.stunect;

public class Group {

    private final int groupID;
    private groupType type;
    private int capacity;

    public Group(int groupID, groupType type) {

        this.groupID = groupID;
        this.type = type;
        capacity = type == groupType.GROUP_PRIVATE ? 2 : 20;
    }

    //Getters

    public int getGroupID () {
        return this.groupID;
    }

    public groupType getGroupType () {
        return this.type;
    }

}
