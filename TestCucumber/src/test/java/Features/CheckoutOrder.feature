Feature: Tester la validation de la commande avec des données valides
  Scenario: Tester la validation de la commande avec des données valides
    Given Je suis sur le site Swag Labs
    When Je tape le user_name
    And Je tape le mot_de_passe
    And Je tape sur le bouton log_in
    Then redirection vers la page produits
    When Je clique sur le bouton Add_To_Cart de Sauce Labs Backpack
    And Je clique sur le bouton Add_To_Cart de Sauce Labs Bike Light
    And Je clique sur l icone Panier
    Then les produits s ajoutent au Panier
    When Je clique sur le bouton Remove de Sauce_Labs_Backpack
    Then Le produit est retiré du Panier
    When Je clique sur le bouton checkout
    And Je tape le firstName
    And Je tape le LastName
    And Je tape le postalCode
    And Je clique sur le bouton continue
    Then redirection vers la page checkout step two
    When Je clique sur le bouton finish
    Then redirection vers la page checkout complete
    When Je clique sur le bouton back home
    Then redirection vers la page liste des produits
