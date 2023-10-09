package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            updateItemQuality(item);
        }
    }

    private void updateItemQuality(Item item) {
        switch (item.name) {
            case "Aged Brie":
                updateAgedBrie(item);
                break;
            case "Sulfuras, Hand of Ragnaros":
                // "Sulfuras" n'a pas besoin de mise à jour
                break;
            case "Backstage passes to a TAFKAL80ETC concert":
                updateBackstagePasses(item);
                break;
            case "Conjured":
                updateConjuredItem(item);
                break;
            default:
                updateNormalItem(item);
                break;
        }
    }

    // Méthodes privées pour la logique spécifique à chaque type d'article
    private boolean isNormalItem(Item item) {
        return !isAgedBrie(item) && !isSulfuras(item) && !isBackstagePasses(item) && !isConjured(item);
    }

    private boolean isAgedBrie(Item item) {
        return item.name.equals("Aged Brie");
    }

    private boolean isSulfuras(Item item) {
        return item.name.equals("Sulfuras, Hand of Ragnaros");
    }

    private boolean isBackstagePasses(Item item) {
        return item.name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    private boolean isConjured(Item item) {
        return item.name.equals("Conjured");
    }

    private void updateNormalItem(Item item) {
        // Logique pour les éléments normaux
        decreaseQuality(item);
        decreaseSellIn(item);
        if (item.sellIn < 0) {
            // Si la date de péremption est passée, la qualité diminue deux fois plus vite
            decreaseQuality(item);
        }
    }

    private void updateAgedBrie(Item item) {
        // Logique pour "Aged Brie"
        increaseQuality(item);
        decreaseSellIn(item);
        if (item.sellIn < 0) {
            // Si la date de péremption est passée, la qualité augmente deux fois plus vite
            increaseQuality(item);
        }
    }

    private void updateBackstagePasses(Item item) {
        // Logique pour "Backstage Passes"
        increaseQuality(item);
        if (item.sellIn < 11) {
            increaseQuality(item);
        }
        if (item.sellIn < 6) {
            increaseQuality(item);
        }
        decreaseSellIn(item);
        if (item.sellIn < 0) {
            // Après la date de péremption, la qualité tombe à zéro
            item.quality = 0;
        }
    }

    private void updateConjuredItem(Item item) {
        // Logique pour "Conjured"
        decreaseQuality(item);
        decreaseQuality(item);
        decreaseSellIn(item);
        if (item.sellIn < 0) {
            decreaseQuality(item);
            decreaseQuality(item);
        }
    }

    private void increaseQuality(Item item) {
        // Incrémente la qualité de l'élément si elle est inférieure à 50
        if (item.quality < 50) {
            item.quality++;
        }
    }

    private void decreaseQuality(Item item) {
        // Décrémente la qualité de l'élément si elle est supérieure à zéro
        if (item.quality > 0) {
            item.quality--;
        }
    }

    private void decreaseSellIn(Item item) {
        // Décrémente la date de péremption de l'élément (sauf pour "Sulfuras")
        if (!isSulfuras(item)) {
            item.sellIn--;
        }
    }
}
