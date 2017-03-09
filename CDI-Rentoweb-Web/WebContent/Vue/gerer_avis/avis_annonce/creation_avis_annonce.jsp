<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="fr">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	
	<!-- IMPORT CSS/JS -->
	<link href="../../../bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
	<link href="../../../CSS/gerer_avis/avis_annonce/star-rating.css" rel="stylesheet" type="text/css"/>
	<link href="../../../CSS/gerer_avis/avis_annonce/avis_annonce.css" rel="stylesheet" type="text/css"/>
	
	<script type="text/javascript" src="../../../JQuery/jquery-3.1.1.min.js"></script>
	<script type="text/javascript" src="../../../bootstrap/js/bootstrap.js"></script>
	<script type="text/javascript" src="../../../JS/gerer_avis/avis_annonce/star-rating.js"></script>
	<script type="text/javascript" src="../../../JS/gerer_avis/avis_annonce/creation_avis_annonce.js"></script>
	
	<!-- Titre de la page -->
	<title>Création avis utilisateur</title>

</head>

<body>

<!-- Formulaire de creation d'un avis utilisateur -->
	<form method="get" action="#" onsubmit="return controleAvisComplet()">
	
<!-- Label Note -->
		<div class="labelNote">
			<label for="bruit_ext" class="control-label">Bruit Extérieur :</label>
			<br>
			<label for="bruit_int" class="control-label">Bruit Intérieur :</label>
			<br>
			<label for="isole_froid" class="control-label">Isolation au froid :</label>
			<br>
			<label for="isole_chaud" class="control-label">Isolation au chaud :</label>
			<br>
			<label for="humidite" class="control-label">Humidité :</label>
			<br>
			<label for="luminosite" class="control-label">Luminosité :</label>
			<br>
			<label for="etat_gene" class="control-label">État général :</label>
			<br>
			<label for="relation_bailleur" class="control-label">Relation Bailleur :</label>
			<br>
		</div>
		
<!-- Note -->
<!-- Gerer grace a Boostrap/JQuery/krajee voir http://plugins.krajee.com/star-rating -->
		<div class="note">
   			<label for="bruit_ext" class="control-label">Bruit Extérieur :<input id="bruit_ext" name="bruit_ext" class="rating rating-loading"  data-min="0" data-max="5" data-step="1" data-size="xs"></label>
   			<input id="bruit_int" name="bruit_int" class="rating rating-loading"  data-min="0" data-max="5" data-step="1" data-size="xs">
   			<input id="isole_froid" name="isole_froid" class="rating rating-loading"  data-min="0" data-max="5" data-step="1" data-size="xs">
   			<input id="isole_chaud" name="isole_chaud" class="rating rating-loading"  data-min="0" data-max="5" data-step="1" data-size="xs">
   			<input id="humidite" name="humidite" class="rating rating-loading"  data-min="0" data-max="5" data-step="1" data-size="xs">
   			<input id="luminosite" name="luminosite" class="rating rating-loading"  data-min="0" data-max="5" data-step="1" data-size="xs">
   			<input id="etat_gene" name="etat_gene" class="rating rating-loading"  data-min="0" data-max="5" data-step="1" data-size="xs">
   			<input id="relation_bailleur" name="relation_bailleur" class="rating rating-loading"  data-min="0" data-max="5" data-step="1" data-size="xs">
		</div>
		
<!-- Commentaire -->
		<div class="commentaire">
			<textarea rows="15" cols="100" name="commentaire" onfocus="cleanCommentaire(this)">Votre commentaire...</textarea>
		</div>
		
<!-- Message information utilisateur -->
<p id="messageInformatif" ></p>

<!-- Valider/Annuler -->
		<div class="action">
			<input type="submit" name="valider" value="valider" />
			<input type="reset" name="annuler" value="annuler" />
		</div>
	</form>
</body>
</html>