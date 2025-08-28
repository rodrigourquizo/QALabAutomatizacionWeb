#language: es
@testfeature
Característica: Login
  Yo, como usuario
  Quiero, tener una opción para iniciar sesión

  @test
  Esquema del escenario: Iniciar sesión
    Dado que me encuentro en la página de login de mystore
    Cuando inicio sesion con las credenciales usuario: "<usuario>" y contraseña: "<contraseña>"


    Ejemplos:
        | usuario        | contraseña    |
        | rodhub09@gmail.com  | nilocotedigo  |


