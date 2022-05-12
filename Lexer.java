
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lexer {

	/*
	 * A lexer (or "tokenizer") converts an input into tokens that
	 * eventually need to be interpreted.
	 * 
	 * Given the input
	 * (\bat .bat flies)cat λg.joy! )
	 * you should output the ArrayList of strings
	 * [(, \, bat, ., bat, flies, ), cat, \, g, ., joy!, )]
	 *
	 */
	public static ArrayList<String> tokenize(String input) {
		ArrayList<String> tokens = new ArrayList<String>();

		// This next line is definitely incorrect!
		//tokens.add(input);

		String word = "";
		ArrayList<String> notLetters = new ArrayList<String>(Arrays.asList(
				new String[] { "(", ")", ".", ",", "/", "\\", ";", "{", "}", "[", "]", "+", "*", "^", "-", "!" }));

		ArrayList<String> list = new ArrayList<String>();

		for (int i = 0; i < input.length(); i++) {
			if (notLetters.contains(input.substring(i, i+1))) {
				if (word != "")
					list.add(word);
				word = "";
				list.add(input.substring(i, i+1));
			}

			else if ((!notLetters.contains(input.substring(i, i+1))) && !(input.substring(i, i+1).equals(" "))) {
				word += input.substring(i, i+1);
			}

			else if(input.substring(i, i+1).equals(" ") && word != ""){
				list.add(word);
				word = "";
			}

			// else if (input.substring(i, i+1).equals(" ")) {
			// 	list.add(word);
			// }

		}
		return list;

	}

}
