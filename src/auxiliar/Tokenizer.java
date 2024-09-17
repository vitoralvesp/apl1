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

package Apl1.src.auxiliar;
import java.util.ArrayList;
import java.util.List;

public class Tokenizer {
	private char[] input;
	private int index;

	/* Construtor */
	// Tokenizer(string) --> inicializa o tokenizer para a análise de uma operação recebida como string
	public Tokenizer(String s) {
		input = s.toCharArray();
		index = 0;

	}

	/* Métodos */
	// getNextChar() --> retorna o próximo caractere da string se index for menor que o tamanho total de
	// caracteres da string e '\0' caso contrário
	private char getNextChar() {
		if (index >= input.length) return '\0';
		return input[index++];

	}

	// tokenize() --> realiza o reconhecimento dos operandos e operadores válidos da expressão aritmética
	public List<String> tokenize() {
		List<String> tokens = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		char currChar = getNextChar();
		boolean isTokenizing = true;
		
		while(isTokenizing) {
			
			while(Character.isWhitespace(currChar)) currChar = getNextChar();

			if(Character.isDigit(currChar)) {
				sb.setLength(0);

				// reconhecimento dos operandos (tipo float)
				while(Character.isDigit(currChar) || currChar == '.') {
					sb.append(currChar);
					currChar = getNextChar();
				}
				
				tokens.add(sb.toString());
				
			} else if(currChar == '(') {
				tokens.add("(");
				currChar = getNextChar();
                        } else if(currChar == ')') {
                                tokens.add(")");
				currChar = getNextChar();	
			} else if(currChar == '+') {
				tokens.add("+");
				currChar = getNextChar();
                        } else if(currChar == '-') {
				if(!Character.isDigit(tokens.get(tokens.lastIndexOf('-')-1).charAt(0)) ||
				tokens.get(tokens.lastIndexOf('-')-1).charAt(0) != ')'){
					tokens.add("~");
				}
                		else tokens.add("-");
				currChar = getNextChar();
			} else if(currChar == '*') {
				tokens.add("*");
				currChar = getNextChar();
			} else if(currChar == '/') {
				tokens.add("/");
				currChar = getNextChar();
			} else if(currChar == '\0') {
				isTokenizing = false;

			} else {
				System.out.println("\nERRO! Token não reconhecido: " + currChar);
                                System.out.println("Leitura falhou! Um ou mais"
                                        + " tokens não foram reconhecidos.");
				return null;
			}

                }
		
	      return tokens;
			
	}

}
