package ${packageName};


import java.io.Serializable;

/**
* ${tableName}-实体类
*/
public class ${tableName} implements Serializable {

    <#list columns as column>
    // ${column.columnComment}
    private ${column.columnType} ${column._columnName};
    </#list>
}
