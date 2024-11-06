¿Qué tipo de arquitectura usaron y por qué? ¿Podría mejorarla?
Para el proyecto usamos la arquitectura MVVM, Model-View-ViewModel.
Era la arquitectura que más conocíamos por lo visto en clase y que más se adecuaba a las necesidades del proyecto, por lo que terminamos optando por ella.
Nos permitió separar la lógica de la interfaz de usuario y tener un código más limpio y ordenado.

Hasta el momento no consideramos alguna mejora en la arquitectura, pero sí en el código en general, como por ejemplo, la creación de un archivo de constantes para los strings que se repiten en la aplicación.
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

¿Tuvieron objetos stateful y stateless? ¿Cómo definen la elección de los mismos?
Si tuvimos objetos stateful como por ejemplo:
- El remember que lo aplicamos en el momento en el que necesitábamos mostrar los números de la tarjeta y ocultarlos, este estado cambiaba al darle al botón del ojo.
- El ViewModel que nos permite almacenar datos y persistirlos a través del ciclo de vida de la aplicación.

Al ser una información que cambia dependiendo de la interacción del usuario, decidimos que estos objetos sean stateful porque necesitamos que se actualicen en tiempo real.

Además, también tuvimos objetos stateless como por ejemplo:
- El componente CardInfo, que recibe un número de tarjeta y el saldo a cargar.
- El componente ServiceCard, que recibe un icono, un texto y una acción a realizar.
- El componente TopBar que en base a los parámetros y pantalla en la que esté situado cambia el contenido de la misma.

Al ser información que no cambiaba, decidimos que estos objetos sean stateless porque no necesitamos que se actualicen en tiempo real y solo se rendericen una vez.
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

¿Qué mejoras detectan que podrían realizarle a la app? ¿Tendrían side effect si escala el volumen de datos? Comenten al menos 2 cuestiones a refactorizar y tener en cuenta.
Mejoras que podrían realizarse:
 - Agregar un archivo de constantes para los strings que se repiten en la aplicación.
 - Agregar el estilo de las cards en un archivo de estilos, para no tener que repetirlo en cada componente. 
   A esto nos referimos por ejemplo CardInfo y ServiceCard su contenido interno no es el mismo pero el estilo de su contenedor si.

Sobre si tendríamos side effect si escala el volumen de datos, creemos que sí, ya que si el día de mañana quisiéramos agregar idiomas a la aplicación, tendremos que modificar todos los componentes que contienen texto y no solo un archivo de constantes.
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

¿Qué manejo de errores harían? ¿dónde los contemplan a nivel código? Mencionen la estrategia de mapeo que más se adecúe.
En el caso de manejo de errores lo haríamos con un manejo por niveles,es decir una capa que maneje los errores de los datos de la base de datos, y una capa que maneje los errores de la parte de presentación para el usuario.

Capa de Datos: Aquí es donde podriamos manejar los errores que provienen de servicios remotos. Utilizando try-catch para capturar excepciones y devuelve un Result que distinga entre éxito y error.

Capa de Presentación: Usando ViewModels, podemos mapear los resultados de la capa de datos y manejar el estado de la UI para mostrar mensajes de error o estados de carga.

Una estrategia recomendada es utilizar un sealed class de tipo UiState. De este modo, puedes representar estados como Success, Error, y Loading. Esto para poder manejar el mapeo y representación de los errores en la capa de presentación

En el caso de uso de persistencia para Favoritos, ¿que estrategia sugieren?.
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

Si la tendríamos que convertir a Español y conservar el Inglés, qué estrategia utilizaría para extenderla. Y si necesitamos agregar otros idiomas?

Para extender la aplicación a varios idiomas, incluyendo Español e Inglés, podríamos implementar una estrategia utilizando string resources.

Definiriamos archivos de recursos de texto (strings.xml) específicos para cada idioma en la carpeta res/values. Por ejemplo, crea un archivo strings.xml para el inglés en res/values/strings.xml y otro para el español en res/values-es/strings.xml.

Accederiamos a las string resources usando stringResource(id = R.string.resource_name) desde nuestros componentes. 
