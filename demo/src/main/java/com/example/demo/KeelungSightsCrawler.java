package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class KeelungSightsCrawler {

    public org.example.Sight[] getItems(String inputZone) {

        final String url = "https://www.travelking.com.tw";
        ArrayList<org.example.Sight> sights = new ArrayList<org.example.Sight>();

        {
            try {
                Document doc = Jsoup.connect(url + "/tourguide/taiwan/keelungcity/").get();
                Element guidePoint = doc.getElementById("guide-point");
                Elements zones = guidePoint.select("div.box>h4");

                for (Element zone : zones) {
                    if (zone.text().substring(0, 2).equals((inputZone))) {

                        Elements List = zone.nextElementSibling().select("ul>li");
                        for (Element li : List) {
                            String href = li.select("a").attr("href");
                            Document docli = Jsoup.connect(url + href).get();
                            Element pointArea = docli.getElementById("point_area");

                            org.example.Sight s = new org.example.Sight();
                            s.setSightName(pointArea.select("meta[itemprop=name]").attr("content"));
                            s.setZone(zone.text().substring(0, 2));
                            s.setCategory(pointArea.select("cite>span>span>strong").text());
                            s.setPhotoURL(pointArea.select("meta[itemprop=image]").attr("content"));
                            s.setAddress(pointArea.select("meta[itemprop=address]").attr("content"));
                            s.setDescription(pointArea.select("meta[itemprop=description]").attr("content"));

                            sights.add(s);
                        }
                    }
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return sights.toArray(new org.example.Sight[0]);
    }
}
