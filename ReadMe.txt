AlignText Program version 4.0 28/09/2017

GENERAL USAGE NOTES
-------------------

- To compile the program in Terminal, type 
	javac AlignText.java

- To run this program in Terminal, type
	java AlignText file_name line_length <align_mode> title_lines(0 if no title included)

- This program implements a method to align the given text in a *.txt file with six different formats.
	L:	align left
	LI:	align left with two digits of indent
	R:	align right
	C:	centre horizontally
	J:	justified
	JI:	justified with two digits of indent

- When running this program, four parameters should be included in the running line.
	1.	the name (and path if the text file is not in the current address) of the file containing the text.
	2.	the desired length of the line for wrapping the text. Must > 0.
	3.	align_mode including(L, LI, R, C, J, JI). If it's missing, default alignment mode will be right.
	4.	title_lines number of lines for the title (while will be centre) unlike the rest. If no title is desired, it is safe to just ignore it.

- If either argument is missing or invalid, the following message will be output: usage: java AlignText file_name line_length <align_mode> title_lines
