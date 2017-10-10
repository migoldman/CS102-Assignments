package topsortcourses;
import java.util.ArrayList;

public class Course {
    
    private String name;
    private ArrayList<Course> successors;
    private ArrayList<Course> prerequisites;
    
    public Course(String name) {
        this.name = name; 
        this.successors = new ArrayList<Course>();
        this.prerequisites = new ArrayList<Course>();
    }
    
    public String getName() { return name; }
    
    public void addPrerequisite(Course c) { prerequisites.add(c); }
    
    public void addSuccessor(Course c) { successors.add(c); }    
    
    public void removePrerequisite(Course c) { prerequisites.remove(c); }
    
    public void removeSuccessor(Course c) { successors.remove(c); }    
    
    public ArrayList<Course> getPrerequisites() { return prerequisites; }
    
    public ArrayList<Course> getSuccessors() { return successors; }
    
}