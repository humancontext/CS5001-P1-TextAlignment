/**
 * This class is made to deal with right align situation.
 * member variables are set to be private for encapsulation.
 * @author XignzhiYue CS5001 Student (xy31@st-andrews.ac.uk)
 * @version 2.0
 * @since 2017-09-26
 */

public class RightAlignText extends Text {
	/**
	* this is the constructor.
	* @param 	text is the paragraphs to be dealt with.
	* @param	len is the desired line length.
	*/
	public RightAlignText(String[] text, int len) {
		super(text, len);
	}

	/**
	* this method right-align a given line with right length.
	* @param 	line is a given line of text.
	* @param	lineLen is the desired line length.
	*/
	private String align(String line, int lineLen) {
		int len = line.length();
		//add spaces in front of each line.
		for (int i = 0; i < lineLen - len; i++) {
			line = " " + line;
		}
		return line;
	}

	/**
	* this method transform raw paragraphs into right-aligned lines.
	* add each right-aligned line to ArrayList<String> lines.
	*/
	public void alignText() {
		//go through each paragraph
		for (int i = 0; i < paragraphs.length; i++) {
			//split words and store the words in each paragraph in words[].
			String[] words = paragraphs[i].split(" ");
			//this counts the index of word that we are dealing with.
			int nowAt = 0;
			while (nowAt < words.length) {
				//get the number of words for this line.
				int wordCount = AlignText.getLineWords(words, lineLength, nowAt);
				//put the words from nowAt to (nowAt + wordCount) into a line.
				String thisLine = AlignText.formLine(words, nowAt, nowAt + wordCount);
				//do the align part for this line.
				String alignLine = align(thisLine, lineLength);
				lines.add(alignLine);
				nowAt = nowAt + wordCount;
			}
		}
	}
}
