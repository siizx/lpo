// For more information see https://aka.ms/fsharp-console-apps

let isNone =
    function (* isNone : ’a option -> bool *)
    | None -> true
    | _ -> false

let isSome =
    function (* isSome : ’a option -> bool *)
    | Some _ -> true
    | _ -> false



let isIn el = 
    let rec aux =
        function
            | Node(label, left, right) -> el = label || if el < label then aux left else aux right 
            | _ -> false
        aux 




let insert el = 
    let rec aux =
        function
            | Node(label, left, right) as t -> if el = label then t else if el < label then Node(label, aux left, right) else Node(label, left, aux right)
            | _ -> Node(el, Empty, Empty)
    aux
