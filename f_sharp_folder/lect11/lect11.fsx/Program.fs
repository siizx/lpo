// For more information see https://aka.ms/fsharp-console-apps
let pippo = (54,98);; // una coppia di interi
fst pippo;; // estrae il primo elemento della coppia
snd pippo;; // estrae il secondo elemento della coppia

let pippo = (1,2);;


let x = 3;;
// funzoine double. moltiplica y (argomento passato alla chiama della funzione) per x (variabile locale).
// the declaration of local variable x in double shadows the top-level x.
let double y = // questa indentazione è obbligatoria
    let x = 2 
    y*x;;
double 4;;

// altro esempio di funzioni piu elaborate:
let y = 2;
let getFun i =
    let x = 2*i
    fun y->y+x;;
// getFun si aspetta quindi 2 argomenti.
let f2 = getFun 2;;

f2 3;; // 3 è il secondo argomento della funzione getFun, che è una funzione che prende un argomento e lo somma a x.

// =================================================================================
// =================================================================================


// BOOLEANS

1<0 && 0/0>0;; // false. qua non da errorei perche la prima condizione è falsa, quindi non valuta la seconda.
0/0>0 && 1<0;; // errore: attempt to divide by zero.

////////// RECURSIVE FUNCTIONS: REC KEYORD + IF THEN ELSE. PAG 16/22

// example 1
//let sumSquare n =
//    if n<0 then 0 else n*n+sumSquare(n-1);; (*sumSquare not defined on the right-hand side*)
// Siccome la funzione non e' stata definita con let rec, non puo' essere chiamata ricorsivamente.


// =================================================================================
// =================================================================================


// example 2
let rec sumSquare n =
    if n<0 then 0 else n*n+sumSquare(n-1);; (*sumSquare defined on the right-hand side*)

let rec sumCube n =
    if n<0 then 0 else n*n*n+sumCube(n-1);; (*sumCube defined on the right-hand side*)

// queste due funzioni sono molto simili, quindi possiamo definire 
// una funzione generica 'genSum' che prende come argomento una funzione.

let square x = x * x
let cube x = x * x * x


let rec genSum f n =
    if n < 0 then 0 else f n + genSum f (n - 1);;


let sumSquare = genSum square
let sumCube = genSum cube

sumSquare 3;; // = 14



// =================================================================================
// funzione fattoriale
let rec pp p =
    if p<2 then 1 else p*pp(p-1);;
pp 5;;
// =================================================================================




// =================================================================================
// =================================================================================

////// LISTE

let ls = 2::3::4::[];; // lista di interi
printfn "%A" ls;;

let ls2 = 5::6::7::8::[];;
printfn "%A" ls2;;

let lsls = (1::[])::(3::4::[])::(45::32::[])::[];; // lista di liste di interi
printfn "%A" lsls;;

// concateno le liste
let catls = ls@ls2;;
printfn "%A" catls;;