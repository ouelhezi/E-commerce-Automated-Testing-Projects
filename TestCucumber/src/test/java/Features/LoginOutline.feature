Feature: Tester la fonctionnalité login invalide
  Scenario Outline: Tester login avec données invalides
    Given Je suis sur le site SwagLabs
    When Je saisie le username "<username>"
    And Je saisie le password "<password>"
    And Je clique sur le bouton log in
    Then Echec de redirection vers la page Produits
    And Le message d erreur "<message>" s affiche
    Examples:
      | username      | password     | message                                                                   |
      | standard_user | pass         | Epic sadface: Username and password do not match any user in this service |
      | ouma          | secret_sauce | Epic sadface: Username and password do not match any user in this service |
      | ouma          | pass         | Epic sadface: Username and password do not match any user in this service |

