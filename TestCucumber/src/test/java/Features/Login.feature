Feature: Tester la fonctionnalité login
  Scenario: Tester login avec données valides
    Given Je suis sur le site e-commerce Swag Labs
    When Je saisie le username
    And Je saisie le password
    And Je clique sur le bouton login
    Then Redirection vers la page produits