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
let inc a = a+1;; 
List.map inc a;;

// oppure
let a = [1;2;3;4;5;6];;
List.map ((+)1) a;;

// A possible efficient definition with tail recursion
let map f =
    let rec loop acc = function (* acc contains a list *)
        | hd::tl -> loop (f hd::acc) tl (* f hd is the head of acc*)
        | _ -> List.rev acc (* reverses the list *)
    loop []
// ^ non capito. da rivedere.

// o ancora
List.map String.length ["apple"; "orange" ];;



/////// fold (tail recursion)

let fold f =
    let rec loop acc = function
        | hd::tl -> loop (f acc hd) tl
        | _ -> acc
    loop



let a = [1;2;3;4;5;6];;

let sumList = fold (+) 0;;
sumList a;;




