package com.gildedrose;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class GildedRoseTest {

  @Test
  @DisplayName("Test Le nom est inchangé")
  void testName() {
    Item element = new Item("foo", 0, 0);
    GildedRose gildedRose= new GildedRose(new Item[] {element});
    
    assertEquals("foo", element.name, "the name changed");
    
  }

  @Test
  @DisplayName("Test Qualité est positive")
  void testQuality() {
    Item element = new Item("foo", 0, 0);
    GildedRose gildedRose= new GildedRose(new Item[] {element});
    

    //La qualité doit etre positive ou nul
    assertTrue(element.quality >= 0, "Quality should not be negative");
  }


@Test
@DisplayName("Test La qualité se dégrade deux fois plus vite apres la date de péremption")
void testQualityDegradesTwiceAsFastAfterSellIn() {
  // Créez un produit avec une qualité initiale de 10 et une date de péremption de 0 jours
  Item item = new Item("Sample Product", 0, 10);

  // Créez une instance de GildedRose avec le produit
  GildedRose gildedRose = new GildedRose(new Item[]{item});

  // Appelez la méthode updateQuality pour effectuer la première mise à jour
  gildedRose.updateQuality();
  int qualityAfterFirstUpdate = item.quality;

  // Appelez à nouveau la méthode updateQuality pour effectuer la deuxième mise à jour
  gildedRose.updateQuality();

  // Vérifiez que la qualité a diminué de 2 unités après la date de péremption
  assertEquals(qualityAfterFirstUpdate - 2, item.quality, "Quality should degrade twice as fast after sellIn");
}


  @Test
  @DisplayName ("Test La qualité ne dépasse pas 50")
  void testQualityNeverExceeds50() {
  // Créez un produit avec une qualité initiale de 50 et une date de péremption de 5 jours
    Item item = new Item("dfhdhf", 5, 50);

    // Créez une instance de GildedRose avec le produit
    GildedRose gildedRose = new GildedRose(new Item[]{item});

    // Appelez la méthode updateQuality plusieurs fois pour vérifier que la qualité ne dépasse pas 50
    for (int i = 0; i < 10; i++) {
        
        assertTrue(item.quality <= 50, "Qualité ne dépasse pas 50");
    }
    }

  @Test
  @DisplayName ("Sulfura ne périme pas") 
  void testSulfurasNeverExpiresOrLosesQuality() {
    // Créez un produit Sulfuras avec une qualité initiale de 80 (maximum) et une date de péremption de 10 jours
    Item sulfuras = new Item("Sulfuras, Hand of Ragnaros", 10, 80);

    // Créez une instance de GildedRose avec le produit Sulfuras
    GildedRose gildedRose = new GildedRose(new Item[]{sulfuras});

    // Appelez la méthode updateQuality plusieurs fois pour vérifier que la qualité et la date de péremption ne changent pas
    for (int i = 0; i < 10; i++) {
        
        assertEquals(80, sulfuras.quality, "Qualité reste à 80");
        assertEquals(10, sulfuras.sellIn, "Date de péremption reste à 10");
    }
  }
  @Test
  @DisplayName("Test Backstage passes")
  void testBackstagePassesQuality() {
    // Créez un produit Backstage pass avec une qualité initiale de 10 et une date de péremption de 12 jours
    Item backstagePass = new Item("Backstage passes to a TAFKAL80ETC concert", 12, 10);

    // Créez une instance de GildedRose avec le produit Backstage pass
    GildedRose gildedRose = new GildedRose(new Item[]{backstagePass});

// Appelez la méthode updateQuality plusieurs fois pour vérifier le comportement
    gildedRose.updateQuality(); // Après la première mise à jour (11 jours restants)
    assertEquals(11, backstagePass.sellIn, "SellIn should decrease by 1");
    assertEquals(11, backstagePass.quality, "Quality should increase by 1");



  
}
  @Test
  @DisplayName("Test behavior of Backstage passes")
  void testBackstagePassesQualityEntre5et10() {
    // Créez un produit Backstage pass avec une qualité initiale et une date de péremption
    Item backstagePass = new Item("Backstage passes to a TAFKAL80ETC concert", 6, 20);

    // Créez une instance de GildedRose avec le produit Backstage pass
    GildedRose gildedRose = new GildedRose(new Item[]{backstagePass});

// Appelez la méthode updateQuality plusieurs fois pour vérifier le comportement
    gildedRose.updateQuality(); // Après la première mise à jour (5 jours restants)
    assertEquals(5, backstagePass.sellIn, "SellIn should decrease by 1");
    assertEquals(22, backstagePass.quality, "Quality should increase by 1");



  
}
  @Test
  @DisplayName("Test Backstage passes")
  void testBackstagePassesQualityEntre0et5() {
    // Créez un produit Backstage pass avec une qualité initiale et une date de péremption
    Item backstagePass = new Item("Backstage passes to a TAFKAL80ETC concert", 4, 20);

    // Créez une instance de GildedRose avec le produit Backstage pass
    GildedRose gildedRose = new GildedRose(new Item[]{backstagePass});

// Appelez la méthode updateQuality plusieurs fois pour vérifier le comportement
    gildedRose.updateQuality(); 
    assertEquals(3, backstagePass.sellIn, "SellIn should decrease by 1");
    assertEquals(23, backstagePass.quality, "Quality should increase by 1");



  
}
  @Test
  @DisplayName("Test Backstage passes")
  void testBackstagePassesQualityà0() {
  
    Item backstagePass = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20);

    // Créez une instance de GildedRose avec le produit Backstage pass
    GildedRose gildedRose = new GildedRose(new Item[]{backstagePass});

 gildedRose.updateQuality(); 
    assertEquals(-1, backstagePass.sellIn, "SellIn should decrease by 1");
    assertEquals(0, backstagePass.quality, "Quality should drop to 0");
} 
  @Test
  @DisplayName("Test Conjured item quality degradation")
  void testConjuredItemQualityDegradation() {
    // Créez un élément "Conjured" avec une qualité initiale de 10 et une date de péremption de 5 jours
    Item conjuredItem = new Item("Conjured", 5, 10);

    // Créez une instance de GildedRose avec l'élément "Conjured"
    GildedRose gildedRose = new GildedRose(new Item[]{conjuredItem});

    // Appelez la méthode updateQuality pour vérifier la dégradation de qualité accélérée
    gildedRose.updateQuality();

    // La qualité devrait avoir diminué de 2
    assertEquals(8, conjuredItem.quality, "Conjured item quality should degrade twice as fast");
}

}
