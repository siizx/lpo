// 1) Definire la funzione generica genSum : (int -> int) -> int -> int tale che genSum f n calcola f 0 + f 1 + ... + f n. 

let square n = n * n;;
let cube n = n*n*n;;

let rec genSum f n =
    if n<0 then 0 else f n + genSum f (n-1);;

let squareSum n = 
    genSum square n;;
squareSum 3;;

let cubeSum n =
    genSum cube n;;
cubeSum 3;;


// =====================================================================
// =====================================================================

// 2) Definire la funzione generica genProd : (int -> int) -> int -> int tale che genProd f n calcola f 0 * f

let rec genProd f n =
    if n<2 then 1 else f n * genProd f (n-1);;

let rec fact n =
    if n<2 then 1 else n * fact (n-1);;
fact 5;;

let rec twoRaisedTo n =
    if n<1 then 1 else 2 * twoRaisedTo (n-1);;
twoRaisedTo 3;; 

