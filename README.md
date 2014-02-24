TP Crypto RSA
=============
-------------------------------------------------------------------
		AVET Anthony DURAZ Aurélien
-------------------------------------------------------------------

En ce qui concerne le point d'avancement du TP, celui-ci est terminé, nous arrivons a généré des clés, crypter des message, decrypter des messages et vérifier une signature.

Le projet contient différents points d'entrèes:

Gencle
------

Cette classe permet de Generer un couple de clé public et privé. Pour cela elle utilise les méthodes de la classe Fonctions. Les clées ainsi que les valeurs générées sont écrites dans le fichier "essai.priv".

Chiffre
-------

Cette classe permet de crypter un message. Elle utilise le fichier "essai.priv" pour obtenir la clée publique necessaire à l'encryptage du message. Le message crypté est placé dans "crypt.priv".

DeChiffre
-------

Cette classe permet de décrypter un message. Elle utilise le fichier "essai.priv" pour obtenir la clée privé necessaire pour decrypter le message placé dans le fichier "crypt.priv".

Signature
--------

Cette classe nous permet de jouer l'ensemble d'une communication entre deux personnes:
- generation des clés des deux personnes
- Cryptage du message
- Cryptage du sha1 
- Decryptage du message
- Decryptage du sha1
- Verification des deux Sha1

Exemple d'utilisation : 
-taille des blocs : 512, 1024
- mot a envoyer : Bonjour ceci est le message crypté que je vous ai envoyé, Adversus periculum naturalis ratio permittit se defendere
