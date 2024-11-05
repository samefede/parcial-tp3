¿Qué tipo de arquitectura usaron y por qué? ¿Podría mejorarla?

Para el proyecto usamos la arquitectura MVVM, Model View ViewModel.
Era la arquitectura que más conocíamos por lo visto en clase y que más se adecuaba a las necesidades del proyecto, por lo que terminamos optando por ella.
Nos permitio separar la lógica de la interfaz de usuario y tener un código más limpio y ordenado.

Hasta el momento no consideramos alguna mejora en la arquitectura, pero si en el código en general, como por ejemplo la creación de un archivo de constantes para los strings que se repiten en la aplicación.


¿Tuvieron objetos stateful y stateless? ¿Cómo definen la elección de los mismos?
Si tuvimos objetos stateful como por ejemplo:
- El remember que lo aplicamos en el momento en el que necesitabamos mostrar los numeros de la tarjeta y ocultarlos, este estado cambiaba al darle al boton del ojo.
- El ViewModel que nos permite almacenar datos y persistirlos a traves del ciclo de vida de la aplicacion.

Al ser una informacion que cambia dependiendo de la interaccion del usuario, decidimos que estos objetos sean stateful porque necesitamos que se actualicen en tiempo real.

Ademas, tambien tuvimos objetos stateless como por ejemplo:
- El componente CardInfo, que recibe un numero de tarjeta y el saldo a cargar.
- El componente ServiceCard, que recibe un icono, un texto y una accion a realizar.
- El componente TopBar que en base a los parametros y pantalla en la que este situado cambia el contenido de la misma.

Al ser informacion que no cambiaba, decidimos que estos objetos sean stateless porque no necesitamos que se actualicen en tiempo real y solo se rendericen una vez.


¿Qué mejoras detectan que podrían realizarle a la app? ¿Tendrían side effect si escala el volumen de datos? Comenten al menos 2 cuestiones a refactorizar y tener en cuenta.
Mejoras que podrian realizarse:
 - Agregar un archivo de constantes para los strings que se repiten en la aplicacion.
 - Agregar el estilo de las cards en un archivo de estilos, para no tener que repetirlo en cada componente. 
   A esto nos referimos por ejemplo CardInfo y ServiceCard su contenido interno no es el mismo pero el estilo de su contenedor si.

Sobre si tendriamos side effect si escala el volumen de datos, creemos que si, ya que si el dia de manana quisieramos agregar idiomas a la aplicacion, tendriamos que modificar todos los componentes que contienen texto y no solo un archivo de constantes.

¿Qué manejo de errores harían? ¿dónde los contemplan a nivel código? Mencionen la estrategia de mapeo que más se adecúe.


En el caso de uso de persistencia para Favoritos, ¿que estrategia sugieren?.


Si la tendríamos que convertir a Español y conservar el Inglés, qué estrategia utilizaría para extenderla. Y si necesitamos agregar otros idiomas?
