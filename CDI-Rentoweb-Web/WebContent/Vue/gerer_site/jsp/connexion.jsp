<%@ page pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Connexion d'un utilisateur</title>
</head>
<body>
	<p>Vous pouvez vous connecter en renseignant le formulaire
		ci-dessous</p>
	<form method="post" action="../connexion">
		<fieldset>
			<legend>Connexion</legend>
			<label for="email">Adresse émail <span class="requis">*</span></label>
			<input type="text" id="email" name="email" value="" size="20"<br/>
				maxlength="60" /> <br /> <label for="motdepasse">Mot de
				passe <span class="requis">*</span>
			</label> <input type="password" id="motdepasse" name="motdepasse" value=""
				size="20" maxlength="20" /> <br /> <span> <input
				type="reset" value="recommencer" class="sansLabel" /> <input
				type="submit" value="connexion" class="sansLabel" />
			</span>

		</fieldset>
	</form>
	<p>Mot de passe oublié ?</p>
	<p>Inscription</p>
</body>
</html>