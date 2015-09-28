package main.test;

import java.util.Hashtable;
import java.util.Set;

import main.JLexerCore;

public class Main {
	public static void main(String[] args) {
		String code = "if a == b return ;";
		JLexerCore javaLexer = new JLexerCore(code);
		Hashtable<String, String> lexerResults = javaLexer.tokenize();
		Set<String> keys = lexerResults.keySet();
		for (String key : keys) {
			System.out.println("[" + key + ":" + lexerResults.get(key) + "]");
		}
	}
}
