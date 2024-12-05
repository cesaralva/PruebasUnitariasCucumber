@Test
Feature: Obtener usuarios

  Scenario: Obtener usuario sin parametro
    Given el usuario sin parametros
    When se envia solicitud de usuario
    Then debería devolver el codigo 200
    And validar el usuario de la lista de esquemas json

  Scenario Outline: Obtener usuario con parametro de genero
    Given el usuario con genero "<genero>"
    When se envia solicitud de usuario
    Then debería devolver el codigo 200
    And validar el usuario de la lista de esquemas json
    And validar el genero del usuario cual debe ser "<genero>"
    Examples:
      | genero |
      | female   |

  Scenario Outline: Obtener usuario con parametro de nombre
    Given el usuario con nombre "<nombre>"
    When se envia solicitud de usuario
    Then debería devolver el codigo 200
    And validar el usuario de la lista de esquemas json
    And validar el nombre de usuario debe contener "<nombre>"
    Examples:
      | nombre |
      | Tarun Gill |
      | Bhasvan Asan  |

  Scenario Outline: Obtener usuario con parametro de estado
    Given el usuario con estado "<estatus>"
    When se envia solicitud de usuario
    Then debería devolver el codigo 200
    And validar el usuario de la lista de esquemas json
    And validar el estado del usuario debe ser "<estatus>"
    Examples:
      | estatus  |
      | active   |
      | inactive |

  Scenario Outline: Obtener usuario con parametro de email
    Given el usuario con email "<email>"
    When se envia solicitud de usuario
    Then debería devolver el codigo 200
    And validar el usuario de la lista de esquemas json
    And validar el email del usuario debe contener "<email>"
    Examples:
      | email     |
      | tarun_gill@rowe-tillman.test |
      | bhasvan_asan@price-rolfson.test |