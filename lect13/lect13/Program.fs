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
printfn "%A" a;;

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


let ls = [67;87;90;4];;
let ordSwap =
    function 
        | x::y::tl as ls -> if x>y then y::x::tl else ls
        | other -> other;;
ordSwap ls;;

let c = 'a';;
System.Char.ToUpper c;;

// Strings in F#
// Examples
let s = "hello" + " " + "world";;
let s2 = "hello" ˆ " " ˆ "world";;
String.length s;;

"int value {2*3} bool value {true&&false}";;
$"int value {2*3} bool value {true&&false}";; // questo calcola


let ls = [67;87;90;4];;

ls.Length;; // = 4
ls.Item 0;;
let ls = List.init 6 (fun x->x*2);;
ls.Item 5;; // ritorna l'elemento in pos 5
let ls = List.init 6 (fun x->0);;

let rec sum =
function
| h::t -> h+sum t
| [] -> 0;;
List.init 10 (fun x->x+1)|> sum;;

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
accSum tt;;



// stesso esempio ma piu' elegante:
let accSum =
    let rec loop acc = (* loop: int -> int list -> int *)
        function
            | hd::tl -> loop (acc+hd) tl
            | _ -> acc
    loop 0;;
let tt = List.init 10 (fun x -> x+3);;

accSum tt;;