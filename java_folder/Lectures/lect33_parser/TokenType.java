package parser;


public enum TokenType { 
	// used internally by the tokenizer, should never been accessed by the parser
	SYMBOL, SKIP, 
	// non singleton categories
	NUM,   
	// end-of-file
	EOF, 	
	// symbols
	PLUS, TIMES, OPEN_PAR, CLOSE_PAR,
	// no keywords
}
