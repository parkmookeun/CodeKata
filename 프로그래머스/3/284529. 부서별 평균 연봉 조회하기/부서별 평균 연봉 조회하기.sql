SELECT dp.DEPT_ID, dp.DEPT_NAME_EN, ROUND(AVG(em.SAL),0) AS AVG_SAL 
FROM HR_DEPARTMENT dp
INNER JOIN HR_EMPLOYEES em
ON dp.DEPT_ID = em.DEPT_ID
GROUP BY dp.DEPT_ID
ORDER BY 3 DESC;