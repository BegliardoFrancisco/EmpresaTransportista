# EmpresaTransportista
TP de backend de aplicaciones 

(Cliente)
Registrar Solicitud de trasnporte de contenedor
Consultar Contenedor y su estado actual X 
Costo y tiempo estimado de entrega



(Administrador)
Registrar Ciudades
Registrar Depositos
Registrar Tarifa
Registrar Camiones
Registrar Contenedores X

Actualizar Ciudades
Actualizar Depositos
Actualizar Tarifa
Actualizar Camiones
Actualizar Contenedores X

Actualizar Solicitudes (Camiones)
Actualizar Contenedores (estado) X

Consultar todos los contenedores pedientes de entrega X

Calcular costo total de entrega 
Validar que un camion no supere su capacidad maxima de peso ni volumen

El tiempo estimado se calcula en base a las distancias entre los puntos involucrados

El seguimiento debe mostrar los estados del envío en orden cronologico

Los tramos de ruta deben calcular fecha estimadas y reales para calcular el desempeño.




API MICROSERVICIO DE PEDIDOS 

Cliente 
Contenedor
Solicitud
Tramo de Ruta

----------------------------------------------------------------------

POST /solicitudes
Body {contenedorId, origenId, destinoId, depositoId}
ROL: CLIENTE

GET /solicitudes/{id}
ver detalle solicitud
ROL: CLIENTE y ADMIN

GET /solicitudes/pendientes
Listar todas las solicitudes pendientes de entrega
ROL: ADMIN

----------------------------------------------------------------------

GET /seguimiento/{contenedorId}
Ver estados actual del contenedor y su historial (cliente)
Muestra estados ordenados cronologicamente ordenados por tramos
ROL: CLIENTE

-------------------------------------------------------------------------------------------------------


POST /contenedores
Registrar un nuevo contenedor 
ROL: ADMIN

GET /Contenedores
{Hay que ver como hacemos eso si ponemos un /{idCLiente} en la URI o lo hacemos por medio del token}
listar contenedores del cliente auntenticado
ROL: CLIENTE

GET /contenedores/pendientes
listar todos los contenedores del cliente
ROL: ADMIN

--------------------------------------------------------------------------------------------------------

PATCH /tramos/{id}/estado
Registrar avance: actualizar fechas reales de salida/legada 
BODY: {fechaSalidaReal, fechaLlegadaReal}

---------------------------------------------------------------------------------------------------------

GET /clientes/{id}
Obtener datos del cliente
ROL: ADMIN y CLIENTE




