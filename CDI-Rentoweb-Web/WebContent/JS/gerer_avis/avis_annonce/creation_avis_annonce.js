/**
 * JavaScript lier a la JSP de creation d'avis annonce
 * 
 * @author Aurélien
 * @version 1
 * @since 09/03/2017
 * 
 */

/**
 * Vide le textarea commentaire du texte qui s'y trouve par defaut.
 * 
 * @author Aurélien
 * @version 1
 * @since 09/03/2017
 * 
 */
function cleanCommentaire(element){
	
	//console.log("Clean Commentaire");
	
	element.innerHTML = "";
	
	//console.log("Element : " + element)
	
}

/**
 * Controle que tout les champs qui doivents etre renseigner par l'utilisateur le sont et affiche a l'utilisateur les champs qui n'ont pas etait renseigner.
 * 
 * @see creationSpanMessageErreur
 * @returns boolean true si tout les note son toute renseigner et que le commentaire a était écris.
 * 
 * @author Aurélien
 * @version 1
 * @since 09/03/2017
 * 
 */
function controleAvisComplet(){
	
	//console.log('controleAvisComplet' + "Destruction du monde en cour mais secretement");
	
	var retour = true;
	
	var bruit_ext = document.getElementsByName('bruit_ext')[0];
	var bruit_int = document.getElementsByName('bruit_int')[0];
	var isole_froid = document.getElementsByName('isole_froid')[0];
	var isole_chaud = document.getElementsByName('isole_chaud')[0];
	var humidite = document.getElementsByName('humidite')[0];
	var luminosite = document.getElementsByName('luminosite')[0];
	var etat_gene = document.getElementsByName('etat_gene')[0];
	var relation_bailleur = document.getElementsByName('relation_bailleur')[0];
	var commentaire = document.getElementsByName('commentaire')[0];
	
	/*console.log("Note : [" 
			+ "bruit_ext : " + bruit_ext.value
			+ "bruit_int : " + bruit_int.value
			+ "isole_froid : " + isole_froid.value
			+ "isole_chaud : " + isole_chaud.value
			+ "humidite : " + humidite.value 
			+ "luminosite : " + luminosite.value
			+ "etat_gene : " + etat_gene.value 
			+ "relation_bailleur : " + relation_bailleur.value
			+ "]");*/
	
	//console.log("Commentaire : [" + commentaire.value + "]");
	
	//Controle de tout les champs obligatoire (recuperer si dessu)
	//TODO Trop de IF pensez a ameliorer ce controle
	if(bruit_ext.value == "" || bruit_int.value == "" || isole_froid.value == "" || isole_chaud.value == "" || humidite.value == "" || luminosite.value == "" || etat_gene.value == "" || relation_bailleur.value == "" || commentaire.value == ""){
		
		//console.log("Attention attention vous n'avez pas tout renseigner c'est pas bien le lapin devoreur de monde va venir vous mangez")
		
		retour = false;
		var messageInformatif = "Vous avez oubli\351 de renseigner les champs suivant : ";
		
		if(bruit_ext.value == ""){
			
			messageInformatif = messageInformatif + "note bruit exterieur ";
			
		}
		
		if(bruit_int.value == ""){
			
			messageInformatif = messageInformatif + "note bruit interieur ";
			
		}

		if(isole_froid.value == ""){
			
			messageInformatif = messageInformatif + "note isolation froid ";
			
		}

		if(isole_chaud.value == ""){
			
			messageInformatif = messageInformatif + "note isolation chaud ";
			
		}

		if(humidite.value == ""){
			
			messageInformatif = messageInformatif + "note humidite ";
			
		}

		if(luminosite.value == ""){
			
			messageInformatif = messageInformatif + "note luminosite ";
			
		}

		if(etat_gene.value == ""){
			
			messageInformatif = messageInformatif + "note etat general ";
			
		}

		if(relation_bailleur.value == ""){
			
			messageInformatif = messageInformatif + "note relation bailleur ";
			
		}

		if(commentaire.value == ""){
			
			messageInformatif = messageInformatif + "le commentaire ";
			
		}
		
		//console.log("Voila tout ce que vous avez pas fait :O :O :O : " + messageInformatif)
		var textNodeMessageInformatif = document.createTextNode(messageInformatif);
		var elementMessageInformatif = document.getElementById('messageInformatif');
		
		elementMessageInformatif.textContent = "";
		elementMessageInformatif.appendChild(textNodeMessageInformatif);
		
	}
	
	return retour;
}