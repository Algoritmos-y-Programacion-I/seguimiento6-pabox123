package ui;

import java.util.Scanner;

import model.SpeciesController;
import model.SpeciesType;
import model.Species;
public class SpeciesExecutable {

	private Scanner reader;
	private SpeciesController speciesController;

	public static void main(String[] args) {
		SpeciesExecutable exe = new SpeciesExecutable();
		exe.showMainMenu();
	}

	public SpeciesExecutable() {

		reader = new Scanner(System.in);
		speciesController = new SpeciesController();
	}

	public void showMainMenu() {
		System.out.println("Welcome to Icesi Species");
	
		boolean stopFlag = false;
	
		while (!stopFlag) {
			System.out.println("\nType an option");
			System.out.println("1. register a flora specie");
			System.out.println("2. Register a fauna species");
			System.out.println("3. Edit a Specie");
			System.out.println("4. delete a Specie");
			System.out.println("5. show the specie");
			System.out.println("0. Exit");
	
			int mainOption = reader.nextInt();
	
			switch (mainOption) {
				case 1:
					registerSpecies(); 
					break;
				case 2:
					registerFaunaSpecies(); 
					break;
				case 3:
					editSpecies();
					break;
				case 4:
					deleteSpecies();
					break;
				case 5:
					showSpecies();
					break;
				case 0:
					System.out.println("Thanks for using our system");
					stopFlag = true;
					break;
				default:
					System.out.println("put a valid option");
					break;
			}
		}
	}
	public void registerSpecies() {

		System.out.println("Type the new Species' name: ");
		String name = reader.next();

		System.out.println("Type the new Species' scientific name: ");
		String scientificName = reader.next();

		System.out.println("is a flowering plant? (true/false) ");
		boolean hasFlowers = reader.nextBoolean();
	
		System.out.println(" have fruits? (true/false) ");
		boolean hasFruits = reader.nextBoolean();
	
		System.out.println("what is the maximum height it can reach? (in mts) ");
		double maxHeight = reader.nextDouble();
	

		if (speciesController.registerSpecies(name, scientificName, hasFlowers, hasFruits, maxHeight)) {
			System.out.println("Species registered successfully");
		} else {
			System.out.println("Error, Species couldn't be registered");
		}
	}

	public void registerFaunaSpecies() {
		System.out.println("put the new species name ");
		String name = reader.next();
	
		System.out.println("put the new species scientific name ");
		String scientificName = reader.next();
	
		System.out.println("is migratory? (true/false) ");
		boolean isMigratory = reader.nextBoolean();
	
		System.out.println("what is the maximum weight can reach? (in kg) ");
		double maxWeight = reader.nextDouble();
	
		if (speciesController.registerFaunaSpecies(name, scientificName, isMigratory, maxWeight)) {
			System.out.println("Species registered successfully");
		} else {
			System.out.println("Error, Species couldn't be registered");
		}
	}


         
         
           



	public void editSpecies() {

		System.out.println("Which Species do you want to edit?");

		String query = speciesController.showSpeciesList();

		if (!query.equals("")) {
			System.out.println(query);

			System.out.println("enter the number of the species to edit");
            int index = reader.nextInt() ; 
            reader.nextLine(); 

            System.out.println("put the new species name");
            String newName = reader.nextLine();

            System.out.println("put the new species scientific name");
            String newScientificName = reader.nextLine();

			if (speciesController.editSpecies(index, newName, newScientificName)) {
                System.out.println("species edited successfully");
		} else {
			System.out.println("There aren't any species registered yet");
		}
	}

	}

	public void deleteSpecies() {

		System.out.println("Which Species do you want to delete?");

		String query = speciesController.showSpeciesList();

		if (!query.equals("")) {
			System.out.println(query);

			System.out.println("put the number of the species to delete it");
            int index = reader.nextInt(); 
            reader.nextLine(); 

            if (speciesController.deleteSpecies(index)) {
                System.out.println("species deleted successfully");
            } else {
                System.out.println(" error species could not be deleted");
            }

		} else {
			System.out.println("There aren't any species registered yet");
		}

	}

	public void showSpecies() {
    System.out.println("what Species do you want to review");

    String query = speciesController.showSpeciesList();

    if (!query.equals("")) {
        System.out.println(query);

        System.out.println("Put the number of the species to show it");
        int index = reader.nextInt();
        reader.nextLine();

        Species species = speciesController.getSpecies(index); 

        if (species != null) {
            System.out.println("Details:");
            System.out.println("Name: " + species.getName());
            System.out.println("Scientific Name: " + species.getScientificName());
            
         
            if (species.getType() == SpeciesType.LAND_FLORA || species.getType() == SpeciesType.AQUATIC_FLORA) {
                System.out.println("has Flowers " + species.hasFlowers());
                System.out.println("has Fruits " + species.hasFruits());
                System.out.println("max Height " + species.getMaxHeight() + " mts");
            } else {
                System.out.println("migratory " + species.isMigratory());
                System.out.println("max weight " + species.getMaxWeight() + " kg");
            }
        } else {
            System.out.println("species not found");
        }
    } else {
        System.out.println("There aren't any species registered yet");
    }
}
}
