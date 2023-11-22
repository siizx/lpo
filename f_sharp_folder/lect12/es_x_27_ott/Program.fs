// 1) Definire la funzione interval : int -> int -> int list tale che interval a b 
// restituisce la lista ordinata corrispondente all'intervallo dei numeri interi compresi 
// tra a e b, estremi inclusi.

let rec interval x y =
    if x > y then []
    else interval x (y-1) @ [y];;
interval (-2) 5;;

// =================================================

// 2) Provare a definire per casi le seguenti funzioni su liste, mostrando i pattern che individuano i 
// vari casi e le espressioni che corrispondono al valore che deve essere restituito.

//    a) La funzione length: 'a list -> int che calcola la lunghezza di una lista.
let rec lenght a =
    match a with 
        | _::t -> 1 + lenght t
        | [] -> 0;;
    
let lst = [4;6;8;2;0];;
lenght lst;;

//    b) La funzione sum: int list -> int che calcola la somma di tutti gli elementi di una lista.

let rec sum a =
    match a with
        | h::t -> h+sum t
        | [] -> 0;;

let lst = [4;6;8;2;0];;
sum lst;;


// c) La funzione swap: 'a list -> 'a list che restituisce la lista dove i 
//    primi due elementi sono stati

let swap a = 
    match a with
        | [] -> a;
        | x::y::t -> y::x::t;;

let lst = [4;6;8;2;0];;
swap lst;;

