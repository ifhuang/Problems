select a.id
from Weather as a join Weather as b
where TO_DAYS(a.DATE) - TO_DAYS(b.DATE) = 1 and a.Temperature > b.Temperature