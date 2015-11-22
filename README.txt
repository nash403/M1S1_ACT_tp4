Nintunze Honoré & Petit Antoine

I) Qu'est-ce qu'une propriété NP ?
1) 
Certificat : Un tableau de taille n contenant toutes les villes (pas de doublon autorisé). 

Dans l'implémentation les villes correspondront à leurs positions dans le tableau en entrée.

Le certifcat est effectivement bornée par la taille de l'entrée : 
ça taille est n, et celle de l'entrée est n².

Algorithme de vérification : 
	Pour i allant de 0 à n-2
		on ajoute D[i,i+1] au résultat
	On ajoute D[n-1, 0] au résultat
	On retourne résultat <= l

L'algorithme est en O(n), par conséquent il est polynomial par rapport à l'entrée.

2)1)
Algorithme de génération aléatoire de certificat :
	Créer un tableau ordonné de taille n (contenant des valeurs allant de 0 à n-1)
	Mélanger de manière aléatoire les cases du tableau

Cet algorithme permettra de produire tout les certificats possible en respectant les contraintes décidés au départ. De plus cet algorithme devrait permettre d'avoir une génération uniforme des résultats.

2)2)
Algorithme non-déterministe polynomial :
	Générer un certificat aléatoire 
	Vérifier ce certificat

Cet algorithme retournera vrai si le certificat est valide, mais il retournera faux dans le cas contraire.
Cet algorithme générera donc des faux négatifs.

3)1)
Pour un n fixé, notre certificat peut prendre n! valeur

3)2)
Pour notre certificat nous prendrons l'ordonné de manière croissante.
Par conséquent le dernier certificat possible sera un tableau décroissant strictement.

3)3)
Algorithme du British Museum :
	résultat = faux
	Générer le premier certificat (contenant les valeurs allant de 0 à n-1)
	Tant que résultat != faux & le certificat n'est pas le dernier
		résultat = vérification du certificat
		certificat = certificat suivant (par rapport à l'ordre décidé précédemment)
	Si résultat = faux retourne vérification certificat (pour tester le dernier)
	Sinon retourne résultat

II) Réductions polynomiales
4)1)
HamiltonCycle <=p TSP

En transformant le tableau en entrée d'HamiltonCycle de la manière suivante on peut le faire résoudre par les mêmes algorithme que TSP :
	On parcours le tableau de booléen : 
		Si c'est vrai alors on transforme en 1
		Sinon on transforme en une valeur plus grande

De plus on indique que l est égale à n.

La transformation est polynomiale par rapport à la taille de l'entrée, en effet elle s'effectue en O(n²) et l'entrée est de taille n².

Cette transformation résout bien HamiltonCycle, en effet, TSP retourne vrai si et seulement si on arrive à parcourir tout les villes et retourner à notre points de départ en parcourant une distance plus petite que l. Or avec la transformation effectuée on peut avoir un résultat vrai seulement en passant avec les chemins à 1 (en effet en prenant un autre chemin on dépassera forcément). 
Quand on retourne vrai on a réussi à parcourir tout les points et retourner au point de départ. On a donc effectuer un HamiltonCylcle.

4)3) 
Sachant que HamiltonCycle est connues pour être NP-complet.
Si on arrive à le réduire dans un autre problème cela veut dire que cet autre problème est au moins aussi difficile que lui.
Par conséquent TSP est NP-dur.
De plus TSP est NP, il est donc NP-complet.

4)4)
Sachant que TSP et HamiltonCycle sont tout deux NP-complet on peut dire que TSP se réduit polynomialement dans HamiltonCycle, car la propriété des problèmes NP-dur c'est qu'on peut réduire tout problème NP en eux. Or être NP-complet c'est être à la fois NP-dur et NP-complet.

5)1)