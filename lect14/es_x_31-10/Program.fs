(*//// soluzioni in fondo /////

1) Definire mediante ricorsione di coda e parametro di accumulazione la funzione filter : ('a -> bool) -> 'a list -> 'a list tale che filter p l restituisce, rispettando l'ordine iniziale, la lista degli elementi e di l tali che p e = true.
Esempio:
filter ((<)0) [-1;1;-2;2;0] = [1;2] tiene solo gli elementi positivi
filter (fun x -> x % 2=0) [-1;1;-2;2;0] = [-2; 2; 0]  tiene solo gli elementi pari   *)

(*A*)

let ls = [ -1; 1; -2; 2; 0 ]

let filter f =
    let rec loop acc =
        function
        | hd :: tl -> loop (if f hd then hd :: acc else acc) tl
        | _ -> List.rev acc

    loop []

filter ((<) 0) [ -1; 1; -2; 2; 0 ] = [ 1; 2 ]

(*B*)

let filter f =
    let rec loop acc =
        function
        | hd :: tl -> loop (if f hd then hd :: acc else acc) tl
        | _ -> List.rev acc

    loop []

filter (fun x -> x % 2 = 0) [ -1; 1; -2; 2; 0 ] = [ -2; 2; 0 ] (* tiene solo gli elementi pari *)


(*2 Definire filter usando List.fold.*)

let g = (fun x -> x % 2 = 0)
let f = ((<) 0)
let ls = [ -1; 1; -2; 2; 0 ]

let filter p ls =
    List.fold (fun acc hd -> if p hd then hd :: acc else acc) [] ls |> List.rev

filter f ls
filter g ls







(*Soluzioni

let filter p =
    let rec loop acc =
        function
        | hd :: tl -> loop (if p hd then hd :: acc else acc) tl
        | _ -> List.rev acc

    loop []

let filter p ls =
    List.fold (fun acc hd -> if p hd then hd :: acc else acc) [] ls |> List.rev
*)
