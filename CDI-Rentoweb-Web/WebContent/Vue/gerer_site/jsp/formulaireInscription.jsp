<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Formulaire d'inscription</title>
</head>
<body>
	<form method="post" action="../inscription">
		<fieldset>
			<legend></legend>
			<span>
			<label for="particulier">Particulier <input type="radio" name="radio" value="particulier"></label>
			<label for="professionnel">Professionnel <input type="radio" name="radio" value="professionnel"></label>
			</span>
			<input type="number" name="identifier">	
			<label for="email">Adresse émail <span class="requis">*</span></label>
			<input type="email" id="email" name="email" value="" size="20" maxlength="60" /> <br /> 
			<label for="motdepasse">Mot de passe <span class="requis">*</span></label> 
			<input type="password" id="motdepasse" name="motdepasse" value="" size="20" maxlength="20" /> <br /> 
			<label for="confirmation">Confirmation du mot de passe <span class="requis">*</span>
			</label> <input type="password" id="confirmation" name="confirmation" value="" size="20" maxlength="20" /> <br /> 
			<label for="nom"> Nom <span class="requis">*</span>
			</label> <input type="text" id="nom" name="nom" value="" size="20" maxlength="60" /> <br /> 
			<label for="prenom"> Prénom <span class="requis">*</span>
			</label> <input type="text" id="prenom" name="prenom" value="" size="20" maxlength="60" /> <br /> 
			<label for="tel">Numéro de téléphone <span class="requis">*</span>
			</label> <input type="tel" name="usertel" value="" size="10" maxlength="20" /> <br /> 
			<span> 
			<input type="reset" value="Recommencer" class="sansLabel" /> 
			<input type="submit" value="Inscription" class="sansLabel" />
			</span>

		</fieldset>
	</form>

</body>
</html>