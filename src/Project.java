import java.util.*;

public class Project {
    //id of the project
    private String projectNumber;
    //technologies required to fulfill the project
    private ArrayList<String> technologyNeeded;
    //staff already assigned to do the project
    private ArrayList<String> assignedStaff;
    //how many workpalces are found
    private int foundWorkPlaces;
    //how many workplaces are there to be set
    private int workPlaces;

    public Project(String projectName, ArrayList<String> listOfProjects) {
        projectNumber = projectName;
        technologyNeeded = listOfProjects;
        workPlaces = technologyNeeded.size();
        assignedStaff = new ArrayList<>();
    }

    public Project(Project p)
    {
        this.projectNumber = p.projectNumber;
        this.technologyNeeded = new ArrayList<>(p.technologyNeeded); // Deep copy the list
        this.foundWorkPlaces = p.foundWorkPlaces;
        this.workPlaces = technologyNeeded.size();
        this.assignedStaff = new ArrayList<>(p.assignedStaff);
    }

    public int GetWorkPlacesNumber() {
        return this.workPlaces;
    }

    public int GetDoneWorkPlaces() {
        return this.foundWorkPlaces;
    }

    public Float CalculateFreeWorkSpace()
    {
        return ((float)this.foundWorkPlaces /this.workPlaces) * 100f;
    }

    public ArrayList<String> GetTechnologiesNeeded() {
        return this.technologyNeeded;
    }

    public ArrayList<String> GetAssignedStaff() {
        return this.assignedStaff;
    }

    public void AssignToProject(Project p,String str) {
        p.assignedStaff.add(str);
    }

    public int GetWorkplacesSet()
    {
        return this.foundWorkPlaces;
    }

    public void IncreaseWorkplaces()
    {
        this.foundWorkPlaces++;
    }

    public String GetProjectNumber()
    {
        return this.projectNumber;
    }
}
