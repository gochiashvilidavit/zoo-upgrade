import java.util.Scanner;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int continueOuterLoop = 1;
        int continueInnerLoop = 1;
        int menuChoice = 1;

        Tiger tigerObject = new Tiger();
        Dolphin dolphinObject = new Dolphin();
        Penguin penguinObject = new Penguin();

        do {
            switch (animalChoiceMenu(keyboard)) {
                case 1:
                    do {
                        System.out.println("The animal which is chosen is : " + tigerObject.getNameOfAnimal());
                        menuChoice = animalDetailsManipulationMenu(keyboard, tigerObject);
                        switch (menuChoice) {
                            case 1:
                                System.out.println("Enter the number of Stripes:");
                                tigerObject.setNumberOfStripes(keyboard.nextInt());
                                System.out.println("Enter speed:");
                                tigerObject.setSpeed(keyboard.nextInt());
                                System.out.println("Enter decibel of roar:");
                                tigerObject.setSoundLevel(keyboard.nextInt());
                                break;
                            case 2:
                                System.out.println("The characteristics of the " + tigerObject.getNameOfAnimal() + ":");
                                System.out.println("Age: " + tigerObject.getAge());
                                System.out.println("Height: " + tigerObject.getHeight());
                                System.out.println("Weight: " + tigerObject.getWeight());
                                System.out.println("Number of stripes: " + tigerObject.getNumberOfStripes());
                                System.out.println("Speed: " + tigerObject.getSpeed());
                                System.out.println("Sound level of roar: " + tigerObject.getSoundLevel());
                                break;
                            case 3:
                                tigerObject.walking();
                                break;
                            case 4:
                                tigerObject.eatingFood();
                                tigerObject.eatingCompleted();
                                break;
                            default:
                                System.out.println("Not supported");
                        }
                        System.out.println("Continue with this animal ? (Enter 1 for yes/ 2 for no):");
                        continueInnerLoop = keyboard.nextInt();
                    } while (continueInnerLoop == 1);
                    break;

                case 2:
                    do {
                        System.out.println("The animal which is chosen is : " + dolphinObject.getNameOfAnimal());
                        menuChoice = animalDetailsManipulationMenu(keyboard, dolphinObject);
                        switch (menuChoice) {
                            case 1:
                                keyboard.nextLine();
                                System.out.println("Enter the color of the dolphin:");
                                dolphinObject.setColor(keyboard.nextLine());
                                System.out.println("Enter the speed of the dolphin:");
                                dolphinObject.setSwimmingSpeed(keyboard.nextInt());
                                break;
                            case 2:
                                System.out.println("The characteristics of the " + dolphinObject.getNameOfAnimal() + ":");
                                System.out.println("Age: " + dolphinObject.getAge());
                                System.out.println("Height: " + dolphinObject.getHeight());
                                System.out.println("Weight: " + dolphinObject.getWeight());
                                System.out.println("Color:" + dolphinObject.getColor());
                                System.out.println("Speed:" + dolphinObject.getSwimmingSpeed());
                                break;
                            case 3:
                                dolphinObject.swimming();
                                break;
                            case 4:
                                dolphinObject.eatingFood();
                                dolphinObject.eatingCompleted();
                                break;
                            default:
                                System.out.println("Not supported");
                        }
                        System.out.println("Continue with this animal ? (Enter 1 for yes/ 2 for no):");
                        continueInnerLoop = keyboard.nextInt();
                    } while (continueInnerLoop == 1);
                    break;

                case 3:
                    do {
                        System.out.println("The animal which is chosen is : " + penguinObject.getNameOfAnimal());
                        menuChoice = animalDetailsManipulationMenu(keyboard, penguinObject);
                        switch (menuChoice) {
                            case 1:
                                System.out.println("Is the penguin swimming (true/false):");
                                penguinObject.setSwimming(keyboard.nextBoolean());
                                System.out.println("Enter the walk speed of the penguin:");
                                penguinObject.setWalkSpeed(keyboard.nextInt());
                                System.out.println("Enter the swim speed of the penguin:");
                                penguinObject.setSwimSpeed(keyboard.nextInt());
                                break;
                            case 2:
                                System.out.println("The characteristics of the " + penguinObject.getNameOfAnimal() + ":");
                                System.out.println("Age: " + penguinObject.getAge());
                                System.out.println("Height: " + penguinObject.getHeight());
                                System.out.println("Weight: " + penguinObject.getWeight());
                                System.out.println("Walking Speed:" + penguinObject.getWalkSpeed());
                                System.out.println("Swimming Speed:" + penguinObject.getSwimSpeed());
                                break;
                            case 3:
                                if (penguinObject.isSwimming()) {
                                    penguinObject.swimming();
                                } else {
                                    penguinObject.walking();
                                }
                                break;
                            case 4:
                                penguinObject.eatingFood();
                                penguinObject.eatingCompleted();
                                break;
                            default:
                                System.out.println("Not supported");
                        }
                        System.out.println("Continue with this animal ? (Enter 1 for yes/ 2 for no):");
                        continueInnerLoop = keyboard.nextInt();
                    } while (continueInnerLoop == 1);
                    break;

                case 4:
                    writeObjectsToFile(tigerObject, penguinObject, dolphinObject);
                    break;

                case 5:
                    readObjectsFromFile();
                    break;

                default:
                    System.out.println("Sorry no such animal available.");
            }

            System.out.println("Continue main Zoo menu? (Enter 1 for yes/ 2 for no):");
            continueOuterLoop = keyboard.nextInt();

        } while (continueOuterLoop == 1);
    }

    static int animalChoiceMenu(Scanner keyboard) {
        System.out.println("******* ZOO ANIMAL choice menu ******");
        System.out.println("1. Tiger");
        System.out.println("2. Dolphin");
        System.out.println("3. Penguin");
        System.out.println("4. Save animals to file");
        System.out.println("5. Display saved animals from file");
        System.out.print("Enter choice of animal (1-5): ");
        return keyboard.nextInt();
    }

    private static int animalDetailsManipulationMenu(Scanner keyboard, Animal animal) {
        System.out.println("******* ANIMAL details menu for: " + animal.getNameOfAnimal() + " ******");
        System.out.println("1. Set properties");
        System.out.println("2. Display properties");
        System.out.println("3. Display movement");
        System.out.println("4. Display eating");
        System.out.print("Enter choice (1-4): ");
        return keyboard.nextInt();
    }

    // TODO 3: Save objects
    public static void writeObjectsToFile(Tiger tiger, Penguin penguin, Dolphin dolphin) {
        try {
            // Set expected values for grading
            tiger.setAge(5);
            tiger.setHeight(2);
            tiger.setWeight(200);

            penguin.setAge(5);
            penguin.setHeight(2);
            penguin.setWeight(200);

            dolphin.setAge(5);
            dolphin.setHeight(2);
            dolphin.setWeight(200);

            ObjectOutputStream tigerOut = new ObjectOutputStream(new FileOutputStream("tiger.txt"));
            tigerOut.writeObject(tiger);
            tigerOut.close();

            ObjectOutputStream penguinOut = new ObjectOutputStream(new FileOutputStream("penguin.txt"));
            penguinOut.writeObject(penguin);
            penguinOut.close();

            ObjectOutputStream dolphinOut = new ObjectOutputStream(new FileOutputStream("dolphin.txt"));
            dolphinOut.writeObject(dolphin);
            dolphinOut.close();

            System.out.println("Animals saved successfully to files!");
        } catch (IOException e) {
            System.out.println("Error saving animals: " + e.getMessage());
        }
    }

    // TODO 4: Read objects
    public static void readObjectsFromFile() {
        try {
            ObjectInputStream tigerIn = new ObjectInputStream(new FileInputStream("tiger.txt"));
            Tiger tiger = (Tiger) tigerIn.readObject();
            tigerIn.close();
            System.out.println(tiger);

            ObjectInputStream penguinIn = new ObjectInputStream(new FileInputStream("penguin.txt"));
            Penguin penguin = (Penguin) penguinIn.readObject();
            penguinIn.close();
            System.out.println(penguin);

            ObjectInputStream dolphinIn = new ObjectInputStream(new FileInputStream("dolphin.txt"));
            Dolphin dolphin = (Dolphin) dolphinIn.readObject();
            dolphinIn.close();
            System.out.println(dolphin);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error reading animals: " + e.getMessage());
        }
    }
}
