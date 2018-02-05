import java.util.ArrayList;
/**
 * This abstract class is template for all subclasses.
 * @author XignzhiYue CS5001 Student (xy31@st-andrews.ac.uk)
 * @version 2.0
 * @since 2017-09-26
 */


public abstract class Text {
	//paragraphs[] stores the entire raw text from the file.
	protected String[] paragraphs;
	//lineLength is the desired line length we set.
	protected int lineLength;
	//lines stores all the lines after alignment.
	protected ArrayList<String> lines= new ArrayList<>();

	/**
	* this is the constructor.
	* @param 	text is the paragraphs to be dealt with.
	* @param	len is the desired line length.
	*/
	public Text(String[] text, int len) {
		paragraphs = text;
		lineLength = len;
	}

	/**
	* this method transform raw paragraphs into aligned lines.
	* to be implemented by subclasses for different requirments.
	*/
	abstract public void alignText();

	/**
	* this method print out the aligned text.
	*/
	public void showText() {
		for (int i = 0; i < lines.size(); i++) {
			System.out.println(lines.get(i));
		}
	}
}
