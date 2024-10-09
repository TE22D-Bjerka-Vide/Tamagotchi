
import java.util.Scanner;

        public class Main {
            public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);

                // Låt spelaren döpa sin tamagotchi
                System.out.print("Vad vill du att din tamagotchi ska heta? ");
                String name = scanner.nextLine();
                Tamagotchi pet = new Tamagotchi(name);

                // Spelloopen
                while (pet.getAlive()) {
                    System.out.println("Vad vill du göra med " + name + "?");
                    System.out.println("1. Lära ett nytt ord");
                    System.out.println("2. Hälsa på " + name);
                    System.out.println("3. Mata " + name);
                    System.out.println("4. Ingenting");
                    System.out.print("Välj ett alternativ: ");
                    int choice = scanner.nextInt();
                    scanner.nextLine();  // Rensa radbrytning

                    switch (choice) {
                        case 1:
                            System.out.print("Vilket ord vill du lära " + name + "? ");
                            String word = scanner.nextLine();
                            pet.teach(word);
                            break;
                        case 2:
                            pet.speak();
                            break;
                        case 3:
                            pet.feed();
                            break;
                        case 4:
                            System.out.println("Du gjorde ingenting.");
                            pet.tick();
                            break;
                        default:
                            System.out.println("Ogiltigt val, försök igen.");
                    }

                    // Skriv ut status efter varje handling
                    pet.printStats();
                }

                System.out.println("Spelet är över. " + name + " lever inte längre.");
                scanner.close();
            }
        }

