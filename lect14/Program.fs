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
let accRev ls = (* parameter ls needed to get a polymorphic function *)
    let rec loop acc = function
        | hd::tl -> loop (hd::acc) tl
        | _ -> acc
    loop [] ls;;

