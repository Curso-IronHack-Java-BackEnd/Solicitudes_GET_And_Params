
## CFU: JPQL y SQL Nativo

**Ventajas SPQL**

 - Las consultas no estan vinculadas a una base de datos especifica por
   lo que resulta más facil su portabilidad
 - Esta orientado a objetos por lo que son más faciles de escribir si
   estamos acostumbrados a trabajar en lenguajes de programacion
   orientados a objetos.
 - Simplifica las consultas, haciendolas más legibles

**Desventajas SPQL**

 - Pueden resultar menos eficientes ya que las consultas tienen que ser
   traducidas a SQL antes de ejecutarse lo que repercute en el
   rendimiento sobre todo si se trata de consultas muy complejas
 - Hay ciertas funciones complejas o especificas de la base de datos que
   no pueden realizarse y necesitan lenguaje SQL especifico para dicha
   base de datos.

**Ventajas SQL**

 - Las consultas se ejecutan directamente sobre la base de datos por lo
   que tendremos mas eficiencia al no necesitar de traduccion y mas
   funciones disponibles.

**Desventajas SQL**

 - Al estar vinculadas las consultas con la base de datos especifica es
   más complicada su portabilidad o la migracion a otro sistema de bases
   de datos.

En resumen, JPQL es ideal para aplicaciones que requieren portabilidad entre diferentes bases de datos, mientras que SQL nativo es más adecuado cuando se necesita aprovechar funciones específicas de la base de datos
