import java.util.ArrayList;
import java.util.Objects;

public class Staff {
    //id of the staff
    private String staffNumber;
    //technolgy that each employee is skilled at
    private ArrayList<String> technologyPerEmp;
    //number of projects that staff is curently working on
    private int projectsWorkedOn;
    //at what technology does staff work
    private String workingAt;
    //what project is staff working at, used at telling if he can work at certain place again
    private String projectThatStaffWorksOn;

    public Staff(String empNumber, ArrayList<String> givenProfession) {
        staffNumber = empNumber;
        technologyPerEmp = givenProfession;
        projectsWorkedOn = 0;
    }

    public Staff(Staff s)
    {
        this.staffNumber = s.staffNumber;
        this.technologyPerEmp = new ArrayList<>(s.technologyPerEmp); // Deep copy the list
        this.projectsWorkedOn = s.projectsWorkedOn;
        this.workingAt = s.workingAt;
    }

    public void AddProjectThatStaffWorksOn(String str)
    {
        this.projectThatStaffWorksOn=str;
    }

    public boolean CanWork(String p,String t) {
        if (projectsWorkedOn == 0) {
            return true;
        } else if (projectsWorkedOn == 1 && IsSpecialClass()) {
            return true;
        } else if(Objects.equals(this.projectThatStaffWorksOn, p) && !Objects.equals(t, workingAt) && projectsWorkedOn == 1)
        {
            return true;
        }
         else {
            return false;
        }
    }

    public boolean IsSpecialClass()
    {
        if(technologyPerEmp.contains("PM") && technologyPerEmp.contains("QA") && technologyPerEmp.size()==2 ) {
            return true;
        }
        else if((technologyPerEmp.contains("QA") ||technologyPerEmp.contains("PM"))&& technologyPerEmp.size()==1) {
            return true;
        }
        else {
            return false;
        }
    }

    public void SetWorkPlace(String work)
    {
        this.workingAt = work;
    }

    public ArrayList<String> GetTechnologyPerEmp()
    {
     return technologyPerEmp;
    }

    public String GetStaffNumber()
    {
        return staffNumber;
    }

    public void IncreaseProjectsWorkedOn()
    {
        projectsWorkedOn++;
    }

    public int GetProjectsWorkedOn()
    {
        return projectsWorkedOn;
    }
}
