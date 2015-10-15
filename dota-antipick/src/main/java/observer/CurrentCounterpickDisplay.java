package observer;

import com.vsprog.counterpick.*;

import java.util.*;

/**
 * @author vsa
 * @date 08.08.2015.
 */
public class CurrentCounterpickDisplay implements Observer {
    public static final int BUNCHES_COUNT = 7;
    private List<Hero> heroes;

    private Pick pick;
    private Pick counterPick;
    private List<String> firstHeroEnemies;
    private List<String> secondHeroEnemies;
    private List<String> thirdHeroEnemies;
    private List<String> fourthHeroEnemies;
    private List<String> fifthHeroEnemies;
    private List<Bunch> heroesBunch;

    private List<String> heroFriends;

    private int currentCount = 0;

    private Hero firstEnemy, secondEnemy, thirdEnemy, fourthEnemy, fifthEnemy;
    private Map<String, Integer> counterPickHeroes;

    private OutputInfo outputInfo;
    private boolean isAnalyzed = false;

    public CurrentCounterpickDisplay(Pick pick) {
        this.pick = pick;
        firstEnemy = new Hero();
        secondEnemy = new Hero();
        thirdEnemy = new Hero();
        fourthEnemy = new Hero();
        fifthEnemy = new Hero();

        counterPick = new Pick();

        firstHeroEnemies = new ArrayList<String>();
        secondHeroEnemies = new ArrayList<String>();
        thirdHeroEnemies = new ArrayList<String>();
        fourthHeroEnemies = new ArrayList<String>();
        fifthHeroEnemies = new ArrayList<String>();

        heroFriends = new ArrayList<String>();

        counterPickHeroes = new HashMap<String, Integer>();
        heroesBunch = new ArrayList<Bunch>();

        outputInfo = new OutputInfo();

        pick.registerObserver(this);
    }

    public void update(Hero firstHero, Hero secondHero, Hero thirdHero, Hero fourthHero, Hero fifthHero) {
        int weight;

        // выбран первый герой
        if (firstHero != null && secondHero == null && thirdHero == null && fourthHero == null && fifthHero == null) {
            weight = 1;

            for (String heroName : firstHeroEnemies) {
                counterPickHeroes.put(heroName, weight);
            }
        }

        // выбран второй герой
        if (firstHero != null && secondHero != null && thirdHero == null && fourthHero == null && fifthHero == null) {
            secondHeroEnemies.addAll(secondHero.getEnemies());
            weight = 1;

            for (String heroName : secondHeroEnemies) {
                if (counterPickHeroes.containsKey(heroName)) {
                    weight = counterPickHeroes.get(heroName);
                    counterPickHeroes.put(heroName, weight++);
                } else {
                    counterPickHeroes.put(heroName, weight);
                }
            }
        }

        // выбран третий герой
        if (firstHero != null && secondHero != null && thirdHero != null && fourthHero == null && fifthHero == null) {
            thirdHeroEnemies.addAll(thirdHero.getEnemies());
            weight = 1;

            for (String heroName : thirdHeroEnemies) {
                if (counterPickHeroes.containsKey(heroName)) {
                    weight = counterPickHeroes.get(heroName);
                    counterPickHeroes.put(heroName, weight++);
                } else {
                    counterPickHeroes.put(heroName, weight);
                }
            }
        }

        // выбран четвертый герой
        if (firstHero != null && secondHero != null && thirdHero != null && fourthHero != null && fifthHero == null) {
            fourthHeroEnemies.addAll(fourthHero.getEnemies());
            weight = 1;

            for (String heroName : fourthHeroEnemies) {
                if (counterPickHeroes.containsKey(heroName)) {
                    weight = counterPickHeroes.get(heroName);
                    counterPickHeroes.put(heroName, weight++);
                } else {
                    counterPickHeroes.put(heroName, weight);
                }
            }
        }

        // выбран пятый герой
        if (firstHero != null && secondHero != null && thirdHero != null && fourthHero != null && fifthHero != null) {
            fifthHeroEnemies.addAll(fifthHero.getEnemies());
            weight = 1;

            for (String heroName : fifthHeroEnemies) {
                if (counterPickHeroes.containsKey(heroName)) {
                    weight = counterPickHeroes.get(heroName);
                    counterPickHeroes.put(heroName, weight++);
                } else {
                    counterPickHeroes.put(heroName, weight);
                }
            }
        }

        List<Bunch> triples = new ArrayList<Bunch>();
        List<Bunch> quaternion = new ArrayList<Bunch>();
        List<Bunch> cinque = new ArrayList<Bunch>();

        if (firstHero != null && secondHero != null && thirdHero != null && fourthHero != null && fifthHero != null) {

            for (String heroName : counterPickHeroes.keySet()) {

                // get hero from anti pick list
                Hero hero = HeroesBuilder.getHeroByName(heroes, heroName);

                List<String> friends = hero.getFriends();

                for (String friendHeroName : friends) {
                    if (counterPickHeroes.containsKey(friendHeroName)) {
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
                String firstHeroName = bunch.getFirstHero();
                String secondHeroName = bunch.getSecondHero();
                Hero hero = HeroesBuilder.getHeroByName(heroes, secondHeroName);

                // поиск слабой триплы
                for (String heroName : hero.getFriends()) {
                    if (!bunch.getFirstHero().equals(heroName)
                            && !firstHero.getName().equals(heroName)
                            && !secondHero.getName().equals(heroName)
                            && !thirdHero.getName().equals(heroName)
                            && !fourthHero.getName().equals(heroName)
                            && !fifthHero.getName().equals(heroName)
                            && HeroesBuilder.getHeroByName(heroes, firstHeroName).getFriends().contains(heroName)) {

                        triples.add(new Bunch(bunch.getFirstHero(), bunch.getSecondHero(), heroName));
                    }
                }
            }

            for (Bunch bunch : triples) {
                String secondHeroName = bunch.getSecondHero();
                String thirdHeroName = bunch.getThirdHero();

                Hero hero = HeroesBuilder.getHeroByName(heroes, thirdHeroName);
                // поиск слабой четверки
                for (String heroName : hero.getFriends()) {
                    if (!bunch.getFirstHero().equals(heroName)
                            && !bunch.getSecondHero().equals(heroName)
                            && !firstHero.getName().equals(heroName)
                            && !secondHero.getName().equals(heroName)
                            && !thirdHero.getName().equals(heroName)
                            && !fourthHero.getName().equals(heroName)
                            && !fifthHero.getName().equals(heroName)
                            && HeroesBuilder.getHeroByName(heroes, secondHeroName).getFriends().contains(heroName)) {
                        quaternion.add(new Bunch(bunch.getFirstHero(), bunch.getSecondHero(), bunch.getThirdHero(), heroName));
                    }
                }
            }

            for (Bunch bunch : quaternion) {
                String thirdHeroName = bunch.getThirdHero();
                String fourthHeroName = bunch.getFourthHero();

                Hero hero = HeroesBuilder.getHeroByName(heroes, fourthHeroName);
                // поиск слабой четверки
                for (String heroName : hero.getFriends()) {
                    if (!bunch.getFirstHero().equals(heroName)
                            && !bunch.getSecondHero().equals(heroName)
                            && !bunch.getThirdHero().equals(heroName)
                            && !bunch.getFourthHero().equals(heroName)
                            && !firstHero.getName().equals(heroName)
                            && !secondHero.getName().equals(heroName)
                            && !thirdHero.getName().equals(heroName)
                            && !fourthHero.getName().equals(heroName)
                            && !fifthHero.getName().equals(heroName)
                            && HeroesBuilder.getHeroByName(heroes, thirdHeroName).getFriends().contains(heroName)) {
                        cinque.add(new Bunch(bunch.getFirstHero(), bunch.getSecondHero(), bunch.getThirdHero(), bunch.getFourthHero(), heroName));
                    }
                }
            }
        }

        Map<Double, Bunch> finalResultList = new HashMap<Double, Bunch>();

        for (Bunch bunch : cinque) {
            if (!bunch.getFirstHero().equals(firstHero.getName())
                    && !bunch.getSecondHero().equals(firstHero.getName())
                    && !bunch.getThirdHero().equals(firstHero.getName())
                    && !bunch.getFourthHero().equals(firstHero.getName())
                    && !bunch.getFifthHero().equals(firstHero.getName())

                    && !bunch.getFirstHero().equals(secondHero.getName())
                    && !bunch.getSecondHero().equals(secondHero.getName())
                    && !bunch.getThirdHero().equals(secondHero.getName())
                    && !bunch.getFourthHero().equals(secondHero.getName())
                    && !bunch.getFifthHero().equals(secondHero.getName())

                    && !bunch.getFirstHero().equals(thirdHero.getName())
                    && !bunch.getSecondHero().equals(thirdHero.getName())
                    && !bunch.getThirdHero().equals(thirdHero.getName())
                    && !bunch.getFourthHero().equals(thirdHero.getName())
                    && !bunch.getFifthHero().equals(thirdHero.getName())

                    && !bunch.getFirstHero().equals(fourthHero.getName())
                    && !bunch.getSecondHero().equals(fourthHero.getName())
                    && !bunch.getThirdHero().equals(fourthHero.getName())
                    && !bunch.getFourthHero().equals(fourthHero.getName())
                    && !bunch.getFifthHero().equals(fourthHero.getName())

                    && !bunch.getFirstHero().equals(fifthHero.getName())
                    && !bunch.getSecondHero().equals(fifthHero.getName())
                    && !bunch.getThirdHero().equals(fifthHero.getName())
                    && !bunch.getFourthHero().equals(fifthHero.getName())
                    && !bunch.getFifthHero().equals(fifthHero.getName())) {

                Hero bFirst = HeroesBuilder.getHeroByName(heroes, bunch.getFirstHero());
                Hero bSecond = HeroesBuilder.getHeroByName(heroes, bunch.getSecondHero());
                Hero bThird = HeroesBuilder.getHeroByName(heroes, bunch.getThirdHero());
                Hero bFour = HeroesBuilder.getHeroByName(heroes, bunch.getFourthHero());
                Hero bFive = HeroesBuilder.getHeroByName(heroes, bunch.getFifthHero());

                double winRateSum = bFirst.getWinrate()
                        + bSecond.getWinrate()
                        + bThird.getWinrate()
                        + bFour.getWinrate()
                        + bFive.getWinrate();

                bunch.setWinRateSum(winRateSum);
                finalResultList.put(winRateSum, bunch);

            }
        }

        if (firstHero != null && secondHero != null && thirdHero != null && fourthHero != null && fifthHero != null) {
            Map<Double, Bunch> treeMap = new TreeMap<Double, Bunch>(new Comparator<Double>() {
                public int compare(Double o1, Double o2) {
                    return o2.compareTo(o1);
                }
            });

            treeMap.putAll(finalResultList);

            Map<Double, Bunch> rawMap = new HashMap<Double, Bunch>();
            rawMap.putAll(finalResultList);

            int sevenCount = 0;

            double totalWinRate = firstHero.getWinrate()
                    + secondHero.getWinrate()
                    + thirdHero.getWinrate()
                    + fourthHero.getWinrate()
                    + fifthHero.getWinrate();

            System.out.println("Heroes pick win rate: " + totalWinRate + "\n");

            Bunch pickBunch = new Bunch(firstHero.getName(),
                    secondHero.getName(),
                    thirdHero.getName(),
                    fourthHero.getName(),
                    fifthHero.getName()
            );

            pickBunch.setWinRateSum(firstHero.getWinrate()
                            + secondHero.getWinrate()
                            + thirdHero.getWinrate()
                            + fourthHero.getWinrate()
                            + fifthHero.getWinrate()
            );

            outputInfo.setPickBunch(pickBunch);

            for (Bunch finalBunch : treeMap.values()) {
                if (sevenCount < BUNCHES_COUNT) {
                    System.out.println(finalBunch + " | win rate summ: " + finalBunch.getWinRateSum());
                    outputInfo.addBunch(finalBunch);
                } else {
                    isAnalyzed = false;
                    break;
                }
                sevenCount++;
            }

            sevenCount = 0;

            for (Bunch finalBunch : rawMap.values()) {
                if (sevenCount < BUNCHES_COUNT) {
                    System.out.println(finalBunch + " | win rate summ: " + finalBunch.getWinRateSum());
                    outputInfo.addRawBunch(finalBunch);
                } else {
                    isAnalyzed = true;
                    break;
                }
                sevenCount++;
            }

            if (firstHero.getName().equals(secondHero.getName())
                    && secondHero.getName().equals(thirdHero.getName())
                    && thirdHero.getName().equals(fourthHero.getName())
                    && fourthHero.getName().equals(fifthHero.getName())) {
                for (String enemy : firstHero.getEnemies()) {
                    Bunch oneHero = new Bunch(enemy);
                    Hero hero = HeroesBuilder.getHeroByName(heroes, enemy);
                    oneHero.setWinRateSum(hero.getWinrate());
                    outputInfo.addOneHeroBunch(oneHero);
                }
            }
            System.out.println("\n");
        }

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
        if (fifthEnemy.getName() != null
                && secondEnemy.getName() != null
                && thirdEnemy.getName() != null
                && fourthEnemy.getName() != null) {
            System.out.println("First hero: " + firstEnemy.getName());
            System.out.println("Second hero: " + secondEnemy.getName());
            System.out.println("Third hero: " + thirdEnemy.getName());
            System.out.println("Fourth hero: " + fourthEnemy.getName());
            System.out.println("Fifth hero: " + fifthEnemy.getName());
        }
    }

    public int getCurrentCount() {
        return currentCount;
    }

    public void incrementCurrentCount() {
        currentCount++;
    }

    public void setCurrentCount(int currentCount) {
        this.currentCount = currentCount;
    }

    public void setHeroes(List<Hero> heroes) {
        this.heroes = heroes;
    }

    public OutputInfo getFinalOutputInfo() {
        return outputInfo;
    }

    public boolean isAnalyzed() {
        return isAnalyzed;
    }

    public void setIsAnalyzed(boolean isAnalyzed) {
        this.isAnalyzed = isAnalyzed;
    }
}