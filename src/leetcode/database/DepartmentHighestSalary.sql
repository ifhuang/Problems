select d.Name as Department, e1.Name as Employee, e1.Salary
from Employee as e1 join Department as d join
    (select DepartmentId, max(Salary) as Salary
    from Employee
    group by DepartmentId ) as e2
    on e1.DepartmentId = e2.DepartmentId and e1.Salary = e2.Salary and e1.DepartmentId = d.Id