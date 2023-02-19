package com.a.introduction.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GildedRoseADefaultItemTest {

    public static final String DEFAULT_ITEM = "DEFAULT_ITEM";

    @Test
    public void shouldDecreaseTheQualityAndSellByOne_whenItemIsNonExpired() {
        int nonExpiredSellIn = 15;
        int nonExpiredQuality = 3;
        Item[] items = createGildedRoseWithSingleItem(DEFAULT_ITEM, nonExpiredSellIn, nonExpiredQuality);
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        int expectedSellIn = 14;
        int expectedQuality = 2;
        Item expected = new Item(DEFAULT_ITEM, expectedSellIn, expectedQuality);
        Item actual = app.items[0];
        validateGildedRoseItem(expected, actual);
    }

    @Test
    public void shouldDecreaseTheQualityByTwoAndSellByOne_whenItemIsExpired() {
        int expiredSellIn = -1;
        int expiredQuality = 3;
        Item[] items = createGildedRoseWithSingleItem(DEFAULT_ITEM, expiredSellIn, expiredQuality);
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        int expectedSellIn = -2;
        int expectedQuality = 1;
        Item expected = new Item(DEFAULT_ITEM, expectedSellIn, expectedQuality);
        Item actual = app.items[0];
        validateGildedRoseItem(expected, actual);
    }

    private Item[] createGildedRoseWithSingleItem(String itemName, int sellIn, int quality) {
        Item item = new Item(itemName, sellIn, quality);
        Item[] items = new Item[]{item};
        return items;
    }

    private void validateGildedRoseItem(Item expected, Item actual) {
        assertEquals(expected.name, actual.name);
        assertEquals(expected.sellIn, actual.sellIn);
        assertEquals(expected.quality, actual.quality);
    }
}