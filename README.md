# Glosario de conceptos técnicos en JUnit 5:
### JUnit 5: Es una plataforma de pruebas para Java, que consta de tres subproyectos principales: JUnit Jupiter, JUnit Vintage y JUnit Platform. JUnit 5 permite escribir y ejecutar pruebas unitarias de manera más flexible y moderna que las versiones anteriores de JUnit.

### JUnit Jupiter: Es el nuevo motor de pruebas que proporciona una API más rica para escribir pruebas y realizar aserciones en JUnit 5. Incluye anotaciones y mecanismos para ejecutar pruebas.

### JUnit Vintage: Es el subproyecto de JUnit 5 que permite la ejecución de pruebas escritas con versiones anteriores de JUnit (JUnit 3 y JUnit 4) dentro de la plataforma JUnit 5.

### JUnit Platform: Es la base sobre la cual se ejecutan las pruebas de JUnit 5. Define la arquitectura y la API común para ejecutar pruebas, incluidos otros marcos de pruebas que pueden integrarse con JUnit, como TestNG.

### Test: Una unidad de código escrita para comprobar si una parte de un sistema de software se comporta como se espera. En JUnit 5, las pruebas se implementan utilizando métodos anotados con @Test.

### @Test: Es una anotación que indica que un método es una prueba que debe ejecutarse. JUnit 5 ejecuta estos métodos como pruebas unitarias.

### Assertions: Son métodos utilizados para verificar las condiciones de las pruebas. Ejemplos comunes incluyen assertEquals(), assertTrue(), assertFalse(), entre otros. Permiten validar que el comportamiento del código sea el esperado.

### @BeforeEach: Anotación que indica que el método marcado se ejecutará antes de cada prueba. Esto es útil para la configuración de recursos comunes que necesitan ser inicializados antes de cada ejecución de prueba.

### @AfterEach: Anotación que indica que el método marcado se ejecutará después de cada prueba. Se usa para realizar limpieza o liberar recursos utilizados durante las pruebas.

### @BeforeAll: Anotación que marca un método que debe ejecutarse una sola vez antes de que se ejecuten todas las pruebas de la clase de prueba. Es útil para configurar recursos que son compartidos por todas las pruebas.

### @AfterAll: Anotación que marca un método que debe ejecutarse una sola vez después de que se hayan ejecutado todas las pruebas de la clase. Se usa para liberar recursos globales.

### @Disabled: Anotación que se utiliza para deshabilitar temporalmente una prueba. El método marcado con @Disabled no se ejecutará cuando se ejecuten las pruebas.

### @Tag: Anotación que permite etiquetar las pruebas con palabras clave (como "rapida", "baja prioridad", etc.) para que puedan ser seleccionadas y ejecutadas de manera más específica o filtradas en el momento de ejecución.

### @Nested: Anotación que permite agrupar pruebas de manera jerárquica. Los métodos anotados con @Nested están relacionados entre sí, lo que ayuda a organizar las pruebas dentro de clases.

### @TestInstance: Anotación que permite especificar el ciclo de vida de la instancia de la clase de prueba. Puede ser PER_METHOD (por defecto, se crea una nueva instancia de la clase para cada prueba) o PER_CLASS (se reutiliza la misma instancia de la clase para todas las pruebas).

### @RepeatedTest: Anotación que permite ejecutar una prueba varias veces. El número de repeticiones se puede especificar como argumento. Es útil para verificar que una prueba se ejecute correctamente de forma repetida.

### @ParameterizedTest: Anotación que permite ejecutar una prueba con varios conjuntos de datos de entrada. Es útil para pruebas donde el mismo comportamiento debe verificarse con diferentes valores de entrada.

### TestExecutor: Es el mecanismo encargado de ejecutar las pruebas unitarias dentro de la plataforma JUnit 5. A través de la interfaz de la plataforma, las pruebas pueden ejecutarse en entornos como IDEs, servidores de integración continua, o desde la línea de comandos.

### TestPlan: Es una representación de todas las pruebas que se van a ejecutar, sus resultados y su estado. El TestPlan se puede utilizar para analizar los resultados de las pruebas en detalle.

### Dynamic Tests: Son pruebas que se generan en tiempo de ejecución, lo que significa que los métodos de prueba no son estáticos, sino que se crean dinámicamente durante la ejecución del código.

### @ExtendWith: Anotación que permite extender la funcionalidad de las pruebas mediante el uso de extensiones. Las extensiones permiten modificar el comportamiento de las pruebas, agregar características como la inyección de dependencias, o manejar excepciones.

### @InjectMocks: Se utiliza junto con frameworks como Mockito para inyectar automáticamente dependencias mock (simuladas) en los objetos que están siendo probados.

### Mockito: Es una biblioteca de pruebas que se usa comúnmente junto con JUnit 5 para crear objetos simulados (mocks) que permiten verificar el comportamiento de las clases sin tener que depender de implementaciones reales de las dependencias.

### TestExecutionExceptionHandler: Es una interfaz que maneja excepciones durante la ejecución de las pruebas. Permite personalizar cómo se manejan los errores que ocurren durante la ejecución de pruebas.

### @ValueSource: Es una anotación que se utiliza con pruebas parametrizadas para proporcionar una fuente de valores que se pasarán como argumentos a las pruebas.

### @MethodSource: Es una anotación que se usa con pruebas parametrizadas para definir un método que devolverá los valores que se utilizarán para ejecutar la prueba.

### @CsvSource: Es una anotación usada en pruebas parametrizadas para proporcionar un conjunto de valores de entrada en formato CSV (valores separados por comas).

### @TestConstructor: Es una anotación que permite especificar cómo se deben construir las instancias de la clase de prueba, usando el constructor adecuado para la inyección de dependencias.
