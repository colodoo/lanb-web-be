SELECT
    <#list columns as column>
        ${column.columnName} as ${column._columnName}<#if column_has_next>,</#if>
    </#list>
FROM
    ${tableName}
WHERE
    <#list columns as column>
        ${column.columnName} = ${r"#{"}${column._columnName}${r"}"}<#if column_has_next> and </#if>
    </#list>