Dato il tipo polimorfo degli alberi binari di ricerca
type 'a btree =
    | Empty
    | Node of 'a * 'a btree * 'a btree
definire la funzione getMin: 'a btree -> 'a option che restituisce l'elemento minimo, se esiste, di un albero binario di ricerca, None altrimenti.
Esempi:
> Node (3, Node (1, Empty, Node (2, Empty, Empty)), Node (6, Node (4, Empty, Empty), Empty)) |> getMin;;
val it: int option = Some 1

> getMin Empty |> Option.isNone;;
val it: bool = true

//////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////

type 'a btree =
    | Empty
    | Node of 'a * 'a btree * 'a btree

let getMin t =
    let rec loop acc =
        function
        | Empty -> None
        | Node n -> loop(if n < acc then acc = n else acc) 

(*line 27*)

Node (3, Node (1, Empty, Node (2, Empty, Empty)), Node (6, Node (4, Empty, Empty),Empty)) |> getMin;;

getMin Empty |> Option.isNone;;





////////SOLUZIONE COPILOT/////


type 'a btree =
    | Empty
    | Node of 'a * 'a btree * 'a btree

let rec getMin tree =
    match tree with
    | Empty -> None
    | Node(value, Empty, _) -> Some value
    | Node(_, left, _) -> getMin left (*line 48*)

Node (3, Node (1, Empty, Node (2, Empty, Empty)), Node (6, Node (4, Empty, Empty), Empty)) |> getMin;;

getMin Empty |> Option.isNone;;