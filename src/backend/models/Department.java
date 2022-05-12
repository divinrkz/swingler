package backend.models;

public class Department {
    private int id;
    private String name;
    private String description;
    private  String status;
    private int schoolId;

    public Department() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(int schoolId) {
        this.schoolId = schoolId;
    }

    public Department(int id, String name, String description, String status, int schoolId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = status;
        this.schoolId = schoolId;
    }


}
