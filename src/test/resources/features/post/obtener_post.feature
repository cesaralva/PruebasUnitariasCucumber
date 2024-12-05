@Test
Feature: Obtener posts

  Scenario: Obtener post sin parametro
    Given el post sin parametros
    When se envia solicitud de post
    Then debería devolver el codigo 200
    And validar el post de la lista de esquemas json

  Scenario Outline: Obtener post con parametro de id de usuario
    Given el post con Usuario Id <idUsuario>
    When se envia solicitud de post
    Then debería devolver el codigo 200
    And validar el post de la lista de esquemas json
    And validar el Usuario Id del post cual debe ser <idUsuario>
    Examples:
      | idUsuario |
      | 7566336 |

  Scenario Outline: Obtener usuario con parametro de titulo
    Given el post con Titulo "<titulo>"
    When se envia solicitud de post
    Then debería devolver el codigo 200
    And validar el post de la lista de esquemas json
    And validar el Titulo del post debe contener "<titulo>"
    Examples:
      | titulo |
      | Caveo vulgus audacia rerum adfectus creator desolo sed. |

  Scenario Outline: Obtener usuario con parametro de cuerpo
    Given el post con Cuerpo "<cuerpo>"
    When se envia solicitud de post
    Then debería devolver el codigo 200
    And validar el post de la lista de esquemas json
    And validar el Cuerpo del post debe ser "<cuerpo>"
    Examples:
      | cuerpo |
      | Quos cursus coma. Bardus sed ullam. Supplanto enim asperiores. Curo tantum cavus. Volubilis trado thymum. Cibus vigor terminatio. Ultio decretum cohibeo. Decet audio socius. Vicissitudo statim tutamen. Barba synagoga peccatus. Aer pectus spero. Tribuo non aedificium. Minima convoco speciosus. Audentia ulciscor commodi. Defluo vitiosus adulatio. Consequuntur cito vitiosus. Curvus verto stultus. Calcar crastinus baiulus. Libero despirmatio sublime. |
