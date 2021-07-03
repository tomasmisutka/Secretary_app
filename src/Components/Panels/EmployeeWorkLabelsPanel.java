package Components.Panels;

import Common.Employee;
import Common.WorkLabel;
import Components.WorkLabelComponent;
import Services.DBConnection;
import dragNdrop.DragListener;
import dragNdrop.DropListener;
import layouts.WrapLayout;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class EmployeeWorkLabelsPanel extends JPanel
{
    private final Employee employee;
    private ArrayList<WorkLabel> workLabels;

    public EmployeeWorkLabelsPanel(Employee employee)
    {
        this.employee = employee;
        this.workLabels = new ArrayList<>();
        this.initContent();
    }

    private void initContent()
    {
        this.setBackground(Color.white);
        this.setLayout(new WrapLayout(WrapLayout.CENTER, 0, 3));
        workLabels = DBConnection.getInstance().getWorkLabelsAssignedToEmployee(employee.getId());

        for (WorkLabel workLabel : workLabels)
        {
            WorkLabelComponent workLabelComponent = new WorkLabelComponent(workLabel);
            this.add(workLabelComponent);
            new DragListener(workLabelComponent, this);
        }
        new DropListener(this);
    }

    public Employee getEmployee()
    {
        return employee;
    }

    public ArrayList<WorkLabel> getWorkLabels()
    {
        return this.workLabels;
    }
}
