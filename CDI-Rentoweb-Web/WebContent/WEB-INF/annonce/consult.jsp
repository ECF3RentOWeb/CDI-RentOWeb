<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang=fr>
    <head>
        <title>Consultation annonce</title>
         <link rel="stylesheet" href="${pageContext.request.contextPath}/annonce/style.css" />
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    </head>
    <body>
    
    <%-- Include banner --%>
	<!--<jsp:include page="/WEB-INF/include/header.html" />-->

	<!-- Include main menu -->
	<jsp:include page="/WEB-INF/include/menu_haut_particulier.html" />


	    <div class="container">
      <header class="row">
        <div class="col-sm-12">
          Entete
        </div>
      </header>
      <div class="row">
        <div class="col-sm-12">
          Menu
        </div>
        </div>      
      <div class="row">
        <nav class="col-sm-2">
          Menu
        </nav>
        <section class="col-sm-10">
          Section
          <div class="row">
              <p>
            Je suis passionn� par les <strong>tigres</strong> depuis tr�s longtemps. Ce site a �t� construit en <em>hommage � ces merveilleux f�lins...</em><br>
            Je fais partie de la <abbr title="Soci�t� des Amoureux des Tigres">SAT</abbr> qui a pour but de faire conna�tre ces splendides animaux. 
          </p>
          <p>Voici ce qu'en dit le wikipedia :</p>
            <blockquote>
              Le Tigre (Panthera tigris) est un mammif�re carnivore de la famille des f�lid�s (Felidae) du genre Panthera. 
Ais�ment reconnaissable � sa fourrure rousse ray�e de noir, il est le plus grand f�lin sauvage et l'un des plus grands carnivores du monde. 
L'esp�ce est divis�e en neuf sous-esp�ces poss�dant des diff�rences mineures en termes de taille ou de comportement. Superpr�dateur, 
il chasse principalement les cerfs et les sangliers, bien qu'il puisse s'attaquer � des proies de taille plus importante comme les buffles. 
Jusqu'au XIXe si�cle, le Tigre �tait r�put� mangeur d'homme. La structure sociale des tigres en fait un animal solitaire ; 
le m�le poss�de un territoire qui englobe les domaines de plusieurs femelles et ne participe pas � l'�ducation des petits.<br>
              <small class="pull-right">Wikipedia</small><br>
            </blockquote>
            
          </div>
        </section>
      </div>
      <footer class="row">
        <div class="col-sm-12">
          Pied de page
        </div>
      </footer>
    </div>



                        
    <!--<jsp:include page="/WEB-INF/include/footer.html" />--> 

    </body>
	<script type="text/javascript" src="/WEB-INF/lib/bootstrap/js/bootstrap.min.js">
	</script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<link href="/WEB-INF/lib/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <link href="css/style.css" rel="stylesheet">
</html>