import java.util.ArrayList;

public class Staff {
    private ArrayList<String> technologyPerEmp;
    private String staffNumber;
    private int projectsWorkedOn;
    private String workingAt;

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

    public boolean CanWork() {
        if (projectsWorkedOn == 0) {
            return true;
        } else if (projectsWorkedOn == 1 && IsSpecialClass()) {
            return true;
        } else {
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
}
