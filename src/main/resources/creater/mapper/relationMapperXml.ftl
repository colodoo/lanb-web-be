<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${packageName}.service.mapper.${tableName?cap_first}RelationMapper">

	<select id="get${tableName?cap_first}List" resultType="${packageName}.model.${tableName?cap_first}" parameterType="${packageName}.model.${tableName?cap_first}VO">
${SQLstring}
	</select>

</mapper>