Dato il tipo polimorfo degli alberi binari di ricerca

// spiegato a pagina 7 lect 16

type 'a btree =
    | Empty
    | Node of 'a * 'a btree * 'a btree

definire la funzione getMin: 'a btree -> 'a option che restituisce l'elemento minimo, se esiste, di un albero binario di ricerca, None altrimenti.


Esempi:
> Node (3, Node (1, Empty, Node (2, Empty, Empty)), Node (6, Node (4, Empty, Empty), Empty)) |> getMin;;
val it: int option = Some 1

> getMin Empty |> Option.isNone;;
val it: bool = true


//////////// soluzione /////////

type 'a btree =
    | Empty
    | Node of 'a * 'a btree * 'a btree

let getMin t =
    let rec aux = function
        | Empty -> None
        | Node(value,leftNode,rightNode) -> if leftNode = Empty then Some value else aux leftNode
    aux t

Node (3, Node (1, Empty, Node (2, Empty, Empty)), Node (6, Node (4, Empty, Empty), Empty)) |> getMin;;

getMin Empty |> Option.isNone;;