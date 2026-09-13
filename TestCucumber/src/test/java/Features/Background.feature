@SenarioComplet
Feature: tester le site SwagLabs
  En tant qu'utilisateur je veux tester le site SwagLabs

  Background: je souhaite tester la connexion et l ajout de produit au panier
    Given je suis redirige vers le site swaglabs
    When je saisis my username
    And je saisis my password
    And je clique sur login button
    Then la page de produits s affiche
    When je clique sur le btn addtocard du pdt backpack
    And  je clique sur le btn addtocard du pdt tshirt
    Then les pdts sont ajoutes au panier
@SenarionSuppression
  Scenario: je souhaite tester la suppression d un produit
    When je presse sur le bouton panier
    And je clique sur le bouton remove tshirt
    Then le produit tshirt est retire du panier
@SenarioCheckout
  Scenario: je souhaite tester les donnees de checkout des donnees perso
    When je clique sur le bouton panier
    And je clique sur le Checkout button
    Then la page your information s affiche
    When je saisis firstname
    And je saisis lastname
    And je tape le code postal
    And je clique sur le Continue button
    Then une page Overview s affiche
    When je clique sur le Finish button
    Then la page Checkout complete s affichera
    When je clique sur le Back home button
    Then Redirection vers home