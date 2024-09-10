package Apl1.src.auxiliar;

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
                                tokens.add("-");
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
				System.out.println("ERRO! Token não reconhecido: " + currChar);
				isTokenizing = false;
			}

		}
	      System.out.println("Encerrando leitura...");
	      return tokens;
			
	}
	
	public static void main(String args[]){
		Tokenizer tk = new Tokenizer("((4.0+3.5)*(22.3-10.1))/(33*3-2)");
		List<String> tokens = tk.tokenize();
		for(int i = 0; i<tokens.size();i++) System.out.println("token [" + i + "]: " + tokens.get(i));
	}

}
