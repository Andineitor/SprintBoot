# SprintBoot
<h1>
CURSO SPRINTBOOT
</h1>

<p>Dentro de este curso se aborda temas como fundamentos, desarrollo web, persistencia de datos, línea de comandos, seguridad y mensajería. Además, explora herramientas complementarias como Thymeleaf, H2 y RabbitMQ. </p>

<p>
Tambien cuenta con un login amigable para poder exponer el tema de autentiación y seguridad para las rutas
</p>
<br>

<hr>

<h2>
LOGIN
</h2>
<img src="source/login.png">

<hr>

<h2>
SERVICIOS REST
</h2>
<img src="source/rest.png">

<h2>
SERVICIOS MENSAJERIA
</h2>

<p>
El proyecto "Busca" recibe un mensaje del servidor RabbitMQ que contiene los parámetros necesarios para realizar una búsqueda en el sistema de reuniones. "Busca" consume la API del proyecto "Reuniones" para obtener la información de las reuniones según los parámetros proporcionados. El sistema utiliza RabbitMQ para orquestar la comunicación entre "Busca" y "Reuniones".</p>
<img src="source/rabbit.png">
<img src="source/recibido.png">
<img src="source/respuesta.png">


