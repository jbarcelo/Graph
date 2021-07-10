# Graph

Aquest repo conté dos programes. 

El primer, Graph, fa una cerca en un graf
definit per una matriu d'adjacència.

El segon, GitHubGraph, fa una cerca en el graf d'usuaris de githbub.
Aquest segon està limitat pel fet que la API de GitHub imposa un màxim de 60 consultes per hora.
És molt fàcil arribar a aquesta xifra si recorrem el graf d'usuaris.

Seguidament es mostren exemples d'execució dels dos programes.

jbarcelo@jbarcelo-Inspiron-5570:~/development/repos/Graph$ java Graph 
------------------------------
Looking for neighbors at distance: 1
Looking for neighbors of node 0
Node 1 is adjacent
Node 1 is not in our list. We add it.
At this point we should verify if the new node satisfied the search condition.
Node 2 is adjacent
Node 2 is not in our list. We add it.
At this point we should verify if the new node satisfied the search condition.
newNeighbors found: 2
------------------------------
Looking for neighbors at distance: 2
Looking for neighbors of node 1
Node 0 is adjacent
Node 3 is adjacent
Node 3 is not in our list. We add it.
At this point we should verify if the new node satisfied the search condition.
Looking for neighbors of node 2
Node 0 is adjacent
Node 3 is adjacent
newNeighbors found: 1
------------------------------
Looking for neighbors at distance: 3
Looking for neighbors of node 3
Node 1 is adjacent
Node 2 is adjacent
Node 4 is adjacent
Node 4 is not in our list. We add it.
At this point we should verify if the new node satisfied the search condition.
newNeighbors found: 1
------------------------------
Looking for neighbors at distance: 4
Looking for neighbors of node 4
Node 3 is adjacent
Node 5 is adjacent
Node 5 is not in our list. We add it.
At this point we should verify if the new node satisfied the search condition.
newNeighbors found: 1
------------------------------
Looking for neighbors at distance: 5
Looking for neighbors of node 5
Node 4 is adjacent
newNeighbors found: 0


jbarcelo@jbarcelo-Inspiron-5570:~/development/repos/Graph$ java -cp json-20210307.jar:. GitHubGraph   
IMPORTANT: The GitHub API is limited to 60 requests/hour. If we reach that limit the program will fail  
Enter the user to start the search:  
jbarcelo  
Enter the user to search:  
jfisteus  
------------------------------  
Looking for neighbors at distance: 1  
Looking for neighbors of node jbarcelo  
Node mitar is adjacent  
Node mitar is not in our list. We add it.  
Node jfisteus is adjacent  
We found jfisteusat distance 1  

