package model;

public class SpeciesController {

	private Species[] species;

	public SpeciesController() {

		this.species = new Species[80];

	}
	public boolean registerSpecies(String name, String scientificName, boolean hasFlowers, boolean hasFruits, double maxHeight) {
        for (int i = 0; i < species.length; i++) {
            if (species[i] == null) {
                species[i] = new Species(name, scientificName, hasFlowers, hasFruits, maxHeight);
                return true;
            }
        }
        return false;
    }
	public boolean registerFaunaSpecies(String name, String scientificName, boolean isMigratory, double maxWeight) {
        for (int i = 0; i < species.length; i++) {
            if (species[i] == null) {
                species[i] = new Species(name, scientificName, isMigratory, isMigratory, maxWeight);
                return true;
            }
        }
        return false;
    }

		public String showSpeciesList() {
			StringBuilder msg = new StringBuilder();
	
			for (int i = 0; i < species.length; i++) {
				if (species[i] != null) {
					msg.append("\n").append(i + 1).append(". ").append(species[i].getName());
				}
			}
	
			return msg.toString();
		}

	public boolean editSpecies(int index, String newName, String newScientificName) {
        if (index >= 0 && index < species.length && species[index] != null) {
            species[index].setName(newName);
            species[index].setScientificName(newScientificName);
            return true;
        }
        return false;
    }

	public boolean deleteSpecies(int index) {
        if (index >= 0 && index < species.length && species[index] != null) {
            species[index] = null; 
            return true;
        }
        return false;
    }

    public Species getSpecies(int index) {
        if (index >= 0 && index < species.length) {
            return species[index];
        }
        return null;
    }
}
