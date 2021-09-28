package com.nfa.stunect;

public class Group {

    private final String groupID;
    private groupType type;
    private int capacity;

    public Group(String groupID, groupType type) {

        this.groupID = groupID;
        this.type = type;
        capacity = type == groupType.GROUP_PRIVATE ? 2 : 20;
    }

    //Getters

    public String getGroupID () {
        return this.groupID;
    }

    public groupType getGroupType () {
        return this.type;
    }

}
