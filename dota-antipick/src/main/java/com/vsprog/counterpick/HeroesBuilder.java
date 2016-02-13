package com.vsprog.counterpick;

import com.sun.org.apache.xerces.internal.dom.DeferredElementImpl;
import javafx.scene.image.Image;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author vsa
 * @date 16.05.2015.
 */
public class HeroesBuilder {

    private static final String HERO_PATH = "hero.xml";
    private static final String IMAGES_PATH = "images/";

    public List<Image> loadImageHeroes(List<String> names) {
        List<Image> images = new ArrayList<Image>();

        for (String name : names) {
            Image image = new Image(getClass().getClassLoader().getResource(IMAGES_PATH + name + ".jpg").toString());
            images.add(image);
        }
        return images;
    }

    public List<Hero> loadHeroesInfo() {
        List<Hero> heroes = new ArrayList<Hero>();
        Hero hero;

        try {
            File xmlFile = new File(getClass().getClassLoader().getResource(HERO_PATH).getFile());
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = builderFactory.newDocumentBuilder();

            Document document = dBuilder.parse(xmlFile);
            document.getDocumentElement().normalize();

            NodeList nodes = document.getElementsByTagName("hero");

            for (int i = 0; i < nodes.getLength(); i++) {
                Node node = nodes.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    hero = new Hero();
                    hero.setName(element.getElementsByTagName("name").item(0).getTextContent());
                    hero.setWinrate(Double.valueOf(element.getElementsByTagName("winrate").item(0).getTextContent()));

                    NodeList enemies = ((DeferredElementImpl) ((Element) node).getElementsByTagName("enemies").item(0)).getElementsByTagName("enemy");
                    for (int j = 0; j < enemies.getLength(); j++) {
                        hero.addEnemy(enemies.item(j).getTextContent());
                    }

                    NodeList friends = ((DeferredElementImpl) ((Element) node).getElementsByTagName("friends").item(0)).getElementsByTagName("friend");
                    for (int j = 0; j < friends.getLength(); j++) {
                        hero.addFriend(friends.item(j).getTextContent());
                    }
                    heroes.add(hero);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return heroes;
    }

    public static Hero getHeroByName(List<Hero> heroes, String heroName) {
        for (Hero hero : heroes) {
            if (hero.getName().equals(heroName)) {
                return hero;
            }
        }
        return new Hero();
    }
}
