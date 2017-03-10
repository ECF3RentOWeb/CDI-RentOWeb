<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="fr">
<!-- <%@page import="rtw.entity.gererAvis.avisAnnonce" %> -->
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

<!-- Récupération de l'avis a modifier -->
<!-- <jsp:useBean id="name" scope="request" class="rtw.entity.gererAvis.avisAnnonce"></jsp:useBean> -->

<!-- Formulaire de creation d'un avis utilisateur -->
	<form method="get" action="#" onsubmit="return controleAvisComplet()">
<!-- Note -->
<div class="note">
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
		
<!-- Stars Note -->
<!-- Gerer grace a Boostrap/JQuery/krajee voir http://plugins.krajee.com/star-rating -->
		<div class="starsNote">
   			<input id="bruit_ext" name="bruit_ext" class="rating rating-loading" value="<%= %>" data-min="0" data-max="5" data-step="1" data-size="xs">
   			<input id="bruit_int" name="bruit_int" class="rating rating-loading" value="<%= %>" data-min="0" data-max="5" data-step="1" data-size="xs">
   			<input id="isole_froid" name="isole_froid" class="rating rating-loading" value="<%= %>" data-min="0" data-max="5" data-step="1" data-size="xs">
   			<input id="isole_chaud" name="isole_chaud" class="rating rating-loading" value="<%= %>" data-min="0" data-max="5" data-step="1" data-size="xs">
   			<input id="humidite" name="humidite" class="rating rating-loading" value="<%= %>" data-min="0" data-max="5" data-step="1" data-size="xs">
   			<input id="luminosite" name="luminosite" class="rating rating-loading" value="<%= %>" data-min="0" data-max="5" data-step="1" data-size="xs">
   			<input id="etat_gene" name="etat_gene" class="rating rating-loading" value="<%= %>" data-min="0" data-max="5" data-step="1" data-size="xs">
   			<input id="relation_bailleur" name="relation_bailleur" class="rating rating-loading" value="" data-min="0" data-max="5" data-step="1" data-size="xs">
		</div>
</div>
	
<!-- Commentaire -->
		<div class="commentaire">
			<textarea rows="15" cols="100" name="commentaire" onfocus="cleanCommentaire(this)"><%= %></textarea>
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