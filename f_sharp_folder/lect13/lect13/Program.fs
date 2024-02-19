// length:

let a = [3;57;22;38;97;45];;

let rec length a =
    match a with
        | h::t -> 1+ length t
        | [] -> 0;;
length a;;

// sum

let rec sum a =
    match a with
        | h::t -> h + sum t
        | [] -> 0;;
sum a;;

let swap a =
    match a with 
        | x::y::t -> y::x::t
        | [x] -> [x]
        | [] -> [];;

swap a;;
printfn "%A" a;; // IMPORTANTE: %A stands for "any type"

let b = true;
let mynot p =
    match p with
        | true -> false
        | false -> true;;
 printfn "%A" (mynot b);; 

// OPPURE 
// let mynot = function | true -> false | false -> true;;
// printfn "%A" (mynot b);;

 let o = 0;;
 let isZero p =
    match p with
        | 0 -> true
        | _ -> false;;
printfn "%A" (isZero o);;

// IMPORTANT: the "function" keyword is a shorthand for defining a function that consists of a single pattern match on its input. It allows you to define a function and a pattern match in one step.

let ls = [78;67;87;90;4];;
let ordSwap =
    function 
        | x::y::tl as ls -> if x>y then y::x::tl else ls // "as ls" e' un alias che diamo alla lista x::y::tl, viene comoda per non dovera riscrivere tutta...
        | other -> other;;
ordSwap ls;;

let rec printl l =
    match l with
    | [] -> printfn ""
    | h :: t ->
        printf "%d" h //  attenzione a non dimenticare '"%d" h'
        printl t
printl (ordSwap ls)


// +++++++++

let c = 'a';;
System.Char.ToUpper c;;

// ======== Strings in F# =========
// Examples


//In F#, the ^ operator is used for string concatenation, but only when you're working with .NET Framework. However, in .NET Core and .NET 5+, the ^ operator is not recognized for string concatenation, and you should use the + operator instead.

//let s2 = "hello" ˆ " " ˆ "world";;


let s = "hello" + " " + "world";;
String.length s;;

"int value {2*3} bool value {true&&false}";; // senza "$" all'inizio della linea, l'operazione non viene calcolata. viene semplicemente stampato ogni carattere come se fosse una semplice stringa.
$"int value {2*3} bool value {true&&false}";; // questo calcola invece il suo risultato. questo si chiama -> string interpolation

// List.init n inizializza la lista con n elementi, con valore pari al proprio indice.
let ls = [67;87;90;4];;
let ls = List.init 6 (fun x -> x)
ls.Length;; // = 4
ls.Item 0;;

// IMPORTANT: The behavior of starting with x = 0 and incrementing x by 1 for each subsequent element is built into the List.init function in F#.

let ls = List.init 6 (fun x->x*2);;
ls.Item 5;; // ritorna l'elemento in pos 5
let ls = List.init 6 (fun x->0);;

let rec sum =
function // letteralmente ==  a match with, ma come vedi, qua evitiamo la fatica di dichiarare la funzione con l'argomento
| h::t -> h+sum t
| [] -> 0;;
List.init 10 (fun x->x+1)|> sum;; // |> sembra una specie di pipe

// REVERSE
let rec reverse =
function
| hd::tl -> reverse tl @ [hd]
| _ -> [];;

let tt = List.init 10 (fun x -> x+3);;
reverse tt;;


// QUA loop prenderebbe solo 1 argomento, ma in realta' glie ne possiamo passare 2
// perche' se gli passiamo un intero + una lista, allora:
// acc = 1st valore ; lista = hd::tl
let rec loop acc = (* simulates the loop *)
    function
    | hd::tl -> loop (acc+hd) tl (* continues the loop *)
    | _ -> acc;; 
let accSum = loop 0;;
let tt = List.init 10 (fun x -> x+3);;
accSum tt;;



// stesso esempio ma piu' elegante:
let accSum = // accSum non ha bisogno di 'function' perche' function, ricordiamo, serve quando si fa il pattern match
    let rec loop acc = (* loop: int -> int list -> int *)
        function
            | hd::tl -> loop (acc+hd) tl
            | _ -> acc
    loop 0;; // quindi: loop acc e' innestata in accSum, e chiamata con accumulatore a zero. cosi' quando chiameremo accSum, dovremo solo passare una lista
let tt = List.init 10 (fun x -> x+3);;

accSum tt;;


// ================ Ripasso


// provo a ricordare come implementare la funzione  'sum'
// e popolare una lista con il metodo visto prima.


let rec sum =
    function
    | [] -> 0
    | h::t -> h + (sum t)

let ls = List.init 7 (fun x -> x) |> sum

let rec reverse =
    function
        | [] -> []
        | h::t -> reverse t @ [h] // ATTENZIONE: devo ritornare [h], non solo 'h'.
let ls = List.init 7 (fun x -> x)
reverse ls


// ++++ Provo a ricordare accSum:

// definisco una lista:
let ls = List.init 7 (fun x -> x+1);;

let accSum =
    let rec loop acc =
        function
            | [] -> acc
            | h::t -> loop (acc+h) t 
    loop 0

accSum ls;;