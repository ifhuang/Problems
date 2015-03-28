select a.name as Employee
from Employee as a join Employee as b on a.ManagerId = b.id
where a.Salary > b.Salary