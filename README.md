pedretes
========

Joc de les pedretes adaptat per programadors

La història
===========

Fa molts anys a les planuries del cetiti hi vivia la tribu dels indis Ittis. Eren una tribu noble que vivia en harmonia seguint els manaments que el gran esperit els hi havia deixat escrits en  el pergamí blanc. 
Aquesta tribu tenia una tradició. Un cop a l'any s'enfrontaven en la lliga del 'Joc de les pedretes ' per  veure qui era l'indi més audaç. Aquest joc consistia, i consisteix en:

Es disposen tres pilots de pedres amb un nombre  aleatori d'aquestes cada un. Hi ha dos jugadors i guanya el que tregui l'última pedra. És juga per torns i a cada torn el jugador ha de treure un mínim d'una pedra d'un pilot i pot treure el mateix nombre de pedres de qualsevol combinació dels tres pilots. Es a dir, pot treure 1 pedra del primer pilot, dues pedres dels dos primers pilots o deu de tots.
Com que anem curts de pedres hem implementat una versió per a ordinador del joc on cada indi pot programar una estratègia per a jugar-hi. El podem descarregar de github
gienini/pedretes
Per a fer-ho només hae de crear una classe que implementi l'interfície jugable i deixar-la  al paquet de jugadors.  L'interfície jugable ens fa implementar un mètode. El mètode jugar, és així:

public Jugada fesJugada(int x, int y, int z, int torn);

x,y i z són els tres pilons de pedres i l'arbitre ens donarà el valor que tenen actualment, torn es el numero de torn en que estem. L'arbitre esperarà que li retornem una Jugada

Jugada(int n, boolean x, boolean y, boolean z)

on int n és el numero de pedres que volem treure i els booleans x,y i z indiquen de quines piles volem treure pedres. Amb el projecte hi han uns quants jugadors d'exemple.
Tots els jugadors que estiguin al paquet jugadors s'enfronten en el campionat. El camionat consisteix en una lliga de tres enfrontaments. Els enfrontaments es poden guanyar, perdre o perdre per eliminació. Si es guanya s'ens dona 1 punt, si es perd -1 un punt i si ens eliminen -2 punts. Si un jugador triga més de 6 segons o fa una jugada il•legal és eiminat (per la partida)

Per executar el campionat click dret a la classe Campionat i run as Java Application

Estructura del programa (més o menys)

![alt tag](http://oi59.tinypic.com/oho5ft.jpg)
