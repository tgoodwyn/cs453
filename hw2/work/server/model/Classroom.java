package server.model;

public class Classroom {
    
    public int instructorRectID = 0;
    public int questionRectID = 5;
    public boolean instructorHasEntered = false;

    // this array has the current # of occupants 
    // for each of the 10 rectangles
    public int[] rectangles = new int[7];
    
}