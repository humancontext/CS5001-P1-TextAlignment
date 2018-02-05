/**
 * This class is made to deal with left-align requirement.
 * Also, two digits of indent will be added except for the
 * first paragraph.
 * @author XignzhiYue CS5001 Student (xy31@st-andrews.ac.uk)
 * @version 1.0
 * @since 2017-09-28
 */

public class LeftIndentText extends Text {
	/**
	* this is the constructor.
	* @param 	text is the paragraphs to be dealt with.
	* @param	len is the desired line length.
	*/
	public LeftIndentText(String[] text, int len) {
		super(text, len);
	}

	/**
	* this method transform raw paragraphs into centred lines.
	* add each left-aligned line to ArrayList<String> lines.
	* Because left-align is natural, it's not needed to be
	* aligned with intention.
	*/
	public void alignText() {
		for (int i = 0; i < paragraphs.length; i++) {
			String[] words = paragraphs[i].split(" ");
			if (i != 0) {
				words[0] = "  " + words[0];
			}
			int nowAt = 0;
			while (nowAt < words.length) {
				int wordCount = AlignText.getLineWords(words, lineLength, nowAt);
				String thisLine = AlignText.formLine(words, nowAt, nowAt + wordCount);
				String alignLine = thisLine;
				lines.add(alignLine);
				nowAt = nowAt + wordCount;
			}
		}
	}
}
