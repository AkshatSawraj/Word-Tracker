Title: Tracker 
By: Akshat S, Altamish L
Description:
 Tracker is a program that can read .txt files and 
 scan through every word for unique information. 
 Our program uses a Binary Tree data structure to 
 store such information, and output findings into 
 the repository.txt file found in your /res folder.

Instructions:
1) Run Jar file in a command prompt with "java -jar filelocationOfJar filepathoftextFile -command"
As you run the jar file, you may enter the following arguments into your command line. 
Sample: "java -jar ./Tracker.jar ./textfile.txt -po"
Java command, jar command, location of the file, location of the text file, command for print type.


Tracker.Jar is the main file.
The 2nd parameter is the command for action. (-pf -pl -po)

Command Definitions for 2nd Parameter (Arg[1])
-pf to print in alphabetic order all words along with the corresponding list of files in which the
words occur
-pl to print in alphabetic order all words along with the corresponding list of files and numbers
of the lines in which the word occur
-po to print in alphabetic order all words along with the corresponding list of files, numbers of
the lines in which the word occur and the frequency of occurrence of the words.


