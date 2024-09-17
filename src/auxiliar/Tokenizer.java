package Apl1.src.auxiliar;

/**
 *
 * @author Lucas Pires de Camargo Sarai - 10418013
 * @author Vitor Alves Pereira - 10410862
 * 
 * Ciência da Computação
 * 3D
 * EDI
 * 
 * Referências:
 *  Herança em Java
 *  Árvores - fundamentos
 * 
 */

import java.util.ArrayList;
import java.util.List;

public class Tokenizer{
	private char[] input;
	private int index;

	public Tokenizer(String s){
		input = s.toCharArray();
		index = 0;

	}

	private char getNextChar(){
		if(index>=input.length) return '\0';
		return input[index++];

	}

	public List<String> tokenize(){
		List<String> tokens = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		char currChar = getNextChar();
		boolean isTokenizing = true;
		
		while(isTokenizing){
			while(Character.isWhitespace(currChar)) currChar = getNextChar();

			if(Character.isDigit(currChar)){
				sb.setLength(0);
				while(Character.isDigit(currChar) || currChar == '.') {
					sb.append(currChar);
					currChar = getNextChar();
				}
				tokens.add(sb.toString());
			}else if(currChar == '(') {
				tokens.add("(");
				currChar = getNextChar();
                        }else if(currChar == ')') {
                                tokens.add(")");
				currChar = getNextChar();	
			}else if(currChar == '+') {
				tokens.add("+");
				currChar = getNextChar();
			}else if(currChar == '-') {
				if(!Character.isDigit(tokens.get(tokens.lastIndexOf('-')-1).charAt(0)) 
                                   ||tokens.get(tokens.lastIndexOf('-')-1).charAt(0) != ')'){
					tokens.add("~");
				}
                		else tokens.add("-");
				currChar = getNextChar();
			}else if(currChar == '*') {
				tokens.add("*");
				currChar = getNextChar();
			}else if(currChar == '/') {
				tokens.add("/");
				currChar = getNextChar();
			}else if(currChar == '\0'){
				isTokenizing = false;

			}else{
				System.out.println("\nERRO! Token não reconhecido: " + currChar);
                                System.out.println("Leitura falhou! Um ou mais"
                                        + " tokens não foram reconhecidos.");
				return null;
			}

                }
	      return tokens;
			
	}

}
