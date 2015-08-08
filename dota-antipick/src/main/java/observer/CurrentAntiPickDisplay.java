package observer;

import com.vsprog.anitipick.Hero;
import com.vsprog.anitipick.Pick;

import java.util.*;

/**
 * @author vsa
 * @date 08.08.2015.
 */
public class CurrentAntiPickDisplay implements Observer {
    private Pick pick;
    private Pick anitiPick;
    private List<String> firstHeroEnemies;
    private List<String> secondHeroEnemies;
    private List<String> thirdHeroEnemies;
    private List<String> fourthHeroEnemies;
    private List<String> fifthHeroEnemies;

    private int currentCount = 0;

    private Hero firstEnemy, secondEnemy, thirdEnemy, fourthEnemy, fifthEnemy;
    private Map<String, Integer> antiPickHeroes;

    public CurrentAntiPickDisplay(Pick pick) {
        this.pick = pick;
        firstEnemy = new Hero();
        secondEnemy = new Hero();
        thirdEnemy = new Hero();
        fourthEnemy = new Hero();
        fifthEnemy = new Hero();

        anitiPick = new Pick();

        firstHeroEnemies = new ArrayList<>();
        secondHeroEnemies = new ArrayList<>();
        thirdHeroEnemies = new ArrayList<>();
        fourthHeroEnemies = new ArrayList<>();
        fifthHeroEnemies = new ArrayList<>();

        antiPickHeroes = new HashMap<>();

        pick.registerObserver(this);
    }

    @Override
    public void update(Hero firstEnemy, Hero secondEnemy, Hero thirdEnemy, Hero fourthEnemy, Hero fifthEnemy) {
        System.out.println("--------------------------------------------------------------");
        // вес героя
        int weight = 0;

        // выбран первый герой
        if (firstEnemy != null && secondEnemy == null && thirdEnemy == null && fourthEnemy == null && fifthEnemy == null) {
            firstHeroEnemies.addAll(firstEnemy.getEnemies());
            weight += 1;

            for (String heroName : firstHeroEnemies) {
                antiPickHeroes.put(heroName, weight);
            }
        }

        // выбран второй герой
        if (firstEnemy != null && secondEnemy != null && thirdEnemy == null && fourthEnemy == null && fifthEnemy == null) {
            secondHeroEnemies.addAll(secondEnemy.getEnemies());
            weight = 1;

            for (String heroName : secondHeroEnemies) {
                if (antiPickHeroes.containsKey(heroName)) {
                    weight = antiPickHeroes.get(heroName);
                    antiPickHeroes.put(heroName, weight++);
                } else {
                    antiPickHeroes.put(heroName, weight);
                }
            }
        }

        // выбран третий герой
        if (firstEnemy != null && secondEnemy != null && thirdEnemy != null && fourthEnemy == null && fifthEnemy == null) {
            thirdHeroEnemies.addAll(thirdEnemy.getEnemies());
            weight = 1;

            for (String heroName : thirdHeroEnemies) {
                if (antiPickHeroes.containsKey(heroName)) {
                    weight = antiPickHeroes.get(heroName);
                    antiPickHeroes.put(heroName, weight++);
                } else {
                    antiPickHeroes.put(heroName, weight);
                }

            }
        }

        // выбран четвертый герой
        if (firstEnemy != null && secondEnemy != null && thirdEnemy != null && fourthEnemy != null && fifthEnemy == null) {
            fourthHeroEnemies.addAll(fourthEnemy.getEnemies());
            weight = 1;

            for (String heroName : fourthHeroEnemies) {
                if (antiPickHeroes.containsKey(heroName)) {
                    weight = antiPickHeroes.get(heroName);
                    antiPickHeroes.put(heroName, weight++);
                } else {
                    antiPickHeroes.put(heroName, weight);
                }
            }
        }

        // выбран четвертый герой
        if (firstEnemy != null && secondEnemy != null && thirdEnemy != null && fourthEnemy != null && fifthEnemy != null) {
            fifthHeroEnemies.addAll(fifthEnemy.getEnemies());
            weight = 1;

            for (String heroName : fifthHeroEnemies) {
                if (antiPickHeroes.containsKey(heroName)) {
                    weight = antiPickHeroes.get(heroName);
                    antiPickHeroes.put(heroName, weight++);
                } else {
                    antiPickHeroes.put(heroName, weight);
                }
            }
        }

        // извлекаем 5 героев с наибольшим весом
        for (String heroName : antiPickHeroes.keySet()) {
            if (antiPickHeroes.get(heroName) > 1) {
                System.out.println(heroName + ": " + antiPickHeroes.get(heroName));
            }
        }

        System.out.println("--------------------------------------------------------------");

        this.firstEnemy = firstEnemy != null ? firstEnemy : new Hero();
        this.secondEnemy = secondEnemy != null ? secondEnemy : new Hero();
        this.thirdEnemy = thirdEnemy != null ? thirdEnemy : new Hero();
        this.fourthEnemy = fourthEnemy != null ? fourthEnemy : new Hero();
        this.fifthEnemy = fifthEnemy != null ? fifthEnemy : new Hero();

        display();
    }

    public void display() {
        System.out.println("Первый герой: " + firstEnemy.getName());
        System.out.println("Второй герой: " + secondEnemy.getName());
        System.out.println("Третий герой: " + thirdEnemy.getName());
        System.out.println("Четвертый герой: " + fourthEnemy.getName());
        System.out.println("Пятый герой: " + fifthEnemy.getName());
    }

    public int getCurrentCount() {
        return currentCount;
    }

    public void incrementCurrentCount() {
        currentCount++;
    }
}