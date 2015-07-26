package com.vsprog.anitipick;

import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

/**
 * @author vsa
 * Date: 10.06.2015.
 */
public class GenerationTest {

    private List<String> heroes;

    private Map<String, String> heroesMap = new HashMap<String, String>();

    private String[] badInput;
    private String[] goodInput;
    private String[] friend;

    @Before
    public void initArray() {
        badInput = "AH,NiS,DR,Rik,Sni,Sil,Blo,DP,BH,Cli,NA,Rub,VS,SD".split(",");
        goodInput = "".split(",");
        friend = "SF,Tid,Lic,Ear,Tiny,SK,Mag,Mee,Kun,Jak,Lun,NS,Tim,QP".split(",");

        heroes = new ArrayList<String>();
        heroes.addAll(Arrays.asList(
                "Abaddon", "Alchemist", "Ancient Apparition", "Anti-Mage", "Axe",
                "Bane", "Batrider", "Beastmaster", "Bloodseeker", "Bounty Hunter", "Brewmaster", "Bristleback",
                "Broodmother",
                "Centaur Warrunner", "Chaos Knight", "Chen", "Clinkz", "Clockwerk", "Crystal Maiden",
                "Dark Seer", "Dazzle", "Death Prophet", "Disruptor", "Doom", "Dragon Knight", "Drow Ranger",
                "Earth Spirit", "Earthshaker", "Elder Titan", "Ember Spirit", "Enchantress", "Enigma",
                "Faceless Void",
                "Gyrocopter",
                "Huskar",
                "Invoker", "Io",
                "Jakiro", "Juggernaut",
                "Keeper of the Light", "Kunkka",
                "Legion Commander", "Leshrac", "Lich", "Lifestealer", "Lina", "Lion", "Lone Druid", "Luna", "Lycan",
                "Magnus", "Medusa", "Meepo", "Mirana", "Morphling",
                "Naga Siren", "Nature's Prophet", "Necrophos", "Night Stalker", "Nyx Assassin",
                "Ogre Magi", "Omniknight", "Oracle", "Outworld Devourer",
                "Phantom Assassin", "Phantom Lancer", "Phoenix", "Puck", "Pudge", "Pugna",
                "Queen of Pain",
                "Razor", "Riki", "Rubick",
                "Sand King", "Shadow Demon", "Shadow Fiend", "Shadow Shaman", "Silencer", "Skywrath Mage", "Slardar",
                "Slark", "Sniper", "Spectre", "Spirit Breaker", "Storm Spirit", "Sven",
                "Techies", "Templar Assassin", "Terrorblade",
                "Tidehunter", "Timbersaw", "Tinker", "Tiny", "Treant Protector", "Tusk", "Troll Warlord",
                "Undying", "Ursa",
                "Vengeful Spirit", "Venomancer", "Viper", "Visage",
                "Warlock", "Weaver", "Windranger", "Winter Wyvern", "Witch Doctor", "Wraith King",
                "Zeus"));

        heroesMap.put("Ab", "Abaddon");
        heroesMap.put("Al", "Alchemist");
        heroesMap.put("AA", "Ancient Apparition");
        heroesMap.put("AM", "Anti-Mage");
        heroesMap.put("Ax", "Axe");

        heroesMap.put("Ban", "Bane");
        heroesMap.put("Bat", "Batrider");
        heroesMap.put("Bea", "Beastmaster");
        heroesMap.put("Blo", "Bloodseeker");
        heroesMap.put("BH", "Bounty Hunter");
        heroesMap.put("Bre", "Brewmaster");
        heroesMap.put("Bri", "Bristleback");
        heroesMap.put("Bro", "Broodmother");

        heroesMap.put("CW", "Centaur Warrunner");
        heroesMap.put("CK", "Chaos Knight");
        heroesMap.put("Che", "Chen");
        heroesMap.put("Cli", "Clinkz");
        heroesMap.put("Clo", "Clockwerk");
        heroesMap.put("CM", "Crystal Maiden");

        heroesMap.put("DS", "Dark Seer");
        heroesMap.put("Daz", "Dazzle");
        heroesMap.put("DP", "Death Prophet");
        heroesMap.put("Dis", "Disruptor");
        heroesMap.put("Doo", "Doom");
        heroesMap.put("DK", "Dragon Knight");
        heroesMap.put("DR", "Drow Ranger");

        heroesMap.put("EhS", "Earth Spirit");
        heroesMap.put("Ear", "Earthshaker");
        heroesMap.put("ET", "Elder Titan");
        heroesMap.put("ErS", "Ember Spirit");
        heroesMap.put("Enc", "Enchantress");
        heroesMap.put("Eni", "Enigma");

        heroesMap.put("FV", "Faceless Void");

        heroesMap.put("Gyr", "Gyrocopter");

        heroesMap.put("H", "Huskar");

        heroesMap.put("Inv", "Invoker");
        heroesMap.put("I", "Io");

        heroesMap.put("Jak", "Jakiro");
        heroesMap.put("Jug", "Juggernaut");

        heroesMap.put("Kotl", "Keeper of the Light");
        heroesMap.put("Kun", "Kunkka");

        heroesMap.put("LC", "Legion Commander");
        heroesMap.put("Les", "Leshrac");
        heroesMap.put("Lic", "Lich");
        heroesMap.put("Lif", "Lifestealer");
        heroesMap.put("Lina", "Lina");
        heroesMap.put("Lio", "Lion");
        heroesMap.put("LD", "Lone Druid");
        heroesMap.put("Luna", "Luna");
        heroesMap.put("Lyc", "Lycan");

        heroesMap.put("Mag", "Magnus");
        heroesMap.put("Med", "Medusa");
        heroesMap.put("Mee", "Meepo");
        heroesMap.put("Mir", "Mirana");
        heroesMap.put("Mor", "Morphling");
        heroesMap.put("NaS", "Naga Siren");
        heroesMap.put("NP", "Nature's Prophet");
        heroesMap.put("Nec", "Necrophos");
        heroesMap.put("NiS", "Night Stalker");
        heroesMap.put("NA", "Nyx Assassin");

        heroesMap.put("OM", "Ogre Magi");
        heroesMap.put("Omn", "Omniknight");
        heroesMap.put("Ora", "Oracle");
        heroesMap.put("OD", "Outworld Devourer");

        heroesMap.put("PA", "Phantom Assassin");
        heroesMap.put("PL", "Phantom Lancer");
        heroesMap.put("Ph", "Phoenix");
        heroesMap.put("Puc", "Puck");
        heroesMap.put("Pud", "Pudge");
        heroesMap.put("Pug", "Pugna");

        heroesMap.put("QP", "Queen of Pain");

        heroesMap.put("Raz", "Razor");
        heroesMap.put("Rik", "Riki");
        heroesMap.put("Rub", "Rubick");

        heroesMap.put("SK", "Sand King");
        heroesMap.put("SD", "Shadow Demon");
        heroesMap.put("SF", "Shadow Fiend");
        heroesMap.put("SS", "Shadow Shaman");
        heroesMap.put("Sil", "Silencer");
        heroesMap.put("SM", "Skywrath Mage");
        heroesMap.put("Slardar", "Slardar");
        heroesMap.put("Slark", "Slark");
        heroesMap.put("Sni", "Sniper");
        heroesMap.put("Spe", "Spectre");
        heroesMap.put("SB", "Spirit Breaker");
        heroesMap.put("StS", "Storm Spirit");
        heroesMap.put("Sve", "Sven");

        heroesMap.put("Tec", "Techies");
        heroesMap.put("TA", "Templar Assassin");
        heroesMap.put("Ter", "Terrorblade");
        heroesMap.put("Tid", "Tidehunter");
        heroesMap.put("Tim", "Timbersaw");
        heroesMap.put("Tin", "Tinker");
        heroesMap.put("Tiny", "Tiny");
        heroesMap.put("TP", "Treant Protector");
        heroesMap.put("T", "Tusk");
        heroesMap.put("TW", "Troll Warlord");

        heroesMap.put("Und", "Undying");
        heroesMap.put("Urs", "Ursa");

        heroesMap.put("VS", "Vengeful Spirit");
        heroesMap.put("Ven", "Venomancer");
        heroesMap.put("Vip", "Viper");
        heroesMap.put("Vis", "Visage");

        heroesMap.put("War", "Warlock");
        heroesMap.put("Wea", "Weaver");
        heroesMap.put("Win", "Windranger");
        heroesMap.put("WW", "Winter Wyvern");
        heroesMap.put("WD", "Witch Doctor");
        heroesMap.put("WK", "Wraith King");

        heroesMap.put("Z", "Zeus");


    }

    @Test
    @Ignore
    public void badEnemyHeroes() {
        for (String s : badInput) {
            for (int i = 0; i < heroes.size(); i++) {
                if (heroes.get(i).equals(s))
                    System.out.println("<enemy id=\"" + i + "\" type=\"bad\">" + heroes.get(i) + "</enemy>");

            }
        }
        System.out.println("-------------------------------------------");
    }

    @Test
    @Ignore
    public void goodEnemyHeroes() {
        for (String s : goodInput) {
            for (int i = 0; i < heroes.size(); i++) {
                if (heroes.get(i).equals(s))
                    System.out.println("<enemy id=\"" + i + "\" type=\"good\">" + heroes.get(i) + "</enemy>");
            }
        }
        System.out.println("-------------------------------------------");
    }

    @Test
    @Ignore
    public void friendsHeroes() {
        for (String s : friend) {
            for (int i = 0; i < heroes.size(); i++) {
                if (heroes.get(i).equals(s))
                    System.out.println("<friend id=\"" + i + "\">" + heroes.get(i) + "</friend>");
            }
        }
    }

    @Test
    public void badEnemyHeroesShortNames() throws InterruptedException {
        int count = 0;
        for (String s : badInput) {
            for (String key : heroesMap.keySet()) {
                if (key.equals(s)) {
                    System.out.println("<enemy id=\"" + findHeroId(heroesMap.get(key)) + "\" type=\"bad\">" + heroesMap.get(key) + "</enemy>");
                    count++;
                }
            }
            Thread.sleep(100);
        }
        System.out.println("-------------------------------------------");
        System.out.println("Count1: " + badInput.length + "\n" + "Count2:" + count + "\n");
        System.out.println("-------------------------------------------");
    }

    @Test
    public void goodEnemyHeroesShortNames() throws InterruptedException {
        int count = 0;
        for (String s : goodInput) {
            for (String key : heroesMap.keySet()) {
                if (key.equals(s)) {
                    System.out.println("<enemy id=\"" + findHeroId(heroesMap.get(key)) + "\" type=\"good\">" + heroesMap.get(key) + "</enemy>");
                    count++;
                }
            }
            Thread.sleep(100);
        }
        System.out.println("-------------------------------------------");
        System.out.println("Count1: " + badInput.length + "\n" + "Count2:" + count + "\n");
        System.out.println("-------------------------------------------");
    }

    @Test
    public void friendsHeroesShortNames() throws InterruptedException {
        int count = 0;
        for (String s : friend) {
            for (String key : heroesMap.keySet()) {
                if (key.equals(s)) {
                    System.out.println("<friend id=\"" + findHeroId(heroesMap.get(key)) + "\">" + heroesMap.get(key) + "</friend>");
                    count++;
                }
            }
            Thread.sleep(100);
        }
        System.out.println("-------------------------------------------");
        System.out.println("Count1: " + badInput.length + "\n" + "Count2:" + count + "\n");
        System.out.println("-------------------------------------------");
    }

    private String findHeroId(String heroName) {
        for (int i = 0; i < heroes.size(); i++) {
            if (heroes.get(i).equals(heroName)) {
                return String.valueOf(i);
            }
        }
        return "NOT_FOUND: " + heroName;
    }
}
