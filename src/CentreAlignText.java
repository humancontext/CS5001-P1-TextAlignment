/**
 * This class is made to deal with centred requirement.
 * @author XignzhiYue CS5001 Student (xy31@st-andrews.ac.uk)
 * @version 2.0
 * @since 2017-09-26
 */

public class CentreAlignText extends Text {
	/**
	* this is the constructor.
	* @param 	text is the paragraphs to be dealt with.
	* @param	len is the desired line length.
	*/
	public CentreAlignText(String[] text, int len) {
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
		/*if the length difference n is a odd number, the tests
		  demand (n+1)/2 spaces in front of that line*/
		int back = space / 2;
		int front = space - back;
		for (int i = 0; i < front; i++) {
			line = " " + line;
		}
		return line;
	}

	/**
	* this method transform raw paragraphs into centred lines.
	* add each centred line to ArrayList<String> lines.
	*/
	public void alignText() {
		for (int i = 0; i < paragraphs.length; i++) {
			String[] words = paragraphs[i].split(" ");
			int nowAt = 0;
			while (nowAt < words.length) {
				int wordCount = AlignText.getLineWords(words, lineLength, nowAt);
				String thisLine = AlignText.formLine(words, nowAt, nowAt + wordCount);
				String alignLine = align(thisLine, lineLength);
				lines.add(alignLine);
				nowAt = nowAt + wordCount;
			}
		}
	}
}
