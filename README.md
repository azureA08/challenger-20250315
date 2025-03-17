# challenger-20250315

Challenger Sooft 2025

Challenge back:

     El challenge que se trata de generar los siguientes 3 endpoints:
     1.Uno que traiga las empresas que hicieron transferencias el último mes
     2. Otro que traiga las empresas que se adhirieron el último mes.
     3  El último que haga la adhesión de una empresa.
     Deseable: usar arquitectura hexagonal (o utilizar servicio con el que te sientas más sólido/seguro)
     Base: puede usarse relacional o no relacional
     Datos de la empresa: CUIT, Razón Social, Fecha Adhesión
     Datos de la transferencia: Importe, Id Empresa, Cuenta Débito, Cuenta Crédito
     Datos de apitrasaccionDetalle CUIT, Razón Social, Fecha Adhesión,Importe, Id Empresa, Cuenta Débito, Cuenta Crédito, fechaTransaccion

Realizar test unitarios.

    Las dudas en el desarrollo asumirlas y ponerlas en un archivo de aclaracion.

Aclarcaiones:

Agrege al modelo una clase ApiTransaccionDetalle , con el fin de tener los dato de La empresa adherida con la
transferencia en una misma tabla ApiTransaccionDetalle y así mejorar los tiempo de respesta de las consulta al realizar
un select a la misma.Esta tabla que expone la información detalladas de las transferecias de las empresa , se cargaria
con un storeprocedure /dtsx .
Los test junit los implemente sobre los controles , el obejitvo fue realizar pruebas de integración
Falto implementar los test de dependencia; para ver si existe depencia circular , jars deprecados.El objetivo es que las
capas no esten acopladas con Archunit ; para estar alineado, con los criterios de arquitectura limpia.Como complemento
al junit ,se le puede agregar un test simple d carga utilizando rest assured.

Campos de apitrasaccionDetalle CUIT, Razón Social, Fecha Adhesión,Importe, Id Empresa, Cuenta Débito, Cuenta Crédito,
fechaTransaccion

DO ==> Implementaciones realizadas.

     El Punto 1 y 2 se resuelve implementado las consutas utilizando  @Query

Los tres endpoints

     PuntoP 1-get Trealas empresas que hicieron transferencias el último mes

@GetMapping("/findEmpresasConTransferenciasUltimoMes")
public List<Empresa> findEmpresasConTransferenciasUltimoMes() {
return empresaService.findEmpresasConTransferenciasUltimoMes();
}

     Punto 2. Otro que traiga las empresas que se adhirieron el último mes.

@GetMapping("/adheridas-ultimo-mes")
public List<Empresa> obtenerEmpresasAdheridasUltimoMes() {
return empresaService.obtenerEmpresasAdheridasUltimoMes();
}

     Punto 3 Metodao para adherir una empresa

@PostMapping("/adherir")
public ResponseEntity<Empresa> adherirEmpresa(@RequestBody Empresa empresa) {
Empresa empresaAdherida = empresaService.adherirEmpresa(empresa);
return new ResponseEntity<>(empresaAdherida, HttpStatus.CREATED);
}

# Challenger 2025 Update 20250317.
