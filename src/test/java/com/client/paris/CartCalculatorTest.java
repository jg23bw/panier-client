package com.client.paris;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Stream;

public class CartCalculatorTest {

    record TestCase(String description, Client client, double expectedTotal) {}

    static final List<Product> PANIER_COMMUN = List.of(
            new Product(ProductType.TEL_HAUT_DE_GAMME, 1),
            new Product(ProductType.TEL_MOYENNE_GAMME, 2),
            new Product(ProductType.LAPTOP, 1)
    );

    static Stream<TestCase> panierClientProvider() {
        return Stream.of(
                new TestCase(
                        "Client particulier",
                        new ClientParticulier("1", "Alice", "Dupont"),
                        1500 + 2 * 800 + 1200  // = 4300
                ),
                new TestCase(
                        "Client pro CA < 10M",
                        new ClientProfessionnel("2", "MaBoite", "FR123", "123456789", 9_000_000),
                        1150 + 2 * 600 + 1000  // = 3350
                ),
                new TestCase(
                        "Client pro CA > 10M",
                        new ClientProfessionnel("3", "BigCorp", null, "987654321", 15_000_000),
                        1000 + 2 * 550 + 900  // = 3000
                ),
                new TestCase(
                        "Client pro CA = 10M",
                        new ClientProfessionnel("4", "Moyenne", "FR987", "456789123", 10_000_000),
                        1000 + 2 * 550 + 900  // = 3000
                )
        );
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("panierClientProvider")
    void testPanierAvecClient(TestCase testCase) {
        double total = CartCalculator.calculateTotal(testCase.client(), PANIER_COMMUN);
        assertEquals(testCase.expectedTotal(), total);
    }
}

