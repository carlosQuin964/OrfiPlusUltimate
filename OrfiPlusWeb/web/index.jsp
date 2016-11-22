
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>OrfiPlus</title>
	<meta charset="utf-8">
	<meta name="format-detection" content="telephone=no">
	<link rel="stylesheet" type="text/css" href="resources/css/font-awesome.css">
	<link rel="icon" type="image/png" href="resources/images/favicon.ico" />
	<link rel="stylesheet" href="resources/css/css/stuck.css">
	<link rel="stylesheet" href="resources/css/css/owl.carousel.css">
	<link rel="stylesheet" href="resources/css/css/form.css">
	<link rel="stylesheet" href="resources/css/css/touchTouch.css">
	<link rel="stylesheet" href="resources/css/css/camera.css">
	<link rel="stylesheet" href="resources/css/css/style.css">
	<script src="resources/js/js/jquery.js"></script>
	<script src="resources/js/js/jquery-migrate-1.1.1.js"></script>
	<script src="resources/js/js/script.js"></script>
	<script src="resources/js/js/superfish.js"></script>
	<script src="resources/js/js/jquery.equalheights.js"></script>
	<script src="resources/js/js/jquery.mobilemenu.js"></script>
	<script src="resources/js/js/jquery.easing.1.3.js"></script>
	<script src="resources/js/js/tmStickUp.js"></script>
	<script src="resources/js/js/jquery.ui.totop.js"></script>
	<script src="resources/js/js/touchTouch.jquery.js"></script>
	<script src="resources/js/js/owl.carousel.js"></script>
	<script src="resources/js/js/sForm.js"></script>
	<script src="resources/js/js/camera.js"></script>

	<script src="resources/js/js/jquery.mobile.customized.min.js"></script>
	<script>
		$(document).ready(function(){
			jQuery('#camera_wrap').camera({
				loader: false,
				pagination: false ,
				minHeight: '200',
				thumbnails: false,
				height: '39,0625%',
				caption: true,
				navigation: true,
				fx: 'mosaic'
			});
			var owl = $("#owl");
			owl.owlCarousel({
				items : 7, 
				itemsDesktop : [995,5], 
				itemsDesktopSmall : [767, 3], 
				itemsTablet: [700, 3], 
				itemsMobile : [479, 2], 
				navigation : true,
			});
			$().UItoTop({ easingType: 'easeOutQuart' });
			$('#stuck_container').tmStickUp({});
			$('.gallery a.gal_item').touchTouch();
		});
	</script>

</head>
<body class="page1" id="top">

	<header>
		<div id="stuck_container">
			<div class="container">
				<div class="row">
					<div class="grid_12">
                        
                          <img class="ima" src="resources/images/logos.png" alt="Your Happy Family">
                        
						</h1>
						<div class="menu_block">
							<nav class="horizontal-nav full-width horizontalNav-notprocessed">
								<ul class="sf-menu">
									<li class="current"><a href="index.jsp">Inicio</a></li>
									<li><a href="quienes somos.html">Quienes Somos</a></li>
									<li><a href="contactosNuevo.html">Contactenos</a></li>
                                                                        <li><a href="preguntas.jsp">Preguntas Frecuentes</a></li>
								</ul>
							</nav>
							<div class="clear"></div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</header>
	<div class="main">
		<div class="slider_wrapper">
			<div id="camera_wrap" class="">
				<div data-src="resources/images/slide.jpg">
					<div class="caption fadeIn">
						<div class="title">OrfiPlus</div>
						<p>En la joyería Orfi se diferencian dos tipos de joya, según su material de producción ya sea plata y oro. Es el proceso de representar un modelo de un sistema real que permite analizar sus características,  </p>
						<p>se pretende implementar en forma en la cual el cliente pueda parametrizar el producto y pueda tener una cotización preliminar del valor de la joya</p>
						<a href="faces/login.xhtml">Ingresar</a>
					</div>
				</div>
				<div data-src="resources/images/slide1.jpg">
					<div class="caption fadeIn">
						<div class="title">¿A que nos dedicamos?</div>
						<p>La Joyería Orfi, dedicada a la fabricación y ventas de joyas y relojería, donde se realizan marcación o grabado, fundición, venta y arreglos de relojería. La compañía maneja unas normas la cual las piezas que nos ofrezcan sean totalmente de oro, no se aceptan imitaciones o que estén relacionadas con robo o hurto, haciendo las respectivas pruebas</p>

						<a href="faces/login.xhtml">Ingresar</a>
					</div>
				</div>
				<div data-src="resources/images/slide2.jpg">
					<div class="caption fadeIn">
						<div class="title">Historia</div>
						<p>La joyería Orfi ubicada en el barrio San Cristóbal en Bogotá, se dedica a la fabricación y venta de joyas producidas en metales finos como son plata y oro; se destaca la fabricación de anillos, pulseras, cadenas, argollas y pendientes. Además de esto comercializa relojes de pulsera.

							En la actualidad la joyería carece de un control de producción respecto a materia prima y stock de productos. Una de las mayores dificultades evidenciadas, se presenta en la comunicación con el cliente en los trabajos por encargo</p>
							
							<a href="faces/login.xhtml">Ingresar</a>
						</div>
					</div>
				</div>
			</div>

			<div class="block1">
				<div class="container">
					<div class="row">
						<div class="grid_12">
							<div class="rel">
								<p>
									Crea una cuenta en orfi plus y podras reservar y conecer mas de  nuestros productos
								</p>
								<a href="faces/registro.xhtml" class="btn bt__1"> Registrarse</a>
							</div>
						</div>
					</div>
				</div>
			</div>
			<section class="content">
				<div class="container"><div class="ic"></div>
				<div class="row">
					<div class="grid_12">
						<h2>Portafolios</h2>
						<div class="gallery">
							<div class="row">
								<div class="grid_4">
									<a href="resources/images/big1.jpg" class="gal_item">
										<img src="resources/images/page1_img1.jpg" alt="">
										<div class="gal_caption">Para Todos</div>
										<span class="gal_magnify"></span>
									</a>
								</div>
								<div class="grid_4">
									<a href="resources/images/big2.jpg" class="gal_item">
										<img src="resources/images/page1_img2.jpg" alt="">
										<div class="gal_caption">Todos los estilos</div>
										<span class="gal_magnify"></span>
									</a>
								</div>
								<div class="grid_4">
									<a href="resources/images/big3.jpg" class="gal_item">
										<img src="resources/images/page1_img3.jpg" alt="">
										<div class="gal_caption">Variedad</div>
										<span class="gal_magnify"></span>
									</a>
								</div>
								<div class="grid_4">
									<a href="resources/images/big4.jpg" class="gal_item">
										<img src="resources/images/page1_img4.jpg" alt="">
										<div class="gal_caption">Para Hombres</div>
										<span class="gal_magnify"></span>
									</a>
								</div>
								<div class="grid_4">
									<a href="resources/images/big5.jpg" class="gal_item">
										<img src="resources/images/page1_img5.jpg" alt="">
										<div class="gal_caption">Para Mujeres</div>
										<span class="gal_magnify"></span>
									</a>
								</div>
								<div class="grid_4">
									<a href="resources/images/big6.jpg" class="gal_item">
										<img src="resources/images/page1_img6.jpg" alt="">
										<div class="gal_caption">Anillos</div>
										<span class="gal_magnify"></span>
									</a>
								</div>
							</div>
						</div>
					</div>
					<div class="clear"></div>
					<div class="grid_4">
						<h3 class="mb__0">Ingresa</h3>
						<div class="block2">
							<div class="block2_title color1">Podras</div>
							<ul class="list">
								<li><a href="#">Conocer Nuestros Productos </a></li>
								<li><a href="#">Hacer Reservas de los productos </a></li>
								<li><a href="#">Realizar seguimiento de trabajos encargados</a></li>
							</ul>
						</div>
						<div class="block2">
							<div class="block2_title color1">Diseño</div>
							<ul class="list">
								<li><a href="#">También podrás realizar prediseños a tu gusto </a></li>
								<li><a href="#">Mirar las últimas innovaciones con detalles que podrás reservar </a></li>
								<li><a href="#">Conocer las últimas promociones </a></li>
							</ul>
						</div>
					</div>
					<div class="grid_4">
					<h3>Encontrarás</h3>
						<p>Todos sobre nuestros productos tanto disponibles como en desarrollo.</p>
						<p> <span class="color1"><a href="http://www.templatemonster.com/properties/topic/design-photography/" rel="nofollow"></a></span> escoger el producto que sea de su preferencia para poder reservarlo desde la web .</p>
						realizar seguimientos a los productos que están por entregar y los que acabo de reservar a su medida<br>
						<a href="faces/login.xhtml" class="btn bt__2">Ingresar</a>
					</div>
					<div class="grid_4">
						<h3>Reservar Productos</h3>
						<ul class="list1">
							<li>
								<div class="list_count">1</div>
								<div class="extra_wrapper">
									<div class="list1_title color2"><a href="#">Regístrate a Orfi plus y ingresa con tu usuario y contraseña
										
									</div>
								</li>
								<li>
									<div class="list_count">2</div>
									<div class="extra_wrapper">
										<div class="list1_title color2"><a href="#">Ingresa a los productos conoce los detalles y reserva tu producto 

										</div>
									</li>
									<li>
										<div class="list_count">3</div>
										<div class="extra_wrapper">
											<div class="list1_title color2"><a href="#">Llena el formulario de reserva para conocer mejor el producto que quieres reservar

											</div>
										</li>
									</ul>
								</div>
								<div class="clear"></div>
								<div class="grid_12">
									<h3 class="head1">Multimedia</h3>
								</div>
								<div class="clear"></div>
							</div>
						</div>
						<div id="owl">
							<div class="item"><img src="resources/images/car_img1.jpg" alt=""></div>
							<div class="item"><img src="resources/images/car_img2.jpg" alt=""></div>
							<div class="item"><img src="resources/images/car_img3.jpg" alt=""></div>
							<div class="item"><img src="resources/images/car_img4.jpg" alt=""></div>
							<div class="item"><img src="resources/images/car_img5.jpg" alt=""></div>
							<div class="item"><img src="resources/images/car_img6.jpg" alt=""></div>
							<div class="item"><img src="resources/images/car_img7.jpg" alt=""></div>
							<div class="item"><img src="resources/images/car_img1.jpg" alt=""></div>
							<div class="item"><img src="resources/images/car_img2.jpg" alt=""></div>
							<div class="item"><img src="resources/images/car_img3.jpg" alt=""></div>
							<div class="item"><img src="resources/images/car_img4.jpg" alt=""></div>
							<div class="item"><img src="resources/images/car_img5.jpg" alt=""></div>
							<div class="item"><img src="resources/images/car_img6.jpg" alt=""></div>
							<div class="item"><img src="resources/images/car_img7.jpg" alt=""></div>
						</div>
					</section>



				</div>

				<footer>
					<div class="container">
						<div class="row">
							<div class="grid_12">
								<div class="footer_socials">
									<a href="#" class="fa fa-twitter"></a>
									<a href="#" class="fa fa-facebook"></a>
									<a href="#" class="fa fa-google-plus"></a>
									<a href="#" class="fa fa-pinterest"></a>
								</div>

							</div>
						</div>
					</div>
				</div>
			</footer>
		</body>
		</html>
