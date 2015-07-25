package com.vsprog.anitipick;

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

    public List<Image> getHeroesPictures(String resource) {
        List<String> names = loadHeroesNames();
        List<Image> images = loadImageHeroes(names);

        return images;
    }

    public List<Image> loadImageHeroes(List<String> names) {
        List<Image> images = new ArrayList<Image>();

        for (String name : names) {
            Image image = new Image(getClass().getClassLoader().getResource(IMAGES_PATH + name + ".jpg").toString());
            images.add(image);
        }
        return images;
    }

    public List<String> loadHeroesNames() {
        List<String> names = new ArrayList<String>();

        try {
            File fXmlFile = new File(getClass().getClassLoader().getResource(HERO_PATH).getFile());
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();

            NodeList nodes = doc.getElementsByTagName("hero");

            for (int i = 0; i < nodes.getLength(); i++) {
                Node nNode = nodes.item(i);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    names.add(eElement.getElementsByTagName("name").item(0).getTextContent());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return names;
    }

}
