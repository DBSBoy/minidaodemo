select
id,
name
from
city
where 1= 1
<#if city.id ?? && city.id ?length gt 0>
 and id = :city.id
</#if>

