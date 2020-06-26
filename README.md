# Notas rápida

* Agrege un **.zip** con un proyecto nuevo en Maven con la depedencia ya instalada.
* Dado limitaciones de la libreria, cada objeto JSON debe abarcar una sola línea.

# ¿Cómo instalarlo?

**(En terminal):**

1. Entrar en la carpeta `horarios` (después de clonar el repositorio).
2. Ejecutar `mvn compile`, `mvn package`, `mvn install`.
3. Comprobar configuración (Linux) con `ls ~/.m2/repository/org/` debería aparecer una carpeta llamada `orzhov`.

## Agregar dependencia

En un `pom.xml`, agregar lo siguiente:
   
```
    <dependency>
      <groupId>org.orzhov</groupId>
      <artifactId>horarios</artifactId>
      <version>1.0-SNAPSHOT</version>
    </dependency>
```

## Ejecutar programa

### Code

1. Ejecutar `mvn package`.
2. Ejecutar `java -cp target/<Archivo>.jar <Compañia>.App -DconfigFile=<RutaJSON>`.

### IntelliJ

1. Ir a la opción `Run`, posteriormente `Edit Configurations`.
2. En `VM Options` colocar `-DconfigFile=<RutaJSON>`.


# Por hacer

[ ] Refactorización (en especial de App.java)


