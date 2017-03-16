<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="fr">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

	<!-- IMPORT CSS/JS/FONT -->
	<link href="../../../bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
	<link href="../../../CSS/gerer_avis/avis_annonce/star-rating.css" rel="stylesheet" type="text/css"/>
	<link href="../../../CSS/gerer_avis/avis_annonce/avis_annonce.css" rel="stylesheet" type="text/css"/>
	
	<script type="text/javascript" src="../../../JQuery/jquery-3.1.1.min.js"></script>
	<script type="text/javascript" src="../../../bootstrap/js/bootstrap.js"></script>
	<script type="text/javascript" src="../../../JS/gerer_avis/avis_annonce/star-rating.js"></script>
	<script type="text/javascript" src="../../../JS/gerer_avis/avis_annonce/creation_avis_annonce.js"></script>
	
	<link href='https://fonts.googleapis.com/css?family=Lato:400,300,100,300italic' rel='stylesheet' type='text/css'>
	
	<!-- Titre de la page -->
	<title>Création avis utilisateur</title>
</head>

<body>

<!-- Formulaire de creation d'un avis utilisateur -->
	<form method="get" action="#" onsubmit="return controleAvisComplet()">
	
<!-- Note -->
		<div class="note">
			<h2>Note</h2>
<!-- Label Note -->
			<div class="labelNote">
				<label class="label_bruit_ext">Bruit Extérieur :</label>
				<br>
				<label class="label_bruit_int">Bruit Intérieur :</label>
				<br>
				<label class="label_isole_froid">Isolation au froid :</label>
				<br>
				<label class="label_isole_chaud">Isolation au chaud :</label>
				<br>
				<label class="label_humidite">Humidité :</label>
				<br>
				<label class="label_luminosite">Luminosité :</label>
				<br>
				<label class="label_etat_gene">État général :</label>
				<br>
				<label class="label_relation_bailleur">Relation Bailleur :</label>
			</div>
				
<!-- Stars Note voir http://plugins.krajee.com/star-rating-->
			<div class="starsNote">
	   			<input id="bruit_ext" name="bruit_ext" class="rating rating-loading"  data-min="0" data-max="5" data-step="1" data-size="xs">
	   			<input id="bruit_int" name="bruit_int" class="rating rating-loading"  data-min="0" data-max="5" data-step="1" data-size="xs">
	   			<input id="isole_froid" name="isole_froid" class="rating rating-loading"  data-min="0" data-max="5" data-step="1" data-size="xs">
	   			<input id="isole_chaud" name="isole_chaud" class="rating rating-loading"  data-min="0" data-max="5" data-step="1" data-size="xs">
	   			<input id="humidite" name="humidite" class="rating rating-loading"  data-min="0" data-max="5" data-step="1" data-size="xs">
	   			<input id="luminosite" name="luminosite" class="rating rating-loading"  data-min="0" data-max="5" data-step="1" data-size="xs">
	   			<input id="etat_gene" name="etat_gene" class="rating rating-loading"  data-min="0" data-max="5" data-step="1" data-size="xs">
	   			<input id="relation_bailleur" name="relation_bailleur" class="rating rating-loading"  data-min="0" data-max="5" data-step="1" data-size="xs">
			</div>
				
<!-- Help tooltip  -->
			<div class="helpTooltip">
				<!-- TODO -->
				<img id="icon_bruit_ext" src="../../../IMG/grey-information-icon-24x24.png" onmouseover="afficheTooltips(this)" onmouseout="cacheTooltips(this)"/>
				<img id="icon_bruit_int" src="../../../IMG/grey-information-icon-24x24.png" onmouseover="afficheTooltips(this)" onmouseout="cacheTooltips(this)" />
				<img id="icon_isole_froid" src="../../../IMG/grey-information-icon-24x24.png" onmouseover="afficheTooltips(this)" onmouseout="cacheTooltips(this)" />
				<img id="icon_isole_chaud" src="../../../IMG/grey-information-icon-24x24.png" onmouseover="afficheTooltips(this)" onmouseout="cacheTooltips(this)" />
				<img id="icon_humidite" src="../../../IMG/grey-information-icon-24x24.png" onmouseover="afficheTooltips(this)" onmouseout="cacheTooltips(this)" />
				<img id="icon_luminosite" src="../../../IMG/grey-information-icon-24x24.png" onmouseover="afficheTooltips(this)" onmouseout="cacheTooltips(this)" />
				<img id="icon_etat_gene" src="../../../IMG/grey-information-icon-24x24.png" onmouseover="afficheTooltips(this)" onmouseout="cacheTooltips(this)" />
				<img id="icon_relation_bailleur" src="../../../IMG/grey-information-icon-24x24.png" onmouseover="afficheTooltips(this)" onmouseout="cacheTooltips(this)" />
			</div>
		</div>
		


<!-- Commentaire -->
		<div class="commentaire">
			<h2>Commentaire</h2>
<!-- Nombre Caractère restant -->
			<div class="caractereRestant">
				<label id="label_nombre_caractere_restant">Nombre de caractère restant : </label><p id="nombre_Caractere_Restant">4000</p>
			</div>
			<textarea id="commentaire" rows="15" cols="100" name="commentaire" onfocus="cleanCommentaire(this)" onkeyup="calculCaractereRestant()">Votre commentaire...</textarea>
		</div>

<!-- Valider/Annuler -->
		<div class="action">
			<input id="valider" type="submit" name="valider" value="valider" />
			<input id="annuler" type="reset" name="annuler" value="annuler" />
		</div>
		
<!-- MessageInformatif -->
		<div class="messageInformatif">
			<p id="messageInformatif" ></p>
		</div>
		
	</form>
</body>
</html>