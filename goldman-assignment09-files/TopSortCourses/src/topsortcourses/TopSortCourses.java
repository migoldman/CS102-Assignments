package topsortcourses;
import acm.program.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Queue;
import java.util.LinkedList;

public class TopSortCourses extends ConsoleProgram {
        Course cmpu101 = new Course("CMPU101");  
        Course cmpu102 = new Course("CMPU102"); 
        Course cmpu145 = new Course("CMPU145");
        Course cmpu203 = new Course("CMPU203");
        Course cmpu224 = new Course("CMPU224");    
        Course cmpu235 = new Course("CMPU235");
        Course cmpu240 = new Course("CMPU240");
        Course cmpu241 = new Course("CMPU241");       
        Course cmpu245 = new Course("CMPU245");      
        Course cmpu250 = new Course("CMPU250");      
        Course cmpu324 = new Course("CMPU324");     
        Course cmpu325 = new Course("CMPU325");
        Course cmpu331 = new Course("CMPU331");        
        Course cmpu334 = new Course("CMPU334");     
        Course cmpu365 = new Course("CMPU365");       
        Course cmpu366 = new Course("CMPU366");       
        Course cmpu375 = new Course("CMPU375");       
        Course cmpu377 = new Course("CMPU377");        
        Course cmpu378 = new Course("CMPU378");
    
    public void run() {
        ArrayList<Course> courseList = initializeCourses();
        markSuccessors(courseList);
        topSortCourses(courseList);
    }
    
    ArrayList<Course> initializeCourses() {
        ArrayList<Course> courseList = new ArrayList<Course>();
        courseList.add(cmpu101);
        
        
        cmpu102.addPrerequisite(cmpu101);
        courseList.add(cmpu102);
        
        cmpu145.addPrerequisite(cmpu101);
        courseList.add(cmpu145);
        
        cmpu203.addPrerequisite(cmpu102);
        courseList.add(cmpu203);
        
        cmpu224.addPrerequisite(cmpu102);
        cmpu224.addPrerequisite(cmpu145);       
        courseList.add(cmpu224);
        
        cmpu235.addPrerequisite(cmpu102);
        cmpu235.addPrerequisite(cmpu145);       
        courseList.add(cmpu235);
        
        cmpu240.addPrerequisite(cmpu145);
        courseList.add(cmpu240);
        
        cmpu241.addPrerequisite(cmpu145);
        courseList.add(cmpu241);
        
        cmpu245.addPrerequisite(cmpu145);
        courseList.add(cmpu245);
        
        cmpu250.addPrerequisite(cmpu102);        
        courseList.add(cmpu250);
        
        cmpu324.addPrerequisite(cmpu224);
        courseList.add(cmpu324);
        
        cmpu325.addPrerequisite(cmpu224);
        courseList.add(cmpu325);
        
        cmpu331.addPrerequisite(cmpu224);
        cmpu331.addPrerequisite(cmpu240);
        courseList.add(cmpu331);
        
        cmpu334.addPrerequisite(cmpu203);
        cmpu334.addPrerequisite(cmpu224);
        courseList.add(cmpu334);
        
        cmpu365.addPrerequisite(cmpu245);
        courseList.add(cmpu365);
        
        cmpu366.addPrerequisite(cmpu240);
        courseList.add(cmpu366);
        
        cmpu375.addPrerequisite(cmpu203);
        courseList.add(cmpu375);
        
        cmpu377.addPrerequisite(cmpu203);
        cmpu377.addPrerequisite(cmpu224);
        courseList.add(cmpu377);
        
        cmpu378.addPrerequisite(cmpu203);
        courseList.add(cmpu378);
        return courseList;
    }
    
    void markSuccessors(ArrayList<Course> courseList) {
        for (Course c:courseList) 
            for (Course p:c.getPrerequisites()) p.addSuccessor(c);

    }
    
    void topSortCourses(ArrayList<Course> courseList) {
        Queue<Course> q = initializeQueue(courseList);
        while (q.size() != 0)
        {
            Course temp= q.remove();
            println(temp.getName());
            ArrayList<Course> pArray = temp.getSuccessors();
            for( int i = 0; i < pArray.size(); i++) {
                Course p = pArray.get(i);
                p.removePrerequisite(temp);
                if(p.getPrerequisites().isEmpty())
                    q.add(p);
                
            }
        }
        
    }
    
    Queue<Course> initializeQueue(ArrayList<Course> courseList) {
        Queue<Course> queue = new LinkedList<Course>();
        for(int i = 0; i < courseList.size(); i++) {
            if (courseList.get(i).getPrerequisites().isEmpty()) {
                queue.add(courseList.get(i));
            }
        }
        return queue;

    }

    public static void main(String[] args) {
        new TopSortCourses().start();
    }
    
}
