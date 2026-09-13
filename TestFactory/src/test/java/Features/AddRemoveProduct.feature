Feature: Tester la fonctionnalité d'ajout et suppression des produits
  Scenario: Tester l'ajout et la suppression des produits du panier
    Given Je suis sur le site ecommerce Swag Labs
    When Je tape le username
    And Je tape le mot de passe
    And Je tape sur le bouton login
    Then redirection vers la page des produits
    When Je clique sur le bouton Add To Cart de Sauce Labs Backpack
    And Je clique sur le bouton Add To Cart de Sauce Labs Bike Light
    And Je clique sur l icone du panier
    Then les produits s ajoutent au panier
    When Je clique sur le bouton Remove de Sauce Labs Backpack
    Then Le produit est retiré du panier
