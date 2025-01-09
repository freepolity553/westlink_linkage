package project.variables;

import utilites.RandomValue;

public class ProjectVariables {

    private String projectNum = String.valueOf(RandomValue.randomInt(5));
    private String projectName = "Авто UI Тест проект-" + RandomValue.randomInt(5);
    private String projectContract = "Договор-" + RandomValue.randomInt(5);

    public String getProjectNum() {
        return projectNum;
    }
    public void setProjectNum(String projectNum) {
        this.projectNum = projectNum;
    }

    public String getProjectContract() {
        return projectContract;
    }
    public void setProjectContract(String projectContract) {
        this.projectContract = projectContract;
    }

    public String getProjectName() {
        return projectName;
    }
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

}


// "Авто UI Тест проект-" + RandomValue.randomInt(5);
