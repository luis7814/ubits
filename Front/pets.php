<!DOCTYPE html>
 
<html lang="es">
 
<head>
<title>Titulo de la web</title>
<meta charset="utf-8" />
<link rel="stylesheet" type="text/css" href="default.css?1.2">

<style>
a:link, a:visited {
  background-color: white;
  color: black;
  border: 2px solid green;
  padding: 10px 20px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
}

a:hover, a:active {
  background-color: green;
  color: white;
}
</style>

</head>
 
<body>
	
    <aside>
		<h3>ReWow</h3>
        <h3>Menú</h3>
           
		<a>Historia</a>
    </aside>    
	<aside>
		<br>
		<br>
       
		   
		<?php
		
		$nombre = $_POST['nombre'];
		
		$url = 'http://localhost:8082/pet/'. $nombre;
		$data = json_decode( file_get_contents($url), true);
		
		?>
		
		<table>
			<tr>
				<td>Nombre : </td>
				<td><?php  echo $data['petName'];?></td>
			</tr>
			<tr>
				<td>Tamaño : </td>
				<td><?php  echo $data['petSize'];?></td>
			</tr>
			<tr>
				<td>Raza : </td>
				<td><?php  echo $data['petDescription'];?></td>
			</tr>
			<tr>
				<td>Tipo mascota : </td>
				<td><?php  echo $data['typePet'];?></td>
			</tr>
		</table>
		
    </aside>
	<aside>
		<h3>Historia</h3>
		
		<?php
	
			$nombre = $_POST['nombre'];
			
			$url = 'http://localhost:8082/quotes/'. $nombre;
			$data = json_decode( file_get_contents($url), true);
		?>
		
		<h3><?php  echo $data[0]['petName'];?></h3>
		
		<?php
			for($i = 0; $i <count($data); $i++) {
		?>
		
		<br>
		<br>
		<table>
			<tr>
				<td>Vacuna : </td>
				<td><?php  echo $data[$i]['vacName'];?></td>
			</tr>
			<tr>
				<td>Veterinario : </td>
				<td><?php  echo $data[$i]['docName'];?></td>
			</tr>
			<tr>
				<td>Tipo cita : </td>
				<td><?php  echo $data[$i]['meseName'];?></td>
			</tr>
			<tr>
				<td>Fecha : </td>
				<td><?php  echo $data[$i]['vapeDate'];?></td>
			</tr>
		</table>
		
		<?php 
			}
		?>
		
		
    </aside>
</body>
