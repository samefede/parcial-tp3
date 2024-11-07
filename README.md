## ¿Qué tipo de arquitectura usaron y por qué? ¿Podría mejorarla?

En el proyecto, decidimos emplear la arquitectura MVVM (Model-View-ViewModel), ya que es la que mejor conocíamos y la que se ajustaba a las necesidades del proyecto. Esta arquitectura nos permitió separar de manera efectiva la lógica de negocio de la interfaz de usuario, lo que resultó en un código más limpio y ordenado.
Hasta el momento, no hemos considerado un cambio en la arquitectura, pero sí hemos identificado algunas mejoras a nivel de código. Por ejemplo, decidimos crear un archivo de constantes para manejar los textos que se repiten a lo largo de la aplicación, lo cual facilita el mantenimiento y mejora la escalabilidad del código.

## ¿Tuvieron objetos stateful y stateless? ¿Cómo definen la elección de los mismos?

STATEFUL

Al ser una información que cambia dependiendo de la interacción del usuario, decidimos que estos objetos sean stateful porque necesitamos que se actualicen en tiempo real.

- El componente Remember, que maneja la visibilidad de los números de tarjeta (se ocultan o se muestran al hacer clic en un botón). Este componente cambia su estado dinámicamente en respuesta a la interacción del usuario.
- El ViewModel, que se encarga de almacenar y persistir datos a través del ciclo de vida de la aplicación. Su estado depende de la interacción y debe ser actualizado en tiempo real.

STATELESS

Los objetos stateless se usan para mostrar información que no necesita actualización dinámica.

- El componente CardInfo, que recibe un número de tarjeta y el saldo a cargar. No tiene un estado interno que dependa de interacciones del usuario, por lo que es stateless.
- El componente ServiceCard, que maneja un icono, un texto y una acción. Al igual que el anterior, no tiene cambios dinámicos, por lo que no requiere un estado interno.
- El componente TopBar, cuyo contenido depende de los parámetros y la pantalla en la que se encuentre, pero no necesita almacenar un estado que se actualice en tiempo real.

## ¿Qué mejoras detectan que podrían realizarle a la app? ¿Tendrían side effect si escala el volumen de datos? Comenten al menos 2 cuestiones a refactorizar y tener en cuenta.
Mejoras que podrían realizarse:

- Centralización de los textos: Crear un archivo de constantes para los strings que se repiten en la aplicación. Esto facilitaría la modificación de textos y la extensión a otros idiomas sin tener que modificar cada componente individualmente.
- Estilos comunes para las cards: Centralizar los estilos de las cards en un solo archivo de estilos, de modo que no sea necesario repetir la misma información en cada componente. Aunque CardInfo y ServiceCard tienen contenido interno diferente, su estilo de contenedor es el mismo.
- Optimización de la carga de datos: Implementar técnicas como paginación o lazy loading para manejar grandes volúmenes de datos de forma eficiente. De este modo, solo se cargan los datos visibles o necesarios en cada momento, lo que mejora el rendimiento de la aplicación sin sobrecargar la red o la UI.

## ¿Qué manejo de errores harían? ¿dónde los contemplan a nivel código? Mencionen la estrategia de mapeo que más se adecúe.
Para el manejo de errores, proponemos una estrategia por capas:

Capa de Datos: Se manejarán los errores provenientes de los servicios remotos. Usaremos try-catch para capturar excepciones y devolver un resultado que distinga entre éxito y error. Esto nos permitirá gestionar de manera eficiente los posibles fallos de comunicación o problemas con los datos.

Capa de Presentación: Utilizando los ViewModels, podemos mapear los resultados de la capa de datos y manejar el estado de la UI para mostrar mensajes de error o estados de carga. Para esto, una estrategia recomendada es usar una sealed class llamada UiState, que puede tener estados como Success, Error y Loading. Esto facilita la representación de los errores y el control de la UI en función de estos estados.

## En el caso de uso de persistencia para Favoritos, ¿que estrategia sugieren?.
Para guardar las preferencias del usuario, como el estado del "Dark Mode" o los favoritos, en nuestra aplicación, tenemos dos opciones principales: SharedPreferences y DataStore.

SharedPreferences (para casos sencillos):

Si solo necesitamos almacenar configuraciones simples, como el estado del "Dark Mode" o los favoritos, SharedPreferences es una buena opción. Es fácil de usar y funciona bien para datos pequeños y poco complejos.

## Si la tendríamos que convertir a Español y conservar el Inglés, qué estrategia utilizaría para extenderla. Y si necesitamos agregar otros idiomas?
Para extender la aplicación a varios idiomas, incluyendo Español e Inglés, podríamos implementar una estrategia utilizando string resources.
Para cada idioma, vamos a crear un archivo strings.xml en la carpeta correspondiente, como:

- Inglés: res/values/strings.xml
- Español: res/values-es/strings.xml

Si en el futuro queremos agregar más idiomas, simplemente necesitamos crear un nuevo archivo strings.xml en la carpeta correspondiente para ese idioma. Android se encargará de seleccionar el archivo correcto según la configuración regional del dispositivo.
