package org.ecommerce;

import org.ecommerce.model.Product;
import org.ecommerce.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer  implements CommandLineRunner {
    private final ProductRepository productRepository;

    public DataInitializer(ProductRepository productRepository) {
        this.productRepository = productRepository;

    }

    @Override
    public void run(String... args) {
        if (productRepository.count() == 0) {
            productRepository.save(new Product(
                    "Sony WH-1000XM4",
                    "Casque Bluetooth avec réduction de bruit active,30h d'autonomie,micro intégré",
                    229.0,
                    15,
                    "https://m.media-amazon.com/images/I/71A9daPY+DL._AC_SX679_.jpg",
                    299,
                    "Le casque Sony WH-1000XM4 offre une réduction de bruit de pointe , une autonomie de 30h et  une compatibilité avec Alexa et Google Assistant.",
                    "Sony",
                    "Réduction de bruit, Bluetooth, 30h",
                    35,
                    new String[]{"Réduction de bruit", "Bluetooth 5.0", "Autonomie 30h"}
            ));
            productRepository.save(new Product(
                    "JBL Tune 510BT",
                    "Casque sans fil Bluetooth,40h d'autonomie, design pliable",
                    34.89,
                    20,
                    "https://m.media-amazon.com/images/I/51js-l-Fd4L._AC_SX679_.jpg",
                    59,
                    "Le JBL Tune 510BT est un casque léger et confortable avec 40 heures de batterie  et une charge rapide.",
                    "JBL",
                    "Casque Bluetooth léger",
                    40,
                    new String[]{"Bluetooth 5.0", "Autonomie 40h", "Charge rapide"}
            ));
            productRepository.save(new Product(
                    "Philips TAH4205BK",
                    "Casque sans fil pliable,basses puissantes,29h de batterie",
                    29.99,
                    18,
                    "https://m.media-amazon.com/images/I/61bJOFn3R4L._AC_SX679_.jpg",
                    49,
                    "Un casque Philips sans fil avec des basses puissantes, conçu pour un confort longue durée.",
                    "Philips",
                    "Confort et basses puissantes",
                    30,
                    new String[]{"Pliable", "Autonomie 29h", "Confort léger"}
            ));
            System.out.println(" Simple products inserted into the database.");
        } else {
            System.out.println("Products already exist , skipping initialization.");
        }
    }
}
