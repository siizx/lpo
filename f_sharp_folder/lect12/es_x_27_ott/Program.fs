// 1) Definire la funzione interval : int -> int -> int list tale che interval a b
// restituisce la lista ordinata corrispondente all'intervallo dei numeri interi compresi
// tra a e b, estremi inclusi.

let rec interval x y = // RICORSIVA. 2 argomenti, che sono 2 valori appartenenti ad N (numeri naturali)
    if x > y then
        [] // se x > y, restituisco la lista vuota.
    else
        interval x (y - 1) @ [ y ] // altrimenti ritorno, la ricorsione e la concatenazione dell'ultimo elemento dell'intervallo, sotto forma di elemento di una lista -> @[y] = elemento della lista

interval (-2) 5 //  testo la funzione.

// =================================================

// 2) Provare a definire per casi le seguenti funzioni su liste, mostrando i pattern che individuano i
// vari casi e le espressioni che corrispondono al valore che deve essere restituito.

//    a) La funzione length: 'a list -> int che calcola la lunghezza di una lista.
let rec lenght a = // ricorsiva. 1 paramentro
    match a with // il match, "matcha" a seconda del caso.
    | _ :: t -> 1 + lenght t // se la lista non e; vuota ritorno 1 ('_', cioe': qualunque sia l'elemento prima di t (tail)) + lenght t cioe' lunghezza di tail.
    | [] -> 0 //  se la lisa e' vuota.

let lst = [ 4; 6; 8; 2; 0 ] // creo una lista da utilizzare come argomento
lenght lst //  e qua la testo.

//    b) La funzione sum: int list -> int che calcola la somma di tutti gli elementi di una lista.

let rec sum a = // somma ricorsiva degli elemanti di un a lista.
    match a with // matcho a per casi
    | h :: t -> h + sum t // se la lista non e' vuota: ritorno elemento head + somma di tail.
    | [] -> 0 // se la lista e' vuota, ritorno 0.

let lst = [ 4; 6; 8; 2; 0 ] //creo una lista da dare in pasto come argomento.
sum lst


// c) La funzione swap: 'a list -> 'a list che restituisce la lista dove i
//    primi due elementi sono stati scambiati. Se la lista ha meno di due elementi,
//    la funzione restituisce la lista originale senza modifiche.

let swap a =
    match a with
    | [] -> a // se la lista e' vuota, ritorna a, cioe' la stessa lista vuota.
    | x :: y :: t -> y :: x :: t // se non e' vuota, ritorna la lista con i primi due elementi scambiati

let lst = [ 4; 6; 8; 2; 0 ]
swap lst
