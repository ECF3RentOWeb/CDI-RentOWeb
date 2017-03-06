<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<!-- IMPORT CSS/JS -->
	<link href="../../../CSS/gerer_avis/avis_annonce/avis_annonce.css" rel="stylesheet" type="text/css"/>
	<link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.css" rel="stylesheet">
	<link href="../../../CSS/gerer_avis/avis_annonce/star-rating.css" rel="stylesheet" type="text/css"/>
	<script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.0/jquery.js"></script>
	<script type="text/javascript" src="../../../JS/gerer_avis/avis_annonce/star-rating.js">

</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Creation commentaire</title>
</head>
<body>
<!-- Note -->
	<div class="note">
		<div class="bruit_ext">
		    <label for="input-1" class="control-label">Bruit Exterieur</label>
   			<input id="input-1" name="input-1" class="rating rating-loading" data-min="0" data-max="5" data-step="1" data-size="xs">
		</div>
		<div class="bruit_int">
			<input type="radio" name="stars_bruit_int" value="0" />
			<input type="radio" name="stars_bruit_int" value="1" />
			<input type="radio" name="stars_bruit_int" value="2" checked="checked" />
			<input type="radio" name="stars_bruit_int" value="3" />
			<input type="radio" name="stars_bruit_int" value="4" />
		</div>
		<div class="isole_froid">
			<input type="radio" name="stars_isole_froid" value="0" />
			<input type="radio" name="stars_isole_froid" value="1" />
			<input type="radio" name="stars_isole_froid" value="2" checked="checked" />
			<input type="radio" name="stars_isole_froid" value="3" />
			<input type="radio" name="stars_isole_froid" value="4" />
		</div>
		<div class="isole_chaud">
			<input type="radio" name="stars_isole_chaud" value="0" />
			<input type="radio" name="stars_isole_chaud" value="1" />
			<input type="radio" name="stars_isole_chaud" value="2" checked="checked" />
			<input type="radio" name="stars_isole_chaud" value="3" />
			<input type="radio" name="stars_isole_chaud" value="4" />
		</div>
		<div class="humidite">
			<input type="radio" name="stars_humidite" value="0" />
			<input type="radio" name="stars_humidite" value="1" />
			<input type="radio" name="stars_humidite" value="2" checked="checked" />
			<input type="radio" name="stars_humidite" value="3" />
			<input type="radio" name="stars_humidite" value="4" />
		</div>
		<div class="luminosite">
			<input type="radio" name="stars_luminosite" value="0" />
			<input type="radio" name="stars_luminosite" value="1" />
			<input type="radio" name="stars_luminosite" value="2" checked="checked" />
			<input type="radio" name="stars_luminosite" value="3" />
			<input type="radio" name="stars_luminosite" value="4" />
		</div>
		<div class="etat_gene">
			<input type="radio" name="stars_etat_gene" value="0" />
			<input type="radio" name="stars_etat_gene" value="1" />
			<input type="radio" name="stars_etat_gene" value="2" checked="checked" />
			<input type="radio" name="stars_etat_gene" value="3" />
			<input type="radio" name="stars_etat_gene" value="4" />
		</div>
		<div class="relation_bailleur">
			<input type="radio" name="stars_relation_bailleur" value="0" />
			<input type="radio" name="stars_relation_bailleur" value="1" />
			<input type="radio" name="stars_relation_bailleur" value="2" checked="checked" />
			<input type="radio" name="stars_relation_bailleur" value="3" />
			<input type="radio" name="stars_relation_bailleur" value="4" />
		</div>
	</div>
	<br/>
<!-- Commentaire -->
	<div class="commentaire">
		<textarea rows="10" cols="50" name="commentaire">Votre commentaire...</textarea>
		
	
	</div>
	<br/>
<!-- Valider/Annuler -->
	<div class="action">
		<input type="button" name="valider" value="valider" />
		<input type="button" name="annuler" value="annuler" />
	</div>
</body>
</html>