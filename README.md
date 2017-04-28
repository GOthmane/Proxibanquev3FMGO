
Comment lancer l'application Java ProxiBanqueV3

## Pré-requis:
	- Machine cible dotée d'un systeme d'exploitation Windows.
		
	- Installer un serveur d'application Tomcat 9 sur la machine cible et s'assurer qu'il est lancé.

	(Téléchargé depuis : http://tomcat.apache.org/download-90.cgi)
			
	- Installer un serveur de base de donnée mySQL sur la machine cible et s'assurer qu'il est lancé.
		
	(Par exemple WAMPserver permet d'en installer un, il est téléchargeable depuis http://www.wampserver.com/)
			
	- Créer une base de donnée nommée : "bddtest", définir son encodage "utf8_general_ci" et importer le fichier
	bddtest.sql située dans le dossier ressource à la racine du dossier GitHub.
		
	(En utilisant par exemple phpMyAdmin fournit dans WAMPserver)
## Execution :
				
	- Copier le fichier "livraison\Proxibanquev3FMGO.war" dans le repertoire "webapps" de Tomcat
		
	(ex: C:\apache-tomcat-9.0.0.M19\webapps, si Tomcat est installé dans C:\apache-tomcat-9.0.0.M19)
			
	- Accéder à l'application par un navigateur via l'url suivante "http://localhost:8085/Proxibanquev3FMGO/"
		
	(le port 8085 dépend de votre configuration Tomcat)
	
	- Par défaut il y a deux conseillers dans la base
		login : login1
		mot de passe : pwd1
		
		login : login2
		mot de passe : pwd2

## Consulter la documentation: 
	- Double-cliquer sur le fichier index.html se trouvant dans le repertoire "doc" livré avec le fichier jar.

## Consulter les fichiers mockup: aller dans le dossier portant le meme nom et ouvrir les documents (*.bmpr).

## fonctions implémentées : [login] conseillers / [modifier/supprimer/lister]client écrans 1 à 3.