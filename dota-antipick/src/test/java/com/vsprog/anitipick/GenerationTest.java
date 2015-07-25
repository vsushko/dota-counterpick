package com.vsprog.anitipick;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author vsa
 * Date: 10.06.2015.
 */
public class GenerationTest {

    private List<String> heroes;
    private String[] badInput;
    private String[] goodInput;
    private String[] friend;

    @Before
    public void initArray() {
        badInput = "Slardar,Bounty Hunter,Earthshaker,Sand King,Bane,Chaos Knight,Beastmaster,Doom,Lion,Shadow Shaman,Pugna,Death Prophet,Lina,Keeper of the Light,Kunkka,Undying,Tidehunter,Spectre,Clinkz,Faceless Void,Weaver,Naga Siren,Mirana,Morphling".split(",");
        goodInput = "".split(",");
        friend = "Lycan,Lone Druid,Nature's Prophet,Enigma,Keeper of the Light,Jakiro,Vengeful Spirit,Crystal Maiden,Bane,Shadow Demon,Leshrac,Visage,Ursa,Phantom Assassin,Anti-Mage,Naga Siren,Morphling,Dazzle,Omniknight,Io,Lina,Witch Doctor,Warlock,Treant Protector".split(",");

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
    }

    @Test
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
    public void friendsHeroes() {
        for (String s : friend) {
            for (int i = 0; i < heroes.size(); i++) {
                if (heroes.get(i).equals(s))
                    System.out.println("<friend id=\"" + i + "\">" + heroes.get(i) + "</friend>");
            }
        }
    }

}
