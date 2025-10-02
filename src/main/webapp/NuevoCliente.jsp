<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TP5 - GRUPO 11 | Agregar Cliente</title>
<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet" />

<!-- Bootstrap JS -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

<!-- jQuery -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<!-- Font Awesome -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css"
	rel="stylesheet" />

<!-- Animate.css -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css" />

<style type="text/css">
	<jsp:include page="css\style.css"></jsp:include>
</style>
</head>
<body>
	<div class="content">
		<aside class="p-3">
			<h2>Menú</h2>
			<nav class="navbar navbar-expand-lg">
				<ul>
					<li><a href="ServletCliente?Param=nuevocliente"
						class="">Alta de Cliente</a></li>
					<li><a href="ServletCliente?Param=listadoclientes"
						class="">Listado de Clientes</a></li>
				</ul>
			</nav>
		</aside>
		<main class="w-100 p-4">
			<h1>Formulario de Cliente</h1>
			<div>
				Usuario:
				<%=request.getSession().getAttribute("username")%></div>
			<form method="POST" action="ServletCliente">
				<div class="formnuevocliente">
					<div class="row mb-3">
						<div class="col-md-6">
							<label for="inputDni" class="form-label">DNI *</label> <input
								type="number" class="form-control" id="inputDni" name="dni"
								required aria-describedby="dniHelpBlock" min="100000" max="99999999">
								 <small id="dniHelpBlock" class="form-text text-muted">Sólo números, 6 a 8 dígitos (ej.12345678)</small>
						</div>
						<div class="col-md-6">
							<label for="inputCuil" class="form-label">CUIL *</label> <input
								type="number" class="form-control" id="inputCuil" name="cuil"
								required aria-describedby="cuilHelpBlock" min="10000000000" max="99999999999">
								<small id="cuilHelpBlock" class="form-text text-muted">Formato: 11 dígitos (ej: 20333444555)</small>
						</div>
					</div>
					<div class="row mb-3">
						<div class="col-md-6">
							<label for="inputNombre">Nombre *</label> <input type="text"
								class="form-control" id="inputNombre" required>
						</div>
						<div class="col-md-6">
							<label for="inputApellido">Apellido *</label> <input type="text"
								class="form-control" id="inputApellido" required>
						</div>
					</div>
					<div class="row mb-3">
						<div class="col-md-6">
							<label for="inputSexo">Sexo *</label> <select id="inputSexo"
								class="form-control" required>
								<option selected>Elegir...</option>
								<option>M</option>
								<option>F</option>
								<option>X</option>
							</select>
						</div>
						<div class="col-md-6">
							<label for="inputNacionalidad">Nacionalidad</label> <input
								type="text" class="form-control" id="inputNacionalidad">
						</div>
					</div>
					<div class="row mb-3">
						<div class="col-md-6">
							<label for="inputFecha_nacimiento">Fecha de nacimiento *</label>
							<input type="date" id="inputFecha_nacimiento"
								class="form-control" required min="1925-01-01" max="2007-10-01" aria-describedby="fecha_nacimientoHelpBlock">
								<small id="fecha_nacimientoHelpBlock" class="form-text text-muted">Debe tener mínimo 18 años</small>
						</div>
						<div class="col-md-6">
							<label for="inputDireccion">Dirección</label> <input type="text"
								class="form-control" id="inputDireccion">
						</div>
					</div>

					<div class="row mb-3">
						<div class="col-md-6">
							<label for="inputLocalidad">Localidad</label> <input type="text"
								id="inputLocalidad" class="form-control">
						</div>
						<div class="col-md-6">
							<label for="inputProvincia">Provincia</label> <input type="text"
								class="form-control" id="inputProvincia">
						</div>
					</div>

					<div class="row mb-3">
						<div class="col-md-6">
							<label for="inputCorreo_electronico">Correo electrónico *</label>
							<input type="email" id="inputCorreo_electronico"
								class="form-control" required aria-describedby="emailHelpBlock">
								<small id="emailHelpBlock" class="form-text text-muted">Ej: nombre@dominio.com</small>
						</div>
						<div class="col-md-6">
							<label for="inputTelefono">Teléfono</label> <input type="text"
								class="form-control" id="inputTelefono">
						</div>
					</div>
					<div class="">
						<button type="reset" class="btn btn-secondary">Reset</button>
						<button type="submit" class="btn btn-primary">Guardar cliente</button>
					</div>
				</div>
			</form>

		</main>
	</div>
</body>
</html>