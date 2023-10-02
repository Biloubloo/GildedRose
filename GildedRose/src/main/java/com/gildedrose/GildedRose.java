package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        // Parcourt tous les éléments dans le tableau
        for (Item item : items) {
            // Vérifie le type de l'élément et effectue la mise à jour appropriée
            if (isNormalItem(item)) {
                // Pour les éléments normaux
                updateNormalItem(item);
            } else if (isAgedBrie(item)) {
                // Pour "Aged Brie"
                updateAgedBrie(item);
            } else if (isSulfuras(item)) {
                // Pour "Sulfuras", pas de mise à jour nécessaire
            } else if (isBackstagePasses(item)) {
                // Pour "Backstage Passes"
                updateBackstagePasses(item);
            } else if (isConjured(item)) {
                // Pour "Conjured"
                updateConjuredItem(item);
            }
        }
    }

    private boolean isNormalItem(Item item) {
        // Vérifie si l'élément est de type normal
        return !isAgedBrie(item) && !isSulfuras(item) && !isBackstagePasses(item) && !isConjured(item);
    }

    private boolean isAgedBrie(Item item) {
        // Vérifie si l'élément est "Aged Brie"
        return item.name.equals("Aged Brie");
    }

    private boolean isSulfuras(Item item) {
        // Vérifie si l'élément est "Sulfuras"
        return item.name.equals("Sulfuras, Hand of Ragnaros");
    }

    private boolean isBackstagePasses(Item item) {
        // Vérifie si l'élément est "Backstage Passes"
        return item.name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    private boolean isConjured(Item item) {
        // Vérifie si l'élément est "Conjured"
        return item.name.equals("Conjured");
    }

    private void updateNormalItem(Item item) {
        // Mise à jour pour les éléments normaux
        decreaseQuality(item);
        decreaseSellIn(item);
        if (item.sellIn < 0) {
            // Si la date de péremption est passée, la qualité diminue deux fois plus vite
            decreaseQuality(item);
        }
    }

    private void updateAgedBrie(Item item) {
        // Mise à jour pour "Aged Brie"
        increaseQuality(item);
        decreaseSellIn(item);
        if (item.sellIn < 0) {
            // Si la date de péremption est passée, la qualité augmente deux fois plus vite
            increaseQuality(item);
        }
    }

    private void updateBackstagePasses(Item item) {
        // Mise à jour pour "Backstage Passes"
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
        // La qualité des éléments "Conjured" diminue deux fois plus vite que les objets normaux
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

