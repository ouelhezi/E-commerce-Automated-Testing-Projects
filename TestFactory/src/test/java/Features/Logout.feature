Feature: Tester la fonctionnalité logout
  Scenario: Tester la déconnexion du site
    Given Je suis sur le site Swag_Labs
    When Je saisie username
    And Je saisie password
    And Je clique sur login
    Then Redirection vers la page listProduits
    When Je clique sur le bouton open menu
    And Je clique sur le bouton logout
    Then Redirection vers la page login