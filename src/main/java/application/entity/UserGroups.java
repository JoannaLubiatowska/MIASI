package application.entity;

import java.io.Serializable;

public class UserGroups implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2156387742720389706L;
	private Integer userGroupID;
	private String groupName;
	
	public UserGroups(Integer userGroupID, String groupName) {
		super();
		this.userGroupID = userGroupID;
		this.groupName = groupName;
	}
	public Integer getUserGroupID() {
		return userGroupID;
	}
	public void setUserGroupID(Integer userGroupID) {
		this.userGroupID = userGroupID;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
}
