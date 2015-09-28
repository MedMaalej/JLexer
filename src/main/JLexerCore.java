/*
 * This class was written by : Mohamed MAALEJ
 * Sfax , Tunisia 27/09/2015
 * It's a lexer for the Java Programming language 
 */
package main;

import java.util.Hashtable;

public class JLexerCore {
	private String stringToTokenize;

	public JLexerCore(String str) {
		stringToTokenize = str;
	}

	public boolean contains(String strArr[], String findMe) {

		for (int i = 0; i < strArr.length; i++) {
			if (findMe.toUpperCase().equals(strArr[i].toUpperCase())) {
				return true;
			}
		}
		return false;
	}

	public Hashtable<String, String> tokenize() {
		Hashtable<String, String> tokenized = new Hashtable<String, String>();
		String[] javaKeywords = new String[] { "abstract", "assert", "boolean", "break", "byte", "case", "catch",
				"char", "class", "const", "continue", "default", "do", "double", "else", "enum", "extends", "final",
				"finally", "float", "for", "goto", "if", "implements", "import", "instanceof", "int", "interface",
				"long", "native", "new", "package", "private", "protected", "public", "return", "short", "static",
				"strictfp", "super", "switch", "synchronized", "this", "throw", "throws", "transient", "try", "void",
				"volatile", "while" };
		String[] toTokens = this.stringToTokenize.split(" ");
		for (int i = 0; i < toTokens.length; i++) {
			  if (toTokens[i].matches("\\d+")) {
				tokenized.put(toTokens[i], "integer");
			} else if (toTokens[i].equals(".")) {
				tokenized.put(toTokens[i], "dot");
			} else if (toTokens[i].equals("{")) {
				tokenized.put(toTokens[i], "opening bracket");
			} else if (toTokens[i].equals("}")) {
				tokenized.put(toTokens[i], "closing brackets");
			} else if (toTokens[i].equals("[")) {
				tokenized.put(toTokens[i], "opening for array index");
			} else if (toTokens[i].equals("==")) {
				tokenized.put(toTokens[i], "equality test");
			} else if (toTokens[i].equals("=")) {
				tokenized.put(toTokens[i], "value assignment");
			} else if (toTokens[i].equals(";")) {
				tokenized.put(toTokens[i], "semicolon");
			} else if (toTokens[i].equals("(")) {
				tokenized.put(toTokens[i], "opening parenthesis");
			} else if (toTokens[i].equals(")")) {
				tokenized.put(toTokens[i], "closing parenthesis");
			} else if (this.contains(javaKeywords, toTokens[i])) {
				tokenized.put(toTokens[i], toTokens[i]);
			}
			else if(toTokens[i].matches("[A-Z]+"))
			{
				tokenized.put(toTokens[i], "string");
			}
			else
				tokenized.put(toTokens[i], "identifier");
		}
		return tokenized;

	}

}
