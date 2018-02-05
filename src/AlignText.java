/**
 * The AlignText programs implements a method to align the given text
 * with several option including align left, align right, centred and
 * justified.
 * To compile this program, type "javac AlignText.java" in commandline.
 * To run this program, after compiling, type
 * "java AlignText file_name line_length <align_mode> title_lines"
 * @author XignzhiYue CS5001 Student (xy31@st-andrews.ac.uk)
 * @version 4.0
 * @since 2017-10-01
 */

public class AlignText {
	/**
	* This is the main method which print out the aligned text with
	* certain standard.
	* @param	args contains four argument to instruct how to align the text.
	* args[0] the name of the file containing the text.
	* args[1] the desired length of the line for wrapping the text.
	* args[2] the way how the text are required to align:
	* L:	align left;
	* LI:	align left with two digits of indent;
	* R:	align right;
	* C:	align centre;
	* J:	justified.
	* JI:	justified with two digits of indent;
	* args[3] the first numbers of lines that are desired to align by centre. Note t
	*
	* @exception ArrayIndexOutOfBoundsException if any argument is missing or invalid
	* @catch	show the running format "java AlignText file_name line_length <align_mode> title_lines"
	*/

	public static void main(String[] args) {
		try {
			/* FileUtil is a provided class with a method "readFile" to read an array of String from a file
			   divided by line breaks. */
			String[] paragraphs = FileUtil.readFile(args[0]);
			// to transform from a String to Integer.
			int lineLength = Integer.parseInt(args[1]);
			// deal with invalid line_length
			if (lineLength < 1) {
				System.out.println("usage: java AlignText file_name line_length <align_mode> title_lines");
			}
			else {
				// This bit deal with title to centre-align it. If there is no need for that, set title_lines to 0.
				int titleLines = 0;
				if (args.length == 4) {
					titleLines = Integer.parseInt(args[3]);
				}
				String[] titles = new String[titleLines];
				for (int i = 0; i < titleLines; i++) {
					titles[i] = paragraphs[i];
				}
				CentreAlignText title = new CentreAlignText(titles, lineLength);
				title.alignText();
				title.showText();

				// Give the rest of the paragraphs to paragraphs[];
				String[] rest = new String[paragraphs.length - titleLines];
				for (int i = 0; i < paragraphs.length - titleLines; i++) {
					rest[i] = paragraphs[i + titleLines];
				}

				paragraphs = rest;
				// Default setting: right alignment.
				String alignStyle = "R";
				if (args.length >= 3) {
					alignStyle = args[2];
				}

				switch (alignStyle) {
					//Align left
				case "L":
					LeftAlignText textL = new LeftAlignText(paragraphs, lineLength);
					textL.alignText();
					textL.showText();
					break;
					//Align left with indent.
				case "LI":
					LeftIndentText textLI = new LeftIndentText(paragraphs, lineLength);
					textLI.alignText();
					textLI.showText();
					break;
					//Align right.
				case "R":
					RightAlignText textR = new RightAlignText(paragraphs, lineLength);
					textR.alignText();
					textR.showText();
					break;
					//Centred.
				case "C":
					CentreAlignText textC = new CentreAlignText(paragraphs, lineLength);
					textC.alignText();
					textC.showText();
					break;
					//Justified.
				case "J":
					JustifyAlignText textJ = new JustifyAlignText(paragraphs, lineLength);
					textJ.alignText();
					textJ.showText();
					break;
					//Justified with indent.
				case "JI":
					JustifyIndentText textJI = new JustifyIndentText(paragraphs, lineLength);
					textJI.alignText();
					textJI.showText();
					break;
				default:
					System.out.println("usage: java AlignText file_name line_length <align_mode> title_lines");
					System.out.println("align_mode includes only: L, LI, R, C, J, JI");
					break;
				}
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("usage: java AlignText file_name line_length <align_mode> title_lines");
			}
		}

	/**
	* this method is used to decide how many words should be put in this line.
	* @param 	words is all the words (followed by punctuation) in the text.
	* @param	len is the desired length for each aligned line.
	* @param	startIndex is the index (in words[]) of the first word in this line.
	* @return	int This returns the number of words in this line.
	*/
	public static int getLineWords(String[] words, int len, int startIndex) {
		//this gives the current number of words this line have.
		int count = 0;
		//this gives the current length of this line.
		int nowLen = 0;
		//this gives the length of this line if we also include the next word.
		int nextLen = 0;
		do {
			//update the line with a new word.
			nowLen += words[startIndex + count].length();
			count++;
			if (startIndex + count >= words.length) {
				return count;
			}
			nextLen = nowLen + words[startIndex + count].length() + 1;
			//if this line can accomadate one more word add a pace to its end.
			if (nextLen < len) {
				nowLen++;
				nextLen++;
			}
		}while (nextLen <= len);
		return count;
	}

	/**
	* this method is used to transform a given series of words to a single line of text.
	* note that the words[start] will be included in this line, whereas words[end] won't.
	* @param 	words is all the words (followed by punctuation) in the text.
	* @param	start is the index( in words[]) of the first word in this line.
	* @param	end is the index (in words[]) of the first word in the following line.
	* @return	String This returns a single line of text made of words between the two index.
	*/
	public static String formLine(String[] words, int start, int end) {
		String line = "";
		for (int i = start; i < end - 1; i++) {
			line += words[i];
			line += " ";
		}
		//this guarantees no space at the end of each line.
		line += words[end - 1];
		return line;
	}
}




