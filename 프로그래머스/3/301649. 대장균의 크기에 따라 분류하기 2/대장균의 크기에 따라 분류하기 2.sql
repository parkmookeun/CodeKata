SELECT ID,
CASE WHEN SORTED_COLONY.ROW_NUM <= (SORTED_COLONY.TOTAL_COUNT / 4) THEN "CRITICAL"
     WHEN SORTED_COLONY.ROW_NUM <= (SORTED_COLONY.TOTAL_COUNT / 2) THEN "HIGH"
     WHEN SORTED_COLONY.ROW_NUM <= (SORTED_COLONY.TOTAL_COUNT / 4 * 3) THEN "MEDIUM"
     ELSE "LOW" END AS COLONY_NAME
FROM
(SELECT ID, ROW_NUMBER() OVER(ORDER BY SIZE_OF_COLONY DESC) AS ROW_NUM, COUNT(*) OVER() AS TOTAL_COUNT
FROM ECOLI_DATA) SORTED_COLONY
ORDER BY 1 ASC;