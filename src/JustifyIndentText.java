import java.util.ArrayList;
/**
 * This class is made to deal with justified requirement.
 * Also, two digits of indent will be added except for the
 * first paragraph.
 * @author XignzhiYue CS5001 Student (xy31@st-andrews.ac.uk)
 * @version 1.0
 * @since 2017-09-28
 */

public class JustifyIndentText extends Text {
	/**
	* this is the constructor.
	* @param 	text is the paragraphs to be dealt with.
	* @param	len is the desired line length.
	*/
	public JustifyIndentText(String[] text, int len) {
		super(text, len);
	}

	/**
	* this method centre a given line with right length.
	* @param 	line is a given line of text.
	* @param	lineLen is the desired line length.
	*/
	private String align(String line, int lineLen) {
		int len = line.length();
		int space = lineLen - len;
		if (space <= 0) {
			return line;
		}
		int countSpace = 0;
		if (!line.contains(" ")) {
			return line;
		}
		while (countSpace < space) {
			/*add spaces to the spaces between words until it
			  reaches desired length from back forwards.*/
			for (int i = line.length() - 1; i >= 0; i--) {
				//find the space between words.
				if (line.charAt(i) == ' ') {
					//find the start of a series of continuous space
					while (line.charAt(i - 1) == ' ') {
						i--;
					}
					//insert a space between the words
					StringBuilder sb = new StringBuilder(line);
					sb.insert(i, ' ');
					line = sb.toString();
					countSpace++;
					if (countSpace >= space) {
						break;
					}
				}
			}
		}
		return line;
	}

	/**
	* this method transform raw paragraphs into justified lines with indent.
	* and then add each line to ArrayList<String> lines.
	*/
	public void alignText() {
		for (int i = 0; i < paragraphs.length; i++) {
			ArrayList<String> temp = new ArrayList<>();
			String[] words = paragraphs[i].split(" ");
			// give two digits of indent for paragraphs except for the first one.
			if (i != 0) {
				words[0] = "  " + words[0];
			}
			int nowAt = 0;
			while (nowAt < words.length) {
				int wordCount = AlignText.getLineWords(words, lineLength, nowAt);
				String thisLine = AlignText.formLine(words, nowAt, nowAt + wordCount);
				temp.add(thisLine);
				nowAt = nowAt + wordCount;
			}
			//the last line of a paragraph should not be justified.
			for (int j = 0; j < temp.size() - 1; j++) {
				String tempStr = temp.get(j);
				tempStr = align(tempStr, lineLength);
				temp.set(j, tempStr);
			}
			lines.addAll(temp);
		}
	}
}
