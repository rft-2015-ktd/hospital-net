package hu.unideb.hospitalnet.web.statistics.model;

public enum StatType {
	NONE(""), TOP10DISEASES("Leggyakoribb betegségek");

	private String displayName;

	private StatType(String name) {
		displayName = name;
	}

	public String getDisplayName() {
		return displayName;
	}

}
