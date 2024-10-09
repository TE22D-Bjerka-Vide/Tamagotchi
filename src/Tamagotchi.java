import java.util.ArrayList;
import java.util.Random;


public class Tamagotchi {
        // attribute
        private int hunger;
        private int boredom;
        private ArrayList<String> words;
        private boolean isAlive;
        private Random generator;
        public String name;

        // construktor
        public Tamagotchi(String name) {
            this.name = name;
            this.hunger = 0;
            this.boredom = 0;
            this.words = new ArrayList<>();
            this.isAlive = true;
            this.generator = new Random();
        }
/* ******************************* */
/* *********** metoder *********** */
/* ******************************* */
        public void feed() {
            if (isAlive) {
                hunger = Math.max(0, hunger - 1);
                tick();
            }
        }

        public void speak() {
            if (isAlive) {
                if (!words.isEmpty()) {
                    int randomIndex = generator.nextInt(words.size());
                    System.out.println(name + " säger: " + words.get(randomIndex));
                } else {
                    System.out.println(name + " har inte lärt sig några ord än!");
                }
                reduceBoredom();
                tick();
            }
        }

        public void teach(String word) {
            if (isAlive) {
                words.add(word);
                System.out.println(name + " lärde sig ordet: " + word);
                reduceBoredom();
                tick();
            }
        }

        public void printStats() {
            System.out.println("Status för " + name + ":");
            System.out.println("Hunger: " + hunger);
            System.out.println("Tristess: " + boredom);
            System.out.println("Lever: " + (isAlive ? "Ja" : "Nej"));
        }

        public boolean getAlive() {
            return isAlive;
        }

        private void reduceBoredom() {
            boredom = Math.max(0, boredom - 1);
        }

        public void tick() {
            if (isAlive) {
                hunger++;
                boredom++;
                if (hunger > 10 || boredom > 10) {
                    isAlive = false;
                    System.out.println(name + " har dött...");
                }
            }
        }
    }
