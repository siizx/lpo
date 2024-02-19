// sum is not tail recursive
let rec sum = function
    | hd::tl -> hd + sum tl (* last operation: addition *)
    | _ -> 0;;

// loop is tail recursive
let rec loop acc = function
    | hd::tl -> loop (acc+hd) tl (* last operation: recursive call *)
    | _ -> acc;;

// Efficient definition of sum
let accSum =
    let rec loop acc = (* loop: int -> int list -> int *)
        function
            | hd::tl -> loop (acc+hd) tl
            | _ -> acc
    loop 0;;
val accSum: (int list -> int)



// Efficient definition of reverse

let a = [1;2;3;4;5;6];;

let accRev ls =
    let rec loop acc = function
        | hd::tl -> loop (hd::acc) tl
        | [] -> acc // anche _ va bene al posto di []
    loop [] ls;;
accRev a;;

List.rev a;; // la rev come altre ffunzioni sono gia pre-definite nel linguaggio.


////// List.map funzione lista;; applica una funzione ad ogni
////// elemento della lista.
let inc a = a+1;; // funzione che incrementa il valore passato 'a', di 1
List.map inc a;; // applico inc a tutti gli elementi di una lista

// oppure
let a = [1;2;3;4;5;6];;
List.map ((+)1) a;; // uguale a sopra, ma senza creare la funzione inc
// ^^^ vuole le parentesi attorno al +

// A possible efficient definition with tail recursion
let map f =
    let rec loop acc = function (* acc contains a list *)
        | hd::tl -> loop (f hd::acc) tl (* f hd is the head of acc*)
        | _ -> List.rev acc //questa riga copre i casi in cui nella lista siano rimasti 1 o 0 elementi
    loop []
// e' l'equivalente di List.map inc ls
let ls = [1;2;3;4;5;6];;
let inc a = a+1;;
map inc ls


// o ancora
List.map String.length ["apple"; "orange" ];;


/////// fold (tail recursion)

let fold f =
    let rec loop acc = function
        | hd::tl -> loop (f acc hd) tl // diventerebbe: (+) acc hd, cioe' acc+hd
        | _ -> acc
    loop

let a = [1;2;3;4;5;6];;

let sumList = fold (+) 0;; // (+) viene interpretato come funzione -> operazione binaria di addizione
sumList a;;




// ++++++++++ provo a ricostruire map a memoria/logica

let ls = List.init 7 (fun x -> x+1);;
let inc a = a+1;;

let mapInc f l =
    let rec loop acc =
        function 
            | h::t -> loop (acc@[f h]) t
            | [] -> acc
    loop [] l

mapInc inc ls;;