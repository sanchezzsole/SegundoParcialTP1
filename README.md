ENUNCIADO
Una cadena hotelera nos solicita un prototipo de software para la gestión de reservas de uno de sus hoteles más exclusivos. En esta primera etapa, el sistema debe enfocarse en un solo hotel, que cuenta con tres tipos de habitaciones: Estándar, Suite y Suite Presidencial. El hotel tiene 3 pisos, con 5 habitaciones por piso. En cada piso sólo existe un solo tipo de habitación.
Cada habitación puede ser de uno de los tres tipos mencionados y son tarifables, por lo que cuentan con una tarifa particular. Cada habitación tiene un número de identificación único (no negativo), un estado (LIBRE, MANTEMIENTO, RESERVADA), capacidad (entero, mayor a cero) que representa la cantidad de ocupantes maximos por habitacion y una tarifa por noche (entero, mayor a 0) y cada una cuenta con las siguientes caracteristicas:
* Estandar:
Ubicacion: Solo se ubican en el primer piso
Tarifa base: 50
Capacidad: 2
Para estas habitaciones la tarifa es igual a la propia base.
* Suite:
Ubicación: Solo se ubican en el segundo piso.
Tarifa base: 150.
Capacidad: 4.
Las suites pueden tener un servicio adicional opcional (Desayuno incluido, Acceso al spa, Acceso al gimnasio, WiFi gratuito).
Para estas habitaciones la tarifa es igual a la base multiplicado al costo extra del servicio adicional. 
* Suite Presidenciales:
Ubicación: Solo se ubican en el último piso.
Tarifa base: 320.
Capacidad: 6.
Número de habitaciones: (entero, mayor a 1).
También tienen servicio un adicional opcional (Desayuno incluido, Acceso al spa, Acceso al gimnasio, WiFi gratuito)
La tarifa se calcula de la misma manera que en la Suite.

Por otro lado, el hotel cuenta con un listado de clientes exclusivos, que son los únicos que pueden realizar reservas en el hotel. Cada cliente tendrá un DNI (no negativo, ni cero), nombre (no vacio). Los clientes podrán realizar reservas. 
Todas las reservas tienen un cliente asociado, una habitación específica a la cual se le puede  especificar si quiero algún servicio adicional., una fecha de inicio en el formato "dd-MM-aaaa" y una duración en noches que debe ser mayor a 0. Al ser Tarifable, tienen la posibilidad de calcular la tarifa de la reserva que siempre va ser número de noches * el costo de la habitación. 
Las reservas deben ser almacenadas de tal manera que puedan ser consultadas desde la más nueva hasta la más vieja.
pila
Para aprobar el examen se deberá realizar lo siguiente:
- Implementar la clase Habitación aplicando las validaciones indicadas y todo lo que necesites para cumplir con los requerimientos.
- Implementar la clase Reserva aplicando las validaciones indicadas. La clase reserva debe ser capaz de indicar el costo de la tarifa (tarifa de la habitación * la cantidad de noches)
- Completar la clase Hotel, agregando los atributos y métodos necesarios para cumplir con el funcionamiento.
- Implementar la funcionalidad de buscar cliente por dni, que reciba el DNI del cliente y devuelva un Cliente o nulo si no lo encuentra, de la manera mas optima que encontremos.
- Implementar la funcionalidad de buscar habitacion disponible recibiendo el tipo de habitacion y un servicio adicional. El método debe buscar la primer habitación libre dentro del hotel y retorna dicha habitación o nulo si no la encuentra. En caso de que la habitación sea Suite o Suite Presidencial, además, se le deberá agregar el servicio indicado
- Implementar una funcionalidad que nos permita procesar las reservas de los clientes, la cual debe buscar el cliente por su DNI, luego verificar si hay disponibilidad de la habitación solicitada (que se encuentre libre). Si la habitación está disponible, crea una nueva reserva y la agrega a la lista de reservas. Si no hay habitaciones disponibles, debe arrojar una excepción.
- Tambien implementar la funcionalidad de procesar una reservas que me permita elegir el servicio adicional siempre y cuando la habitacion elegida sea Suite o Suite Presidencial. Con las mismas reglas que el punto anterior. excepción??
- Implementar una funcionalidad que permita llevar un historial de reservas. Este historial debe ser accesible y permitir ver las reservas desde la mas nueva hasta la mas antigua.
- Llevar un registro de la cantidad de reservas por tipo de habitación e informarlo ., tal como se muestra en la salida de consola
- Mostrar a la salida el historial de reservas desde la mas nueva en adelante.
- Completar la gestión de errores en la clase Principal. Solo se debe modificar lo que se considere pertinente para la gestión de errores, no modificar el resto de la clase.
