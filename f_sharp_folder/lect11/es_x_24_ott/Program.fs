// 1) Definire la funzione generica genSum : (int -> int) -> int -> int tale che genSum f n calcola f 0 + f 1 + ... + f n.

let square n = n * n //funzione quadro
let cube n = n * n * n // funzione cubo

let rec genSum f n = // funzione GENERICA RICORSIVA con 2 parametri: f funzione (cue/square) e n valore
    if n < 0 then 0 else f n + genSum f (n - 1)

let squareSum n = // funzione specifica. passa a genSum la funzione square e un valore n.
    genSum square n

squareSum 3 // chiamata di funzione con argomento 3.
printfn "squareSum 3 = %d" (squareSum 3)

let cubeSum n = //  altra funzione specifica. passa a gensum la funzione cube e un valore n.
    genSum cube n

cubeSum 3 // altra chiamata di funzione con argomento 3.
printfn "cubeSum 3 = %d" (cubeSum 3)

// =====================================================================
// =====================================================================

// 2) Definire la funzione generica genProd : (int -> int) -> int -> int tale che genProd f n calcola f 0 * f

let rec genProd f n =
    if n < 2 then 1 else f n * genProd f (n - 1)

let rec fact n = if n < 2 then 1 else n * fact (n - 1)
fact 5

let rec twoRaisedTo n =
    if n < 1 then 1 else 2 * twoRaisedTo (n - 1)

twoRaisedTo 3















//
// RIPASSO PRE ESAME
//
// 2) Definire la funzione generica genProd : (int -> int) -> int -> int tale che genProd f n calcola f 0 * f

let rec genProd f n = //  funzione GENERICA RICORSIVA
    if n < 2 then 1 else f n * genProd f (n - 1)

let square n = n * n

let squareProd n = genProd square n

printfn "~ squareProd(3) = %d" (squareProd 3)
