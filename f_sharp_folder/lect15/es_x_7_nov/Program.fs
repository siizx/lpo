module Program
// Dato il tipo polimorfo degli alberi binari di ricerca
//type 'a btree =
//    | Empty
//    | Node of 'a * 'a btree * 'a btree
// definire la funzione getMin: 'a btree -> 'a option che restituisce l'elemento minimo, se esiste, di un albero binario di ricerca, None altrimenti.
// Esempi:
//> Node (3, Node (1, Empty, Node (2, Empty, Empty)), Node (6, Node (4, Empty, Empty), Empty)) |> getMin;;
//val it: int option = Some 1

//> getMin Empty |> Option.isNone;;
//val it: bool = true


// type 'a btree =
//     | Empty
//     | Node of 'a * 'a btree * 'a btree
// //  VABBE, QUA E' UN CASINO, PER QUESTO INTRODUCIAMO SOME E NONE PIU SOTTO.
// let rec getMin =
//     function
//     | Empty -> None
//     | Node(Value, Empty, _) -> Some Value
//     | Node(_, Left, _) -> getMin Left

// Node(3, Node(1, Empty, Node(2, Empty, Empty)), Node(6, Node(4, Empty, Empty), Empty))
// |> getMin

// getMin Empty |> Option.isNone


// ========================================
// ========================================
// ============== SOLUZIONE ===============
// ========================================
// ========================================


type 'a btree =
    | Empty
    | Node of 'a * 'a btree * 'a btree

let rec getMin =
    function
    | Empty -> None
    | Node(value, Empty, _) -> Some value
    | Node(_, left, _) -> getMin left

Node(3, Node(1, Empty, Node(2, Empty, Empty)), Node(6, Node(4, Empty, Empty), Empty))
|> getMin

let rr =
    Node(3, Node(1, Empty, Node(2, Empty, Empty)), Node(6, Node(4, Empty, Empty), Empty))

getMin rr

getMin Empty |> Option.isNone
