<#if (actionErrors?exists && actionErrors?size > 0)>
	<font color="red">
	<#list actionErrors as error>
		<b>${error}</b>
	</#list>
	</font>
</#if>
