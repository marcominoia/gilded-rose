package com.gildedrose;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TexttestFixture {

    private static int DEFAULT_NUMBER_OF_DAYS = 21;
    private static String LINE_SEPARATOR_PROPERTY = "line.separator";

    @Test
    public void testAgainstOriginalOutput() throws URISyntaxException, IOException {
        String expected = loadExpectedOutput();

        String actual = buildTextOutput(DEFAULT_NUMBER_OF_DAYS);

        Assert.assertEquals(expected, actual);
    }

    private static String buildTextOutput(int days){

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("Starting Gilded Rose");
        stringBuilder.append(System.getProperty(LINE_SEPARATOR_PROPERTY));

        Item[] items = new Item[] {
                new Item("+5 Dexterity Vest", 10, 20), //
                new Item("Aged Brie", 2, 0), //
                new Item("Elixir of the Mongoose", 5, 7), //
                new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                new Item("Conjured Mana Cake", 3, 6) };

        GildedRose app = new GildedRose(items);


        for (int i = 0; i < days; i++) {
            stringBuilder.append("-------- day ");
            stringBuilder.append(i);
            stringBuilder.append(" --------");
            stringBuilder.append(System.getProperty(LINE_SEPARATOR_PROPERTY));
            stringBuilder.append("name, sellIn, quality");
            stringBuilder.append(System.getProperty(LINE_SEPARATOR_PROPERTY));
            for (Item item : items) {
                stringBuilder.append(item);
                stringBuilder.append(System.getProperty(LINE_SEPARATOR_PROPERTY));
            }
            stringBuilder.append(System.getProperty(LINE_SEPARATOR_PROPERTY));
            app.updateQuality();
        }

        return stringBuilder.toString();
    }

    private String loadExpectedOutput() throws URISyntaxException, IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        URL resourceURL = classLoader.getResource("expected_text_output.txt");
        assert(resourceURL != null);
        return new String(Files.readAllBytes(Paths.get(resourceURL.toURI())));
    }

    public static void main(String[] args) {
        int days = 21;
        if (args.length > 0) {
            days = Integer.parseInt(args[0]) + 1;
        }
        System.out.println(buildTextOutput(days));
    }

}
