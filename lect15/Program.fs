/////// SOLUIONI IN FONDO //////
~ Esercizio 1) Definire il tipo QuadTree degli alberi con i seguenti tipi di nodi:

nodi Gray: hanno sempre quattro figli
nodi foglia: posso essere di tipo Black o White
Definire la funzione invert : QuadTree -> QuadTree tale che invert t restituisce l'albero ottenuto da t invertendo il colore di tutti i nodi foglia e lasciando invariati quelli di tipo Gray.
Esempio:
Gray(Gray(Black, White, Black, White), Black, White, Black) |> invert;;
val it: QuadTree = Gray (Gray (White, Black, White, Black), White, Black, White)


Gray(Gray(Black, White, Black, White), Black, White, Black) |> invert;;






~ esercizio 2) Dato il tipo dell'albero della sintassi 
                astratta per semplici espressioni aritmetiche

type ExpAST =
    | IntLiteral of int
    | Sign of ExpAST
    | Add of ExpAST * ExpAST
    | Mul of ExpAST * ExpAST
definire la funzione prefixNotation: ExpAST -> string che dato un albero della sintassi astratta, restituisce la stringa corrispondente all'espressione in forma polacca prefissa. Suggerimento: usare le stringhe interpolate $"..."
Esempio:
Sign(Add(IntLiteral 1, Mul(IntLiteral 2, IntLiteral 3))) |> prefixNotation;;
val it: string = "- + 1 * 2 3"

type ExpAST =
    | IntLiteral of int
    | Sign of ExpAST
    | Add of ExpAST * ExpAST
    | Mul of ExpAST * ExpAST

let rec prefixNotation =
    function
    | IntLiteral n -> $"{n}"
    | Sign exp -> $"- {prefixNotation exp}"
    | Add(exp1, exp2) -> $"+ {prefixNotation exp1} {prefixNotation exp2}"
    | Mul(exp1, exp2) -> $"* {prefixNotation exp1} {prefixNotation exp2}"

Sign(Add(IntLiteral 1, Mul(IntLiteral 2, IntLiteral 3))) |> prefixNotation;;













///////// Soluzioni Prof ////////


let rec invert =
    function
    | Gray(t1, t2, t3, t4) -> Gray(invert t1, invert t2, invert t3, invert t4)
    | Black -> White
    | White -> Black
let rec prefixNotation =
    function
    | IntLiteral n -> $"{n}"
    | Sign exp -> $"- {prefixNotation exp}"
    | Add(exp1, exp2) -> $"+ {prefixNotation exp1} {prefixNotation exp2}"
    | Mul(exp1, exp2) -> $"* {prefixNotation exp1} {prefixNotation exp2}"







Soluzione (corretta) Esercizio 1:

type QuadTree =
    | Gray of QuadTree * QuadTree * QuadTree * QuadTree
    | Black
    | White

let rec invert = 
    function
    | Gray(t1,t2,t3,t4) -> Gray(invert t1, invert t2, invert t3, invert t4)
    | White -> Black
    | Black -> White

Gray(Gray(Black, White, Black, White), Black, White, Black) |> invert;;





Soluzione (corretta) Esercizio 2:


type ExpAST =
    | IntLiteral of int
    | Sign of ExpAST
    | Add of ExpAST * ExpAST
    | Mul of ExpAST * ExpAST

let rec prefixNotation =
    function
    | IntLiteral n -> $"{n}"
    | Sign exp -> $"- {prefixNotation exp}"
    | Add(exp1, exp2) -> $"+ {prefixNotation exp1} {prefixNotation exp2}"
    | Mul(exp1, exp2) -> $"* {prefixNotation exp1} {prefixNotation exp2}"

Sign(Add(IntLiteral 1, Mul(IntLiteral 2, IntLiteral 3))) |> prefixNotation;;


