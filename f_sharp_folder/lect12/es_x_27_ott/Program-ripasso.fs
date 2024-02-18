// ++++++ RIPASSO LPO PER ESAME +++++

// 1) Definire la funzione interval : int -> int -> int list tale che interval a b
// restituisce la lista ordinata corrispondente all'intervallo dei numeri interi compresi
// tra a e b, estremi inclusi.

let rec interval a b =
    if a > b then [] else interval a (b - 1) @ [ b ]

let result = (interval 4 9)

let rec printList l =
    match l with
    | [] -> ()
    | h :: t ->
        printf "%d" h
        printList t

printList result

// =================================================

// 2) Provare a definire per casi le seguenti funzioni su liste, mostrando i pattern che individuano i
// vari casi e le espressioni che corrispondono al valore che deve essere restituito.

//    a) La funzione length: 'a list -> int che calcola la lunghezza di una lista.

let l = [ 1; 2; 3; 4; 5; 6; 7 ] // ATTENZIONE, qua la virgola forma i tuples, mentre il punto e virgola separa gli elementi.

let rec length l =
    match l with
    | [] -> 0
    | _ :: t -> 1 + length t

printfn "length l = %d" (length l)


//    b) La funzione sum: int list -> int che calcola la somma di tutti gli elementi di una lista.

let l = [ 1; 3; 6 ]

let rec sumList l =
    match l with
    | [] -> 0
    | h :: t -> h + sumList t

printfn "~~ sumList l = %d" (sumList l) // IMPORTANTE: ricorda le parentesi.



// c) La funzione swap: 'a list -> 'a list che restituisce la lista dove i
//    primi due elementi sono stati scambiati

let l = [ 1; 2; 3; 4; 5 ]

let rec swap l =
    match l with
    | [] -> []
    | x :: [] -> [ x ] // se la lista ha un solo elemento, ritorno la lista
    | x :: y :: t -> y :: x :: t

let rec printl l =
    match l with
    | [] -> printfn ""
    | h :: t ->
        printf "%d" h //  attenzione a non dimenticare '"%d" h'
        printl t

printf "~ Ecco la lista dopo lo swap: "
printl (swap l)
