#language: es
@Feature
Característica: Product - Store
  Yo, como usuario
  Quiero, validar el precio de una compra

  @test
  Esquema del escenario: Validación del precio de un producto
    Dado estoy en la página de la tienda
    Cuando me logueo con mi usuario: "<usuario>" y clave: "<contraseña>"
    Cuando navego a la categoria "<categoria>" y subcategoria "<subcategoria>"
    Y agrego 2 unidades del primer producto al carrito
    Entonces valido en el popup la confirmacion del producto agregado
    Y valido en el popup que el monto sea calculado correctamente
    Cuando finalizo la compra
    Entonces valido el titulo de la pagina del carrito
    Y vuelvo a validar el calculo de precios del carrito

    Ejemplos:
        | usuario        | contraseña    | categoria | subcategoria |
        | rodhub09@gmail.com  | nilocotedigo   | Clothes | Men      |
        | hola      | 123456         | Clothes | Men      |
        | rodhub09@gmail.com  | nilocotedigo   | Autos | Men        |



