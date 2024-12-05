Feature: Obtener posts desde la API

  Scenario: Validar un post sin parámetros
    Given el post sin parametros
    When se envia solicitud de post
    Then validar el post de la lista de esquemas json

  Scenario: Validar un post con un Usuario Id específico
    Given el post con Usuario Id 1
    When se envia solicitud de post
    Then validar el Usuario Id del post cual debe ser 1

  Scenario: Validar un post con un Titulo específico
    Given el post con Titulo "Mi Primer Post"
    When se envia solicitud de post
    Then validar el Titulo del post debe contener "Mi Primer Post"
