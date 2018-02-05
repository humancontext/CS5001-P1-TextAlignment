/**
 * This class is made to deal with left-align requirement.
 * @author XignzhiYue CS5001 Student (xy31@st-andrews.ac.uk)
 * @version 2.0
 * @since 2017-09-26
 */

public class LeftAlignText extends Text {
	/**
	* this is the constructor.
	* @param 	text is the paragraphs to be dealt with.
	* @param	len is the desired line length.
	*/
	public LeftAlignText(String[] text, int len) {
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
