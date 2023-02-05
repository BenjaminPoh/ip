import java.util.Scanner;
import java.util.ArrayList;

public class Duke {

    public static final String GREETING_MESSAGE = "Hai, Ningensama-tachi! Kon-Nakiri!";
    public static final String GOODBYE_MESSAGE = "Otsu-Nakiri!";
    public static final String ACTION_LIST = "list";
    public static final String ACTION_MARK_COMPLETE = "mark";
    public static final String ACTION_MARK_INCOMPLETE = "unmark";
    public static final String ACTION_NEW_TODO = "todo";
    public static final String ACTION_NEW_DEADLINE = "deadline";
    public static final String ACTION_NEW_EVENT = "event";
    public static final String ACTION_GOODBYE = "bye";
    public static final String COMPLETED_TASK_MESSAGE = "Nice! I've marked this task as done!";
    public static final String INCOMPLETE_TASK_MESSAGE = "Why are you being lazy? >:(";
    public static final String ADDED_TASK_MESSAGE = "Done! Added: ";
    //Too many errors. I need a separator
    public static final String ERROR_UNKNOWN_INSTRUCTION = "What are you talking about Ningen?";
    public static final String ERROR_NONINTEGER_INDEX = "Invalid Input. Give Just an Integer!";
    public static final String ERROR_NONEXISTANT_TASK = "That task doesn't exist...";
    public static final String ERROR_NO_INDEX_PROVIDED = "Do you want me to mark the whole list?";
    public static final String CUSTOM_ERROR_MESSAGE =
            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢿⣇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠰⣶⣆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠺⣟⣶⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢹⣿⣆⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢹⡈⣇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⢮⡻⣦⡀⠀⠀⠀⢀⣀⣀⣀⣘⡇⢸⡆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣀⣴⣿⠃⠀⠀⠀⠀⠈⠳⣄⠙⠲⣴⡟⢋⣉⣭⣭⣭⣑⠲⢧⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀⡤⠶⠖⠛⠋⠉⠉⠉⣠⢃⠋⠉⠙⠒⠒⠲⠤⢤⣸⣦⣄⠈⠙⠲⢭⣻⢿⣿⣿⣷⢤⣝⢷⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⡴⠞⠋⠁⠀⠀⠀⠀⡀⠀⠀⣴⠃⢸⠀⠀⠀⠀⠀⠀⢀⣀⠀⠉⠛⠷⣵⣀⠀⣸⡆⠙⣿⣿⣬⣿⣿⢻⣦⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡴⠟⡩⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠰⡑⠀⠘⠈⠁⠀⠀⠀⠀⠀⠀⠀⡉⠀⠀⢿⣿⣿⣿⣧⠀⡘⣟⠀⣼⠛⢿⣿⣆⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡴⠋⡠⠊⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣤⠳⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠳⡄⠈⢿⣿⣿⣿⠀⠁⠘⣾⡏⠀⠀⢡⣍⣳⡄⠀⠀⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣴⠏⠀⢈⠎⠀⠀⠀⠀⠀⠀⠀⢀⠔⣡⠊⠇⠀⠀⠀⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠢⡀⢻⣿⣿⡇⠀⠀⠸⣿⣦⣄⠈⣿⣿⣿⡆⠀⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡾⠃⢀⠔⠁⠀⠀⠀⠀⠀⠀⠀⠀⢁⡼⠁⡸⠀⠀⠀⠀⡆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢆⠀⠘⡬⣿⣿⡇⠀⠀⠀⢿⠥⠤⢾⣿⡿⣿⣷⠄⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⡟⠁⡰⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⠏⠀⠀⡇⠀⠀⠀⠀⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⣧⠀⢁⠸⣿⡇⠀⠀⠀⠘⠛⡿⡿⢿⣧⡽⢻⡆⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⢶⠶⢒⢛⡦⢬⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡰⢱⠀⠀⣦⡀⣠⣶⠗⠀⢇⢀⡆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⡆⠸⠀⣻⠇⠀⠀⡄⢸⣷⡓⠃⠶⢶⣿⣿⡆⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡴⠁⢸⡼⠀⣼⡿⡞⠀⠀⡀⠀⠀⠀⠀⠀⠀⡼⠁⠀⢣⠀⢸⠟⠉⠀⠀⠀⢸⡞⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⡀⠀⠟⠀⠀⠠⠁⢸⣿⣝⡒⣖⣯⣿⣿⡇⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣾⢠⣇⠸⡙⣠⡟⢠⠇⠀⠔⠉⠀⠀⠀⠀⠀⡜⠁⠀⠀⠈⣆⣘⣟⠁⠀⠀⠀⡼⠀⠀⣸⠀⠀⠀⠀⠀⠀⠀⠀⠀⢰⢱⣇⡼⠀⠀⠀⠀⣀⡜⠿⣿⣿⣿⣿⣿⣿⡇⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣼⡇⡌⡟⣆⢳⡝⠂⢸⠤⠒⠀⢀⠒⠦⣀⠀⡜⠀⠀⠀⠀⢰⠋⡇⡌⣦⡀⢀⢰⠃⠀⢀⡏⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⠈⢸⣷⣾⣿⣿⣿⣿⠀⠀⡎⢿⣿⡿⠛⠿⠃⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⡇⠃⡇⠀⣗⠻⡶⠁⡀⢐⠩⠀⠀⠂⠉⡶⠁⡰⠀⠀⢀⠄⠀⡇⠘⡏⠍⠊⢸⠀⠀⣸⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣷⢸⣾⣿⣿⣿⡟⠁⠀⢂⢱⠸⣦⡀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠸⡝⠄⠱⣸⡎⢀⡧⢪⠞⠁⠀⠀⠀⠱⢰⠁⣰⠇⠀⠰⠁⡠⠁⡇⢸⠀⠀⠀⢸⠀⢀⠇⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⢸⠙⠛⠟⡇⠀⠀⠀⠈⡌⡼⢌⢷⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢻⡄⢀⡿⡄⠎⣷⠙⢄⢆⠀⠀⠀⣠⠇⣰⠟⠀⠀⠀⠰⠁⣸⠻⢸⠒⠢⢤⣼⠀⡘⠀⢣⠀⠘⡀⠀⠀⠀⠀⠀⢰⢸⢹⡇⠀⢠⠀⠃⠀⠀⢠⠀⢡⠇⢸⣿⡆⠀⠀⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⣿⢠⢤⣼⠗⠁⠑⣤⡍⠊⠤⠤⡏⡔⣽⠀⠀⠀⠀⠇⡰⠃⠀⢻⡄⠀⠀⠈⡄⡿⠂⢌⣆⠀⣧⠀⢀⠀⠀⠀⢸⣼⢸⠇⡀⢸⠀⢸⠀⠀⠀⠀⠸⠸⢞⣹⣿⡀⠀⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣸⠃⡟⡞⡈⠅⠒⣾⣿⡗⠚⠁⢀⡞⡼⠇⢘⡀⠀⢰⡰⠁⠀⠨⠤⠕⣀⡀⢸⠐⣇⠑⢄⠙⠓⠏⠢⡈⡆⠀⠀⣾⡟⡹⠉⡟⢙⡇⢸⠀⠀⠀⠀⡄⡇⠈⡏⢸⠇⠀⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⠏⠀⢰⠱⢰⠀⣼⣿⣽⣧⢀⣇⠸⢰⠃⡇⣸⠘⠄⢸⣁⠀⠀⠀⠀⠀⠀⠈⠑⡆⠈⠢⠈⠀⠁⠒⠠⡈⠚⡶⠄⡸⠁⠃⡰⣡⣟⢱⡾⠀⠀⠀⠀⡇⡇⣈⠇⣼⠃⠀⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡟⠀⢰⡏⠀⡸⡺⡟⣿⣿⣿⡼⢹⠀⡏⠀⢰⢷⣆⠀⢸⡟⠛⠿⢷⣶⣶⣦⣤⣤⡄⠀⠀⠀⠀⠀⠀⠀⠙⠈⠀⡖⠂⠐⠂⢱⠇⠤⢠⡇⢀⢠⢰⠀⠁⣇⣝⣴⠇⠀⠀⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣼⠁⡀⢸⠁⠀⢱⢹⣿⣧⣿⢿⢳⠀⢠⠘⡄⠀⢸⡏⠦⡀⢯⠀⢸⣿⢿⣿⢿⣿⡏⠉⠂⠀⠀⠀⠀⠀⠀⠀⠀⢈⣠⣤⣀⣀⣁⣀⡀⢀⠃⡌⠘⠀⠀⢠⣿⡟⠁⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⠇⠀⠀⠇⠀⢀⠇⢸⣿⣿⢻⠘⣷⣷⡄⠀⢰⢠⡈⡃⢀⠈⠙⠓⠚⠿⠦⠾⠽⠊⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⢛⣻⣿⣿⣿⠟⣿⠾⡸⠀⠀⢰⠀⢸⣿⣷⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡿⢀⠀⠀⡀⠀⣼⡴⠈⠛⠛⠦⠤⡼⣼⠃⠀⠈⡇⠀⢸⠀⠑⠄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠸⣟⣿⢽⣻⠀⢡⡷⠁⠃⠀⠀⠀⢸⣻⢻⡀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢰⠇⡎⠀⠀⡇⣴⡏⠀⠀⠀⠀⠀⢰⢠⡿⠀⠀⠀⢷⠀⢸⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠋⠁⠀⡞⢡⢰⠀⠀⠀⠀⢸⡙⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⢰⡅⠀⠀⣧⠋⠀⠀⠀⠀⠀⠀⠘⣜⡇⠀⠀⠰⢸⢁⢀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣼⣴⢣⠃⠀⠀⠀⠀⡎⣿⡍⣧⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⢸⡇⠀⠀⡇⠀⠀⠀⠀⠀⠀⠀⢴⢹⡇⣲⠀⠀⠃⢸⡀⢇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠴⠛⡿⣷⠃⠀⢰⠀⡇⠀⡇⢿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⡌⢱⠀⠀⠇⠀⠀⠀⠀⠀⡀⠀⡇⢸⢇⣿⣧⠀⠀⠇⢣⠘⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠒⠒⠒⠒⠂⠄⠀⠀⠀⠀⠀⠀⠀⢀⡟⡽⠙⠀⠀⣾⠀⡇⢀⠓⢻⠉⡿⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⠿⢳⢟⡆⠄⠀⠀⠀⠀⠀⣠⠃⢰⠁⡎⢸⡏⠻⣣⡀⠘⡈⠑⢜⣦⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡠⡎⠈⠀⠇⢀⠴⠿⠤⠧⠼⠠⠼⠀⠳⠤⠤⠤⢤⣄⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣴⢏⣴⣿⡏⠘⡄⢠⠀⠀⠀⡴⣿⠀⡼⡆⢰⠈⣇⠀⠙⢕⢄⠘⡆⠘⡝⠢⢑⠢⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡠⠒⠉⢠⠁⠂⠄⢀⢃⡎⠀⠀⠈⠉⠉⠉⠉⠉⠉⠉⠉⠁⡿⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡾⣣⡾⣿⠟⣧⠀⠈⡄⡆⠀⡞⢰⣿⠀⠃⢱⠸⡄⡁⠑⣼⢠⠹⣷⣜⢆⢳⠀⠀⠀⠀⠈⠒⠤⣀⠀⠀⠀⠀⠀⢀⡠⠔⠈⠀⠀⠀⠀⡎⠀⣸⢀⠇⡜⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣼⠁⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣰⢋⣾⠋⣰⠏⠀⠘⣆⢰⠉⢿⡞⠀⣾⣿⠀⠀⣤⠀⣿⡇⢠⠈⡗⢵⠀⠛⠣⣙⢄⡀⠀⠀⠀⠀⠀⠀⠉⠒⠤⡖⠊⠁⠀⠀⠀⠀⠀⠀⡰⢠⢀⡇⡞⡰⠀⠀⣰⣶⣶⣶⣶⣶⣶⣶⣾⣿⣷⠇⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⢞⡵⠟⠁⣰⠏⠀⠀⠀⠈⡟⠀⡼⠛⢠⡏⢹⠀⠀⢿⡄⡇⠱⠀⢆⢣⠀⢠⠀⠀⠀⡏⠉⠂⠀⠀⠀⠀⠀⠀⠀⢸⡀⠀⠀⠀⠀⡆⠀⠀⢀⢣⠃⡼⣰⢁⠃⠀⠀⠿⠿⠟⠛⠛⠛⠛⠛⠛⢻⡏⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡼⢫⡞⠁⠀⣰⠏⠀⠀⠀⠀⣸⡇⢠⡇⠀⢸⡇⢸⡀⠀⢸⡇⡇⠀⠀⠈⠘⡇⢸⣆⣀⣤⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣇⠀⠀⠀⢠⡇⠀⠀⠘⠀⡰⢡⠃⡈⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡟⠀⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⠀⠀⠀⠀⢀⣴⢋⡴⠋⠀⠀⣰⠏⠀⠀⠀⠀⢠⡏⢧⢀⣄⠠⠾⠓⠚⠣⠤⠼⣿⡇⠀⠀⠀⠀⢻⣿⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⣸⣿⡀⠀⠀⣸⡇⠀⠀⠂⢠⢗⡝⡰⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡾⠁⠀⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⠀⠀⠀⣠⠞⣡⠞⠁⠀⠀⢠⠟⠀⠀⠀⠀⢀⡞⢀⡼⠊⠁⠀⠀⠀⠀⠀⠀⠀⠀⢧⠀⠀⠀⠀⢜⣿⣿⣿⡇⠏⠀⠀⠀⠀⠀⠀⠀⠀⠀⢹⣿⣿⣷⣦⣿⡇⠀⠀⡄⣆⡸⠤⠧⠀⠀⠀⠀⢀⣀⠀⠀⠀⠀⠀⣰⠃⠀⠀⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⣀⡴⠚⠋⡻⠋⡴⢯⣀⠀⠀⢰⠏⠀⠀⠀⠀⠄⡞⡠⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⠀⠀⠀⠀⠀⢻⣿⣿⣧⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⡗⠤⣀⣙⣿⢓⢤⣀⠀⠀⠀⠀⠀⠀⠑⢄⠀⠀⢠⡏⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                    "⢀⠾⠃⠀⣠⠎⢀⠞⠀⠀⠙⣿⣿⠏⠀⠀⠀⢀⠎⡜⡰⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠆⠀⠀⠀⠀⠘⣿⣿⣿⣇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣧⡀⠄⢊⠃⡜⠀⢀⢉⣑⣒⡒⠒⣄⠀⠈⠳⣀⡾⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                    "⠃⠀⢀⠜⠁⡰⠁⠀⠀⠀⢠⣿⠏⠀⠀⠀⢠⠊⣰⠙⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠠⡈⡠⡀⠀⠀⢻⣿⣿⣿⣆⠀⠀⠀⠀⠀⠀⠀⠀⢠⣿⣿⣿⠿⠛⠉⢀⠸⡁⠀⠁⠀⠀⠀⠀⠀⠈⠑⠾⣗⢄⡀⠙⢷⡀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                    "⣄⣠⠂⣠⠊⠀⠀⢀⣀⣤⣿⢯⠀⠀⠀⢠⠃⢠⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣷⡀⢈⠀⠑⣼⣿⣿⣿⣿⡄⠀⠀⠀⠀⠀⠀⢀⠼⠛⠉⣀⠠⢐⣨⣴⢺⡹⣉⣐⣒⣒⠒⠒⢦⣄⡀⠀⠈⠓⢌⡒⢄⠹⣦⡀⠀⠀⠀⠀⠀⠀\n" +
                    "⡜⠁⣴⡥⠶⠛⠋⠉⠙⣿⠃⠃⠀⠀⢀⠃⢠⣿⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠀⠀⠀⠀⠀⢴⣿⣷⡀⢢⠐⢌⠛⢿⣿⣿⣿⡄⠀⠀⠀⢀⠔⠁⠀⣀⣀⠀⠉⠻⢿⣿⠏⣦⡀⠀⠀⠀⠀⠉⠒⢽⡪⣢⢀⠀⠀⠉⠚⠀⡆⠙⣦⡀⠀⠀⠀⠀\n" +
                    "⢀⣼⣿⠁⠀⠀⠀⠀⣼⠃⣶⣶⣶⣤⣦⣄⣞⣆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠎⠀⠀⠀⢀⢊⣿⣿⣿⣷⡀⡆⠀⢈⣷⣾⣿⣿⣿⡄⠀⡰⠁⠀⠀⠀⠉⠒⠤⡉⠀⠐⢹⡸⣇⠙⠓⠢⢤⣤⢀⡀⠀⠈⠙⠿⣷⠀⠀⠀⠀⡇⠀⠸⣿⢷⣤⣦⣤\n" +
                    "⣾⠟⠁⠀⠀⠀⠀⣼⢃⣀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣶⣤⣄⣀⠀⠀⠀⢀⠎⠀⠀⠀⠀⢠⣾⣿⣿⣿⣿⣧⣿⠀⣸⣿⣿⣿⣿⣿⣿⠞⠀⠀⠀⠈⠪⡁⠐⠒⢘⡄⠀⣧⢃⣈⣢⣄⠀⠀⠈⠑⠪⣶⣤⣄⡀⠀⠀⠀⠀⢠⣅⠀⠀⣿⣆⠙⢿⣿\n" +
                    "⠁⠀⠀⠀⠀⠀⣼⠃⣼⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣶⣤⣄⡀⠀⠀⢠⣾⣿⣿⣿⣿⣿⣿⣿⣧⣿⣿⣿⣿⣿⣿⠏⠀⠀⢀⡤⠄⣀⣈⡆⠀⢸⢀⡼⠀⠀⢀⣴⡙⡏⠢⣄⡀⠀⠀⠉⠓⠞⠀⠀⠀⢀⡟⠉⠻⣶⣿⣿⡆⠈⢿\n" +
                    "⠀⠀⠀⠀⠀⣼⢃⢠⣿⣿⣿⣿⣿⣿⣿⣿⠿⣟⣿⣿⣿⣿⠿⣿⣿⣿⣿⣿⣿⣿⣿⣶⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠏⠀⠀⢠⠧⣟⠳⠂⣠⠇⠒⠉⠉⠀⢀⣴⣿⣿⣷⡆⣴⠀⢉⣗⡠⠀⠀⠀⠀⠀⣰⡏⠀⠀⢀⣙⣿⣿⣿⡀⠈\n" +
                    "⠀⠀⠀⠀⣼⠃⢌⣼⣿⣿⣿⣿⠿⣛⣭⣶⣿⡿⠟⢋⣭⣶⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡟⠀⠀⠀⠈⡄⠈⠉⠙⠁⠀⠀⠀⠀⣠⣾⣿⣿⣿⣿⣎⢸⢔⠝⠉⠀⠀⠀⠀⠀⠰⣙⣷⣶⣿⣿⣿⣿⣿⣿⣷⣀\n" +
                    "⠀⠀⠀⣼⣃⣴⣿⡿⠟⣋⣥⣶⣿⡿⠟⣋⣥⣶⣿⣷⣝⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠁⠀⠀⠀⠀⠃⡜⠀⠀⠀⠀⠀⣠⣶⣿⣿⣿⣿⣿⣿⣿⡦⠂⠀⠀⠀⠀⠀⠀⣠⣿⣿⣿⣿⣿⣿⣿⣿⣼⣿⣿⡟\n" +
                    "⠀⠀⣼⣿⡿⣛⣭⣶⣿⡿⢟⣫⣵⣶⣿⣿⣿⣿⣿⣿⣿⣷⣌⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⠀⠀⠀⠀⠀⡰⠁⠀⠀⢀⣤⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀⡰⠙⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀\n" +
                    "⠀⣼⡿⣻⣾⣿⡿⢛⣥⣾⣿⣿⣿⣿⣿⠿⣋⣴⡙⣿⣿⣿⣿⣷⣍⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠀⠀⠀⠀⠀⠘⠁⠀⣤⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡀⠀⠀⠀⠀⠰⠁⠀⠹⣿⣿⣿⣿⣿⣧⣽⣿⢸⠀\n";



    public static String[] processInputMessage(Scanner in) {
        String input = in.nextLine();
        String[] newInput = input.split(" ", 2);
        return newInput;
    }

    public static String[] processEventMessage(String input) {
        String[] eventArray = new String[3];
        String[] inputArray = input.split(" /from ", 2);
        if (inputArray.length == 1) {
            eventArray[0] = "";
            return eventArray;
        }
        eventArray[0] = inputArray[0];
        inputArray = inputArray[1].split(" /to ", 2);
        if (inputArray.length == 1) {
            eventArray[0] = "";
            return eventArray;
        }
        eventArray[1] = inputArray[0];
        eventArray[2] = inputArray[1];
        return eventArray;
    }

    public static String[] processDeadlineMessage(String input) {
        String[] deadlineArray = input.split(" /by ", 2);
        if (deadlineArray.length == 1) {
            deadlineArray[0] = "";
        }
        return deadlineArray;
    }

    public static int ActionInputValidity(String[] input, int indexLimit){
        try {
            if(input.length == 1) {
                throw new NullPointerException();
            }
            int taskIndex = Integer.parseInt(input[1]);
            if (taskIndex > indexLimit || taskIndex < 1) {
                throw new IndexOutOfBoundsException();
            }
            return taskIndex - 1;
        } catch (NumberFormatException nonIntegerIndex) {
            System.out.println(CUSTOM_ERROR_MESSAGE + ERROR_NONINTEGER_INDEX);
            return -1;
        } catch (IndexOutOfBoundsException outOfBoundsIndex) {
            System.out.println(CUSTOM_ERROR_MESSAGE + ERROR_NONEXISTANT_TASK);
            return -1;
        } catch (NullPointerException noIndex) {
            System.out.println(CUSTOM_ERROR_MESSAGE + ERROR_NO_INDEX_PROVIDED);
            return -1;
        }
    }

    public static void main(String[] args) {
        System.out.println(GREETING_MESSAGE);

        ArrayList<Task> todoList = new ArrayList<Task>();
        int sizeOfTodoList = 0;
        Task currentTodo;

        Scanner in = new Scanner(System.in);
        String[] inputMessage = processInputMessage(in);
        while (!inputMessage[0].equals(ACTION_GOODBYE)) {
            switch (inputMessage[0]) {
            case ACTION_LIST:
                for (int i = 0; i < sizeOfTodoList; i += 1) {
                    currentTodo = todoList.get(i);
                    String printedMessage = String.format("%d.%s", i + 1, currentTodo);
                    System.out.println(printedMessage);
                }
                inputMessage = processInputMessage(in);
                break;
            case ACTION_MARK_COMPLETE:
                int taskIndex = ActionInputValidity(inputMessage, sizeOfTodoList);
                if (taskIndex >= 0) {
                    currentTodo = todoList.get(taskIndex);
                    currentTodo.setComplete();
                    System.out.println(COMPLETED_TASK_MESSAGE);
                    System.out.println(currentTodo);
                }
                inputMessage = processInputMessage(in);
                break;
            case ACTION_MARK_INCOMPLETE:
                taskIndex = ActionInputValidity(inputMessage, sizeOfTodoList);
                if (taskIndex >= 0) {
                    currentTodo = todoList.get(taskIndex);
                    currentTodo.setIncomplete();
                    System.out.println(INCOMPLETE_TASK_MESSAGE);
                    System.out.println(currentTodo);
                }
                inputMessage = processInputMessage(in);
                break;
            case ACTION_NEW_TODO:
                Todo newTodo = new Todo(inputMessage[1]);
                todoList.add(newTodo);
                sizeOfTodoList += 1;
                System.out.println(ADDED_TASK_MESSAGE + newTodo);
                inputMessage = processInputMessage(in);
                break;
            case ACTION_NEW_DEADLINE:
                inputMessage = processDeadlineMessage(inputMessage[1]);
                if (inputMessage[0].equals("")) {
                    System.out.println(CUSTOM_ERROR_MESSAGE);
                } else {
                    sizeOfTodoList += 1;
                    Deadline newDeadline = new Deadline(inputMessage[0], inputMessage[1]);
                    todoList.add(newDeadline);
                    System.out.println(ADDED_TASK_MESSAGE + newDeadline);
                }
                inputMessage = processInputMessage(in);
                break;
            case ACTION_NEW_EVENT:
                inputMessage = processEventMessage(inputMessage[1]);
                if (inputMessage[0].equals("")) {
                    System.out.println(CUSTOM_ERROR_MESSAGE);
                } else {
                    sizeOfTodoList += 1;
                    Event newEvent = new Event(inputMessage[0], inputMessage[1], inputMessage[2]);
                    todoList.add(newEvent);
                    System.out.println(ADDED_TASK_MESSAGE + newEvent);
                }
                inputMessage = processInputMessage(in);
                break;
            default:
                System.out.println(CUSTOM_ERROR_MESSAGE + ERROR_UNKNOWN_INSTRUCTION);
                inputMessage = processInputMessage(in);
            }
        }
        System.out.println(GOODBYE_MESSAGE);
        //CS2113T will not let students customise chatbots next sem onwards because of me
    }
}

