


// questi due sono la stessa cosa. list di interi.
[2;4];;
[2]@[4];;
// questo no. lista di liste di interi:
[2]::[4::[]];;

let lst = [2;4;6;8];;
let lst2 = [666]@[2;4;6;8];;
let lst3 = 999::[2;4;6;8];;

printfn "%A" lst;;
printfn "%A" lst2;;
printfn "%A" lst3;;

// =====================================================

let lst = [2;4;6;8];;

let hd (h::t) = h;; // return the head of a list
hd lst;;