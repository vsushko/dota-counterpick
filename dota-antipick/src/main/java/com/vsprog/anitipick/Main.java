package com.vsprog.anitipick;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * DOTA ANTI PICK Application
 */
public class Main extends Application {
    public static void main(String[] args) throws IOException {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        HeroesBuilder heroesBuilder = new HeroesBuilder();
        List<Hero> heroes = heroesBuilder.loadHeroesInfo();

        // пик противника
        Pick pick = new Pick();
        pick.setFirstHero(heroesBuilder.getHeroByName(heroes, "Enigma"));
        pick.setSecondHero(heroesBuilder.getHeroByName(heroes, "Phantom Lancer"));
        pick.setThirdHero(heroesBuilder.getHeroByName(heroes, "Medusa"));
        pick.setFourthHero(heroesBuilder.getHeroByName(heroes, "Axe"));
        pick.setFifthHero(heroesBuilder.getHeroByName(heroes, "Silencer"));


        // герои антипики
        List<String> firstHeroEnemies = new ArrayList<String>();
        firstHeroEnemies.addAll(pick.getFirstHero().getEnemies());

        List<String> secondHeroEnemies = new ArrayList<String>();
        secondHeroEnemies.addAll(pick.getSecondHero().getEnemies());

        List<String> thirdHeroEnemies = new ArrayList<String>();
        thirdHeroEnemies.addAll(pick.getThirdHero().getEnemies());

        List<String> fourthHeroEnemies = new ArrayList<String>();
        fourthHeroEnemies.addAll(pick.getFourthHero().getEnemies());

        List<String> fifthHeroEnemies = new ArrayList<String>();
        fifthHeroEnemies.addAll(pick.getFifthHero().getEnemies());

        System.out.println(firstHeroEnemies.size() + secondHeroEnemies.size() + thirdHeroEnemies.size() + fourthHeroEnemies.size() + fifthHeroEnemies.size());

        List<String> enemies = new ArrayList<String>();
        enemies.addAll(firstHeroEnemies);
        enemies.addAll(secondHeroEnemies);
        enemies.addAll(thirdHeroEnemies);
        enemies.addAll(fourthHeroEnemies);
        enemies.addAll(fifthHeroEnemies);

        List<HeroWeight> weights = new ArrayList<HeroWeight>();

        // посчитаем веса для каждого героя из первого списка антипика в остальных
        // рассчитываем вероятность некоторых героев
        for (String heroName : firstHeroEnemies) {
            int w = 0;

            w += findHeroCountInAntipickList(heroName, secondHeroEnemies);
            w += findHeroCountInAntipickList(heroName, thirdHeroEnemies);
            w += findHeroCountInAntipickList(heroName, fourthHeroEnemies);
            w += findHeroCountInAntipickList(heroName, fifthHeroEnemies);
            System.out.println("Герой: " + heroName + " имеет следующий вес " + w + "  в первом списке антипика");
            weights.add(new HeroWeight(heroName, w));
        }

        for (String heroName : secondHeroEnemies) {
            int w = 0;

            w += findHeroCountInAntipickList(heroName, firstHeroEnemies);
            w += findHeroCountInAntipickList(heroName, thirdHeroEnemies);
            w += findHeroCountInAntipickList(heroName, fourthHeroEnemies);
            w += findHeroCountInAntipickList(heroName, fifthHeroEnemies);
            System.out.println("Герой: " + heroName + " имеет следующий вес " + w + "  во втором списке антипика");
            addHeroWeights(new HeroWeight(heroName, w), weights);
        }

        for (String heroName : thirdHeroEnemies) {
            int w = 0;

            w += findHeroCountInAntipickList(heroName, firstHeroEnemies);
            w += findHeroCountInAntipickList(heroName, secondHeroEnemies);
            w += findHeroCountInAntipickList(heroName, fourthHeroEnemies);
            w += findHeroCountInAntipickList(heroName, fifthHeroEnemies);
            System.out.println("Герой: " + heroName + " имеет следующий вес " + w + "  в третьем списке антипика");
            addHeroWeights(new HeroWeight(heroName, w), weights);
        }

        for (String heroName : fourthHeroEnemies) {
            int w = 0;

            w += findHeroCountInAntipickList(heroName, firstHeroEnemies);
            w += findHeroCountInAntipickList(heroName, secondHeroEnemies);
            w += findHeroCountInAntipickList(heroName, thirdHeroEnemies);
            w += findHeroCountInAntipickList(heroName, fifthHeroEnemies);
            System.out.println("Герой: " + heroName + " имеет следующий вес " + w + "  в четвертом списке антипика");
            addHeroWeights(new HeroWeight(heroName, w), weights);
        }

        for (String heroName : fifthHeroEnemies) {
            int w = 0;

            w += findHeroCountInAntipickList(heroName, firstHeroEnemies);
            w += findHeroCountInAntipickList(heroName, secondHeroEnemies);
            w += findHeroCountInAntipickList(heroName, thirdHeroEnemies);
            w += findHeroCountInAntipickList(heroName, fourthHeroEnemies);
            System.out.println("Герой: " + heroName + " имеет следующий вес " + w + "  в пятом списке антипика");
            addHeroWeights(new HeroWeight(heroName, w), weights);
        }

        System.out.println(firstHeroEnemies.size() + secondHeroEnemies.size() + thirdHeroEnemies.size() + fourthHeroEnemies.size() + fifthHeroEnemies.size());

    }

    private void addHeroWeights(HeroWeight heroWeight, List<HeroWeight> weights) {
        for (HeroWeight weight : weights) {
            if (weight.getHeroName().equals(heroWeight.getHeroName())) {
                weight.setHeroWeight(weight.getHeroWeight() + heroWeight.getHeroWeight());
            }
        }
    }

    private int findHeroCountInAntipickList(String heroName, List<String> heroEnemies) {
        int w = 0;
        for (String enemyName : heroEnemies) {
            if (enemyName.equals(heroName)) {
                w++;
            }
        }
        return w;
    }
}