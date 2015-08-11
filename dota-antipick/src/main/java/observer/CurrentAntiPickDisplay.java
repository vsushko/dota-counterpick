package observer;

import com.vsprog.anitipick.Bunch;
import com.vsprog.anitipick.Hero;
import com.vsprog.anitipick.HeroesBuilder;
import com.vsprog.anitipick.Pick;

import java.util.*;

/**
 * @author vsa
 * @date 08.08.2015.
 */
public class CurrentAntiPickDisplay implements Observer {
    private List<Hero> heroes;

    private Pick pick;
    private Pick antiPick;
    private List<String> firstHeroEnemies;
    private List<String> secondHeroEnemies;
    private List<String> thirdHeroEnemies;
    private List<String> fourthHeroEnemies;
    private List<String> fifthHeroEnemies;
    private List<Bunch> heroesBunch;


    private List<String> heroFriends;

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

        antiPick = new Pick();

        firstHeroEnemies = new ArrayList<>();
        secondHeroEnemies = new ArrayList<>();
        thirdHeroEnemies = new ArrayList<>();
        fourthHeroEnemies = new ArrayList<>();
        fifthHeroEnemies = new ArrayList<>();

        heroFriends = new ArrayList<>();

        antiPickHeroes = new HashMap<>();
        heroesBunch = new ArrayList<>();

        pick.registerObserver(this);
    }

    @Override
    public void update(Hero firstHero, Hero secondHero, Hero thirdHero, Hero fourthHero, Hero fifthHero) {
        System.out.println("--------------------------------------------------------------");
        int weight;

        // выбран первый герой
        if (firstHero != null && secondHero == null && thirdHero == null && fourthHero == null && fifthHero == null) {
            weight = 1;

            for (String heroName : firstHeroEnemies) {
                antiPickHeroes.put(heroName, weight);
            }
        }

        // выбран второй герой
        if (firstHero != null && secondHero != null && thirdHero == null && fourthHero == null && fifthHero == null) {
            secondHeroEnemies.addAll(secondHero.getEnemies());
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
        if (firstHero != null && secondHero != null && thirdHero != null && fourthHero == null && fifthHero == null) {
            thirdHeroEnemies.addAll(thirdHero.getEnemies());
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
        if (firstHero != null && secondHero != null && thirdHero != null && fourthHero != null && fifthHero == null) {
            fourthHeroEnemies.addAll(fourthHero.getEnemies());
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

        // выбран пятый герой
        if (firstHero != null && secondHero != null && thirdHero != null && fourthHero != null && fifthHero != null) {
            fifthHeroEnemies.addAll(fifthHero.getEnemies());
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

        System.out.println("--------------------------------------------------------------");

        if (firstHero != null && secondHero != null && thirdHero != null && fourthHero != null && fifthHero != null) {

            for (String heroName : antiPickHeroes.keySet()) {

                // get hero from anti pick list
                Hero hero = HeroesBuilder.getHeroByName(heroes, heroName);

                List<String> friends = hero.getFriends();

                for (String friendHeroName : friends) {
                    if (antiPickHeroes.containsKey(friendHeroName)) {
                        Bunch bunch = new Bunch();
                        bunch.setSecondHero(friendHeroName);
                        bunch.setFirstHero(heroName);

                        if (!isDoublesExist(heroesBunch, bunch)) {
                            heroesBunch.add(bunch);
                        }
                    }
                }
            }

            for (Bunch bunch : heroesBunch) {
                String firstHeroName = bunch.getSecondHero();
                String secondHeroName = bunch.getSecondHero();
                for (String heroName : antiPickHeroes.keySet()) {
                    if (secondHeroName.equals(heroName) && !firstHeroName.equals(secondHero)
                            && !firstHeroName.equals(heroName)) {
                        System.out.println(new Bunch(firstHeroName, secondHeroName, heroName));
                    }
                }
            }

        }

        // TODO: find triple bunches!!!



        for (Bunch bunch : heroesBunch) {
            System.out.println(bunch);
        }

        // extract 5 heroes with weights
        for (String name : antiPickHeroes.keySet()) {
                System.out.println(name + ": " + antiPickHeroes.get(name));
        }

        System.out.println("--------------------------------------------------------------");

        this.firstEnemy = firstHero != null ? firstHero : new Hero();
        this.secondEnemy = secondHero != null ? secondHero : new Hero();
        this.thirdEnemy = thirdHero != null ? thirdHero : new Hero();
        this.fourthEnemy = fourthHero != null ? fourthHero : new Hero();
        this.fifthEnemy = fifthHero != null ? fifthHero : new Hero();

        display();
    }

    private boolean isDoublesExist(List<Bunch> doubles, Bunch doublesBunch) {
        for (Bunch bunch : doubles) {
            if (doublesBunch.getFirstHero().equals(bunch.getSecondHero())
                    && doublesBunch.getSecondHero().equals(bunch.getFirstHero())) {
                return true;
            }
        }
        return false;
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

    public void setHeroes(List<Hero> heroes) {
        this.heroes = heroes;
    }
}