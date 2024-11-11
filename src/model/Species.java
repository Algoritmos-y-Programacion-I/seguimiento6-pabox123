package model;

public class Species {

	private String name;
	private String scientificName;
	private boolean hasFlowers; 
    private boolean hasFruits;  
    private double maxHeight;   
    private boolean isMigratory; 
    private double maxWeight;    
    private SpeciesType type;
	public Species(String name, String scientificName, boolean hasFlowers2, boolean hasFruits2, double maxHeight2) {

		this.name = name;
		this.scientificName = scientificName;
		this.hasFlowers = hasFlowers;
        this.hasFruits = hasFruits;
        this.maxHeight = maxHeight;
        this.type = SpeciesType.LAND_FLORA;
	}


    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getScientificName() {
		return scientificName;
	}

	public void setScientificName(String scientificName) {
		this.scientificName = scientificName;
	}

	public boolean isHasFlowers() {
		return hasFlowers;
	}

	public void setHasFlowers(boolean hasFlowers) {
		this.hasFlowers = hasFlowers;
	}

	public boolean isHasFruits() {
		return hasFruits;
	}

	public void setHasFruits(boolean hasFruits) {
		this.hasFruits = hasFruits;
	}

	public double getMaxHeight() {
		return maxHeight;
	}

	public void setMaxHeight(double maxHeight) {
		this.maxHeight = maxHeight;
	}

	public boolean isMigratory() {
		return isMigratory;
	}

	public void setMigratory(boolean isMigratory) {
		this.isMigratory = isMigratory;
	}

	public double getMaxWeight() {
		return maxWeight;
	}

	public void setMaxWeight(double maxWeight) {
		this.maxWeight = maxWeight;
	}

	public SpeciesType getType() {
		return type;
	}

	public void setType(SpeciesType type) {
		this.type = type;
	}

public boolean hasFlowers() {
    return hasFlowers;
}



public boolean hasFruits() {
    return hasFruits;
}


}
