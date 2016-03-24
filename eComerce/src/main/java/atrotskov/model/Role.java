package atrotskov.model;

public enum Role {

	GUEST("guest"), USER("user"), ADMIN("admin");
	
	private String displayName;
	
	Role(String displayName){
		
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	
	
}
